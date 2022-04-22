package equipments.weapons;

import java.util.*;
import equipments.modelEquipment;

public class modelWeapon extends modelEquipment{

    protected double dps;

    public String toString(){
        return name+" a "+dps+" DPS | "+durability+" DURABILITE | ";
    }

    // public modelWeapon randObjectRarity(){
    //     if (){

    //     }
    // }

    public modelWeapon(){}

    public modelWeapon(String name, double dps, int durability){
        super(name, durability);
        this.dps = dps;
    }

    public double getModelWeaponDPS(){
        return this.dps;
    }

    public void setModelWeaponDPS(double dps){
        this.dps = dps;
    }




}
