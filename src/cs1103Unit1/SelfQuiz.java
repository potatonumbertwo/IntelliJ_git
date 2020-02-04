package cs1103Unit1;

public class SelfQuiz {
    class Student {
        public void talk() {
        }
    }

    public static void main(String args[]) {
        Student t = null;
        try {
            t.talk();
        } catch (NullPointerException e) {
            System.out.print("There is a NullPointerException. ");
        } catch (Exception e) {
            System.out.print("There is an Exception. ");
        }
        System.out.print("Everything ran fine. ");
    }
}

