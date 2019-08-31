import java.util.Scanner;

class Room {
	//c1, c2 > choice 1 and 2, point to the next Room instances
	int c1, c2;
	//f1, f2 > flags 1 and 2, in case you want to make return prompts different or something, use in printPrompt method
	// defaults are false for now
	boolean f1=false, f2=false;
	String prompt;

	Room(int choiceOneNodeValue, int choiceTwoNodeValue) {
		c1 = choiceOneNodeValue;
		c2 = choiceTwoNodeValue;
	}

	Room(int choiceOneNodeValue, int choiceTwoNodeValue, String prompt) {
		c1 = choiceOneNodeValue;
		c2 = choiceTwoNodeValue;
		this.prompt = prompt;
	}
	
	void printPrompt() {
		if (f1)
			System.out.println("Flag 1 triggered");
		if (f2)
			System.out.println("Flag 2 triggered");
		if (!f1 && !f2)
			System.out.println(prompt);
	}
}

public class adv {
	public static void main(String[] args) {
		int currentRoomNum = 0;
		Room currentRoom = roomReturn(currentRoomNum); // Start in room n0
		System.out.println("Try to reach room 10.");

		while (true) {
			roomReturn(currentRoomNum).printPrompt();
			System.out.println("[1] Go left [2] Go right");
			currentRoomNum = twoWayChoice(currentRoomNum, currentRoom.c1, currentRoom.c2);
			if (currentRoomNum == 10) {
				System.out.println("You made it to room 10.\nThe End.");
				break;
			}
			currentRoom = roomReturn(currentRoomNum);
		}
	}

	static Room roomReturn(int node) {
		
		//since this method creates a new array EACH TIME it is called, it is quite inefficient... fix if u want
		
		Room n0 = new Room(1, 2, "You are in room 0");
		Room n1 = new Room(3, 4, "You are in room 1");
		Room n2 = new Room(5, 6, "You are in room 2");
		Room n3 = new Room(1, 7, "You are in room 3");
		Room n4 = new Room(7, 5, "You are in room 4");
		Room n5 = new Room(8, 9, "You are in room 5");
		Room n6 = new Room(1, 5, "You are in room 6");
		Room n7 = new Room(10, 8, "You are in room 7");
		Room n8 = new Room(10, 10, "You are in room 8");
		Room n9 = new Room(8, 3, "You are in room 9");
		//No room 10 'actually' exists
		Room[] nodeArr = { n0, n1, n2, n3, n4, n5, n6, n7, n8, n9 };
		return nodeArr[node];
	}

	static int twoWayChoice(int node, int nodeChoiceOne, int nodeChoicetwo) {
		@SuppressWarnings("resource") // Cannot close scanner stream... i tried
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			return nodeChoiceOne;
		}
		if (choice == 2) {
			return nodeChoicetwo;
		}
		System.out.println("Enter 1 or 2");
		return twoWayChoice(node, nodeChoiceOne, nodeChoicetwo);
	}
}
