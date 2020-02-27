package Cs1103Unit2;

/**
 * assignment of unit 2 lab 3 recursive syntax
 */

import java.util.Random;

public class SimpleRandomSentences {

    final String[] conjunction = {"and", "or", "but", "because"};

    final String[] proper_noun = {"Monkey D. Luffy", "Sanji", " Tony Tony Chopper", "Zoro", "Usopp", "Nico Robin"};

    final String[] common_noun = {"pirate", "cook", "doctor", "swordsman",};

    final String[] determiner = {"a", "the", "every", "both"};

    final String[] adjective = {"strong", "delicious", "anthropomorphized", "ambition"};

    final String[] intransitive_verb = {"eats", "joins", "sleep", "runs", "jumps", "talks"};

    final String[] transitive_verb = {"loves", "cooks", "rescue", "proclaim"};

    /**
     * get a random element from the string array
     *
     * @param array
     * @return
     */
    public static String getRandom(String[] array) {
        int randomIndex = new Random().nextInt(array.length);
        return array[randomIndex];
    }

    public static void main(String[] args) {

        SimpleRandomSentences simpleRandomSentences = new SimpleRandomSentences();
        while (true) {
            simpleRandomSentences.makeSentences();
            System.out.println(".\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * <sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
     */
    public void makeSentences() {

        if (Math.random() > 0.2) {
            simpleSentence();
        }
        if (Math.random() > 0.5) {
            String conjunctionWord = getRandom(conjunction);
            System.out.print(conjunctionWord + " ");

            makeSentences();

        }
    }

    /**
     * <simple_sentence> ::= <noun_phrase> <verb_phrase>
     */
    public void simpleSentence() {
        nounPhrase();
        verbPhrase();
    }


    /**
     * <noun_phrase> ::= <proper_noun> |
     * <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
     */
    public void nounPhrase() {

        if (Math.random() > 0.85) {

            String properNounWord = getRandom(proper_noun);
            System.out.print(properNounWord + " ");

        } else if (Math.random() > 0.5) {

            String determinerWord = getRandom(determiner);
            System.out.print(determinerWord + " ");

            while (Math.random() > 0.75) {

                String adjectiveWord = getRandom(adjective);
                System.out.print(adjectiveWord + " ");

            }
            String commonNounWord = getRandom(common_noun);
            System.out.print(commonNounWord + " ");

            if (Math.random() > 0.50) {
                System.out.print("who ");
                verbPhrase();
            }
        }
    }

    /**
     * <verb_phrase> ::= <intransitive_verb> |
     * <transitive_verb> <noun_phrase> |
     * is <adjective> |
     * believes that <simple_sentence>
     */
    public void verbPhrase() {
        if (Math.random() > 0.5) {
            String inVerb = getRandom(intransitive_verb);
            System.out.print(inVerb + " ");
        } else if (Math.random() > 0.6) {
            String inVerb = getRandom(transitive_verb);
            System.out.print(inVerb + " ");
            nounPhrase();
        } else if (Math.random() > 0.7) {
            String adjectiveWord = getRandom(adjective);
            System.out.print("is " + adjectiveWord + " ");
        } else {
            System.out.print("believes that ");
            simpleSentence();
        }

    }

}