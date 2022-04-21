public class moto extends vehicule {
    int wheelNb;
    String color;

    public String toString(){
        return marque+" | "+model+" | "+color+" | "+km+" km | "+speedMax+" km/h | "+wheelNb+" roues";
    }

    @Override
    public void start(){
        super.start();
        System.out.println("Vombrissement des cylindres... hum quel plaisir :p");
    }

    public moto(){}

    public moto(String marque, String model, String color, int km, int speedMax, int wheelNb){
        super(marque, model, km, speedMax);
            this.wheelNb=wheelNb;
            this.color=color;
    }
}
