import java.util.*;

public class CodeGenerator extends Object {

	public SimpleNode root;

	public CodeGenerator(SimpleNode n) {
		root = n;
	}

	public void generateCode(SimpleNode n) {
		PrintWriter writer = new PrintWriter("output.java", "UTF-8");

		write.print("
import java.util.*;\n
\n
public class test {\n
\n
	public static void main(String[] args) {\n
\n
		class Card {\n
			public int state;\n
			public Map<Character, Character> readWrite;\n
			public Map<Character, Character> readMove;\n
			public Map<Character, Integer> readJump;\n
	\n
			public Card(int istate) {\n
				state = istate;\n
				readWrite = new HashMap<Character, Character>();\n
				readMove = new HashMap<Character, Character>();\n
				readJump = new HashMap<Character, Integer>();\n
			}\n
\n	
			public void addLine(char read, char write, char move, int jump) {\n
				readWrite.put(new Character(read), new Character(write));\n
				readMove.put(new Character (read), new Character(move));\n
				readJump.put(new Character(read), new Integer(jump));\n
			}\n
		}\n
\n
		boolean finished = false; //for when the line specifies the analysis is over\n
		int currentState = 0;\n
		int currentIndex = 0;\n
		char currentChar;\n
		Vector<Card> cards = new Vector<Card>();\n
\n
		//variable section of code is here\n
			");

		if(n.children == null) {

		}

		write.print("
//end of variable section\n
		StringBuilder input = new StringBuilder(args[0]);\n
\n
		while(!finished) {\n
			//get char\n
			currentChar = input.charAt(currentIndex);\n
			//process char\n
			input.setCharAt(currentIndex, cards.elementAt(currentIndex).readWrite.get(currentChar).charValue());\n
			//jump or end\n
			if(cards.elementAt(currentIndex).readJump.get(currentChar).intValue() == -1) {\n
				finished = true;\n
				continue;\n
			} else\n
				currentState = cards.elementAt(currentIndex).readJump.get(currentChar).intValue();\n
			//move\n
			if(cards.elementAt(currentIndex).readMove.get(currentChar).charValue() == 'r')\n
				currentIndex++;\n
			else\n
				currentIndex--;\n
		}\n
\n
		System.out.println(input);\n
	}\n
}
			");

		System.out.println("CODE SUCCESSFULLY GENERATED");
	}

}