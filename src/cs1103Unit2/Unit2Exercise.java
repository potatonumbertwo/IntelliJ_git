package cs1103Unit2;

public class Unit2Exercise {

    static final String[] conjunction = {"and", "or", "but", "because"};

    static final String[] proper_noun = {"Luffy", "Sanji", " Tony Tony Chopper", "Zoro", ""};

    static final String[] common_noun = {"pirate", "cook", "doctor", "swordsman",};

    static final String[] determiner = {"a", "the", "every", "both"};

    static final String[] adjective = {"strong", "delicious", "anthropomorphized", "ambition"};

    static final String[] intransitive_verb = {"eats", "joins", "sleep"};

    static final String[] transitive_verb = {"loves", "cooks", "rescue", "proclaim"};

    public static void main(String[] args) {


    }

    public static void randomItem(String[] arrayOfStrings) {


    }

    static void randomNounPhrase() {
        int n = (int) (Math.random() * conjunction.length);
        int v = (int) (Math.random() * proper_noun.length);
        int m = (int) (Math.random() * common_noun.length);

        System.out.print(proper_noun[n] + conjunction[n] );
        if (Math.random() > 0.5)
            System.out.print(" " + proper_noun[m]);
        System.out.print(" that " + proper_noun[v] + " ");
        if (Math.random() > 0.5)
            randomNounPhrase();
    }


}

