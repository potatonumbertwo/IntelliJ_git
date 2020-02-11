package unit8;

public class Exercise1 {
    public static void main(String[] args) {

        intAndChar test = new intAndChar();
        System.out.println(test.name);
        System.out.println(test.number);
    }


}

class intAndChar {

    int number;
    char name;

    public void intAndChar() {
        System.out.println(number);
        System.out.println(name);
    }


}
