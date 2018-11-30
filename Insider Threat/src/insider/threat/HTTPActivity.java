package insider.threat;

/**
 * Representação de atividades HTTP
 * @author Felipe Morais da Silva
 * @author Daniel Henrique Ferreira Gomes
 */
public class HTTPActivity extends Activity{
    private String url;

    /**
     * Construtor
     * @param id
     * @param utl
     */
    public HTTPActivity(String id, String utl) {
        super(id);
        this.url = utl;
    }

    /**
     * Acessa o URL
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Altera o URL
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return super.toString() + ", URL: " + url;
    }
}
