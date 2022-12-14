/**
 * This class represents a short text-based adventure game.
 *
 * @author Jiamin Zeng, Josephine Choong
 */
import java.util.Scanner;

public class AdventureGame {
    // attributes
    /**
     * The name of the player.
     */
    private String name;
    /**
     * The player's health.
     */
    private int playerHealth;
    /**
     * The player's input.
     */
    private String decision;
    /**
     * The Scanner object.
     */
    private Scanner scan;
    /**
     * The mushroom enemy's health.
     */
    private int mushroomHealth;
    /**
     * The pineapple enemy's health.
     */
    private int pineappleHealth;
    /**
     * The player's inventory.
     */
    private String inventory;
    /**
     * Endings.
     */
    private String[] endings = {"1. ", "2. ", "3. ", "4. ", "5. ", "6. ", "7. ", "8. ", "9. ", "10. "};

    // constructors
    /**
     * Instantiates an AdventureGame object (with the player's name).
     * @param name Player name
     */
    public AdventureGame (String name) {
        this.name = name;
        playerHealth = 100;
        mushroomHealth = 100;
        pineappleHealth = 250;
        scan = new Scanner(System.in);
        inventory = "";
    }

    // uses a default name if the player has entered nothing for the name
    /**
     * Instantiates an AdventureGame object (without player's name).
     */
    public AdventureGame () {
        name = "Bob";
        playerHealth = 100;
        mushroomHealth = 100;
        pineappleHealth = 250;
        scan = new Scanner(System.in);
        inventory = "";
    }

    // helper methods

    // prints the adventure out
    /**
     * Void method that contains a majority of the gameplay (player choices and story).
     */
    public void printStory() {
        int randomNum = (int) (Math.random() * 3) + 1;
        String randomWord = "";
        boolean quit = false;

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
                "Where do you want to go? Left or right? \nLeft (1) \nRight (2) \n");
        decision = scan.nextLine();
        do { // https://stackoverflow.com/questions/59411268/how-to-keep-switch-statement-continuing-in-java
            switch (decision) {
                case "1":
                    System.out.println("You head to your left and find " + randomWord);
                    quit = true;
                    break;
                case "2":
                    System.out.println("You head to your right and find a clearing. Seems peaceful; nothing's wrong.");
                    quit = true;
                    break;
                default: // https://www.w3schools.com/java/java_switch.asp
                    System.out.println("You decide to go straight. The only problem is a tree in the way. You should probably just stay on the path \nLeft (1) \nRight (2) \n");
                    decision = scan.nextLine();
                    break;
            }
        }
        while (!quit);

        System.out.println("You continue your journey and find a flower. It's red.");
        System.out.println("Pick it up? \nYes (1) \nNo (2) \n");
        decision = scan.nextLine();

        quit = false;
        do {
            switch (decision) {
                case "1":
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("You obtained a flower! It's added to your inventory.");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("It's probably very important.");
                    inventory += "flower";
                    quit = true;
                    break;
                case "2":
                    System.out.println("You leave the flower.");
                    quit = true;
                    break;
                default:
                    System.out.println("You still think about this very important decision.  \nYes (1) \nNo (2) \n");
                    decision = scan.nextLine();
                    break;
            }
        } while (!quit);

        System.out.println("You continue on your journey to find berries.");
        System.out.println("...");
        System.out.println("It's quiet, until something clinks behind you. Turn around? \nYes (1)  \nNo? (2) \n");
        decision = scan.nextLine();

        quit = false;
        do {
            switch (decision) {
                case "1":
                    System.out.println("You turn around. Nothing's there. You continue on.");
                    quit = true;
                    break;
                case "2":
                    System.out.println("You don't turn around and continue on. It was probably nothing.");
                    quit = true;
                    break;
                default:
                    System.out.println("You are frozen with fear. Yet, you feel like you should do something  \nYes (1) \nNo (2) \n");
                    decision = scan.nextLine();
                    break;
            }
        } while (!quit);

        System.out.println("There's a bottle on the ground. Seems like a potion.");
        System.out.println("Pick it up? \nYes (1) \nNo (2) \n");
        decision = scan.nextLine();

        quit = false;
        do {
            switch (decision) {
                case "1":
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("You obtained a potion! It's added to your inventory.");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    inventory += "potion";
                    quit = true;
                    break;
                case "2":
                    System.out.println("You leave the potion.");
                    quit = true;
                    break;
                default:
                    System.out.println("You are filled with indecision. This is a very bad choice. Do you want to get the potion? \nYes (1) \nNo (2) \n");
                    decision = scan.nextLine();
                    break;

            }
        } while (!quit);

        System.out.println("You're pretty deep inside the forest now. It's getting kind of dark, too.");
        System.out.println("Yeah. It's dark.");
        System.out.println("Probably your cue to go home.");
        System.out.println("...");
        System.out.println("Something's rustling in the bushes...\n");
        System.out.println("Look? (1) \n");
        decision = scan.nextLine();


        if (decision.equals("1")) {
            System.out.println("A mushroom pops out! It's the size of you!");
        } else {
            System.out.println("You turn away but the mushroom pops out anyways. It's the size of you!");
        }

        System.out.println("There's a rock to your left but the mushroom doesn't seem hostile... \n");
        System.out.println("What will you do?: \nFight (1) \nChill (2)\n");
        decision = scan.nextLine();

        quit = false;
        do {
            switch (decision) {
                case "1":
                    System.out.println("You pick up the rock. Violence is not the question... but the answer!!!");
                    battle("mushroom");
                    quit = true;
                    break;
                case "2":
                    if (inventory.contains("flower")) {
                        printStory(1);
                    } else {
                        printStory(2);
                    }
                    quit = true;
                    break;
                default:
                    System.out.println("You have a staring contest with the mushroom. It does not have eyes. You should do something else. \nFight (1) \nChill (2)\n");
                    decision = scan.nextLine();
                    break;
            }

        } while (!quit);

    }

    // battle method
    /**
     * Battle system.
     *
     * @param monster The enemy name
     */
    private void battle(String monster) {
        int turn = 0;
        String randomText = "";
        int death = 0;
        boolean mushroomDead = false;

        System.out.println("You start first!");
        if (monster.equals("pineapple")) {
            System.out.println("You are facing a god. Your health is restored.\n\n\nYou are filled with determination and inflict 20 damage per turn");
        }

        while (turn < 8) {
            int randomNum = (int) (Math.random() * 3) + 1;
            int playerAttack = 0;
            int enemyAttack = 0;

            // player turn

            System.out.print("Battle choices: \n(1) Rock \n(2) Paper \n(3) Scissors \n(4) Potion \n"); // gives player's choices
            decision = scan.nextLine();

            playerAttack = playerAttack(decision);

            if (decision.equals("1")) { // rock
                System.out.println("You used Rock! You dealt " + playerAttack + " damage!");

            } else if (decision.equals("2")) { // paper
                System.out.println("You used Paper! You dealt " + playerAttack + " damage!");
            } else if (decision.equals("3")) { // scissors
                System.out.println("You used Scissors! You dealt " + playerAttack + " damage! However, you accidentally " +
                        "stab yourself with it, dealing 10 damage to yourself!");
            } else if (decision.equals("4")) {
                // heal
                if (inventory.contains("potion")) {
                    System.out.println("You used the Potion! You healed 20 HP!");
                    playerHealth += 20;
                    if (playerHealth > 100) {
                        playerHealth = 100;
                        System.out.println("Your health is maxed out!");
                    }
                } else {
                    System.out.println("You don't have this item! Oh well!");
                }
            } else {
                System.out.println("You frantically wave your hands. You are unsure what this will do");
            }
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");

            if (monster.equals("mushroom")) {
                mushroomHealth -= playerAttack;
                // mushroom turn
                mushroomLook();
                enemyAttack = enemyAttack("mushroom");
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
                System.out.println(randomText + " It dealt " + enemyAttack + " damage!");
                playerHealth -= enemyAttack;

                // print hp status
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("You have " + playerHealth + " HP!");
                System.out.println("Mushroom has " + mushroomHealth + " HP!\n\n");
                turn++;
                if (playerHealth <= 0 && mushroomHealth <= 0) {
                    printStory(8);
                    menu();
                } else if (playerHealth <= 0) {
                    printStory(10);
                    menu();
                } else if (mushroomHealth <= 0) {
                    printStory(4);
                    mushroomDead = true;
                    playerHealth = 100;
                }
            }
            else if (monster.equals("pineapple")) {
                pineappleHealth -= playerAttack + 20;
                // pineapple fight
                if ((turn == 4) && (pineappleHealth > 0) && (playerHealth > 0)) {
                    System.out.println("\n\nThis is rather difficult, isn't it?\n\n[W I S H] \n(1)\n");
                    decision = scan.nextLine();
                    if (decision.equals("1")) {
                        System.out.println("You WISHED. For what you weren't sure. For who you didn't know.\nYou feel rejuvenated.\n\n\nHP fully healed.\n\n");
                    } else {
                        System.out.println("You aren't sure what to do. You feel confused. But you WISHED anyways. \nYou feel rejuvenated.\n\n\nHP fully healed.\n\n");
                    }
                    playerHealth = 100;
                }
                enemyAttack = enemyAttack("pineapple");
                switch (enemyAttack) {
                    case 30:
                        randomText = "The pineapple god sings a lullaby! How did you take damage???" +
                                " You start feeling sleepy... but you snap out of it!";
                        break;
                    case 15:
                        randomText = "The pineapple god exploded!!! That hurt a lot!";
                        break;
                    case 10:
                        randomText = "The pineapple god threw a chair at you. Where did it get a chair from???";
                        break;
                    case 5:
                        randomText = "The pineapple god made fun of your mother!!! What will you do???";
                        break;
                }
                System.out.println(randomText + " It dealt " + enemyAttack + " damage!");
                playerHealth -= enemyAttack;

                // print hp status
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("You have " + playerHealth + " HP!");
                System.out.println("The pineapple god has " + (pineappleHealth - playerAttack - 20) + " HP!\n\n");
                turn++;

                if (playerHealth <= 0 && pineappleHealth <= 0) {
                    printStory(9);
                    menu();
                }
                else if (playerHealth <= 0) {
                    printStory(3);
                    death ++;
                    if (death < 3) {
                        System.out.println("...\n\n\n\n\nContinue?\nYes (1) \nNo (2)\n");
                        decision = scan.nextLine();

                        boolean again = false;

                        do {
                            switch (decision) {
                                case "1": // The player chooses to continue
                                    System.out.println("...\n\n\nYou did not succumb.\n\n");
                                    turn = 0;
                                    playerHealth = 100;
                                    again  = true;
                                    break;
                                case "2": // The player chooses to quit
                                    System.out.println("The last sound you hear is the pineapple laughing");
                                    again  = true;
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("The underworld DLC is not available. \nContinue?\nYes (1) \nNo (2)\n");
                                    decision = scan.nextLine();
                                    break;

                            }
                        } while (!again );
                    }
                } else if (pineappleHealth <= 0) {
                    printStory(6);
                    menu();
                }
                else if (death == 2) {

                    printStory(7);
                    menu();
                }
            }
            if ((turn == 7) && (playerHealth > 0)) {
                printStory(5);
                menu();
            }
            if (mushroomDead) {
                System.out.println(".\n.\n.\n.\n.\n.\nWould you like to play a secret boss?\nYes (1) \nNo (2)\n");
                decision = scan.nextLine();

                boolean fightSecretBoss = false;
                do {
                    switch (decision) {
                        case "1":
                            System.out.println("You continue your journey... delving deeper and deeper." +
                                    " The sun has long set and the shadows are tall. You're tired and hungry and berry-less.");
                            System.out.println("In the distance, you see something gold. What could that be?\nLook (1) \nStay where you are (2) \n");
                            decision = scan.nextLine();

                            switch (decision) {
                                case "1":
                                    System.out.println("You head towards the golden light and find... ");
                                    System.out.println("A pineapple!!!\nIt seems rather angry for some reason");
                                    break;
                                case "2":
                                    System.out.print("You have no choice. You head towards the golden light and find... ");
                                    System.out.println("A pineapple!!!\nIt seems rather angry for some reason");
                                    break;
                                default:
                                    System.out.println("Being confused doesn't stop you from running towards the light");
                                    System.out.println("You find... a mango. No, wait, it's a pineapple. \nIt seems rather angry for some reason");
                                    break;
                            }
                            battle("pineapple");
                            fightSecretBoss = true;
                            break;

                        case "2":
                            System.out.println("Well, that's all for the DLC! Stay tuned for R*s*d*n* E*i* 9!");
                            menu();
                        default:
                            System.out.println("Huh? \nWould you like to play a secret boss?\nYes (1) \nNo (2)\n");
                            decision = scan.nextLine();
                            break;
                    }

                } while (!fightSecretBoss);
            }
        }
    }

    // print out handsome mushroom
    /**
     * Prints out a mushroom.
     */
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
    /**
     * Returns the player's attack.
     *
     * @param decision The player's choice of attack.
     * @return The player's attack depending on what attack they chose.
     */
    private int playerAttack(String decision) {
        int attack = 0;
        switch (decision) {
            case "1":
                // (1) rock
                // randomly deals 1-30 dmg to the enemy
                attack = (int) (Math.random() * 30) + 1;
                break;
            case "2":
                // (2) paper
                // deals 20 dmg each time to the enemy
                attack = 20;
                break;
            case "3":
                // (3) scissors
                // deals 30 dmg to the enemy and 10 dmg to the player
                attack = 30;
                playerHealth -=10;
                break;
        }
        return attack;
    }

    // mushroom will randomly deal 1-30 dmg
    /**
     * Returns a monster's attack.
     *
     * @param monster The enemy name
     * @return The enemy's attack depending on what enemy (String monster) the player is facing
     */
    private int enemyAttack(String monster) {
        // Mushroom attack
        if (monster.equals("mushroom")) {
            return (int) (Math.random() * 30) + 1;
        }
        // Pineapple attack
        int randomNum = (int) (Math.random() * 3) + 1;
        switch (randomNum) {
            case 1: // Pineapple deals 40 dmg
                return 40;
            case 2: // Pineapple deals 15 dmg
                return 15;
            case 3: // Pineapple deals 5 dmg
                return 5;
        }
        return 10;
    }
    /**
     * Prints an ending depending on the (int endingNumber).
     *
     * @param endingNumber Returns one of endings 1-10.
     */
    // prints what ending the player gets
    private void printStory(int endingNumber) {
        switch (endingNumber) {
            case 1: // You decide to chill with the mushroom and have the flower
                endings[0] = "[HAPPY-GO-LUCKY MUSHROOM-FLOWER TAMER ENDING ACHIEVED - ENDING 1]";
                System.out.println("You decide to give the red flower you picked up earlier to the mushroom.\n" +
                        "It seems very happy. You invite the mushroom to your house and have some hot soup.\n\n\n" +
                        "[HAPPY-GO-LUCKY MUSHROOM-FLOWER TAMER ENDING ACHIEVED - ENDING 1]\n\n" +
                        name + " SIGNING OUT!");
                break;
            case 2: // You decide to chill with the mushroom and don't have the flower
                endings[1] = "[HAPPY-GO-LUCKY MUSHROOM TAMER ENDING ACHIEVED - ENDING 2]";
                System.out.println("The two of you have a nice chat about chickens and watermelons.\n" +
                        "You invite the mushroom to your house and have some hot soup.\n\n\n" +
                        "[HAPPY-GO-LUCKY MUSHROOM TAMER ENDING ACHIEVED - ENDING 2]\n\n" +
                        name + " SIGNING OUT!");
                break;
            case 3: // You lose to the pineapple
                endings[2] = "[I SHOULD HAVE WATERED MY FISH ENDING ACHIEVED - ENDING 3]";
                System.out.println("You have lost the battle! The pineapple god laughs at you!!!\n\n\n" +
                        "[I SHOULD HAVE WATERED MY FISH ENDING ACHIEVED - ENDING 3]\n\n" +
                        name + " SIGNING OUT!");
                break;
            case 4: // You defeat the mushroom
                endings[3] = "[YOUR MOTHER RAISED A VIOLENT CHILD ENDING ACHIEVED - ENDING 4]";
                System.out.println("You won! The mushroom monster waddles away, defeated and bruised.\n" +
                        "You feel kind of bad for it...\n" +
                        "You decide to head home after that, holding a bloodied rock.\n\n\n" +
                        "[YOUR MOTHER RAISED A VIOLENT CHILD ENDING ACHIEVED - ENDING 4]\n\n" +
                        name + " SIGNING OUT!");
                break;
            case 5: // You couldn't defeat the monster in the set amount of times
                endings[4] = "[WHAT IS WRONG WITH THESE ENDING NAMES ENDING ACHIEVED - ENDING 5]";
                System.out.println("You couldn't defeat the monster in time! You run away like how I ran from my ex-wife!" +
                        "\n\n\n[WHAT IS WRONG WITH THESE ENDING NAMES ENDING ACHIEVED - ENDING 5]\n\n" +
                        name + " SIGNING OUT!");
                break;
            case 6: // The secret ending for killing the pineapple
                endings[5] = "[DER EINE ENDING ACHIEVED - SECRET ENDING]";
                System.out.println("You have killed a god. The pineapple god dissolves in the golden wind.\n" +
                        "What will you do now? There's nothing left for you, or anyone else.\n" +
                        "The sky has lost it's sun and the world is plunged into darkness.\n\n\n" +
                        "[DER EINE ENDING ACHIEVED - SECRET ENDING]\n\n" +
                        name + " SIGNING OUT!");
                break;
            case 7: // After you died 2 times to the pineapple
                endings[6] = "[OBLITERATED ENDING ACHIEVED - ENDING 7]";
                System.out.println("\nYou have no right." +
                        "\n\n\n[OBLITERATED ENDING ACHIEVED - ENDING 7]");
                break;
            case 8: // You and the mushroom reach 0 hp
                endings[7] = "[SHOULD HAVE USED THE FLOWER - ENDING 8]";
                System.out.println("You both lost. You become a mushroom ghost and the mushroom became a human ghost. \n\n\n" +
                        "[SHOULD HAVE USED THE FLOWER - ENDING 8]\n\n" + name + " SIGNING OUT!");
                break;
            case 9: // You and the pineapple reach 0 hp
                endings[8] = "[I CAN'T WAIT FOR DELTARUNE CHAPTER 3 ENDING ACHIEVED - ENDING 9]";
                System.out.println("The two of explode into smithereens. The sky is clear and the sun is shining.\n\n\n" +
                        "[I CAN'T WAIT FOR DELTARUNE CHAPTER 3 ENDING ACHIEVED - ENDING 9]");

                break;
            case 10: // You lose to the mushroom
                endings[9] = "[YOU GOT THRASHED ENDING ACHIEVED - ENDING 10]";
                System.out.println("You get thrashed by the mushroom. You become a mushroom ghost. Your ancestors are ashamed...\n\n\n" +
                        "[YOU GOT THRASHED ENDING ACHIEVED - ENDING 10]");
                break;
        }
    }

    public void menu() {
        inventory = "";
        playerHealth = 100;
        mushroomHealth = 100;
        pineappleHealth = 100;
        while (true) {
            System.out.println("\n\nMENU:\n");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("1. Start!\n2. Achievements\n3. Exit Game");
            decision = scan.nextLine();
            switch (decision) {
                case "1":
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Starting game...");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    printStory();
                    break;
                case "2":
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("Endings Achieved:\n");
                    for (int i = 0; i < endings.length; i++) {
                        System.out.print(endings[i] + "\n");
                    }
                    break;
                case "3":
                    System.out.println("Buh-bye.");
                    System.exit(0);
                default:
                    System.out.println("Error!");
                    break;
            }
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------");
        }
    }

}