# INSIDER THREAT 

## Autores

 - Daniel Henrique
 - Felipe Morais

## Objetivos

 - [x] Leitura de arquivos de log como entrada de dados.
 - [x] Montagem dos perfis de usuários.
 - [x] Visualização dos perfis de usuários.
 - [x] Detecção de anomalias.

## Geral

Há três pastas com nomes auto explicativos:
 
 - executavel
 - codigo-fonte
 - relatorio

## Executando

Para executar o código, basta entrar na pasta executavel e executar

> java -jar Insider_Threat.jar <caminho do arquivo de configuração>

O caminho do arquivo de configuração é opcional. Por padrão ele lê prefs.txt na mesma pasta que o executável

## Prefs.txt

O arquivo prefs.txt padrão é assim:

users: data/ldap.csv
logons: data/logon.csv
devices: data/device.csv
https: data/http.csv
out: out.txt
begin: YYYY-MM-DD 
end: YYYY-MM-DD

Se quiser realizar um rápido teste, com o prefs.txt na mesma pasta que o executável, coloque a pasta data com todos os CSVs na pasta do executável e em seguida execute o comando da seção anterior sem passar nenhum caminho.

Para customizar, basta alterar os valores de caminho ou data livremente. 

Caso não queira intervalos de data, substitua a data por none (exemplo-> begin: none).

## Compilando o código

Para compilar o código, basta carregar as bibliotecas (numa IDE) encontradas na pasta lib dentro do código fonte e possuir o arquivo pref.txt configurado.



## Comandos

Os comandos funcionando com uma ideia parecida à navegação de pastas em ambiente linux. A sintaxe pode ser conferida a seguir.

### Navegação

$ user <ID>                       : Acessa o usuário conforme o id passado

$ pc <ID>                         : Acessa o computador conforme o id passado

$ act <ID>                        : Acessa a atividade conforme o id passado

$ up                              : Vola um nível

$ top                             : Volta à raiz de busca

### Exibição

$ hist                            : Mostra o histograma do contexto atual

$ info                            : Mostra os detalhes do contexto atual

$ list                            : Lista os elementos internos

$ compare <USER_ID_1> <USER_ID_2> : O usuário recebe um histograma de comparação entre 2 usuários. Ao executar volta à raiz. 

$ analyse <ROLE>                  : Escreve no arquivo de saída o resultado da análise. Ao executar volta à raiz. 

### Outros

$ quit                            : Finalizar aplicação