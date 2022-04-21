package heros;
import java.util.*;

import monsters.monster;

public abstract class hero {
    protected String name;
    protected int hp;
    protected double dmg;
    protected double armor;
    protected double def;
    protected boolean life;

    public hero() {
        this.name = "Ton héro";
        this.hp = 150;
        this.dmg = 30;
        this.armor = 15;
        this.def = armor;
        this.life = true;
    }

    public hero(String name, int hp, double dmg, double armor, double def, boolean life){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.armor = armor;
        this.def = armor;
        this.life = true;

    }

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+armor+" ARMURE";
    }

    public void attackHero(monster m){
            this.armor = this.def;
            double dmgHero = m.getHpMonster()-(this.getDmgHero()-m.getArmorMonster());
            m.setHpMonster((int) dmgHero);
            System.out.println("\n"+getNameHero()+" attaque "+m.getNameMonster()+" et lui inflige "+(this.getDmgHero()-m.getArmorMonster())+" DMG \n");
            System.out.println(m);

    }

    public void parryHero(){
        this.armor = this.def*2;
        System.out.println("\n"+getNameHero()+" se prépare à parer la prochaine attaque, son armure augmente !  "+"+ "+(getArmorHero()/2)+" ARMURE");
    }

    public void playHero(monster m){
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("---==== Choisissez votre action [ATTAQUER]= tapez 1 ou [PARER]= tapez 2  : ");
        choice = input.nextInt();
        System.out.println("\n-=======================================================-");
        
            if (choice == 1){
                attackHero(m);
            }
        
            else if (choice == 2){
                parryHero();
            }

            else{
                System.out.println("-========================================================-");
                System.out.println("---==== Merci d'utiliser 1 ou 2 pour continuer ! ====---");
                System.out.println("---==== Choisissez votre action [ATTAQUER]= tapez 1 ou [PARER]= tapez 2  :");
                choice = input.nextInt();
            }
        }

    public void monsterCheckLife(monster m){
        if (m.getHpMonster() <= 0){
            m.setLifeMonster(false);
            System.out.println("\n =========> "+getNameHero()+" a poncé "+m.getNameMonster()+",  LVL UP !");    
        }
    }

    public String getNameHero(){
        return this.name;
    }

    public int getHpHero(){
        return this.hp;
    }

    public double getDmgHero(){
        return this.dmg;
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