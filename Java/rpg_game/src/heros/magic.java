package heros;

import java.util.*;

import equipments.consumables.modelconso;
import equipments.consumables.potSoin;
import equipments.jelwery.modelJelwery;
import equipments.weapons.modelWeapon;
import equipments.weapons.staff;
import equipments.armors.modelArmor;

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
        this.weapon_slot1 = new staff();
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

    public magic(String name, int hp, double dmg, int mana, double armor, double def, boolean life, int level, double xp, 
    modelWeapon weapon_slot1, modelWeapon weapon_slot2, 
    modelArmor armor_slot1, modelArmor armor_slot2, modelArmor armor_slot3, 
    modelArmor armor_slot4, modelArmor armor_slot5, modelArmor armor_slot6, modelArmor armor_slot7, 
    modelJelwery jelwery_slot1, modelJelwery jelwery_slot2, modelJelwery jelwery_slot3,
    modelconso consumables_slot1, modelconso consumables_slot2, modelconso consumables_slot3){
        super(name, hp, dmg, armor, def, life, level, xp, 
        weapon_slot1, weapon_slot2, 
        armor_slot1, armor_slot2, armor_slot3, armor_slot4, armor_slot5, armor_slot6, armor_slot7, 
        jelwery_slot1, jelwery_slot2, jelwery_slot3, 
        consumables_slot1, consumables_slot2, consumables_slot3);
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
