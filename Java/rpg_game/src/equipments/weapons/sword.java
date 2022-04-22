package equipments.weapons;

public class sword extends modelWeapon{

    int rage;

    public String toString(){
        return name+" + "+dps+" DPS | "+"+ "+rage+" RAGE | "+durability+"/"+durability+" DURABILITE | ";
    }

    public sword(){
        this.name="sword";
        this.dps=20;
        this.rage=40;
        this.durability=50;
    }

    public sword(String name, double dps, int rage, int durability){
        super(name, dps, durability);
        this.rage=rage;
    }

    public int getRage() {
        return this.rage;
    }

    public void setRage(int rage) {
        this.rage=rage;
    }
    
}
