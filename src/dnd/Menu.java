package dnd;

import dnd.Personna.Character;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private Character fictionalCharacter = null;
    private final Color color = new Color();
    private final Color.Colors colors = color.new Colors();
    private String randomColor;

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
            System.out.println("You have to choose between 'mage' \uD83E\uDDD9\u200D♀\uFE0F or 'warrior' ⚔\uFE0F ...");
            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Please add the character type: ");
            System.out.println("Tape '2' to exit the game \uD83D\uDC4B");
            type = scanner.nextLine();
            if (type.equals("2")) {
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                System.exit(0);
            }
            if (!type.equals("mage") && !type.equals("warrior")) {
                System.out.println("Invalid type! \uD83D\uDEAB Please choose between 'mage'\uD83E\uDDD9\u200D♀\uFE0F or 'warrior'⚔\uFE0F .");
                continue;
            }

            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Please add the character name: ");
            System.out.println("Tape '2' to exit the game \uD83D\uDC4B");
            name = scanner.nextLine();
            if (name.equals("2")) {
                System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                System.exit(0);
            }

            fictionalCharacter = new Character(name, type);
            System.out.println(colors.colored(randomColor, "Character created successfully! \uD83D\uDCAB "));
            System.out.println(colors.colored(randomColor, "Your informations:" + fictionalCharacter.toString()));
            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Do you want to start the game now? 'y' for Yes or 'n' for No.");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y":
                    System.out.println("Starting the game...\uD83C\uDFB2");
                    new Game().playTurn(); // Appeler la méthode pour démarrer le jeu
                    break;
                case "n":
                    System.out.println("You can start the game later");
                    break;
                default:
                    System.out.println("Invalid choice! \uD83D\uDEAB You can start the game later from the menu. ⏳ ");
            }

            System.out.println("\uD83D\uDC68\u200D\uD83D\uDCBB Do you want to modify your character \uD83D\uDD04 ? 'y' for Yes or 'n' for No.");
            String modifyChoice = scanner.nextLine();
            if (modifyChoice.equalsIgnoreCase("y")) {
                modifyCharacter();
            } else if (modifyChoice.equalsIgnoreCase("n")) {
                System.out.println(colors.colored(randomColor, "Welcome to the Dungeon of Naheulbeuk \uD83D\uDEAA✨ " + fictionalCharacter.getName() + ", Type: " + fictionalCharacter.getType() + "!" + "The game is starting..."));
                System.out.println(colors.colored(randomColor, "Your informations:" + fictionalCharacter.toString()));
                break;
            } else {
                System.out.println("Invalid choice! \uD83D\uDEAB ");
            }
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
                    fictionalCharacter.setName(newName);
                    System.out.println(colors.colored(randomColor, "Character name updated successfully! \uD83D\uDCAB "));
                    System.out.println(colors.colored(randomColor, "Your informations:" + fictionalCharacter.toString()));
                    break;
                case 2:
                    System.out.println("Enter new type, 'mage' \uD83E\uDDD9\u200D♀\uFE0F or 'warrior' ⚔\uFE0F ...: ");
                    String newType = scanner.nextLine();
                    if (!newType.equals("mage") && !newType.equals("warrior")) {
                        System.out.println("Invalid type! Please choose between 'mage'\uD83E\uDDD9\u200D♀\uFE0F or 'warrior'⚔\uFE0F.");
                    } else {
                        fictionalCharacter.setType(newType);
                        System.out.println(colors.colored(randomColor, "Character type updated successfully! \uD83D\uDCAB "));
                        System.out.println(colors.colored(randomColor, "Your informations:" + fictionalCharacter.toString()));
                    }
                    break;
                case 3:
                    System.out.println(colors.colored(randomColor, "Welcome to the Dungeon of Naheulbeuk: " + fictionalCharacter.getName() + ", Type: " + fictionalCharacter.getType()));
                    System.out.println(colors.colored(randomColor, "Your informations:" + fictionalCharacter.toString()));
                    new Game().playTurn(); // Commencer le jeu
                    break;
                case 4:
                    System.out.println("Exiting the game. Goodbye! \uD83D\uDC4B");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! \uD83D\uDEAB ");
            }

            if (fictionalCharacter.getType() == null || fictionalCharacter.getName() == null) {
                System.out.println("Invalid character \uD83D\uDEAB ! Please ensure that both type and name are set. \uD83D\uDE15 ");
                break;
            }
        }
    }
}
