package equipments.consumables;

import java.util.*;
import equipments.modelEquipment;

public class modelconso extends modelEquipment{

    int pool;
    String color;

    public modelconso(){}

    public modelconso(String name, int durability, int pool, String color){
        super(name, durability);
        this.pool = pool;
        this.color = color;
    }

    public int getPool(){
        return this.pool;
    }

    public String getColor(){
        return this.color;
    }

    public void setPool(int pool){
        this.pool = pool;
    }

    public void setColor(String color){
        this.color = color;
    }
    
}
