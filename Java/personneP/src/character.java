public class character {
    private String nom;
    private int positionX;
    private int positionY;
    private String direction;
    private int map = 10;

    public character(){}
    public character(String nom, int X, int Y, String dir){
        this.nom = nom;
        this.positionX = X;
        this.positionY = Y;
        this.direction = dir;
    }

    public String toString(){
        return nom+" "+positionX+" "+positionY+" "+direction;
    }

    public void move(int dist){
        if (this.direction.equals("Haut")){
            positionY = positionY + dist;
        }
        else{
            positionY = 0;
        }
    
    
        if (this.direction.equals("Bas")){
            positionY = positionY - dist; 
        }
        
        if (this.direction.equals("Gauche")){
            positionX = positionX - dist;
        }
        
        if (this.direction.equals("Droite")){
            positionX = positionX + dist;
        }
    }

    public String getNom(){
        return this.nom;
    }

    public String getPosition(){
        return ""+this.positionX+" "+this.positionY;
    }
    public int getX(){
        return this.positionX;
    }

    public int getY(){
        return this.positionY;
    }

    public String getDir(){
        return this.direction;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPosition(int X,int Y){
        this.positionX = X;
        this.positionY = Y;
    }

    public void setX(int X){
        this.positionX = X;
    }

    public void setY(int Y){
        this.positionY = Y;
    }

    public void setDir(String dir){
        this.direction = dir;
    }




}
