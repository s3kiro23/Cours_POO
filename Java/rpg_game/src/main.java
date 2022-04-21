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
        
        while (h1.getLifeHero() && m1.getLifeMonster() && (mobsList.size() > 0)){

        if (round%2 == 1){

            h1.playHero(m1);
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            h1.monsterCheckLife(m1);

        }
        if (round%2 == 0){

            m1.playMonster(h1);
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            m1.heroCheckLife(h1);

        }
        round+=1;

        }
    }
}
