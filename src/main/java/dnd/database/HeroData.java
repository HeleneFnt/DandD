package dnd.database;

import dnd.personna.Hero;
import dnd.personna.Mage;
import dnd.personna.Warrior;
import dnd.stuff.DefensiveStuff;
import dnd.stuff.OffensiveStuff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HeroData {

    public static dnd.database.HeroData HeroData;

    // Méthode pour obtenir une connexion à la base de données
    private static Connection getConnection() throws Exception {
        String url = "jdbc:mariadb://localhost:3306/DungeonsAndDragons";
        String user = "HeleneFnt";
        String password = "6cp6pgk";
        return DriverManager.getConnection(url, user, password);
    }

    // Méthode pour récupérer la liste des héros
    public static List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Hero")) {

            while (resultSet.next()) {
                String type = resultSet.getString("Type");
                String name = resultSet.getString("Name");
                int healthPoints = resultSet.getInt("HealthPoint");
                int attackStrength = resultSet.getInt("AttackStrength");

                OffensiveStuff offensiveStuff = null;
                DefensiveStuff defensiveStuff = null;

                Hero hero;
                if (type.equalsIgnoreCase("Mage")) {
                    hero = new Mage(name);
                } else if (type.equalsIgnoreCase("Warrior")) {
                    hero = new Warrior(name);
                } else {
                    continue;
                }

                hero.setHealthPoints(healthPoints);
                hero.setAttackStrength(attackStrength);
                hero.setOffensiveStuff(offensiveStuff);
                hero.setDefensiveStuff(defensiveStuff);
                heroes.add(hero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public static void main(String[] args) {
        List<Hero> heroes = getHeroes();
        for (Hero hero : heroes) {
            System.out.println("Type: " + hero.getType());
            System.out.println("Name: " + hero.getName());
            System.out.println("HealthPoints: " + hero.getHealthPoints());
            System.out.println("AttackStrength: " + hero.getAttackStrength());
            System.out.println("OffensiveStuff: " + (hero.getOffensiveStuff() != null ? hero.getOffensiveStuff().getName() : "None"));
            System.out.println("DefensiveStuff: " + (hero.getDefensiveStuff() != null ? hero.getDefensiveStuff().getName() : "None"));
            System.out.println();
        }
    }

    //Méthode pour ajouter un héros à la base de données
    public static int createHero(Hero hero) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO Hero (Type, Name, HealthPoint, AttackStrength) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, hero.getType());
            statement.setString(2, hero.getName());
            statement.setInt(3, hero.getHealthPoints());
            statement.setInt(4, hero.getAttackStrength());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void editHero(Hero hero, int idPlayer) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Hero SET Name = ?, Type = ?, HealthPoint = ?, AttackStrength = ? WHERE id = ?")) {
            statement.setString(1, hero.getName());
            statement.setString(2, hero.getType());
            statement.setInt(3, hero.getHealthPoints());
            statement.setInt(4, hero.getAttackStrength());
            statement.setInt(5, idPlayer);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeLifePoints(Hero hero, int newLifePoints) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Hero SET HealthPoint = ? WHERE id = ?")) {
            statement.setInt(1, newLifePoints);
            statement.setInt(2, hero.getId()); // Utiliser l'ID du héros pour identifier l'enregistrement à mettre à jour
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Successfully updated health points for hero: " + hero.getName() +
                        ". New health points: " + newLifePoints);
            } else {
                System.out.println("Failed to update health points for hero: " + hero.getName());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while updating health points for hero: " + hero.getName());
            e.printStackTrace();
        }
    }

}