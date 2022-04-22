package equipments.weapons;

public class crossbow extends modelWeapon {

    int focus;

    public String toString(){
        return name+" a "+dps+" DPS | "+" + "+focus+" FOCUS | "+durability+" DURABILITE | ";
    }

    public crossbow(){}

    public crossbow(String name, double dps, int focus, int durability){
        super(name, dps, durability);
        this.focus = focus;
    }

    public int getFocus(){
        return this.focus;
    }

    public void setFocus(int focus){
        this.focus = focus;
    }

}
