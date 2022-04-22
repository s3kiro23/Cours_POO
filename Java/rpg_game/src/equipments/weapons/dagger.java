package equipments.weapons;

public class dagger extends modelWeapon{

    int energie;

    public String toString(){
        return name+" a "+dps+" DPS | "+"+ "+energie+" ENERGIE | "+durability+" DURABILITE | ";
    }

    public dagger(){}

    public dagger(String name, double dps, int energie, int durability){
        super(name, dps, durability);
        this.energie = energie;
    }

    public int getEnergie(){
        return this.energie;
    }

    public void setEnergie(int energie){
        this.energie=energie;
    }

    
}
