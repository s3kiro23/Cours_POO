package heros;

import java.util.*;

public class magic extends modelHero {
    int mana;

    // Affichage caractéristiques des personnages

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+mana+" mana | "+armor+" ARMURE";
    }

    // Construteur par défaut et avec attributs

    public magic(){

        // Création d'une liste de nom et choix random lors de la génération du héro
        List<String> magicName = new ArrayList<>();
        magicName.add("Jaina PortVaillant");
        magicName.add("Medhiv");
        magicName.add("Milhouse Tempête-de-Mana");
        magicName.add("Ryanna");
        magicName.add("Elisande");
        magicName.add("Khadgar");
        magicName.add("Kalecgos");
        magicName.add("Kael'thas Haut-Soleil");
        magicName.add("Vendros");
        magicName.add("Vargoth");
        String magicNameRNG = magicName.get(new Random().nextInt(magicName.size()));
        this.name = magicNameRNG;

        // Attributs par défaut pour la classe 'magic'
        this.hp = 100;
        this.dmg = 70;
        this.mana = 100;
        this.armor = 10;
        this.def = armor;
        this.life = true;
    }

    public magic(String name, int hp, double dmg, int mana, double armor, double def, boolean life){
        super(name, hp, dmg, armor, def, life);
        this.mana = mana;
    }

    // Accesseurs

    public int getManaHero(){
        return this.mana;
    }

    public void setManaHero(int mana){
        this.mana = mana;
    }
}
