import java.util.*;
import java.io.*;

public class CodeGenerator extends Object {

	public SimpleNode root;

	public CodeGenerator(SimpleNode n) {
		root = n;
	}

	public void generateCode() throws FileNotFoundException, UnsupportedEncodingException, IOException
	{
		generateCode(root);
	}

	public void generateCode(SimpleNode n) throws FileNotFoundException, UnsupportedEncodingException, IOException
	{
		OutputStream output = new FileOutputStream("output.java");

		String s = new String("import java.util.*;\n\npublic class test {\n\n\tpublic static void main(String[] args) {\n\n\t\tclass Card {\n\t\t\tpublic int state;\n\t\t\tpublic Map<Character, Character> readWrite;\n\t\t\tpublic Map<Character, Character> readMove;\n\t\t\tpublic Map<Character, Integer> readJump;\n\n\t\t\tpublic Card(int istate) {\n\t\t\t\tstate = istate;\n\t\t\t\treadWrite = new HashMap<Character, Character>();\n\t\t\t\treadMove = new HashMap<Character, Character>();\n\t\t\t\treadJump = new HashMap<Character, Integer>();\n\t\t\t}\n\n\t\t\tpublic void addLine(char read, char write, char move, int jump) {\n\t\t\t\treadWrite.put(new Character(read), new Character(write));\n\t\t\t\treadMove.put(new Character (read), new Character(move));\n\t\t\t\treadJump.put(new Character(read), new Integer(jump));\n\t\t\t}\n\t\t}\n\n\tboolean finished = false; //for when the line specifies the analysis is over\n\tint currentState = 0;\n\tint currentIndex = 0;\n\tchar currentChar;\n\tVector<Card> cards = new Vector<Card>();\n\n\t//variable section of code is here\n");

		output.write(s.getBytes());

		if(n.children == null) { //it's a childless node for which code must be created
			System.out.println("YOOOO");
		} else {

		}

		s = new String("\t//end of variable section\n\tStringBuilder input = new StringBuilder(args[0]);\n\n\twhile(!finished) {\n\t\t//get char\n\t\tcurrentChar = input.charAt(currentIndex);\n\t\t//process char\n\t\tinput.setCharAt(currentIndex, cards.elementAt(currentIndex).readWrite.get(currentChar).charValue());\n\t\t//jump or end\n\t\tif(cards.elementAt(currentIndex).readJump.get(currentChar).intValue() == -1) {\n\t\t\tfinished = true;\n\t\t\tcontinue;\n\t\t} else\n\t\t\tcurrentState = cards.elementAt(currentIndex).readJump.get(currentChar).intValue();\n\t\t//move\n\t\tif(cards.elementAt(currentIndex).readMove.get(currentChar).charValue() == 'r')\n\t\t\tcurrentIndex++;\n\t\telse\n\t\t\tcurrentIndex--;\n\t}\n\n\tSystem.out.println(input);\n\t}\n}");

		output.write(s.getBytes());

		System.out.println("CODE SUCCESSFULLY GENERATED");
	}

}