public class vehicule {
    protected String marque;
    protected String model;
    protected int km;
    protected int speedMax;

    public void start(){
        System.out.println("\nLa "+this.getMarque()+" démarre");
    }

    public vehicule(){}

    public vehicule(String marque, String model, int km, int speedMax){
        this.marque=marque;
        this.model=model;
        this.km=km;
        this.speedMax=speedMax;
    }

    public String getMarque(){
        return this.marque;
    }

    public String getModel(){
        return this.model;
    }

    public int getKm(){
        return this.km;
    }

    public int getSpeedMax(){
        return this.speedMax;
    }

    public void setMarque(String marque){
        this.marque=marque;
    }

    public void setModel(String model){
        this.model=model;
    }

    public void setKm(int km){
        this.km=km;
    }

    public void setSpeedMax(int speedMax){
        this.speedMax=speedMax;
    }


}


