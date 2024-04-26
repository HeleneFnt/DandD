package dnd;
import java.util.Scanner;


public class Menu {
        Scanner scanner = new Scanner(System.in);
        Character fictionalCharacter = null;

        public void startMenu() {
                System.out.println("Welcome to the Dungeon of Naheulbeuk !");
                System.out.println("Tape '1' to create a fictional character");
                System.out.println("Tape '2' to exit the game");

                while (true) {
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                                case 1:
                                        createCharacter();
                                        break;
                                case 2:
                                        if (fictionalCharacter != null) {
                                                modifyCharacter();
                                        } else {
                                                System.out.println("No character created yet");
                                        }
                                        break;
                                case 3:
                                        System.out.println("Exiting the game. Goodbye!");
                                        System.exit(0);
                                        break;
                                default:
                                        System.out.println("Invalid choice!");
                        }
                }
        }

        public void createCharacter() {
                System.out.println("Creating a fictional character...");
                String name;
                String type;

                while (true) {
                        System.out.println("You have to choose between warrior or mage...");
                        System.out.println("Please add the character type: ");
                        System.out.println("Tape '2' to exit the game");
                        type = scanner.nextLine();
                        if (type.equals("2")) {
                                System.out.println("Exiting the game. Goodbye!");
                                System.exit(0);
                        }
                        if (!type.equals("mage") && !type.equals("warrior")) {
                                System.out.println("Invalid type! Please choose between 'mage' or 'warrior'.");
                                continue;
                        }

                        System.out.println("Please add the character name: ");
                        System.out.println("Tape '2' to exit the game");
                        name = scanner.nextLine();
                        if (name.equals("2")) {
                                System.out.println("Exiting the game. Goodbye!");
                                System.exit(0);
                        }

                        fictionalCharacter = new Character(name, type);
                        System.out.println("Character created successfully! Name: " + fictionalCharacter.getName() + ", Type: " + fictionalCharacter.getType());
                        System.out.println("Do you want to modify your character ? 'y' for Yes or 'n' for No.");
                        System.out.println("Tape '2' to exit the game");
                        String choice = scanner.nextLine();
                        if (choice.equals("2")) {
                                System.out.println("Exiting the game. Goodbye!");
                                System.exit(0);
                        }

                        switch (choice.toUpperCase()) {
                                case "Y":
                                        modifyCharacter();
                                        break;
                                case "N":
                                        System.out.println("Welcome to the Dungeon of Naheulbeuk " + fictionalCharacter.getName() + ", Type: " + fictionalCharacter.getType() + "!");
                                        System.out.println("Your informations:"+ fictionalCharacter.toString());
                                        return;
                                default:
                                        System.out.println("Invalid choice!");
                        }
                }
        }

        public void modifyCharacter() {
                System.out.println("Modifying character...");
                while (true) {
                        System.out.println("Tape '1' to modify name");
                        System.out.println("Tape '2' to modify type");
                        System.out.println("Tape '3' No it's ok! Enter into the Dungeon of Naheulbeuk");
                        System.out.println("Tape '4' to exit the game");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                                case 1:
                                        System.out.println("Enter new name: ");
                                        String newName = scanner.nextLine();
                                        fictionalCharacter.setName(newName);
                                        System.out.println("Character name updated successfully!");
                                        System.out.println("Your informations:"+ fictionalCharacter.toString());
                                        break;
                                case 2:
                                        System.out.println("Enter new type: ");
                                        String newType = scanner.nextLine();
                                        fictionalCharacter.setType(newType);
                                        System.out.println("Character type updated successfully!");
                                        System.out.println("Your informations:"+ fictionalCharacter.toString());
                                        break;
                                case 3:
                                        System.out.println("Welcome to the Dungeon of Naheulbeuk: " + fictionalCharacter.getName() + ", Type: " + fictionalCharacter.getType());
                                        System.out.println("Your informations:"+ fictionalCharacter.toString());
                                        break;
                                case 4:
                                        System.out.println("Exiting the game. Goodbye!");
                                        System.exit(0);
                                default:
                                        System.out.println("Invalid choice!");
                        }
                }
        }

}
