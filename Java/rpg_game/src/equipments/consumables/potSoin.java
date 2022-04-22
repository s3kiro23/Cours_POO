package equipments.consumables;

public class potSoin extends modelconso{

    public String toString(){
        return name+" avec un pool de "+this.pool+" HP ";
    }

    public potSoin(){
        this.name="Potion de soin";
        this.durability=1;
        this.pool=100;
        this.color="Rouge";
    }

    public potSoin(String name, int durability, int pool, String color){
        super(name, durability, pool, color);
    }
    
}
