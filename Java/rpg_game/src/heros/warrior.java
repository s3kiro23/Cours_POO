package heros;

import java.util.*;

public class warrior extends modelHero {
    int rage;

    // Affichage caractéristiques des personnages
    
    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+rage+" RAGE | "+armor+" ARMURE";
    }
    
    // Construteur par défaut et avec attributs

    public warrior(){

        // Création d'une liste de nom et choix random lors de la génération du héro
        List<String> warriorName = new ArrayList<>();
        warriorName.add("Arthas");
        warriorName.add("Marcus Jonathan");
        warriorName.add("Lothar");
        warriorName.add("Anduin");
        warriorName.add("Garrosh Hurlenfer");
        warriorName.add("Tarakor");
        warriorName.add("Thrall");
        warriorName.add("Sergent Bly");
        warriorName.add("Sethman");
        warriorName.add("Sangredent");
        String warriorNameRNG = warriorName.get(new Random().nextInt(warriorName.size()));
        this.name = warriorNameRNG;

        // Attributs par défaut pour la classe 'warrior'
        this.hp = 170;
        this.dmg = 55;
        this.rage = 100;
        this.armor = 20;
        this.def = armor;
        this.life = true;
    }

    public warrior(String name, int hp, double dmg, int rage, double armor, double def, boolean life){
        super(name, hp, dmg, armor, def, life);
        this.rage = rage;
    }

    // Accesseurs

    public int getRageHero(){
        return this.rage;
    }

    public void setRageHero(int rage){
        this.rage = rage;
    }

}
