import java.util.*;

public class main {
    public static void main(String[] args) throws Exception {
    int round = 0;
       
    hero h1 = new hero();
    System.out.println(h1);

    monster m1 = new monster();
    System.out.println(m1);;

        while (h1.getHpHero() > 0 && m1.getHpMonster() > 0){
            System.out.println("\n-=======================  Tour "+(round+=1)+"  ======================-\n");
            h1.playHero(m1);
            m1.playMonster(h1);

        if (h1.getHpHero() == 0){
            System.out.println("\n =========> "+m1.getNameMonster()+" a poncé "+h1.getNameHero()+",  Game Over !");
        }
        if (m1.getHpMonster() == 0){
            System.out.println("\n =========> "+h1.getNameHero()+" a poncé "+m1.getNameMonster()+",  LVL UP !");
        }
    
        }
    }
}
