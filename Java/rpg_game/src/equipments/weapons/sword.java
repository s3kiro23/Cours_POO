package equipments.weapons;

import java.util.*;
public class sword extends modelWeapon{

    int rage;

    public String toString(){
        return name+" avec + "+dps+" DPS | "+"+ "+rage+" RAGE | "+durability+"/"+durability+" DURABILITE | ";
    }

    public sword(){

        List<String> swordList = new ArrayList<>();

        for (int i=0;i<10;i++){
            swordList.add("Sabre fétiche de Xy'Rath");
            swordList.add("Machette de botaniste éclairé");
            swordList.add("Lame du grand mal");
            swordList.add("Sorcelame d’Amarth");
            swordList.add("Sabre tranchevigne");
            swordList.add("Épée courte forge-tripe");
            swordList.add("Épée courte à l’épreuve des combats");
            swordList.add("Allonge d’Hirukon radieuse");
            swordList.add("Sabre torse-temps");
            swordList.add("Lame-vortex de Deomen");
        }
        String swordNameRNG = swordList.get(new Random().nextInt(swordList.size()));

        this.name=swordNameRNG;
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
