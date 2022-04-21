package heros;

// import java.util.*;

public class sentinelle extends modelHero{
    String tabardColor;

    public sentinelle(){
        this.name = "Sentinelle";
        this.hp = 60;
        this.dmg = 20;
        this.armor = 5;
        this.def = armor;
        this.life = true;
        this.tabardColor="Bleu";
    }

    public sentinelle(String name, int hp, double dmg, double armor, double def, boolean life, String tabardColor){
        super(name, hp, dmg, armor, def, life);
        this.tabardColor=tabardColor;
    }
}
