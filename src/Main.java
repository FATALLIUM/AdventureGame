import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
    // asks for player's name
    System.out.print("What is your name?: ");
    String name = scan.nextLine();

    // makes sure that the player name is less than twelve characters
       while (name.length() >= 12) {
        System.out.println("I can't remember that. Please don't have your name be more than 12 characters.");
        System.out.print("What is your name: ");
        name = scan.nextLine();
    }

    if (name.equals("")) { // if the player has entered nothing
        System.out.println("... your name is Bob now.");
        AdventureGame game = new AdventureGame();
        game.printStory();
    } else if (name.equals("Steve")) { // if the player has entered 'Steve'
        System.out.println("Steve? Oh, like that mushroom ghost.");
    }
    AdventureGame game = new AdventureGame(name);
    game.menu();
    }
}
