package monsters;
import java.util.*;

import equipments.modelEquipment;
import equipments.armors.modelArmor;
import equipments.jelwery.modelJelwery;
import equipments.weapons.modelWeapon;
import heros.modelHero;

public abstract class modelMonster {
    protected String name;
    protected int hp;
    protected double dmg;
    protected double armor;
    protected double def;
    protected boolean life;
    protected modelEquipment butin;

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+armor+" ARMURE";
    }

    public void attackMonster(modelHero h){
        this.armor = this.def;
        double dmgMonster = h.getHpHero()-(this.getDmgMonster()-h.getArmorHero());
        h.setHpHero((int) dmgMonster);
        System.out.println(getNameMonster()+" attaque "+h.getNameHero()+" et lui inflige "+(this.getDmgMonster()-h.getArmorHero())+" DMG \n");
        System.out.println(h);
    }

    public void parryMonster(){
        this.armor = this.def*2;
        System.out.println(getNameMonster()+" sauvage se prépare à parer la prochaine attaque, son armure augmente !  "+"+ "+getArmorMonster()/2+" ARMURE");
    }

    public void playMonster(modelHero h){
        Random rand = new Random();
        int rng = rand.nextInt(2-1+1)+1;

        if (rng == 1){
            attackMonster(h);
        }
    
        else if (rng == 2){
            parryMonster();
        }
    }

    public modelMonster() {}

    public modelMonster(String name, int hp, double dmg, double armor, double def, boolean life){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.armor = armor;
        this.def = armor;
        this.life = true;
    }

    public void heroCheckLife(modelHero h){
        if (h.getHpHero() <= 0){
            h.setLifeHero(false);
            System.out.println("\n =========> "+getNameMonster()+" a poncé "+h.getNameHero()+",  GAME OVER !");    
        }
    }

    public String getNameMonster(){
        return this.name;
    }

    public int getHpMonster(){
        return this.hp;
    }

    public double getDmgMonster(){
        return this.dmg;
    }

    public double getArmorMonster(){
        return this.armor;
    }

    public double getDefMonster(){
        return this.def;
    }

    public boolean getLifeMonster(){
        return this.life;
    }

    public void setNameMonster(String name){
        this.name = name;
    }

    public void setHpMonster(int hp){
        this.hp = hp;
    }

    public void setDmgMonster(double dmg){
        this.dmg = dmg;
    }

    public void setArmorMonster(double armor){
        this.armor = armor;
    }

    public void setDefMonster(double armor){
        this.def = armor;
    }

    public void setLifeMonster(boolean life){
        this.life = life;
    }
}
