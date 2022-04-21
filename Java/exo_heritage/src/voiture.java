public class voiture extends vehicule {
    String color;
    String pack;

    public String toString(){
        return marque+" | "+model+" | "+color+" | "+pack+" | "+km+" km | "+speedMax+" km/h";
    }

    @Override
    public void start(){
        super.start();
        System.out.println("Vroum vroum... :D");
    }

    public voiture(){}

    public voiture(String marque, String model, String color, String pack, int km, int speedMax){
        super(marque, model, km, speedMax);
        this.color=color;
        this.pack=pack;
    }
}
