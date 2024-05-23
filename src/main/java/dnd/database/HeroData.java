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

    // Méthode pour obtenir une connexion à la base de données
    private static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/DungeonsAndDragons";
        String user = "HeleneFnt";
        String password = "6cp6pgk";
        Class.forName("com.mysql.cj.jdbc.Driver");
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
                int healthPoints = resultSet.getInt("HealthPoints");
                int attackStrength = resultSet.getInt("AttackStrength");

                OffensiveStuff offensiveStuff = null;
                DefensiveStuff defensiveStuff = null;

                Hero hero;
                if (type.equalsIgnoreCase("Magicien")) {
                    hero = new Mage(name);
                } else if (type.equalsIgnoreCase("Guerrier")) {
                    hero = new Warrior(name);
                } else {
                    continue; // Si le type n'est pas reconnu, passer à l'enregistrement suivant
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
}
