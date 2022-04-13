public class Main {
       public static void main(String[] args) throws Exception {

       // Personne p1  = new Personne("Bruno", "bruno@yopmail.com", 625);
       // Personne p2  = new Personne("Nicolas", "nicola@yopmail.com", 124);
       // Personne p3  = new Personne("Paul", "paul@yopmail.com", 3589);
       // Personne p4  = new Personne("Antoine", "antoine@yopmail.com", 4578);

       // System.out.println(p1.getNum());
       // System.out.println(p1.sendMail());
       // p1.setNum(256);
       // System.out.println(p1.getNum());


       // System.out.println(p2.getNom()+" "+p2.getNum()+" "+p2.getMail());

       // System.out.println(p3.getNom()+" "+p3.getNum()+" "+p3.getMail());
       // System.out.println(p3.sendMail());

       // System.out.println(p4.getNom()+" "+p4.getMail());
       // System.out.println(p4.sendMail());

       // Personne p5 = p1;
       // System.out.println(p5.getNom());

       // p1.setNom("Eric");
       // System.out.println(p5.getNom());

       character p1 = new character("Elek", 0, 0,"Droite");
       character p2 = new character("Korky", 0, 0,"Haut");

       p1.move(2);
       p2.move(10);

       System.out.println(p1);
       System.out.println(p2);
              
       }

       }
   