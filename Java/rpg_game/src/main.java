import java.util.*;

import heros.warrior;
import heros.modelHero;
import heros.magic;
import heros.sentinelle;
import heros.hunt;
import heros.rogue;
import monsters.boss;
import monsters.mob;
import monsters.modelMonster;

public class main {
    public static void main(String[] args) throws Exception {

    System.out.println("---==== Bienvenue dans le jeu 'Dungeons & Goodoo's ====---\n\n");

    
    // Compteur de tour

    int round = 1;
    
    // Selection du type de personnage

    int choice = 0;
    Scanner input = new Scanner(System.in);
    System.out.println("Choisissez votre type de héro :\n");
    System.out.println("[CHASSEUR]= 1 ");
    System.out.println("[VOLEUR]= 2 ");
    System.out.println("[MAGE]= 3 ");
    System.out.println("[GUERRIER]= 4 ");
    choice = input.nextInt();
    System.out.println("\n-=======================================================-\n");

    List<modelHero> heroslist = new ArrayList<>();

    if (choice == 1){
        for (int i=0;i<4;i++){
            heroslist.add(new hunt());
            heroslist.add(new hunt());
            heroslist.add(new hunt());
            heroslist.add(new hunt());
        }
        System.out.println("Un héro de classe CHASSEUR a été créé avec les caractéristiques suivantes : \n");
        System.out.println("-----> "+heroslist.get(0));
    }
    
    else if (choice == 2){
        for (int i=0;i<4;i++){
            heroslist.add(new rogue());
            heroslist.add(new rogue());
            heroslist.add(new rogue());
            heroslist.add(new rogue());
        }
        System.out.println("Un héro de classe VOLEUR a été créé avec les caractéristiques suivantes : \n");
        System.out.println("-----> "+heroslist.get(0));    }

    else if (choice == 3){
        for (int i=0;i<4;i++){
            heroslist.add(new magic());
            heroslist.add(new magic());
            heroslist.add(new magic());
            heroslist.add(new magic());
        }
        System.out.println("Un héro de classe MAGE a été créé avec les caractéristiques suivantes : \n");
        System.out.println("-----> "+heroslist.get(0));    }

    else if (choice == 4){
        for (int i=0;i<4;i++){
            heroslist.add(new warrior());
            heroslist.add(new warrior());
            heroslist.add(new warrior());
            heroslist.add(new warrior());
        }
        System.out.println("Un héro de classe GUERRIER a été créé avec les caractéristiques suivantes : \n");
        System.out.println("-----> "+heroslist.get(0));    }

    else{
        System.out.println("-========================================================-\n");
        System.out.println("---==== Merci d'utiliser une valeur entre 1 et 4 seulement pour sélectionner votre héro ! ====---");
        System.out.println("---==== Choisissez votre type de héro ====---\n");
        System.out.println("---==== [HUNT]= 1 ");
        System.out.println("---==== [ROGUE]= 2 ");
        System.out.println("---==== [MAGIC]= 3 ");
        System.out.println("---==== [WARRIOR]= 4 ");
        choice = input.nextInt();
    }

    System.out.println("\n\n-- Le combat va commencer contre :\n\n");

    // Génération d'une liste de mobs aléatoire

    List<modelMonster> mobsList = new ArrayList<>();

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
    
    // Tour par tour hero/monstre avec vérification des HP comme compteur de fin 

        while (heroslist.get(0).getLifeHero() && mobsList.get(0).getLifeMonster() && (mobsList.size() > 0)){

        if (round%2 == 1){

            heroslist.get(0).playHero(mobsList.get(0));
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            heroslist.get(0).monsterCheckLife(mobsList.get(0));

        }
        if (round%2 == 0){

            mobsList.get(0).playMonster(heroslist.get(0));
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            mobsList.get(0).heroCheckLife(heroslist.get(0));

        }
        round+=1;

        }
    }
}
