package heros;

import java.util.*;

import equipments.consumables.potSoin;
import equipments.weapons.bow;
import equipments.weapons.crossbow;
import equipments.weapons.modelWeapon;

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
        this.weapon_slot1 = new bow();
        this.weapon_slot2 = new crossbow();
        this.armor_slot1 = null;
        this.armor_slot2 = null;
        this.armor_slot3 = null;
        this.armor_slot4 = null;
        this.armor_slot5 = null;
        this.armor_slot6 = null;
        this.armor_slot7 = null;
        this.consumable_slot1 = new potSoin();
        this.consumable_slot2 =  null;
        this.consumable_slot3 =  null;
        this.jelwery_slot1 =  null;
        this.jelwery_slot2 =  null;
        this.jelwery_slot3 =  null;

    }

    public hunt(String name, int hp, double dmg, int focus, double armor, double def, boolean life, int level, double xp, 
    modelWeapon weapon_slot1, modelWeapon weapon_slot2, 
    modelWeapon armor_slot1, modelWeapon armor_slot2, modelWeapon armor_slot3, 
    modelWeapon armor_slot4, modelWeapon armor_slot5, modelWeapon armor_slot6, modelWeapon armor_slot7, 
    modelWeapon jelwery_slot1, modelWeapon jelwery_slot2, modelWeapon jelwery_slot3,
    modelWeapon consumables_slot1, modelWeapon consumables_slot2, modelWeapon consumables_slot3){
        super(name, hp, dmg, armor, def, life, level, xp,
        weapon_slot1, weapon_slot2, 
        armor_slot1, armor_slot2, armor_slot3, armor_slot4, armor_slot5, armor_slot6, armor_slot7, 
        jelwery_slot1, jelwery_slot2, jelwery_slot3, 
        consumables_slot1, consumables_slot2, consumables_slot3);
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