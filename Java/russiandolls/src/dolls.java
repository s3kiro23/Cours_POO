public class dolls {
    private int height;
    private dolls content;
    private dolls container;
    private static int count;

    public String toString(){
        if (this.content!=null){
            return ""+height+"["+this.content.toString()+"]";
        }
        else {
            return ""+this.height;
        }
    }

    public dolls(){}

    public dolls(int height){
        this.height = height;
        count++;
    }

    public dolls(int height, dolls d1, dolls d2){
        this.height = height;
        this.content = d1;
        this.container = d2;
        d1.setContainer(this);
        d2.setContent(this);
        count++;
    }

    public int getHeight(){
        return this.height;
    }

    public dolls getContent(){
        return this.content;
    }

    public dolls getContainer(){
        return this.container;
    }

    public static int getCount(){
        return count;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setContent(dolls content){
        this.content = content;
    }

    public void setContainer(dolls container){
        this.container = container;
    }



}

