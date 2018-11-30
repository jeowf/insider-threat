# insider-threat

##TODO

 - Comandos
 - Definir intervalo de data em prefs.txt
 - implementar tostrings das classes nó

## Arquivo de configuração

users: data/ldap.csv
logons: data/logon.csv
devices: data/device.csv
https: data/http.csv
out: out.txt


begin : YYYY-MM-DD 
end: YYYY-MM-DD

begin: none
end: none

## Comandos

$ hist                            : Mostra o histograma do contexto atual

$ info                            : Mostra os detalhes do contexto atual

$ list                            : Lista os elementos internos

$ user <ID>                       : Acessa o usuário conforme o id passado

$ pc <ID>                         : Acessa o computador conforme o id passado

$ act <ID>                        : Acessa a atividade conforme o id passado

$ up                              : Vola um nível

$ top                             : Volta à raiz de busca

$ compare <USER_ID_1> <USER_ID_2> : O usuário recebe um histograma de comparação entre 2 usuários. Ao executar volta à raiz. 

$ analyse <ROLE>                  : Escreve no arquivo de saída o resultado da análise. Ao executar volta à raiz. 

$ quit                            : Finalizar aplicação