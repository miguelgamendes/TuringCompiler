Nome do Grupo: G32
Tema do trabalho: Máquina de Turing
Membros do grupo: 	Diogo Araújo	200701619
					José Ferreira	200702566
					Miguel Mendes	201105535

Instruções de compilação:

	Executar os seguintes comandos, no local dos ficheiros de código-fonte:
		java -cp "[caminho absoluto até ficheiro javacc.jar]" jjtree TuringMachine.jjt
		java -cp "[caminho absoluto até ficheiro javacc.jar]" javacc TuringMachine.jj
		java *.java
		jar cfe TuringMachine.jar TuringMachine *.class

Descrição de exemplos:

	functionalexample.tur
		Ficheiro completamente funcional. Demonstra como um ficheiro bem escrito origina o código adaptado para execução da máquina de Turing.

	lexicalerror.tur
		Ficheiro que possui erros a nível lexixal. Com este ficheiro demontra-se como a ferramente identifica estes erros e os avisos que executa.

	syntaxerror.tur
		Ficheiro com erros sintácticos, que são demonstrados ao utilizar a ferramenta. Os elementos em erro são especificados.

	semanticerror.tur
		Ficheiro com erros semânticos. No caso da existência de este tipo de erros, como este ficheiro demonstra, é declarado o erro cometido.

Descrição de utilização:

	Executar o seguinte comando:
		java -jar TuringMachine.jar [ficheiro de input desejado]

Análise lexical: TuringMachine.jjt
Análise sintáctica: TuringMachine.jjt
Análise semântica: TuringMachine.jjt

Representações Intermédias:
	TURINGMACHINE - representação de base de toda a estrutura
	CARD - representação de um cartão para uma máquina de Turing
	STATE(n) - representação intermédia de um estado n
	LINE - representação intermédia de uma entrada num cartão
	READ(c) - representação intermédia da instrução de leitura do caracter c
	WRITE(c) - representação intermédia da instrução de escrita do caracter c
	MOVE(d) - representação intermédia da intrução de movimento na direcção d
	JUMP(n) -  representação intermédia da instrução de transição para o estado n

Geração de código:

	No passo final de todo o processo, é gerado código Java completamente capaz de processar qualquer input pelo método da máquina de Turing especificada no formato pré-definido no ficheiro de input. São criados cartões, muito semelhantemente a uma máquina de Turing original. Depois da inserção de cada cartão, são adicionadas linas de instruções através de mapas, de forma a se identificar o que se faz em cada tipo de leitura. O primeiro caracter a ser processado da string de input será sempre o primeiro, sendo de momento impossível definir apartir de qual caracter se começar a análise pela máquina de Turing criada.

Testes:

Arquitectura:

	Parte-se de um ficheiro original que definirá o comportamento da máquina de Turing. Este ficheiro deverá estar estruturado da seguinte forma:

		State 0 {
			read a, write b, move right, jump 1; -> no caso de uma instrução normal
			read c, write b, move left, end; -> no case de uma instrução que põe fim à análise
			(...)
		}

		State 1 {
			(...)
		}

		(...)

	A compilação deste ficheiro de input com a ferramenta TuringMachine resulta em código Java capaz de processar qualquer string da mesma forma que uma máquina de Turing cujas instruções sejam semelhantes a aquelas definidas no ficheiro original de input.

Pontos positivos:

	- Não sendo apenas válido para operações sobre fitas em binário, também é possível experimentação com input no formato de string de todo o tipo de caracteres.

Pontos negativos:

	- Impossibilidade de definir apartir de que posição se iniciar a análise da string de input

	- Por defeito, o primeiro cartão definido define também qual será o estado inicial.