package heros;

import java.util.*;

import equipments.armors.modelArmor;
import equipments.consumables.modelconso;
import equipments.jelwery.modelJelwery;
import equipments.weapons.modelWeapon;
import monsters.modelMonster;

public abstract class modelHero {
    protected String name;
    protected int hp;
    protected double dmg;
    protected double armor;
    protected double def;
    protected boolean life;
    protected int level;
    protected double xp;
    protected modelWeapon weapon_slot1;
    protected modelWeapon weapon_slot2;
    protected modelconso consumable_slot1;
    protected modelconso consumable_slot2;
    protected modelconso consumable_slot3;
    protected modelArmor armor_slot1;
    protected modelArmor armor_slot2;
    protected modelArmor armor_slot3;
    protected modelArmor armor_slot4;
    protected modelArmor armor_slot5;
    protected modelArmor armor_slot6;
    protected modelArmor armor_slot7;
    protected modelJelwery jelwery_slot1;
    protected modelJelwery jelwery_slot2;
    protected modelJelwery jelwery_slot3;


    // Constructeur par défaut et avec attributs

    public modelHero(){}

    public modelHero(String name, int hp, double dmg, double armor, double def, boolean life, int level, double xp,
    modelWeapon weapon_slot1, modelWeapon weapon_slot2, 
    modelArmor armor_slot1, modelArmor armor_slot2, modelArmor armor_slot3, 
    modelArmor armor_slot4, modelArmor armor_slot5, modelArmor armor_slot6, modelArmor armor_slot7, 
    modelJelwery jelwery_slot1, modelJelwery jelwery_slot2, modelJelwery jelwery_slot3,
    modelconso consumables_slot1, modelconso consumables_slot2, modelconso consumables_slot3){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.armor = armor;
        this.def = armor;
        this.life = true;
        this.level = level;
        this.xp = xp;
        this.weapon_slot1 = weapon_slot1;
        this.weapon_slot2 = weapon_slot2;
        this.armor_slot1 = armor_slot1;
        this.armor_slot2 = armor_slot2;
        this.armor_slot3 = armor_slot3;
        this.armor_slot4 = armor_slot4;
        this.armor_slot5 = armor_slot5;
        this.armor_slot6 = armor_slot6;
        this.armor_slot7 = armor_slot7;
        this.jelwery_slot1 = jelwery_slot1;
        this.jelwery_slot2 = jelwery_slot2;
        this.jelwery_slot3 = jelwery_slot3;
        this.consumable_slot1 = consumables_slot1;
        this.consumable_slot2 = consumables_slot2;
        this.consumable_slot3 = consumables_slot3;
    }

    // Affichage caractéristiques des personnages

    public String toString(){
        return name+" ["+level+"] "+" a "+hp+" PV | "+dmg+" DMG | "+armor+" ARMURE"+" | "+xp+" XP ";
    }

    // Méthodes 'attaquer' du héro

    public void attackHero(modelMonster m){
            this.armor = this.def;
            double dmgHero = m.getHpMonster()-(this.getDmgHero()-m.getArmorMonster());
            m.setHpMonster((int) dmgHero);
            System.out.println("\n"+getNameHero()+" attaque "+m.getNameMonster()+" et lui inflige "+(this.getDmgHero()-m.getArmorMonster())+" DMG \n");
            System.out.println(m);

    }

    // Méthodes 'parrer' du héro

    public void parryHero(){
        this.armor = this.def*2;
        System.out.println("\n"+getNameHero()+" se prépare à parer la prochaine attaque, son armure augmente !  "+"+ "+(getArmorHero()/2)+" ARMURE");
    }

    // Méthodes 'use potion' du héro

    public void usePotionHero(){

        this.setHpHero(this.getHpHero() + this.consumable_slot1.getPool());
        System.out.println("\n"+getNameHero()+" utilise une potion soin et récupére 100 points de vie");
        this.consumable_slot1 = null;
    }

    // Métode 'jouer' du héro

    public void playHero(modelMonster m){

        System.out.println("\n---==== Choisissez votre action [ATTAQUER]= tapez 1 ou [PARER]= tapez 2  ou [UTILISER POTION]= 3 : ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        System.out.println("\n-=======================================================-");
        
            if (choice == 1){
                attackHero(m);
            }
        
            else if (choice == 2){
                parryHero();
            }

            else if (choice == 3){
                usePotionHero();
            }

            else{
                System.out.println("-========================================================-");
                System.out.println("---==== Merci d'utiliser 1 ou 2 pour continuer ! ====---");
                System.out.println("---==== Choisissez votre action [ATTAQUER]= tapez 1 ou [PARER]= tapez 2  :");
                choice = input.nextInt();
            }
        }

    // Méthode de vérification si un monstre est en vie

    public void monsterCheckLife(modelMonster m){
        if (m.getHpMonster() <= 0){
            m.setLifeMonster(false);
            System.out.println("\n =========> "+getNameHero()+" a poncé "+m.getNameMonster()+",  LVL UP !");    
        }
    }

    // Accesseurs

    public String getNameHero(){
        return this.name;
    }

    public int getHpHero(){
        return this.hp;
    }

    public double getDmgHero(){
        return this.dmg = this.dmg + weapon_slot1.getModelWeaponDPS();
    }

    public double getArmorHero(){
        return this.armor;
    }

    public double getDefHero(){
        return this.def;
    }

    public boolean getLifeHero(){
        return this.life;
    }

    public modelWeapon getHeroWeapon_slot1(){
        return this.weapon_slot1;
    }

    public modelWeapon getHeroWeapon_slot2(){
        return this.weapon_slot1;
    }

    public modelArmor getHeroArmor_slot1(){
        return this.armor_slot1;
    }

    public modelArmor getHeroArmor_slot2(){
        return this.armor_slot2;
    }

    public modelArmor getHeroArmor_slot3(){
        return this.armor_slot3;
    }

    public modelArmor getHeroArmor_slot4(){
        return this.armor_slot4;
    }

    public modelArmor getHeroArmor_slot5(){
        return this.armor_slot5;
    }

    public modelArmor getHeroArmor_slot6(){
        return this.armor_slot6;
    }

    public modelArmor getHeroArmor_slot7(){
        return this.armor_slot7;
    }

    public modelJelwery getHeroJelwery_slot1(){
        return this.jelwery_slot1;
    }

    public modelJelwery getHeroJelwery_slot2(){
        return this.jelwery_slot2;
    }

    public modelJelwery getHeroJelwery_slot3(){
        return this.jelwery_slot3;
    }

    public modelconso getHeroConsumables_slot1(){
        return this.consumable_slot1;
    }

    public modelconso getHeroConsumables_slot2(){
        return this.consumable_slot2;
    }

    public modelconso getHeroConsumables_slot3(){
        return this.consumable_slot3;
    }

    public void setHeroWeapon_slot1(modelWeapon weapon_slot1){
        this.weapon_slot1 = weapon_slot1;
    }

    public void setHeroWeapon_slot2(modelWeapon weapon_slot2){
        this.weapon_slot1 = weapon_slot2;
    }

    public void setHeroArmor_slot1(modelArmor armor_slot1){
        this.armor_slot1 = armor_slot1;
    }

    public void setHeroArmor_slot2(modelArmor armor_slot2){
        this.armor_slot2 = armor_slot2;
    }

    public void setHeroArmor_slot3(modelArmor armor_slot3){
        this.armor_slot3 = armor_slot3;
    }

    public void setHeroArmor_slot4(modelArmor armor_slot4){
        this.armor_slot4 = armor_slot4;
    }

    public void setHeroArmor_slot5(modelArmor armor_slot5){
        this.armor_slot5 = armor_slot5;
    }

    public void setHeroArmor_slot6(modelArmor armor_slot6){
        this.armor_slot6 = armor_slot6;
    }

    public void setHeroArmor_slot7(modelArmor armor_slot7){
        this.armor_slot7 = armor_slot7;
    }

    public void setHeroJelwery_slot1(modelJelwery jelwery_slot1){
        this.jelwery_slot1 = jelwery_slot1;
    }

    public void setHeroJelwery_slot2(modelJelwery jelwery_slot2){
        this.jelwery_slot2 = jelwery_slot2;
    }

    public void setHeroJelwery_slot3(modelJelwery jelwery_slot3){
        this.jelwery_slot3 = jelwery_slot3;
    }

    public void setHeroConsumables_slot1(modelconso consumable_slot1){
        this.consumable_slot1 = consumable_slot1;
    }

    public void setHeroConsumables_slot2(modelconso consumable_slot2){
        this.consumable_slot2 = consumable_slot2;
    }

    public void setHeroConsumables_slot3(modelconso consumable_slot3){
        this.consumable_slot3 = consumable_slot3;
    }

    public void setNameHero(String name){
        this.name = name;
    }
    public void setHpHero(int hp){
        this.hp = hp;
    }

    public void setDmgHero(double dmg){
        this.dmg = dmg;
    }

    public void setArmorHero(double armor){
        this.armor = armor;
    }

    public void setDefHero(double def){
        this.def = armor;
    }

    public void setLifeHero(boolean life){
        this.life = life;
    }

}