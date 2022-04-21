package heros;

import java.util.*;

public class hunt extends modelHero {
    int focus;

    // Affichage caractéristiques des personnages

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+focus+" FOCUS | "+armor+" ARMURE";
    }

    // Construteur par défaut et avec attributs

    public hunt(){

        // Création d'une liste de nom et choix random lors de la génération du héro
        List<String> huntName = new ArrayList<>();
        huntName.add("Su'ura Viveflèche");
        huntName.add("Syrenne");
        huntName.add("Tyrande Murmevent");
        huntName.add("Garaxxas");
        huntName.add("Zerillis");
        huntName.add("Halduron Luisaile");
        huntName.add("Illyanna Corvichêne");
        huntName.add("Zhu Long");
        huntName.add("Lexera");
        huntName.add("Fenris Frère-Loup");
        String huntNameRNG = huntName.get(new Random().nextInt(huntName.size()));
        this.name = huntNameRNG;

        // Attributs par défaut pour la classe 'Hunt'
        this.hp = 120;
        this.dmg = 65;
        this.focus = 100;
        this.armor = 15;
        this.def = armor;
        this.life = true;
    }

    public hunt(String name, int hp, double dmg, int focus, double armor, double def, boolean life){
        super(name, hp, dmg, armor, def, life);
        this.focus = focus;
    }

    // Accesseurs

    public int getFocusHero(){
        return this.focus;
    }

    public void setFocusHero(int focus){
        this.focus = focus;
    }

}