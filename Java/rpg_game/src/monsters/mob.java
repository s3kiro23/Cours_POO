package monsters;

import java.util.*;

public class mob extends modelMonster{

    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+armor+" ARMURE";
    } 

    public mob(){
        List<String> mobsName = new ArrayList<>();
        mobsName.add("Goodoo sauvage");
        mobsName.add("Murloc sauvage");
        mobsName.add("Sanglier sauvage");
        mobsName.add("Lapin sauvage");
        mobsName.add("Serpent sauvage");
        mobsName.add("Araignée sauvage");
        mobsName.add("Poulet sauvage");
        mobsName.add("Orc sauvage");
        mobsName.add("Chien sauvage");
        String mobsNameRNG = mobsName.get(new Random().nextInt(mobsName.size()));

        this.name = mobsNameRNG;
        this.hp = 80;
        this.dmg = 40;
        this.armor = 5;
        this.def = armor;
        this.life = true;
    }

    public mob(String name, int hp, double dmg, double armor, double def, boolean life){
        super(name, hp, dmg, armor, def, life);
    }
}