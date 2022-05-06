import java.util.*;

import equipments.weapons.modelWeapon;
import heros.warrior;
import heros.modelHero;
import heros.magic;
import heros.hunt;
import heros.rogue;
import monsters.boss;
import monsters.mob;
import monsters.modelMonster;

public class main {
    public static void main(String[] args) throws Exception {

    // modelEquipment.randomWeapon();
    // List<modelEquipment> test = modelEquipment.randomWeapon();
    // System.out.print(test);

    
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

    List<modelHero> herosList = new ArrayList<>();

        if (choice == 1){
            for (int i=0;i<4;i++){
                herosList.add(new hunt());
                herosList.add(new hunt());
                herosList.add(new hunt());
                herosList.add(new hunt());
            }
            System.out.println("Un héro de classe CHASSEUR a été créé avec les caractéristiques suivantes : \n");
            System.out.println("-----> "+herosList.get(0));
            System.out.println("\nEquipement de départ = \n\n> 1 "+herosList.get(0).getHeroWeapon_slot1()+"\n> 1 "+herosList.get(0).getHeroConsumables_slot1());
        }
    
        else if (choice == 2){
            for (int i=0;i<4;i++){
                herosList.add(new rogue());
                herosList.add(new rogue());
                herosList.add(new rogue());
                herosList.add(new rogue());
            }
            System.out.println("Un héro de classe VOLEUR a été créé avec les caractéristiques suivantes : \n");
            System.out.println("-----> "+herosList.get(0));
            System.out.println("\nEquipement de départ = \n\n> 1 "+herosList.get(0).getHeroWeapon_slot1()+"\n> 1 "+herosList.get(0).getHeroConsumables_slot1());
        }

        else if (choice == 3){
            for (int i=0;i<4;i++){
                herosList.add(new magic());
                herosList.add(new magic());
                herosList.add(new magic());
                herosList.add(new magic());
            }
            System.out.println("Un héro de classe MAGE a été créé avec les caractéristiques suivantes : \n");
            System.out.println("-----> "+herosList.get(0));
            System.out.println("\nEquipement de départ = \n\n> 1 "+herosList.get(0).getHeroWeapon_slot1()+"\n> 1 "+herosList.get(0).getHeroConsumables_slot1());

        }

        else if (choice == 4){
            for (int i=0;i<4;i++){
                herosList.add(new warrior());
                herosList.add(new warrior());
                herosList.add(new warrior());
                herosList.add(new warrior());
            }
            System.out.println("Un héro de classe GUERRIER a été créé avec les caractéristiques suivantes : \n");
            System.out.println("-----> "+herosList.get(0));
            System.out.println("\nEquipement de départ = \n\n> 1 "+herosList.get(0).getHeroWeapon_slot1()+"\n> 1 "+herosList.get(0).getHeroConsumables_slot1());

        }

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
        
        while (herosList.get(0).getLifeHero() && (mobsList.size() > 0)){

        if (mobsList.get(0).getLifeMonster() == false){
            mobsList.remove(0);
        }

        if (round%2 == 1){

            System.out.println(herosList.get(0).getDmgHero()+" "+herosList.get(0).getHeroWeapon_slot1()+" "+herosList.get(0).getDmgWeaponHero());
            herosList.get(0).playHero(mobsList.get(0));
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            herosList.get(0).monsterCheckLife(mobsList.get(0)); 

            // Fin de partie après avoir supprimé le dernier mob de la liste

            if (mobsList.get(0).getLifeMonster() == false && mobsList.size() != 0){
                mobsList.remove(0);
                herosList.get(0).playHero(mobsList.get(0));
                System.out.println("\n-=============================================-\n");
            }
            else if (mobsList.get(0).getLifeMonster() == false && mobsList.size() == 0){
                System.out.println("\nPartie terminé ! Votre héro a survécu à la vague !");
            }      

        }
        if (round%2 == 0){

            mobsList.get(0).playMonster(herosList.get(0));
            System.out.println("\n-=======================  Tour "+round+"  ======================-\n");
            mobsList.get(0).heroCheckLife(herosList.get(0));

        }
        round+=1;

        }
    }
}
