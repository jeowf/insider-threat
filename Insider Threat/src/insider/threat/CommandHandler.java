package insider.threat;

import java.util.LinkedHashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 * Controla e executa os comandos informados pelo usuário
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class CommandHandler {

    private IOManager ioManager;
    private DataManager dataManager;

    private User user;
    private PC pc;
    private Activity act;

    enum Level {
        ROOT,
        USER,
        PC,
        ACTIVITY
    }

    private Level currentLevel;

    /**
     * Construtor
     * @param ioManager
     * @param dataManager
     */
    public CommandHandler(IOManager ioManager, DataManager dataManager) {
        this.ioManager = ioManager;
        this.dataManager = dataManager;

        currentLevel = Level.ROOT;
    }

    /**
     * Retorna o gerenciador de entrada e saída
     * @return
     */
    public IOManager getIoManager() {
        return ioManager;
    }

    /**
     * Altera o gerenciador de entrada e saída
     * @return
     */
    public DataManager getDataManager() {
        return dataManager;
    }

    /**
     * Exibe as informações do contexto atual do usuário
     */
    public void info() {

        if (currentLevel == Level.ROOT) {
            System.out.print("$ ");
        } else if (currentLevel == Level.USER) {
            System.out.print(user.getId() + "$ ");
        } else if (currentLevel == Level.PC) {
            System.out.print(user.getId() + "@" + pc.getId() + "$ ");
        } else if (currentLevel == Level.ACTIVITY) {
            System.out.print(user.getId() + "@" + pc.getId() + "/" + act.getId() + "$ ");
        }
    }

    /**
     * Executa o comando contido na string passada por parâmetro
     * @param s
     */
    public void execute(String s) {
        boolean valid = false;

        String[] fields = s.split(" ");

        if (fields.length > 0) {

            if (fields[0].equals("hist")) {

                if (currentLevel != Level.ROOT) {
                    showHistogram();
                } else {
                    System.out.println("No histogram to display. Read the README.md to more information.");
                }

            } else if (fields[0].equals("user")) {

                if (fields.length == 2) {
                    user = dataManager.getHashMap().get(fields[1]);
                    if (user != null) {
                        currentLevel = Level.USER;
                    } else {
                        System.out.println("User " + fields[1] + " does not exit.");
                    }

                } else {
                    System.out.println("Invalid number of arguments");
                }

            } else if (fields[0].equals("pc")) {
                if (fields.length == 2) {
                    if (currentLevel != Level.ROOT) {

                        pc = user.getDate().getPcsMap().get(fields[1]);

                        if (pc != null) {
                            currentLevel = Level.PC;
                        } else {
                            System.out.println("Pc " + fields[1] + " does not exit.");
                        }
                    } else {
                        System.out.println("You need select a user to execute this command.");
                    }

                } else {
                    System.out.println("Invalid number of arguments");
                }

            } else if (fields[0].equals("act")) {
                if (fields.length == 2) {
                    if (currentLevel != Level.ROOT && currentLevel != Level.USER) {

                        act = pc.getActivities().get(fields[1]);

                        if (act != null) {
                            currentLevel = Level.ACTIVITY;
                        } else {
                            System.out.println("Activity " + fields[1] + " does not exit.");
                        }
                    } else {
                        System.out.println("You need select a device to execute this command.");
                    }

                } else {
                    System.out.println("Invalid number of arguments");
                }

            } else if (fields[0].equals("info")) {

                if (currentLevel == Level.USER) {
                    System.out.println(user);
                } else if (currentLevel == Level.PC) {
                    System.out.println(pc);
                } else if (currentLevel == Level.ACTIVITY) {
                    System.out.println(act);
                } else {
                    System.out.println(dataManager);
                }

            } else if (fields[0].equals("list")) {

                listItems();

            } else if (fields[0].equals("up")) {
                if (currentLevel == Level.USER) {
                    currentLevel = Level.ROOT;
                } else if (currentLevel == Level.PC) {
                    currentLevel = Level.USER;
                } else if (currentLevel == Level.ACTIVITY) {
                    currentLevel = Level.ACTIVITY;
                } else {
                    System.out.println("You are already in root.");
                }
            } else if (fields[0].equals("top")) {
                currentLevel = Level.ROOT;

            } else if (fields[0].equals("compare")) {

                if (fields.length == 3) {
                    User user1 = dataManager.getHashMap().get(fields[1]);
                    User user2 = dataManager.getHashMap().get(fields[2]);

                    if (user1 == null) {
                        System.out.println("User " + fields[1] + " does not exit.");
                    } else if (user2 == null) {
                        System.out.println("User " + fields[2] + " does not exit.");
                    } else {
                        currentLevel = Level.ROOT;
                        showHistogram(user1, user2);
                    }

                } else {
                    System.out.println("Invalid number of arguments");
                }

            } else if (fields[0].equals("analyse")) {
                if (fields.length >= 2) {
                    String role = fields[1];

                    for (int i = 2; i < fields.length; i++) {
                        role += " " + fields[i];
                    }
                    
                    try {
                        
                        Pair<LinkedHashMap<User, Double>, LinkedHashMap<User, Double>> p = dataManager.generateAnalyze(role, dataManager.getBeginDate(), dataManager.getEndDate());
                        ioManager.writeOutput(p);

                        System.out.println("The result of the analisys was wrote in " + ioManager.getOutFile());
                    } catch (ArithmeticException e) {
                        System.out.println(role + " does not exist.");
                    }
                } else {
                    System.out.println("Invalid number of arguments");
                }

            } else if (!fields[0].equals("quit")) {
                System.out.println("Invalid command. read the README.md to more information.");
            }

        }

    }

    /**
     * Lista os elementos filhos ao nó atual
     */
    private void listItems() {
        if (currentLevel == Level.ROOT) {
            for (Map.Entry<String, User> pair : dataManager.getHashMap().entrySet()) {
                System.out.println(pair.getValue());
            }
        } else if (currentLevel == Level.USER) {

            for (Map.Entry<String, PC> pair : user.getDate().getPcsMap().entrySet()) {
                System.out.println(pair.getValue());
            }
        } else if (currentLevel == Level.PC) {

            for (Map.Entry<String, Activity> pair : pc.getActivities().entrySet()) {
                System.out.println(pair.getValue());
            }

        } else if (currentLevel == Level.ACTIVITY) {
            System.out.println(act);
        }
    }

    /**
     * Plota o histograma entre dois usuários
     * @param user1
     * @param user2
     */
    private void showHistogram(User user1, User user2) {

        double[] histogram1 = dataManager.normalize(user1.getHistogram());
        double[] histogram2 = dataManager.normalize(user2.getHistogram());

        LineChart chart = new LineChart(
                "User Comparison Histogram (" + user1.getId() + " and " + user2.getId() + ")",
                user1.getId() + " and " + user2.getId(),
                histogram1,
                user1.getId(),
                histogram2,
                user2.getId()
        );

        chart.plot();
    }

    /**
     * Plota o histograma referente ao contexto atual
     */
    private void showHistogram() {

        String type = "";
        String text = "";
        double[] histogram = {};

        if (currentLevel == Level.USER) {
            type = "User";
            text = user.getId();
            histogram = dataManager.normalize(user.getHistogram());
        } else if (currentLevel == Level.PC) {
            type = "PC";
            text = pc.getId();
            histogram = dataManager.normalize(pc.getHistogram());
        } else if (currentLevel == Level.ACTIVITY) {

            if (act instanceof HTTPActivity) {
                type = "HTTP";
            } else if (act instanceof LogonActivity) {
                type = "Logon";
            } else if (act instanceof DeviceActivity) {
                type = "Device";
            }

            text = act.getId();
            histogram = dataManager.normalize(act.getHistogram());

        }

        LineChart chart = new LineChart(
                type + " Histogram (" + text + ")",
                text,
                histogram,
                text
        );

        chart.plot();

    }

}
