package heros;

import java.util.*;

public class rogue extends modelHero {
    int energie;

    // Affichage caractéristiques des personnages

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+energie+" ENERGIE | "+armor+" ARMURE";
    }

    // Construteur par défaut et avec attributs

    public rogue(){

        // Création d'une liste de nom et choix random lors de la génération du héro
        List<String> rogueName = new ArrayList<>();
        rogueName.add("Kagani Heurtenuit");
        rogueName.add("Lilian Voss");
        rogueName.add("Mathias Saw");
        rogueName.add("Draka");
        rogueName.add("Tess Grisetête");
        rogueName.add("Edwin VanCleef");
        rogueName.add("Veras Ombrenoir");
        rogueName.add("Conrad Kurzen");
        rogueName.add("Chef Anders");
        rogueName.add("Akaari Sombre-Sang");
        String rogueNameRNG = rogueName.get(new Random().nextInt(rogueName.size()));
        this.name = rogueNameRNG;

        // Attributs par défaut pour la classe 'rogue'
        this.hp = 130;
        this.dmg = 65;
        this.energie = 100;
        this.armor = 15;
        this.def = armor;
        this.life = true;
    }

    public rogue(String name, int hp, double dmg, int energie, double armor, double def, boolean life){
        super(name, hp, dmg, armor, def, life);
        this.energie=energie;
    }

    // Accesseurs

    public int getEnergieHero(){
        return this.energie;
    }

    public void setEnergieHero(int energie){
        this.energie = energie;
    }

}