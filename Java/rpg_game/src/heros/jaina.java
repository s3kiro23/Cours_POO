package heros;
public class jaina extends hero {
    String hairColor;
    double mana;
    
    public String toString(){
        return name+" a "+hp+" PV | "+dmg+" DMG | "+mana+" mana | "+armor+" ARMURE";
    }

    public jaina(){
        this.name = "Jaina";
        this.hp = 140;
        this.dmg = 70;
        this.mana = 100;
        this.armor = 5;
        this.def = armor;
        this.life = true;
    }

    public jaina(String name, int hp, double dmg, double mana, double armor, double def, boolean life, String hairColor){
        super(name, hp, dmg, armor, def, life);
        this.hairColor=hairColor;
        this.mana = mana;
    }
}
