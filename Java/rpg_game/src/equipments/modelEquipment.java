package equipments;

import java.util.*;

import equipments.weapons.modelWeapon;

public abstract class modelEquipment {

    protected String name;
    protected int durability;

    // Génération d'équipement aléatoire

    // public static List<modelEquipment> randomWeapon(){

    //     List<modelEquipment> randomWeaponList = new ArrayList<>();
        
    //     for (int i=0;i<10;i++){
    //         randomWeaponList.add(new modelWeapon());
    //     }
    //     return randomWeaponList;
    // }

    public modelEquipment(){}

    public modelEquipment(String name, int durability){
        this.name = name;
        this.durability = durability;
    }

    public String getModelEquipmentName(){
        return this.name;
    }

    public int getModelEquipmentDurabilite(){
        return this.durability;
    }

    public int getPool(){
        return 0;
    }

    public double getModelWeaponDPS(){
        return 0;
    }

    public void setModelEquipmentName(String name){
        this.name = name;
    }

    public void setModelEquipmentDurabilite(int durability){
        this.durability = durability;
    }
    
}
