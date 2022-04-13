import java.util.*;

public class Cour1 {

    public static int somme(int a)
    {
        int result = 0;
            for (int i=0;i<a;i++)

            {
                result +=i;
                System.out.println(result);
            }
            return result;
    }
    
    // TD 3 - Partie 2 - Exo 1

    public static void puissance(){
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez votre 1ère valeur :");
            int x = input.nextInt();
        System.out.print("Entrez votre 2ème valeur :");
            int n = input.nextInt();
        int a = 1;

        for (int i=0;i<n;i++){
            a = a * x;
            System.out.println(a);
        }
    }

    // TD 3 - Partie 2 - Exo 2

    public static void password(){
        String mdp = "zaire";
        int count = 3;
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez votre mot de passe :");
            String saisie = input.next();

        while (!saisie.equals(mdp) && count > 1){
            count--;
            System.out.println("Mauvais mdp - Tentative restante ="+count);
            System.out.println("Entrez de nouveau votre mot de passe :");
                saisie = input.next();
        }
        if (saisie.equals(mdp)){
                System.out.print("Bienvenue dans votre espace personel");
        }
        else{
                System.out.print("Accès verrouillé - Contactez un admin");
        }
           
    }

    // TD3 - Partie 2 - Exo 3

    public static double epargneBob()
    {
        double solde = 200;
        double taux = 0.02;
        double interet = solde + taux;
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez une valeur :");
            int number = input.nextInt();
            System.out.println("Vous avez entré"+ number);
        
        for (float i=0;i<number;i++)
        {
            interet = solde * taux;
            solde = solde + interet;
            System.out.println(solde);
        }
        return solde;
    } 

    // TD 3 - Partie 2 - Exo 4

    public static int epargneLea()
    {
        int solde = 200;
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez une valeur :");
            int number = input.nextInt();
            System.out.println("Vous avez entré"+ number);

        for (int i=0;i<number;i++)
        {
            solde = solde + 2 * i;
            System.out.println(solde);
        }
        return solde;

    }

    // TD 3 - Partie 2 - Exo 5

    public static int facto(int a)
    {
        int b = 1;
        for (int i=1;i<a;i++)
        {
            b = b * i;
            System.out.println(b);
        }
        return b;
    }

    // TD 3 - Partie 2 - Exo 6

    public static int multi_table()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez votre 1ère valeur :");
            int number1 = input.nextInt();
        System.out.print("Entrez votre 2ème valeur :");
            int number2 = input.nextInt();

        int result = 0;

        for (int i=1;i<=number2;i++)
        {
            result = number1 * i;
            System.out.println(result);
        }
        return result;
    }

    // TD 3 - Partie 2 - Exo 7

    public static int tri_rect()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez le nombre de ligne :");
            int number = input.nextInt();

        for (int i=0;i<number;i++)
        {
            for (int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        return number;
    }

    // TD 3 - Partie 2 - Exo 8

    public static int tri_iso(){
        Scanner input = new Scanner(System.in);
        System.out.print("Entrez le nombre de ligne :");
            int number = input.nextInt();

        for (int i=0;i<number;i++) {
            for (int j=0;j<number-i-1;j++){
                System.out.print("");
                for (int k=0;k<=i*2;k++){
                    System.out.println("*");
                System.out.println();
                }
            }        
        }
        return number;
    }

    // TD 3 - Partie 3 - Exo 1

    public static int sommeL(){
        ArrayList<Integer> SelectR= new ArrayList<Integer>(20);
        System.out.print(SelectR);
    }

    public static void main(String[] args) throws Exception {

        sommeL();
    
    
    }
}