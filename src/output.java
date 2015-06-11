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

	boolean finished = false; //for when the line specifies the analysis is over
	int currentState = 0;
	int currentIndex = 0;
	char currentChar;
	Vector<Card> cards = new Vector<Card>();

	//variable section of code is here
		cards.addElement(new Card(0));
		cards.elementAt(0).addLine('a', 'b', 'r', 0);
		cards.elementAt(0).addLine('c', 'd', 'l', 1);
		cards.addElement(new Card(1));
		cards.elementAt(1).addLine('b', 'b', 'l', 1);
		cards.elementAt(1).addLine('c', 'd', 'r', -1);
		cards.addElement(new Card(2));
		cards.elementAt(2).addLine('b', 'b', 'r', 2);
		cards.addElement(new Card(3));
	//end of variable section
	StringBuilder input = new StringBuilder(args[0]);

	while(!finished) {
		//get char
		currentChar = input.charAt(currentIndex);
		//process char
		input.setCharAt(currentIndex, cards.elementAt(currentIndex).readWrite.get(currentChar).charValue());
		//jump or end
		if(cards.elementAt(currentIndex).readJump.get(currentChar).intValue() == -1) {
			finished = true;
			continue;
		} else
			currentState = cards.elementAt(currentIndex).readJump.get(currentChar).intValue();
		//move
		if(cards.elementAt(currentIndex).readMove.get(currentChar).charValue() == 'r')
			currentIndex++;
		else
			currentIndex--;
	}

	System.out.println(input);
	}
}