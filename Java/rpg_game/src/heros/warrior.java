package heros;

import java.util.*;

import equipments.modelEquipment;
import equipments.consumables.modelconso;
import equipments.consumables.potSoin;
import equipments.weapons.modelWeapon;
import equipments.weapons.sword;

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
        this.weapon_slot1 = new sword();
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

    public warrior(String name, int hp, double dmg, int rage, double armor, double def, boolean life, int level, double xp, 
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
