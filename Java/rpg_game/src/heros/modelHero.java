package heros;

import java.util.*;

import monsters.modelMonster;

public abstract class modelHero {
    protected String name;
    protected int hp;
    protected double dmg;
    protected double armor;
    protected double def;
    protected boolean life;

    // Constructeur par défaut et avec attributs

    public modelHero(){}

    public modelHero(String name, int hp, double dmg, double armor, double def, boolean life){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.armor = armor;
        this.def = armor;
        this.life = true;

    }

    // Affichage caractéristiques des personnages

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+armor+" ARMURE";
    }

    // Méthode de sélection du type de héro en début de partie

    // public static void selectHeroType(String h){
    //     int choice = 0;
    //     Scanner input = new Scanner(System.in);
    //     System.out.println("---==== Choisissez votre type de héro ====---\n");
    //     System.out.println("---==== [HUNT]= tapez 1 ");
    //     System.out.println("---==== [ROGUE]= tapez 2 ");
    //     System.out.println("---==== [MAGIC]= tapez 3 ");
    //     System.out.println("---==== [WARRIOR]= tapez 4 ");
    //     choice = input.nextInt();
    //     System.out.println("\n-=======================================================-");
        
    //         if (choice == 1){
    //             modelHero h1 = new hunt();
    //         }
        
    //         else if (choice == 2){
    //             modelHero h1 = new rogue();
    //         }

    //         else if (choice == 3){
    //             modelHero h1 = new magic();
    //         }

    //         else if (choice == 4){
    //             modelHero h1 = new warrior();
    //         }

    //         else{
    //             System.out.println("-========================================================-\n");
    //             System.out.println("---==== Merci d'utiliser une valeur entre 1 et 4 seulement pour sélectionner votre héro ! ====---");
    //             System.out.println("---==== Choisissez votre type de héro ====---\n");
    //             System.out.println("---==== [HUNT]= tapez 1 ");
    //             System.out.println("---==== [ROGUE]= tapez 2 ");
    //             System.out.println("---==== [MAGIC]= tapez 3 ");
    //             System.out.println("---==== [WARRIOR]= tapez 4 ");
    //             choice = input.nextInt();
    //         }
    //     }

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

    // Métode 'jouer' du héro

    public void playHero(modelMonster m){
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("---==== Choisissez votre action [ATTAQUER]= tapez 1 ou [PARER]= tapez 2  : ");
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