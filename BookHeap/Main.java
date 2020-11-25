import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		MaxHeap MH = new MaxHeap();

		Book[] books = { new Book("Life of Pi"), new Book("Neuromancer"), new Book("Looking Glass"), new Book("Ready Player 1") };
		MH.buildHeap(books);
		System.out.println("**Build heap was used to populate the first few Books in this heap from an array.**");

		while (true) {
			System.out.println("Here is the current heap:");
			if (MH.toString() == "") {
				System.out.println("[These are not items in the heap]");
			} else {
				System.out.println("The Heap as it is stored as an array: " + MH.toString());
				System.out.println();
				System.out.println("The Heap sorted alphabetically: " + MH.sortedPrint());
				System.out.println();
			}

			System.out.println(
					"1. Add a Book to the Heap.\n" + "2. Remove the max Book from the Heap\n" + "3. Exit the program.");
			int userChoice = 0;
			try {
				userChoice = Integer.parseInt(keyboard.nextLine());
			} catch (Exception e) {

			}
			switch (userChoice) {
			case 1:
				System.out.println("Input the title of the Book you wish to add.");
				String titleInput = keyboard.nextLine();
				MH.addBook(new Book(titleInput));
				break;
			case 2:
				Book removedBook = MH.removeMax();
				System.out.println(removedBook + " was removed from the Heap.");
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please try again.\n");
				break;
			}
		}
	}
}
