package unit8;

/**
 * This class create random sentences with the given rules
 *
 * @author danielshotonwa
 */

public class D {

    static final String[] conjunction = {"and", "or", "but", "because"};

    static final String[] proper_noun = {"Fred", "Jane", "Richard Nixon", "Miss America"};

    static final String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};

    static final String[] determiner = {"a", "the", "every", "some"};

    static final String[] adjective = {"big", "tiny", "pretty", "bald"};

    static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};

    static final String[] transitive_verb = {"loves", "hates", "sees", "knows", "looks for", "finds"};


    /**
     * Generate randomItem from a list of Item
     *
     * @param listOfStrings
     * @return
     */

    public static String randomItem(String[] listOfStrings) {

        int n = (int) (Math.random() * listOfStrings.length);

        return listOfStrings[n];

    }


    public static void main(String[] args) {

        while (true) {

            sentence();

            System.out.println(".\n\n");

            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {

            }

        }

    }


    /**
     * This method generate sentence
     */

    static void sentence() {

        simpleSentence();

        if (Math.random() > 0.5) {

            System.out.print(" " + randomItem(conjunction) + " ");

            sentence();

        }

    }


    /**
     * This method generate simple sentence
     */

    static void simpleSentence() {

        randomNounPhrase();

        randomVerbPhrase();

    }



    /*

     * This method generates randomNounPhrase

     */

    static void randomNounPhrase() {

        if (Math.random() > 0.5) {

            System.out.print(randomItem(proper_noun));

        } else {

            System.out.print(" " + randomItem(determiner));

            if (Math.random() > 0.5) {

                System.out.print(" " + randomItem(common_noun));

                if (Math.random() > 0.5) {

                    System.out.print(" who");

                    randomVerbPhrase();

                }

            }

        }

    }


    /**
     * This method generates randomVerbPhrase
     */

    static void randomVerbPhrase() {

        int rand = (int) (Math.random() * 3);


        switch (rand) {

            case 1:

                System.out.print(" " + randomItem(intransitive_verb) + " ");

                break;

            case 2:

                System.out.print(" " + randomItem(transitive_verb) + " ");

                randomNounPhrase();

                break;

            case 3:

                System.out.print(" is " + randomItem(adjective) + " ");

                break;

            default:

                System.out.print(" believes that ");

                simpleSentence();

        }

    }

}

