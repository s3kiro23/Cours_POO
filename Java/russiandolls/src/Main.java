public class Main {
    public static void main(String[] args) throws Exception {

        dolls d1 = new dolls(5);
        dolls d2 = new dolls(7);
        dolls d3 = new dolls(10);
        dolls d4 = new dolls(15);
        dolls d5 = new dolls(20);
        dolls d6 = new dolls(25);
        dolls d7 = new dolls(11,d3,d4);

        d2.setContent(d1);
        d3.setContent(d2);
        d4.setContent(d3);
        d5.setContent(d4);
        d6.setContent(d5);

        System.out.println(""+d1+"\n"+d2+"\n"+d3+"\n"+d4+"\n"+d5+"\n"+d6+"\n"+d7);
        System.out.println(dolls.getCount());


    
    }
}
