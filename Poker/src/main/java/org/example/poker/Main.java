package org.example.poker;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PokerHand pokerHand = new PokerHand("QH KH AH JH TH");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("JH TH 9H 8H 7H");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("AH 7S 7D 7C 7H");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("KC KH AH AS AD");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("KC KH 7H 7S 7D");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("QD 8D 7D 5D 2D");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("AD KD QD JH TD");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("AD 5D 4D 3H 2D");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("AD 5D TD TH TS");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("QD QS TD TH 3D");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("JD JS TD 8H 2D");
        System.out.println(pokerHand.getType());
        pokerHand = new PokerHand("AD KD 8D 6H 5D");
        System.out.println(pokerHand.getType());

        List<PokerHand> handList = new LinkedList<>();
        handList.add(new PokerHand("TH 9H 8H 7H 6H"));
        handList.add(new PokerHand("JH TH 9H 8H 7H"));
        handList.add(new PokerHand("QH KH AH JH TH"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("8H 8S 8C 8D AH").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("8H 8S 8C 8D AH"));
        handList.add(new PokerHand("AH 8H AD AC AS"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("JH JD JS 8D 8H").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("JD JH JS 8D 8H"));
        handList.add(new PokerHand("KH AH AS AH KD"));
        Collections.sort(handList);
        System.out.println(handList);


        System.out.println(new PokerHand("QH 8H JH 7H 9H").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("QH 8H JH 7H 9H"));
        handList.add(new PokerHand("KH QH JH 6H 8H"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("AH 2H 3S 4D 5H").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("AH 2H 3S 4D 5H"));
        handList.add(new PokerHand("KH QH JS TD 9H"));
        handList.add(new PokerHand("JH TH 8S 9D 7H"));
        handList.add(new PokerHand("TH JH QS KD AH"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("JH JD JS KD QH").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("JH JD JS KD QH"));
        handList.add(new PokerHand("AH AS AH 7D QH"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("QD QH TS TD 9H").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("QH QS 3H 3D JH"));
        handList.add(new PokerHand("QH QD TS TD 9H"));
        handList.add(new PokerHand("QH QD TS TD JH"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("JH JD TS 8D 2H").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("JH JD TS 7D 2H"));
        handList.add(new PokerHand("JH JS TH 7D 3H"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println(new PokerHand("AH KH 8S 6D 5H").getType());
        handList = new LinkedList<>();
        handList.add(new PokerHand("AH KH 9S 6D 2H"));
        handList.add(new PokerHand("AH KH 8S 6D 3H"));
        Collections.sort(handList);
        System.out.println(handList);

        System.out.println("Test full sort");
        handList = new LinkedList<>();
        handList.add(new PokerHand("AH KH 9S 6D 2H"));
        handList.add(new PokerHand("AH KH 8S 6D 3H"));
        handList.add(new PokerHand("TH 9H 8H 7H 6H"));
        handList.add(new PokerHand("JH TH 9H 8H 7H"));
        handList.add(new PokerHand("QH KH AH JH TH"));
        handList.add(new PokerHand("AH 2H 3S 4D 5H"));
        handList.add(new PokerHand("KH QH JS TD 9H"));
        handList.add(new PokerHand("JH TH 8S 9D 7H"));
        Collections.sort(handList);
        System.out.println(handList);
    }
}
