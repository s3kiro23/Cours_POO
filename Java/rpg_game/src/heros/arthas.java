package heros;

public class arthas extends hero {

    public arthas(){
        this.name = "Arthas";
        this.hp = 200;
        this.dmg = 50;
        this.armor = 15;
        this.def = armor;
        this.life = true;
    }

    public arthas(String name, int hp, double dmg, double armor, double def, boolean life){
        super(name, hp, dmg, armor, def, life);
    }
}
