package dnd;

import java.util.Scanner;

public class Menu {
        static Scanner scanner = new Scanner(System.in); // Création du scanner pour récupérer les données tapées
        static Character fictional = null; // Initialisation d'une variable pour les personnages de fiction

        public static void main(String[] args) {
                // Créer un nouveau personnage ou quitter le jeu
                System.out.println("Welcome to the Dungeon");
                System.out.println("1. Choose a fictional character");
                System.out.println("2. Exit the game");
                while (true) {
                        int choice = scanner.nextInt(); // Lecture du choix de l'entier  de l'utilisateur

                        switch (choice) {
                                case 1:
                                        System.out.println("Creating a fictional character...");
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



//    public static void main(String[] args) {
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter username");
//
//        String Character = myObj.nextLine();  // Read user input
//        System.out.println("Username is: " + Character);  // Output user input
//    }
