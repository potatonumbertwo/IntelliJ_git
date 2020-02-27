package Unit4;

public class Unit4Discussion {
    public static void main(String[] args) {
        String nullString1 = null;
        String nullString2 = null;

        System.out.println(nullString1 == nullString2);

        try {

            System.out.print(nullString1.equals(nullString2));

        } catch (Exception NullPointerException) {
            System.out.println("The string contains null!");
        }
    }
// output
//  System.out.print(nullString1 == nullString2);
//  True
//  System.out.print(nullString1.equals(nullString2));
//  Exception in thread "main" java.lang.NullPointerException

//    public static void main(String[] args) {
//        char string1 = 'A';
//        char string2 = 'A';
//        char string3 = string1;
//
//
//
//        System.out.println("string1 is equal to string2: " + string1.equals(string2));
//
//        System.out.println("string2 is equal to string3: " + string2.equals(string3));
//
//        System.out.println("string4 is equal to string3: " + string4.equals(string3));
//
//
//    }
//

}