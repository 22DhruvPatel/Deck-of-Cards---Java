/**
 * @author Dhruv Patel
 */

import java.util.Scanner;


/**
 * The class Test program
 */
public class TestProgram {

    /**
     *
     * Main
     *
     * @param args  the args.
     */
    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of suits: ");
        int numOfSuits = sc.nextInt();
        System.out.print("Enter the maximum rank: ");
        int maximumRank = sc.nextInt();

        DeckOfCards deckOfCards = new DeckOfCards(maximumRank, numOfSuits);
        System.out.println(deckOfCards);

        int numberSelected;
        do {
            System.out.println("What do you want to do?> ");
            System.out.println("1=shuffle, 2=deal 1 hand, 3=deal 100,000 times, 4=quit:");
            numberSelected = sc.nextInt();

            if (numberSelected == 1) {
                deckOfCards.shuffle();
                System.out.println(deckOfCards);
            } else if (numberSelected == 2) {
                // deal one hand
                System.out.print("How many cards? ");
                int numCards = sc.nextInt();
                Card[] hand = deckOfCards.dealTopNCards(numCards);
                for (Card card : hand) {
                    System.out.print(card + " ");
                }
                System.out.println();
            } else if (numberSelected == 3) {
                // shuffle and deal 100,000 hands
                System.out.print("How many cards? ");
                int handSize = sc.nextInt();
                int[] histogram = deckOfCards.histogram(handSize, 100000);
                for (int i = 1; i < histogram.length; i++) {
                    if (histogram[i] != 0) {
                        System.out.println(i + ": " + histogram[i]);
                    }
                }
            } else if (numberSelected == 4) {
                System.out.println("Great game. Bye!");
            } else {
                System.out.println("Error! invalid choice.");
            }
        }while (numberSelected != 4);
    }
}
