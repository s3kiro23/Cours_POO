import java.util.*;

public class monster {
    private String name;
    private int hp;
    private double dmg;
    private double armor;
    private double def;
    private boolean life;

    public String toString(){
        return name+" sauvage avec "+hp+" PV, "+dmg+" DMG et "+armor+" ARMURE";
    }

    public void attackMonster(hero h){
        this.armor = this.def;
        double dmgMonster = h.getHpHero()-(this.getDmgMonster()-h.getArmorHero());
        h.setHpHero((int) dmgMonster);
        System.out.println("\n---------------------------");
        System.out.println("\n"+getNameMonster()+" attaque "+h.getNameHero()+" et lui inflige "+(this.getDmgMonster()-h.getArmorHero())+" DMG \n");
        System.out.println(h);
    }

    public void parryMonster(){
        this.armor = this.def*2;
        System.out.println("\n---------------------------");
        System.out.println("\n"+getNameMonster()+" sauvage se prépare à parer la prochaine attaque, son armure augmente !  "+"+ "+getArmorMonster()/2+" ARMURE");
    }

    public void playMonster(hero h){
        Random rand = new Random();
        int rng = rand.nextInt(2-1+1)+1;

        if (rng == 1){
            attackMonster(h);
        }
    
        else if (rng == 2){
            parryMonster();
        }
    }

    public monster() {
        this.name = "Goodoo";
        this.hp = 30;
        this.dmg = 20;
        this.armor = 10;
        this.def = armor;
        this.life = true;
    }
    public monster(String name, int hp, double dmg, double armor, double def, boolean life){
        this.name = name;
        this.hp = hp;
        this.dmg = dmg;
        this.armor = armor;
        this.def = armor;
        this.life = true;
    }

    public String getNameMonster(){
        return this.name;
    }

    public int getHpMonster(){
        return this.hp;
    }

    public double getDmgMonster(){
        return this.dmg;
    }

    public double getArmorMonster(){
        return this.armor;
    }

    public double getDefMonster(){
        return this.def;
    }

    public boolean getLifeMonster(){
        return this.life;
    }

    public void setNameMonster(String name){
        this.name = name;
    }

    public void setHpMonster(int hp){
        this.hp = hp;
    }

    public void setDmgMonster(double dmg){
        this.dmg = dmg;
    }

    public void setArmorMonster(double armor){
        this.armor = armor;
    }

    public void setDefMonster(double armor){
        this.def = armor;
    }

    public void setLifeMonster(boolean life){
        this.life = true;
    }
}
