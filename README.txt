Para compilar executar os seguintes comandos no terminal:

javac main/*.java videopoker/*.java player/*.java deck/*.java card/*.java
jar cmf manif.txt VideoPoker.jar main/* videopoker/* player/* deck/* card/*


Para correr o programa executar o primeiro comando para modo debug e o segundo comando para modo simulação:

/******************************************************/
credit      =   valor do credito do jogador
cmd-file    =   nome do fichero com os comandos
card-file   =   nome do fichero com as cartas
/******************************************************/
java -jar VideoPoker.jar -d credit cmd-file card-file

/******************************************************/
credit      =   valor do credito do jogador
bet         =   valor das apostas
nbdeals     =   numero de apostas
/******************************************************/
java -jar VideoPoker.jar -s credit bet nbdeals



Comando para colonar repositório do github:
/*Abrir terminal na pasta par onde se quer colonar o repositório*/
git clone git@github.com:Rui-Ferreira3/POO-projeto.git

Comandos para trabalhar no projeto:
/*Abrir terminal na pasta par onde se tem o repositório*/
git pull
/*FAZER SEMPRE PULL ANES DE EDITAR ALGUMA COISA PARA FAZER DOWNLOAD DA VERSÂO MAIS RECENTE*/
/*editar código*/
git add *                       // adiciona todas as mudanças
git commit -m "MENSAGEM"        // MENSAGEM tem de fazer uma descrição muito reduzida do que foi editado
git push