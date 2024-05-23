package dnd;

import dnd.boardGame.Board;
import dnd.personna.Mage;
import dnd.personna.Warrior;
import dnd.personna.Hero;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private Hero fictionalHero = null;
    private final Color color = new Color();
    private final Color.Colors colors = color.new Colors();
    private String randomColor;
    private GameDialog dialog = new GameDialog(scanner);


    public void startMenu() {
        randomColor = colors.randomColor();
        System.out.println(colors.colored(randomColor, "Welcome to the Dungeon of Naheulbeuk \uD83C\uDFF0 !"));
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '1' to create a fictional character \uD83D\uDC64");
        System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Tape '2' to exit the game \uD83D\uDC4B");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createCharacter();
                    break;
                case 2:
                    System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! \uD83D\uDEAB ");
            }
        }
    }
    private void createCharacter() {
        System.out.println("Creating a fictional character... \uD83E\uDD16 ");
        String name;
        String type;

        while (true) {
            System.out.println("You have to choose between 'mage' \uD83E\uDDD9\u200D♀\uFE0F or 'warrior' \uD83E\uDD77\uD83C\uDFFB ...");
            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Please add the character type: ");
            System.out.println("Tape '2' to exit the game \uD83D\uDC4B");
            type = scanner.nextLine();
            if (type.equals("2")) {
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                System.exit(0);
            }
            if (!type.equals("mage") && !type.equals("warrior")) {
                System.out.println("Invalid type! \uD83D\uDEAB Please choose between 'mage'\uD83E\uDDD9\u200D♀\uFE0F or 'warrior'\uD83E\uDD77\uD83C\uDFFB .");
                continue;
            }

            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Please add the character name: ");
            System.out.println("Tape '2' to exit the game \uD83D\uDC4B");
            name = scanner.nextLine();
            if (name.equals("2")) {
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                System.exit(0);
            }

            if (type.equals("mage")) {
                fictionalHero = new Mage(name);
            } else {
                fictionalHero = new Warrior(name);
            }

            if (fictionalHero != null) {
                int healthPoints = fictionalHero.getHealthPoints();
                int attackStrength = fictionalHero.getAttackStrength();
            } else {
                System.out.println("Error creating character. Please try again.");
                continue;
            }

            System.out.println(colors.colored(randomColor, "Character created successfully! \uD83D\uDCAB "));
            System.out.println(colors.colored(randomColor, "Your informations:"));
            displayCharacterSpecifics(fictionalHero);

            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Do you want to start the game now? 'y' for Yes or 'n' for No.");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y":
                    System.out.println("Starting the game... First throw \uD83C\uDFB2");
                    System.out.println(fictionalHero.scream());
                    Board board = new Board() ;
                    new Game(dialog, fictionalHero, board).playTurn(); // Appeler la méthode pour démarrer le jeu
                    break;
                case "n":
                    System.out.println("You can start the game later");
                    break;
                default:
                    System.out.println("Invalid choice! \uD83D\uDEAB You can start the game later from the menu. ⏳ ");
            }

            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Do you want to modify your character \uD83D\uDD04 ? 'y' for Yes or 'n' for No.");
            String modifyChoice = scanner.nextLine();
            if (modifyChoice.equals("y")) {
                modifyCharacter();
            } else if (modifyChoice.equals("n")) {
                System.out.println(colors.colored(randomColor, "Welcome to the Dungeon of Naheulbeuk \uD83D\uDEAA✨ " + fictionalHero.getName() + ", Type: " + fictionalHero.getType() + "!" + "The game is starting..."));
                System.out.println(colors.colored(randomColor, "Your informations:"));
                displayCharacterSpecifics(fictionalHero);
                break;
            } else {
                System.out.println("Invalid choice! \uD83D\uDEAB ");
            }
        }
    }
    private void displayCharacterSpecifics(Hero hero) {
        if (hero instanceof Mage) {
            Mage mage = (Mage) hero;
            System.out.println("Your are a famous mage named " + mage.getName() +"!");
            System.out.println("Health Points: " + mage.getHealthPoints());
            System.out.println("Attack Strength: " + mage.getAttackStrength());
        } else if (hero instanceof Warrior) {
            Warrior warrior = (Warrior) hero;
            System.out.println("Your are the dangerous warrior \uD83E\uDD77\uD83C\uDFFB  named " + warrior.getName() +"!");
            System.out.println("Warrior Health Points: " + warrior.getHealthPoints());
            System.out.println("Warrior Attack Strength: " + warrior.getAttackStrength());
        } else {
            System.out.println("The character is not a Mage or a Warrior \uD83E\uDD77\uD83C\uDFFB.");
        }
    }
    private void modifyCharacter() {
        System.out.println("Modifying character...");
        while (true) {
            System.out.println("Tape '1' to modify name \uD83D\uDD04");
            System.out.println("Tape '2' to modify type \uD83D\uDD04 ");
            System.out.println("Tape '3' No it's ok! Enter into the Dungeon of Naheulbeuk and start a game \uD83D\uDEAA✨ ");
            System.out.println("Tape '4' to exit the game \uD83D\uDC4B ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter new name: ");
                    String newName = scanner.nextLine();
                    fictionalHero.setName(newName);
                    System.out.println(colors.colored(randomColor, "Character name updated successfully! \uD83D\uDCAB "));
                    System.out.println(colors.colored(randomColor, "Your informations:"));
                    displayCharacterSpecifics(fictionalHero);
                    break;
                case 2:
                    System.out.println("Enter new type, 'mage' \uD83E\uDDD9\u200D♀\uFE0F or 'warrior' \uD83E\uDD77\uD83C\uDFFB ...: ");
                    String newType = scanner.nextLine();
                    if (!newType.equals("mage") && !newType.equals("warrior")) {
                        System.out.println("Invalid type! Please choose between 'mage'\uD83E\uDDD9\u200D♀\uFE0F or 'warrior'\uD83E\uDD77\uD83C\uDFFB.");
                    } else {
                        fictionalHero.setType(newType);
                        System.out.println(colors.colored(randomColor, "Character type updated successfully! \uD83D\uDCAB "));
                        System.out.println(colors.colored(randomColor, "Your informations:"));
                        displayCharacterSpecifics(fictionalHero);
                    }
                    break;
                case 3:
                    System.out.println(colors.colored(randomColor, "Welcome to the Dungeon of Naheulbeuk: " + fictionalHero.getName() + ", Type: " + fictionalHero.getType()));
                    System.out.println(colors.colored(randomColor, "Your informations:"));
                    displayCharacterSpecifics(fictionalHero);
                    Board board = new Board();
                    new Game(dialog, fictionalHero, board).playTurn(); // Commencer le jeu
                    break;
                case 4:
                    System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! \uD83D\uDEAB ");
            }

            if (fictionalHero.getType() == null || fictionalHero.getName() == null) {
                System.out.println("Invalid character \uD83D\uDEAB ! Please ensure that both type and name are set. \uD83D\uDE15 ");
                break;
            }
        }
    }
}