public class Coin {

    public static final String HEAD = "head";

    public static final String NUMBER = "number";
    Coin(){
    }

    public String flip() {
        String result;
        int i = (int) (Math.random()*10);

        if (i < 6) {
            return HEAD;
        }

        return NUMBER;
    }
}