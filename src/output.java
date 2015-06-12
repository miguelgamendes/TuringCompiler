import java.util.*;

public class output {

	public static void main(String[] args) {

		class Card {
			public int state;
			public Map<Character, Character> readWrite;
			public Map<Character, Character> readMove;
			public Map<Character, Integer> readJump;

			public Card(int istate) {
				state = istate;
				readWrite = new HashMap<Character, Character>();
				readMove = new HashMap<Character, Character>();
				readJump = new HashMap<Character, Integer>();
			}

			public void addLine(char read, char write, char move, int jump) {
				readWrite.put(new Character(read), new Character(write));
				readMove.put(new Character (read), new Character(move));
				readJump.put(new Character(read), new Integer(jump));
			}
		}

	boolean debug = false;

	if(args.length > 2) {
		System.out.println("TURING MACHINE USAGE: java -jar YourTuringMachine.jar inputString [-d]");
		System.exit(1);
	} else {
		if(args.length == 2 && args[1].equals("-d")) {
			debug = true;
		}
	}


	boolean finished = false; //for when the line specifies the analysis is over
	int currentState = 0;
	int currentIndex = 0;
	char currentChar;
	Vector<Card> cards = new Vector<Card>();

	//variable section of code is here
		cards.addElement(new Card(0));
		cards.elementAt(0).addLine('a', 'a', 'r', 1);
		cards.elementAt(0).addLine('b', 'b', 'r', 0);
		cards.elementAt(0).addLine('c', 'c', 'r', 0);
		cards.addElement(new Card(1));
		cards.elementAt(1).addLine('a', 'a', 'r', 1);
		cards.elementAt(1).addLine('b', 'b', 'r', 2);
		cards.elementAt(1).addLine('c', 'c', 'r', 0);
		cards.addElement(new Card(2));
		cards.elementAt(2).addLine('a', 'a', 'r', 1);
		cards.elementAt(2).addLine('b', 'b', 'r', 0);
		cards.elementAt(2).addLine('c', 'd', 'l', 3);
		cards.addElement(new Card(3));
		cards.elementAt(3).addLine('a', 'd', 'r', -1);
		cards.elementAt(3).addLine('b', 'd', 'l', 3);
		cards.elementAt(3).addLine('c', 'd', 'l', 3);
	//end of variable section
	StringBuilder input = new StringBuilder(args[0]);

	while(!finished) {
		if(debug) {
			System.out.println(input);
			for(int i = 0; i < input.length(); i++) {
				if(i == currentIndex)
					System.out.print("^");
				else
					System.out.print(" ");
				if(i == input.length() - 1)
					System.out.println("  " + currentState);
			}
		}

		//get char
		currentChar = input.charAt(currentIndex);
		//process char
		input.setCharAt(currentIndex, cards.elementAt(currentState).readWrite.get(currentChar).charValue());
		//jump or end
		if(cards.elementAt(currentState).readJump.get(currentChar).intValue() == -1) {
			finished = true;
			continue;
		} else
			currentState = cards.elementAt(currentState).readJump.get(currentChar).intValue();
		//move
		if(cards.elementAt(currentState).readMove.get(currentChar).charValue() == 'r')
			currentIndex++;
		else
			currentIndex--;
	}

	System.out.println(input);
	}
}