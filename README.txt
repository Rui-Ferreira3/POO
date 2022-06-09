Para compilar executar os seguintes comandos no terminal:

javac videopoker/*.java player/*.java deck/*.java card/*.java
jar cmf manif.txt VideoPoker.jar videopoker/* player/* deck/* card/*


Para correr o programa executar o primeiro comando para modo debug e o segundo comando para modo simulação:

/*
credit      =   valor do credito do jogador
cmd-file    =   nome do fichero com os comandos
card-file   =   nome do fichero com as cartas
*/
java -jar VideoPoker.jar -d credit cmd-file card-file

/*
credit      =   valor do credito do jogador
bet         =   valor das apostas
nbdeals     =   numero de apostas
*/
java -jar VideoPoker.jar -s credit bet nbdeals

