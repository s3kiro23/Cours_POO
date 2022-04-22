package equipments.weapons;

public class staff extends modelWeapon {

    int mana;

    public String toString(){
        return name+" a "+dps+" DPS | "+" + "+mana+" MANA | "+durability+" DURABILITE | ";
    }

    public staff(){}

    public staff(String name, double dps, int mana, int durability){
        super(name, dps, durability);
        this.mana=mana;
    }
    
    public int getMana(){
        return this.mana;
    }

    public void setMana(int mana){
        this.mana=mana;
    }
}
