package equipments.weapons;

public class bow extends modelWeapon{

    int focus;

    public String toString(){
        return name+" a "+dps+" DPS | "+"+ "+focus+" FOCUS"+durability+" DURABILITE | ";
    }

    // Génération aléatoire d'une arme


    public bow(){
        this.name = "bow";
    }

    public bow(String name, double dps, int focus, int durability){
        super(name, dps, durability);
        this.focus = focus;
    }

    public int getFocus(){
        return this.focus;
    }

    public void setFocus(int focus){
        this.focus = focus;
    }

    // Random sur la rareté lors de génération de l'objet

}
