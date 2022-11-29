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

    // constructors
    public AdventureGame (String name) {
        this.name = name;
        this.playerHealth = 100;
        this.enemyHealth = 100;
        scan = new Scanner(System.in);
        inventory = "";
    }

    // uses a default name if the player has entered nothing for the name
    public AdventureGame () {
        name = "Bob";
        this.playerHealth = 100;
        this.enemyHealth = 100;
        scan = new Scanner(System.in);
        inventory = "";
    }

    // Used for the main class NOT DONE
    public void play() {
        printStory();
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
                "Where do you want to go? Left or right? \nYes (1) \nNo (2) \n");
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
        System.out.println("Pick it up? \nYes (1) \nNo (2) \n");
        decision = scan.nextInt();
        scan.nextLine();
        if (decision == 1) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("You obtained a flower! It's added to your inventory.");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("It's probably very important.");
            inventory += "flower";
        }
        else {
            System.out.println("You leave the flower.");
        }

        System.out.println("You continue on your journey to find berries.");
        System.out.println("...");
        System.out.println("It's quiet, until something clinks behind you. Turn around? \nYes (1)  \n No? (2) \n");
        decision = scan.nextInt();
        scan.nextLine();
        switch (decision) {
            case 1:
                System.out.println("You turn around. Nothing's there. You continue on.");
                break;
            case 2:
                System.out.println("You don't turn around and continue on. It was probably nothing.");
        }
        System.out.println("There's a bottle on the ground. Seems like a potion.");
        System.out.println("Pick it up? \nYes (1) \nNo (2) \n");
        decision = scan.nextInt();
        scan.nextLine();
        if (decision == 1) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("You obtained a potion! It's added to your inventory.");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            inventory += "potion";
        }
        else {
            System.out.println("You leave the potion.");
        }
        System.out.println("You're pretty deep inside the forest now. It's getting kind of dark, too.");
        System.out.println("Yeah. It's dark.");
        System.out.println("Probably your cue to go home.");
        System.out.println("...");
        System.out.println("Something's rustling in the bushes...\n");
        System.out.println("Look? (1) \n");
        decision = scan.nextInt();
        scan.nextLine();
        if (decision == 1) {
            System.out.println("A mushroom pops out! It's the size of you!");
        }
        System.out.println("There's a rock to your left (1) but the mushroom doesn't seem hostile... (2)\n");
        System.out.println("What will you do?: \nFight (1) \nChill (2)\n");
        decision = scan.nextInt();
        scan.nextLine();
        switch (decision) {
            case 1:
                System.out.println("You pick up the rock. Violence is not the question... but the answer!!!");
                battleMushroom();
                break;
            case 2:
                if (inventory.contains("flower")) {
                System.out.println("You decide to give the red flower you picked up earlier to the mushroom.\n" +
                        "It seems very happy. You invite the mushroom to your house and have some hot soup.\n\n\n" +
                        "[HAPPY-GO-LUCKY MUSHROOM TAMER ENDING ACHIEVED - ENDING 1]\n\nname + " + "SIGNING OUT!");
                }
                else {
                    System.out.println("The two of you have a nice chat about chickens and watermelons.\n" +
                            "You invite the mushroom to your house and have some hot soup.\n\n\n" +
                            "[HAPPY-GO-LUCKY MUSHROOM TAMER ENDING ACHIEVED - ENDING 2]\n\n" +
                            name + " SIGNING OUT!");
                }
                break;
        }
    }

    // battle method
    public void battleMushroom() {
        int turn = 0;
        boolean fightEnd = false;
        int randomNum = (int) (Math.random() * 3) + 1;
        String randomText = "";

        while (turn < 7 && !fightEnd) {
            int playerAttack = 0;
            int enemyAttack = 0;

            // player turn
            System.out.println("You start first!");
            System.out.print("Battle choices: \n(1) Rock \n(2) Paper \n(3) Scissors \n(4) Potion \n"); // gives player's choices
            decision = scan.nextInt();
            scan.nextLine();

            playerAttack = playerAttack(decision);

            if (decision == 1) { // rock
                System.out.println("You used Rock! You dealt " + playerAttack + " damage!");
            }
            else if (decision == 2) { // paper
                System.out.println("You used Paper! You dealt " + playerAttack + " damage!");
            } else if (decision == 3) { // scissors
                System.out.println("You used Scissors! You dealt " + playerAttack + " damage! However, you accidentally " +
                        "stab yourself with it, dealing 10 damage to yourself!");
            }
            else {
                // heal?
                if (inventory.contains("potion")) {
                    System.out.println("You used the Potion! You healed 20 HP!" );
                    playerHealth += 20;
                }
                else {
                    System.out.println("You don't have this item! Oh well!");
                }
            }
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            enemyHealth -= playerAttack;

            // mushroom turn
            enemyAttack = mushroomAttack();
            switch (randomNum) {
                case 1:
                    randomText = "Mushroom did a cartwheel! It was very awe-inspiring!";
                    break;
                case 2:
                    randomText = "Mushroom slapped you! It reminded you of your - !!!";
                    break;
                case 3:
                    randomText = "Mushroom flirted with you! You feel confused???";
                    break;
            }
            System.out.println(randomText +  " It dealt " + enemyAttack + " damage!");
            playerHealth -= enemyAttack;

            // print hp status
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("You have " + playerHealth + " HP!");
            System.out.println("Mushroom has " + enemyHealth + " HP!\n\n");
            turn++;
            if (playerHealth <= 0) {
                System.out.println("You have lost the battle! You become a mushroom ghost and roam the lands.\n\n\n" +
                        "[I SHOULD HAVE WATERED MY FISH ENDING ACHIEVED - ENDING 3]\n\n" +
                        name + " SIGNING OUT!");
                fightEnd = true;
            }
            else if (enemyHealth <= 0) {
                System.out.println("You won! The mushroom monster waddles away, defeated and bruised.\n" +
                        "You feel kind of bad for it...\n" +
                        "You decide to head home after that, holding a bloodied rock.\n\n\n" +
                        "[YOUR MOTHER RAISED A VIOLENT CHILD ENDING ACHIEVED - ENDING 4]\n\n" +
                        name + " SIGNING OUT!");
                fightEnd = true;
            }
        }
        if (turn == 6) {
            System.out.println("You couldn't defeat the mushroom monster in time! You run away like how I ran from my ex-wife!" +
                    "\n\n\n[WHAT IS WRONG WITH THESE ENDING NAMES ENDING ACHIEVED - ENDING 5]\n\n" +
                    name + " SIGNING OUT!");
        }
    }

    // print out handsome mushroom
    private void mushroomLook() {
        int l = 0;
        int s = 0;

        for (int j = 1; j <= 3; j++) {
            if(j == 1) {
                l = 1;
                s = 8;
            } else {
                l = 0;
                s = 10;
            }

            for (int i = l; i >= 0; i--) {
                System.out.print(" ");
            }

            for (int k = s; k >= 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int p = 0; p <= 2; p++) {
            System.out.print("     ");

            for (int t = 1; t <= 3; t++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // attack methods
    // based on the player's decision, will do different amounts of dmg
    public int playerAttack(int decision) {
        int attack = 0;
        switch (decision) {
            case 1:
                // (1) rock
                // randomly deals 1-30 dmg to the mushroom
                attack = (int) (Math.random() * 30) + 1;
                break;
            case 2:
                // (2) paper
                // deals 20 dmg each time to the mushroom
                attack = 20;
                break;
            case 3:
                // (3) scissors
                // deals 30 dmg to the mushroom and 10 dmg to the player
                attack = 30;
                playerHealth -=10;
                break;
        }
        return attack;
    }

    // mushroom will randomly deal 1-20 dmg
    public int mushroomAttack() {
        return (int) (Math.random() * 40) + 1;
    }
}
