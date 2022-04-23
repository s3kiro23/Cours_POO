package heros;

import java.util.*;

import equipments.armors.modelArmor;
import equipments.consumables.modelconso;
import equipments.consumables.potSoin;
import equipments.jelwery.modelJelwery;
import equipments.weapons.dagger;


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
        this.weapon_slot1 = new dagger();
        this.weapon_slot2 = null;
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

    // public rogue(String name, int hp, double dmg, int energie, double armor, double def, boolean life, int level, double xp, 
    // modelWeapon weapon_slot1, modelWeapon weapon_slot2, 
    // modelArmor armor_slot1, modelArmor armor_slot2, modelArmor armor_slot3, 
    // modelArmor armor_slot4, modelArmor armor_slot5, modelArmor armor_slot6, modelArmor armor_slot7, 
    // modelJelwery jelwery_slot1, modelJelwery jelwery_slot2, modelJelwery jelwery_slot3,
    // modelconso consumables_slot1, modelconso consumables_slot2, modelconso consumables_slot3){
    //     super(name, hp, dmg, armor, def, life, level, xp, 
    //     weapon_slot1, weapon_slot2, 
    //     armor_slot1, armor_slot2, armor_slot3, armor_slot4, armor_slot5, armor_slot6, armor_slot7, 
    //     jelwery_slot1, jelwery_slot2, jelwery_slot3, 
    //     consumables_slot1, consumables_slot2, consumables_slot3);
    //     this.energie=energie;
    // }

    // Accesseurs

    public int getEnergieHero(){
        return this.energie;
    }

    public void setEnergieHero(int energie){
        this.energie = energie;
    }

}