package monsters;

import java.util.*;

import equipments.modelEquipment;

public class boss extends modelMonster{
    int buffHP;
    double buffArmor;
    double buffDmg;

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+armor+" ARMURE";
    }

    public boss(){

        List<String> bossName = new ArrayList<>();
        bossName.add("Nefarian");
        bossName.add("Ner'Zhul");
        bossName.add("N'Zoth");
        bossName.add("Roi Liche");
        bossName.add("Sylvanas");
        bossName.add("Archimonde");
        bossName.add("Diablo");
        bossName.add("Sargeras");
        bossName.add("Kil'Jaeden");
        bossName.add("Jade");
        String bossNameRNG = bossName.get(new Random().nextInt(bossName.size()));

        this.name = bossNameRNG;
        this.buffHP = 200;
        this.buffArmor = 10;
        this.buffDmg = 80;
        this.hp = 60 + this.buffHP;
        this.dmg = 20 + this.buffDmg;
        this.armor = 10 + this.buffArmor;
        this.def = armor;
        this.life = true;
        // this.butin =
        this.buffHP = 200;
    }

    public boss(String name, int hp, double dmg, double armor, double def, boolean life, modelEquipment butin, int buffHP, double buffDmg, double buffArmor){
        super(name, hp, dmg, armor, def, life, butin);
        this.buffHP = buffHP;
        this.hp = this.buffHP + this.hp;
        this.armor = this.buffArmor + this.armor;
        this.dmg = this.buffDmg + this.dmg;
    }

    public int getBuffHP(){
        return this.buffHP;
    }

    public double getBuffDmg(){
        return this.buffDmg;
    }

    public double getBuffArmor(){
        return this.buffArmor;
    }

    public void setBuffHP(int buffHP){
        this.buffHP = buffHP;
    }

    public void setBuffDmg(double buffDmg){
        this.buffDmg = buffDmg;
    }

    public void setBuffArmor(double buffArmor){
        this.buffArmor = buffArmor;
    }
    
}
