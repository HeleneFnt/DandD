package dnd;

import java.util.Scanner;

public class Menu {
        static Scanner scanner = new Scanner(System.in); // Création du scanner pour récupérer les données tapées
        static Character fictionalCharacter = null; // Initialisation d'une variable pour les personnages de fiction

        public static void main(String[] args) {
                // Créer un nouveau personnage ou quitter le jeu
                System.out.println("Welcome to the Dungeon of Naheulbeuk");
                System.out.println("1. Choose a fictional character");
                System.out.println("2. Exit the game");
                while (true) {
                        int choice = scanner.nextInt(); // Lecture du choix de l'entier  de l'utilisateur
                        scanner.nextLine();

                        switch (choice) {
                                case 1:
                                        System.out.println("Creating a fictional character...");
                                        System.out.println("Please add the character name: ");
                                        String nom = scanner.nextLine();
                                        System.out.println("You have to choose between warrior or mage...");
                                        System.out.println("Please add the character type: ");
                                        String type = scanner.nextLine();
                                        fictionalCharacter = new Character(nom, type);
                                        System.out.println("Character created successfully! Name: " + fictionalCharacter.getName() + ", Type: " + fictionalCharacter.getType());
                                        break;
                                case 2:
                                        System.out.println("Exiting the game. Goodbye!");
                                        System.exit(0); // Sortie du jeu
                                        break;
                                default:
                                        System.out.println("Invalid choice!");
                        }


                }
        }
}

