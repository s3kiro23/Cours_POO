import java.util.*;

import heros.arthas;
import heros.hero;
import heros.jaina;
import heros.sentinelle;
import monsters.boss;
import monsters.mob;
import monsters.monster;

public class main {
    public static void main(String[] args) throws Exception {

    int round = 1;
    System.out.println("--==| Début de la partie ! |==--\n");
    hero h1 = new sentinelle();
    // hero h2 = new arthas();
    // hero h3 = new jaina();
    System.out.println(h1);
    // System.out.println(h2);
    // System.out.println(h3);
    System.out.println("\nVERSUS\n");

    List<monster> mobsList = new ArrayList<>();
    for (int i=0;i<4;i++){
        mobsList.add(new mob()); 
    }
    for (int i=0;i<1;i++){
        mobsList.add(new boss());
    }

    System.out.println("Le Goodoo Gang qui est composé de "+ (mobsList.size()-1)+" mobs et 1 boss\n");
    System.out.println("Le 1er mob est "+mobsList.get(0));
    System.out.println(""+mobsList.get(mobsList.size()-1)+" sera le boss final");

    System.out.println("\n-===================================================-\n");
        
        while (h1.getLifeHero() && mobsList.get(0).getLifeMonster() && (mobsList.size() > 0)){

        if (round%2 == 1){

            h1.playHero(mobsList.get(0));
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            h1.monsterCheckLife(mobsList.get(0));

        }
        if (round%2 == 0){

            mobsList.get(0).playMonster(h1);
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            mobsList.get(0).heroCheckLife(h1);

        }
        round+=1;

        }
    }
}
