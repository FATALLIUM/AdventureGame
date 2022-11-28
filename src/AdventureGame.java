//dmg = damage
import java.util.Scanner;

public class AdventureGame {
    //attributes
    private String name;
    private int playerHealth;
    private int decision;
    private Scanner scan;
    private int enemyHealth;
    private String inventory;

    Scanner scan = new Scanner(System.in);


    // constructors
    public AdventureGame (String name) {
        this.name = name;
        this.playerHealth = 100;
        this.enemyHealth = 100;
    }

    // Used for the main class NOT DONE
    public void play() {



    }


    // helper methods

    // prints the adventure out
    public void printStory() {
        int randomNum = (int) (Math.random() * 3) + 1;
        String randomWord = "";
        if (randomNum == 1) {
            randomWord = "a lake. It has several frogs lying around. They look like they're napping.";
        }
        else if (randomNum == 2) {
            randomWord = "a shed. It seems dilapidated and abandoned.";
        }
        else {
            randomWord = "a deer. It stares at you with unblinking eyes before running away.";
        }
        System.out.println("You are looking for berries to eat in the forest.\nIt is dark and damp and you should have stayed home.");
        System.out.println("You head in deeper into the forest and find a fork in the road.\n" +
                "Where do you want to go? Left or right? (1/2): \n");
        decision = scan.nextInt();
        scan.nextLine(); // clear buffer
        switch (decision) {
            case 1:
                System.out.println("You head to your left and find " + randomWord);
                break;
            case 2:
                System.out.println("You head to your right and find a clearing. Seems peaceful; nothing's wrong.");
                break;
        }
        System.out.println("You continue your journey and find a flower. It's red. You pick it up.");
        System.out.println("You obtained a flower! It's added to your inventory.");
        inventory += "flower";
        System.out.println("You continue on your journey to find berries.");
        System.out.println("...");
        System.out.println("It's quiet, until something clinks behind you. Turn around? (1/2): \n");
        decision = scan.nextInt();
        scan.nextLine();





    }

    // battle method
    public void battleMushroom() {
        int turn = 0;
        while (turn < 5 && (playerHealth > 0) && (enemyHealth > 0)) {
            int playerAttack = 0;
            System.out.println("You start first!");
            System.out.print("Battle choices: \n(1) Rock \n(2) Paper \n(3)Scissors"); //gives player's choices
            decision = scan.nextInt();

            playerAttack = playerAttack(decision);
            if (decision == 1) { //rock
                System.out.println("You used Rock! You dealt " + playerAttack + " damage.");
            }
            else if (decision == 2) { //paper
                System.out.println("You used Paper! You dealt " + playerAttack + " damage.");
            } else if (de)
            enemyHealth -= playerAttack;







            turn++;
        }
    }



    //attack methods

    //based on the player's decision, will do different amounts of dmg
    public int playerAttack(int decision) {
        int attack = 0;
        switch (decision) {
            case 1:
                // (1) rock
                //randomly deals 1-10 dmg to the mushroom
                attack = (int) (Math.random() * 10) + 1;
                break;
            case 2:
                // (2) paper
                //deals 5 dmg each time to the mushroom
                attack = 5;
                break;
            case 3:
                // (3) scissors
                //deals 20 dmg to the mushroom and 10 dmg to the player
                attack = 20;
                playerHealth -=10;
                break;
        }
        return attack;
    }

    //mushroom will randomly deal 1-50 dmg
    public int mushroomAttack() {
        int mushroomAttack = (int) (Math.random() * 50) + 1;
        return mushroomAttack;
    }



}
