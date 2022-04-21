public class main {
    public static void main(String[] args) throws Exception {
        vehicule v1 = new voiture("Renault", "Clio", "Bleu", "Sport", 156000, 240);
        vehicule v2 = new voiture("Peugeot", "307", "Gris métal", "Standard", 210000, 240);
        vehicule m1 = new moto("Honda", "Dax", "Noir", 36000, 80, 2);
        vehicule m2 = new moto("Piaggo","Vespa", "Noir", 6000, 140, 2);
        vehicule m3 = new moto("Can-Am","Ryker", "Gris", 2000, 200, 3);

        System.out.println("=============================\n");
        System.out.println("1. "+v1);
        System.out.println("2. "+v2);
        System.out.println("3. "+m1);
        System.out.println("4. "+m2);
        System.out.println("5. "+m3);
        System.out.println("\n=============================");
        v1.start();
        m2.start();
        m3.start();


    }
}
