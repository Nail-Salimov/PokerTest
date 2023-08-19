package org.example.poker;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

    private Type type;

    private List<Card> cardList;

    public PokerHand(String hand) {
        String[] cards = hand.split(" ");
        if (cards.length != 5) {
            throw new IllegalArgumentException("It's not poker hand");
        }
        cardList = new LinkedList<>();
        for (String cardStr : cards) {
            if (cardStr.length() != 2) {
                throw new IllegalArgumentException(cardStr + " is illegal card");
            }
            String type = String.valueOf(cardStr.charAt(0));
            String suit = String.valueOf(cardStr.charAt(1));
            if (isNumeric(type)) {
                type = "_" + type;
            }
            Card.Suit s = Card.Suit.valueOf(suit);
            Card.Type t = Card.Type.valueOf(type);
            Card card = new Card(t, s);
            cardList.add(card);
        }
        Collections.sort(cardList);
        type = determineHandType(cardList);
        if (!handIsValid(cardList)) {
            throw new IllegalArgumentException("hand is not valid");
        }
    }

    private boolean handIsValid(List<Card> cardList) {
        for (int i=0; i<4; i++) {
            Card first = cardList.get(i);
            Card second = cardList.get(i+1);
            if(first.getType().equals(second.getType()) && first.getSuit().equals(second.getSuit())) {
                return false;
            }
        }
        return true;
    }


    private Type determineHandType(List<Card> cardList) {
        if (isFlashRoyal(cardList)) {
            return Type.ROYAL_FLUSH;
        }
        if (isStraightFlush(cardList)) {
            return Type.STRAIGHT_FLUSH;
        }
        if (isFourOfAKind(cardList)) {
            return Type.FOUR_OF_A_KIND;
        }
        if (isFullHouse(cardList)) {
            return Type.FULL_HOUSE;
        }
        if (isFlush(cardList)) {
            return Type.FLUSH;
        }
        if (isStraight(cardList)) {
            return Type.STRAIGHT;
        }
        if (isThreeOfAKind(cardList)) {
            return Type.THREE_OF_A_KIND;
        }
        if (isTwoPair(cardList)) {
            return Type.TWO_PAIRS;
        }
        if (isOnePair(cardList)) {
            return Type.ONE_PAIR;
        }
        return Type.HIGH_CARD;
    }

    private boolean isFlashRoyal(List<Card> cardList) {
        Card.Suit suit = cardList.get(0).suit;
        int intType = 12;
        for (Card card : cardList) {
            if (card.type != Card.Type.values()[intType] || card.suit != suit) {
                return false;
            }
            intType--;
        }
        return true;
    }

    private boolean isStraightFlush(List<Card> cardList) {
        Card.Suit suit = cardList.get(0).suit;
        int intType = cardList.get(0).type.ordinal();
        for (Card card : cardList) {
            if (card.type != Card.Type.values()[intType] || card.suit != suit) {
                return false;
            }
            intType--;
        }
        return true;
    }

    private boolean isFourOfAKind(List<Card> cardList) {
        int j = 0;
        int intType = cardList.get(0).type.ordinal();
        if (intType != cardList.get(1).type.ordinal()) {
            intType = cardList.get(1).type.ordinal();
            j++;
        }
        for (int i = j; i < j + 4; i++) {
            if (cardList.get(i).type != Card.Type.values()[intType]) {
                return false;
            }
        }
        return true;
    }

    private boolean isFullHouse(List<Card> cardList) {
        int firstCard = cardList.get(0).type.ordinal();
        int secondCard = cardList.get(1).type.ordinal();
        int thirdCard = cardList.get(2).type.ordinal();
        int fourthCard = cardList.get(3).type.ordinal();
        int fifthCard = cardList.get(4).type.ordinal();

        if (firstCard == secondCard && secondCard == thirdCard && fourthCard == fifthCard) {
            return true;
        } else if (firstCard == secondCard && thirdCard == fourthCard && fourthCard == fifthCard) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFlush(List<Card> cardList) {
        Card.Suit suit = cardList.get(0).suit;
        for (Card card : cardList) {
            if (card.suit != suit) {
                return false;
            }
        }
        return true;
    }

    private boolean isStraight(List<Card> cardList) {
        int intType = cardList.get(0).type.ordinal();
        if (cardList.get(0).type.equals(Card.Type.A) && (cardList.get(1).type.equals(Card.Type._5))) {
            intType = cardList.get(1).type.ordinal();
            for (int i = 1; i < 5; i++) {
                if (cardList.get(i).type != Card.Type.values()[intType]) {
                    return false;
                }
                intType--;
            }
            return true;
        }
        for (Card card : cardList) {
            if (card.type != Card.Type.values()[intType]) {
                return false;
            }
            intType--;
        }
        return true;
    }

    private boolean isThreeOfAKind(List<Card> cardList) {
        int firstCard = cardList.get(0).type.ordinal();
        int secondCard = cardList.get(1).type.ordinal();
        int thirdCard = cardList.get(2).type.ordinal();
        int fourthCard = cardList.get(3).type.ordinal();
        int fifthCard = cardList.get(4).type.ordinal();

        if (firstCard == secondCard && secondCard == thirdCard) {
            return true;
        } else if (secondCard == thirdCard && thirdCard == fourthCard) {
            return true;
        } else if (thirdCard == fourthCard && fourthCard == fifthCard) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isTwoPair(List<Card> cardList) {
        int firstCard = cardList.get(0).type.ordinal();
        int secondCard = cardList.get(1).type.ordinal();
        int thirdCard = cardList.get(2).type.ordinal();
        int fourthCard = cardList.get(3).type.ordinal();
        int fifthCard = cardList.get(4).type.ordinal();

        if (firstCard == secondCard && thirdCard == fourthCard) {
            return true;
        } else if (firstCard == secondCard && fourthCard == fifthCard) {
            return true;
        } else if (secondCard == thirdCard && fourthCard == fifthCard) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOnePair(List<Card> cardList) {
        int firstCard = cardList.get(0).type.ordinal();
        int secondCard = cardList.get(1).type.ordinal();
        int thirdCard = cardList.get(2).type.ordinal();
        int fourthCard = cardList.get(3).type.ordinal();
        int fifthCard = cardList.get(4).type.ordinal();

        if (firstCard == secondCard) {
            return true;
        } else if (secondCard == thirdCard) {
            return true;
        } else if (thirdCard == fourthCard) {
            return true;
        } else if (fourthCard == fifthCard) {
            return true;
        } else {
            return false;
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(PokerHand pokerHand) {
        List<Card> cardList2 = pokerHand.cardList;

        int firstCard1 = cardList.get(0).type.ordinal();
        int secondCard1 = cardList.get(1).type.ordinal();
        int thirdCard1 = cardList.get(2).type.ordinal();
        int fourthCard1 = cardList.get(3).type.ordinal();
        int fifthCard1 = cardList.get(4).type.ordinal();

        int firstCard2 = cardList2.get(0).type.ordinal();
        int secondCard2 = cardList2.get(1).type.ordinal();
        int thirdCard2 = cardList2.get(2).type.ordinal();
        int fourthCard2 = cardList2.get(3).type.ordinal();
        int fifthCard2 = cardList2.get(4).type.ordinal();

        int c = -this.type.compareTo(pokerHand.type);
        if (c != 0) {
            return c;
        }
        if (pokerHand.type.equals(Type.ROYAL_FLUSH)) {
            return 0;
        } else if (pokerHand.type.equals(Type.STRAIGHT_FLUSH)) {
            int first = this.cardList.get(0).type.ordinal();
            int second = pokerHand.cardList.get(0).type.ordinal();
            return second - first;
        } else if (pokerHand.type.equals(Type.FOUR_OF_A_KIND)) {
            int four1 = secondCard1;
            int kicker1 = firstCard1 == secondCard1 ? fifthCard1 : firstCard1;

            int four2 = secondCard2;
            int kicker2 = firstCard2 == secondCard2 ? fifthCard2 : firstCard2;

            int result = four2 - four1;
            if (result != 0) {
                return result;
            }
            return kicker2 - kicker1;
        } else if (pokerHand.type.equals(Type.FULL_HOUSE)) {
            int set1 = thirdCard1;
            int pair1 = thirdCard1 == secondCard1 ? fifthCard1 : firstCard1;

            int set2 = thirdCard2;
            int pair2 = thirdCard2 == secondCard2 ? fifthCard2 : firstCard2;

            int result = set2 - set1;
            if (result != 0) {
                return result;
            }
            return pair2 - pair1;
        } else if (pokerHand.type.equals(Type.FLUSH)) {
            for (int i = 0; i < 5; i++) {
                int first = this.cardList.get(i).getType().ordinal();
                int second = pokerHand.cardList.get(i).getType().ordinal();
                int result = second - first;
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        } else if (pokerHand.type.equals(Type.STRAIGHT)) {
            if (firstCard1 == 12 && secondCard1 == 11) {
                if (firstCard2 == 12 && secondCard2 == 11) {
                    return 0;
                }
                return -1;
            }
            if (firstCard2 == 12 && secondCard2 == 11) {
                return 1;
            }

            if (firstCard1 == 12 && secondCard1 == 3) {
                if (firstCard2 == 12 && secondCard2 == 3) {
                    return 0;
                }
                return 1;
            }
            if (firstCard2 == 12 && secondCard2 == 3) {
                return -1;
            }
            for (int i = 0; i < 5; i++) {
                int first = this.cardList.get(i).getType().ordinal();
                int second = pokerHand.cardList.get(i).getType().ordinal();
                int result = second - first;
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        } else if (pokerHand.type.equals(Type.THREE_OF_A_KIND)) {
            int set1 = thirdCard1;
            int f1 = secondCard1 == thirdCard1 ? fourthCard1 : fifthCard1;
            int s1 = secondCard1 == thirdCard1 ? fifthCard1 : secondCard1;

            int set2 = thirdCard2;
            int f2 = secondCard2 == thirdCard2 ? fourthCard2 : fifthCard2;
            int s2 = secondCard2 == thirdCard2 ? fifthCard2 : secondCard2;

            int result = set2 - set1;
            if (result != 0) {
                return result;
            }
            result = f2 - f1;
            if (result != 0) {
                return result;
            }
            result = s2 - s1;
            if (result != 0) {
                return result;
            }
            return 0;
        } else if (pokerHand.type.equals(Type.TWO_PAIRS)) {
            int firstPair1 = secondCard1;
            int secondPair1 = fourthCard1;
            int kicker1 = firstCard1 == secondCard1 ? (thirdCard1 == fourthCard1 ? fifthCard1 : thirdCard1) : firstPair1;

            int firstPair2 = secondCard2;
            int secondPair2 = fourthCard2;
            int kicker2 = firstCard2 == secondCard2 ? (thirdCard2 == fourthCard2 ? fifthCard2 : thirdCard2) : firstPair2;

            int result = firstPair2 - firstPair1;
            if (result != 0) {
                return result;
            }
            result = secondPair2 - secondPair1;
            if (result != 0) {
                return result;
            }
            result = kicker2 - kicker1;
            if (result != 0) {
                return result;
            }
            return 0;
        } else if (pokerHand.type.equals(Type.ONE_PAIR)) {
            int pair1 = firstCard1 == secondCard1 ? firstCard1 :
                    (secondCard1 == thirdCard1 ? secondCard1 : (thirdCard1 == fourthCard1 ? thirdCard1 : fifthCard1));
            List<Integer> kickers1 = new LinkedList<>();
            for (Card card : this.cardList) {
                if (card.getType().ordinal() != pair1) {
                    kickers1.add(card.getType().ordinal());
                }
            }

            int pair2 = firstCard2 == secondCard2 ? firstCard2 :
                    (secondCard2 == thirdCard2 ? secondCard2 : (thirdCard2 == fourthCard2 ? thirdCard2 : fifthCard2));
            List<Integer> kickers2 = new LinkedList<>();
            for (Card card : pokerHand.cardList) {
                if (card.getType().ordinal() != pair2) {
                    kickers2.add(card.getType().ordinal());
                }
            }

            int result = pair2 - pair1;
            if (result != 0) {
                return result;
            }
            for (int i = 0; i < 3; i++) {
                int k1 = kickers1.get(i);
                int k2 = kickers2.get(i);
                result = k2 - k1;
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        } else if (pokerHand.type.equals(Type.HIGH_CARD)) {
            for (int i = 0; i < 5; i++) {
                int c1 = this.cardList.get(i).type.ordinal();
                int c2 = pokerHand.cardList.get(i).type.ordinal();
                int result = c2 - c1;
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }
        throw new IllegalStateException("type not found to compare");
    }

    @Override
    public String toString() {
        return cardList.toString();
    }

    private static class Card implements Comparable<Card> {

        private Type type;

        private Suit suit;

        public Card(Type type, Suit suit) {
            this.type = type;
            this.suit = suit;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public Suit getSuit() {
            return suit;
        }

        public void setSuit(Suit suit) {
            this.suit = suit;
        }

        @Override
        public int compareTo(Card card) {
            return -this.type.compareTo(card.type);
        }

        @Override
        public String toString() {
            return type.toString() + suit.toString();
        }

        private enum Type {
            _2, _3, _4, _5, _6, _7, _8, _9, T, J, Q, K, A
        }

        private enum Suit {
            S, H, D, C
        }
    }

    public enum Type {
        HIGH_CARD, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH
    }
}
