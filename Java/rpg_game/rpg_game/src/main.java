import java.util.*;

public class main {
    public static void main(String[] args) throws Exception {

    int round = 0;
    System.out.println("--==| Début de la partie ! |==--\n");
    hero h1 = new hero();
    System.out.println(h1);
    System.out.println("\nVERSUS\n");
    monster m1 = new monster();
    monster m2 = new monster();
    monster m3 = new monster();
    monster m4 = new monster();
    monster m5 = new monster();
    List mobsList = new ArrayList();
    mobsList.add(m1);
    mobsList.add(m2);
    mobsList.add(m3);
    mobsList.add(m4);
    mobsList.add(m5);
    System.out.println("Le Goodoo Gang composé de "+ mobsList.size()+" mobs");
    System.out.println("Le 1er mob est "+m1);

        // for (int i=0;i<mobsList.size;i++){

        // }
        
        while (h1.getHpHero() > 0 && m1.getHpMonster() > 0){
            System.out.println("\n-=======================  Tour "+(round+=1)+"  ======================-\n");
            h1.playHero(m1);

        if (h1.getHpHero() == 0){
            System.out.println("\n =========> "+m1.getNameMonster()+" a poncé "+h1.getNameHero()+",  Game Over !");
        }
        if (m1.getHpMonster() == 0){
            System.out.println("\n =========> "+h1.getNameHero()+" a poncé "+m1.getNameMonster()+",  LVL UP !");
        }

            m1.playMonster(h1);

        }
    }
}
