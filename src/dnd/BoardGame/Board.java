package dnd.BoardGame;

import dnd.Personna.Gobelin;
import dnd.Personna.Wizard;
import dnd.Personna.Dragon;
import dnd.Stuff.Club;
import dnd.Stuff.Lightning;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private ArrayList<Case> cases;

    public Board() {
        this.cases = new ArrayList<>();
        initializeCases();
    }

    private void initializeCases() {
        // Création de la liste temporaire contenant tous les types de cases avec leur quantité respective
        ArrayList<Case> tempCases = new ArrayList<>();
        tempCases.add(new Lightning(1, "Lightning"));
        tempCases.add(new Club(2, "Club"));
        tempCases.add(new Gobelin(3, "Gobelin"));
        tempCases.add(new Lightning(4, "Lightning"));
        tempCases.add(new Club(5, "Club"));
        tempCases.add(new Gobelin(6, "Gobelin"));
        tempCases.add(new StandardHealthPotion(7, "Standard Health Potion"));
        tempCases.add(new Lightning(8, "Lightning"));
        tempCases.add(new Gobelin(9, "Gobelin"));
        tempCases.add(new Wizard(10, "Wizard"));
        tempCases.add(new Club(11, "Club"));
        tempCases.add(new Gobelin(12, "Gobelin"));
        tempCases.add(new StandardHealthPotion(13, "Standard Health Potion"));
        tempCases.add(new EmptyCase(14, "No effect"));
        tempCases.add(new Gobelin(15, "Gobelin"));
        tempCases.add(new EmptyCase(16, "No effect"));
        tempCases.add(new Wizard(17, "Wizard"));
        tempCases.add(new Club(18, "Club"));
        tempCases.add(new BonusWeaponCase(19, "Bonus Weapon"));
        tempCases.add(new Gobelin(20, "Gobelin"));
        tempCases.add(new Wizard(21, "Wizard"));
        tempCases.add(new BonusWeaponCase(22, "Bonus Weapon"));
        tempCases.add(new Gobelin(23, "Gobelin"));
        tempCases.add(new Wizard(24, "Wizard"));
        tempCases.add(new Gobelin(25, "Gobelin"));
        tempCases.add(new BonusWeaponCase(26, "Bonus Weapon"));
        tempCases.add(new Wizard(27, "Wizard"));
        tempCases.add(new GreatHealthPotion(28, "Great Health Potion"));
        tempCases.add(new Gobelin(29, "Gobelin"));
        tempCases.add(new Wizard(30, "Wizard"));
        tempCases.add(new StandardHealthPotion(31, "Standard Health Potion"));
        tempCases.add(new Gobelin(32, "Gobelin"));
        tempCases.add(new Wizard(33, "Wizard"));
        tempCases.add(new StandardHealthPotion(34, "Standard Health Potion"));
        tempCases.add(new Wizard(35, "Wizard"));
        tempCases.add(new Gobelin(36, "Gobelin"));
        tempCases.add(new Wizard(37, "Wizard"));
        tempCases.add(new BonusWeaponCase(38, "Bonus Weapon"));
        tempCases.add(new Gobelin(39, "Gobelin"));
        tempCases.add(new Wizard(40, "Wizard"));
        tempCases.add(new StandardHealthPotion(41, "Standard Health Potion"));
        tempCases.add(new Gobelin(42, "Gobelin"));
        tempCases.add(new Wizard(43, "Wizard"));
        tempCases.add(new StandardHealthPotion(44, "Standard Health Potion"));
        tempCases.add(new Dragon(45, "Dragon"));
        tempCases.add(new Gobelin(46, "Gobelin"));
        tempCases.add(new Wizard(47, "Wizard"));
        tempCases.add(new BonusWeaponCase(48, "Bonus Weapon"));
        tempCases.add(new BonusWeaponCase(49, "Bonus Weapon"));
        tempCases.add(new Gobelin(50, "Gobelin"));
        tempCases.add(new Wizard(51, "Wizard"));
        tempCases.add(new Dragon(52, "Dragon"));
        tempCases.add(new BonusWeaponCase(53, "Bonus Weapon"));
        tempCases.add(new Wizard(54, "Wizard"));
        tempCases.add(new Gobelin(55, "Gobelin"));
        tempCases.add(new Dragon(56, "Dragon"));
        tempCases.add(new Gobelin(57, "Gobelin"));
        tempCases.add(new Wizard(58, "Wizard"));
        tempCases.add(new BonusWeaponCase(59, "Bonus Weapon"));
        tempCases.add(new Gobelin(60, "Gobelin"));
        tempCases.add(new BonusWeaponCase(61, "Bonus Weapon"));
        tempCases.add(new Dragon(62, "Dragon"));

        // Mélange de la liste temporaire de manière aléatoire
        Collections.shuffle(tempCases);

        // Ajout des cases dans l'ordre à la liste principale de cases
        cases.addAll(tempCases);
    }

    public ArrayList<Case> getCases() {
        return cases;
    }
}
