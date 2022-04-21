package monsters;

import java.util.*;

public class boss extends modelMonster{
    int buffHP;
    double buffArmor;

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
        this.hp = 60 + this.buffHP;
        this.dmg = 20;
        this.armor = 10 + this.buffArmor;
        this.def = armor;
        this.life = true;
        this.buffHP = 200;
    }

    public boss(String name, int hp, double dmg, double armor, double def, boolean life, int buffHP, double buffArmor){
        super(name, hp, dmg, armor, def, life);
        this.buffHP = buffHP;
        this.hp = this.buffHP + this.hp;
        this.armor = this.buffArmor + this.armor;
    }
}
