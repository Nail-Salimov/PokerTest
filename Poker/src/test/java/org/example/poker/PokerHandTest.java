package org.example.poker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerHandTest {

    @Test
    public void testToCreateValidHand() {
        PokerHand pokerHand = new PokerHand("QH KH AH 7H TH");
        assertNotNull(pokerHand);
    }

    @Test
    public void testToCreateInvalidHand() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PokerHand pokerHand = new PokerHand("QH KH AH JH");
        });
        assertTrue(exception.getMessage().contains("It's not poker hand"));
    }

    @Test
    public void testToCreateInvalidCard() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PokerHand pokerHand = new PokerHand("QH 6H AH 9H TN");
        });
        assertTrue(exception.getMessage().contains("No enum"));
    }

    @Test
    public void testToCreateIllegalCard() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PokerHand pokerHand = new PokerHand("QH KH AH JH THH");
        });
        assertTrue(exception.getMessage().contains("is illegal card"));
    }

    @Test
    public void testIsRoyalFlush() {
        PokerHand pokerHand = new PokerHand("AH KH QH JH TH");
        assertEquals(pokerHand.getType(), PokerHand.Type.ROYAL_FLUSH);
    }

    @Test
    public void testIsStraightFlush() {
        PokerHand pokerHand = new PokerHand("JH TH 9H 8H 7H");
        assertEquals(pokerHand.getType(), PokerHand.Type.STRAIGHT_FLUSH);
    }

    @Test
    public void testIsFourOfAKind1() {
        PokerHand pokerHand = new PokerHand("AH AS AD AC 7H");
        assertEquals(pokerHand.getType(), PokerHand.Type.FOUR_OF_A_KIND);
    }

    @Test
    public void testIsFourOfAKind2() {
        PokerHand pokerHand = new PokerHand("AH KS KD KC KH");
        assertEquals(pokerHand.getType(), PokerHand.Type.FOUR_OF_A_KIND);
    }

    @Test
    public void testIsFullHouse1() {
        PokerHand pokerHand = new PokerHand("AH AS AD KC KH");
        assertEquals(pokerHand.getType(), PokerHand.Type.FULL_HOUSE);
    }

    @Test
    public void testIsFullHouse2() {
        PokerHand pokerHand = new PokerHand("AH AS KD KC KH");
        assertEquals(pokerHand.getType(), PokerHand.Type.FULL_HOUSE);
    }

    @Test
    public void testIsFlush() {
        PokerHand pokerHand = new PokerHand("QH 8H 7H 5H 2H");
        assertEquals(pokerHand.getType(), PokerHand.Type.FLUSH);
    }

    @Test
    public void testIsStraight() {
        PokerHand pokerHand = new PokerHand("KH QS JS TC 9H");
        assertEquals(pokerHand.getType(), PokerHand.Type.STRAIGHT);
    }

    @Test
    public void testIsStraightWithA1() {
        PokerHand pokerHand = new PokerHand("AH KS QS JC TH");
        assertEquals(pokerHand.getType(), PokerHand.Type.STRAIGHT);
    }

    @Test
    public void testIsStraightWithA2() {
        PokerHand pokerHand = new PokerHand("AH 2S 3S 4C 5H");
        assertEquals(pokerHand.getType(), PokerHand.Type.STRAIGHT);
    }

    @Test
    public void testIsThreeOfKind1() {
        PokerHand pokerHand = new PokerHand("AH AS AH QH 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.THREE_OF_A_KIND);
    }

    @Test
    public void testIsThreeOfKind2() {
        PokerHand pokerHand = new PokerHand("AH QS QD QH 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.THREE_OF_A_KIND);
    }

    @Test
    public void testIsThreeOfKind3() {
        PokerHand pokerHand = new PokerHand("AH QS 7H 7S 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.THREE_OF_A_KIND);
    }

    @Test
    public void testIsTwoOfPair1() {
        PokerHand pokerHand = new PokerHand("QH QS TH TS 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.TWO_PAIRS);
    }

    @Test
    public void testIsTwoOfPair2() {
        PokerHand pokerHand = new PokerHand("AH QS QH 7S 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.TWO_PAIRS);
    }

    @Test
    public void testIsTwoOfPair3() {
        PokerHand pokerHand = new PokerHand("QH QS TH 7S 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.TWO_PAIRS);
    }

    @Test
    public void testIsOnePair1() {
        PokerHand pokerHand = new PokerHand("QH QS TH 7S 6D");
        assertEquals(pokerHand.getType(), PokerHand.Type.ONE_PAIR);
    }

    @Test
    public void testIsOnePair2() {
        PokerHand pokerHand = new PokerHand("AH QS QH 7S 6D");
        assertEquals(pokerHand.getType(), PokerHand.Type.ONE_PAIR);
    }

    @Test
    public void testIsOnePair3() {
        PokerHand pokerHand = new PokerHand("AH QS TH TS 6D");
        assertEquals(pokerHand.getType(), PokerHand.Type.ONE_PAIR);
    }

    @Test
    public void testIsOnePair4() {
        PokerHand pokerHand = new PokerHand("KH QS TH 7S 7D");
        assertEquals(pokerHand.getType(), PokerHand.Type.ONE_PAIR);
    }

    @Test
    public void testIsHighCard() {
        PokerHand pokerHand = new PokerHand("KH QS TH 7S 6D");
        assertEquals(pokerHand.getType(), PokerHand.Type.HIGH_CARD);
    }

    @Test
    public void testCompareTwoRoyalFlush() {
        PokerHand pokerHand1 = new PokerHand("AH KH QH JH TH");
        PokerHand pokerHand2 = new PokerHand("AH KH QH JH TH");
        assertEquals(pokerHand1.compareTo(pokerHand2), 0);
    }

    @Test
    public void testCompareTwoStraightFlush1() {
        PokerHand pokerHand1 = new PokerHand("JH TH 9H 8H 7H");
        PokerHand pokerHand2 = new PokerHand("TH 9H 8H 7H 6H");
        assertTrue(pokerHand1.compareTo(pokerHand2) < 0);
    }

    @Test
    public void testCompareTwoStraightFlush2() {
        PokerHand pokerHand1 = new PokerHand("JH TH 9H 8H 7H");
        PokerHand pokerHand2 = new PokerHand("TH 9H 8H 7H 6H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareFourOfAKind1() {
        PokerHand pokerHand1 = new PokerHand("8H 8D 8C 8S AH");
        PokerHand pokerHand2 = new PokerHand("AH 8H AD AC AS");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareFourOfAKind2() {
        PokerHand pokerHand1 = new PokerHand("8D 8C 8S 8H AH");
        PokerHand pokerHand2 = new PokerHand("8D 8C 8S 8H KH");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareFullHouse1() {
        PokerHand pokerHand1 = new PokerHand("JH JD JS 8C 8H");
        PokerHand pokerHand2 = new PokerHand("KH AH AS AD KD");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareFullHouse2() {
        PokerHand pokerHand1 = new PokerHand("JH JD JS 8D 8H");
        PokerHand pokerHand2 = new PokerHand("JH JD JS AH AD");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareFlush1() {
        PokerHand pokerHand1 = new PokerHand("QH 8H JH 7H 9H");
        PokerHand pokerHand2 = new PokerHand("KH QH JH 6H 8H");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareFlush2() {
        PokerHand pokerHand1 = new PokerHand("QH 8H JH 7H 9H");
        PokerHand pokerHand2 = new PokerHand("QH 8H JH 7H 9H");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareStraight1() {
        PokerHand pokerHand1 = new PokerHand("AH 2H 3S 4D 5H");
        PokerHand pokerHand2 = new PokerHand("TH JH QS KD AH");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareStraight2() {
        PokerHand pokerHand1 = new PokerHand("KH QH JS TD 9H");
        PokerHand pokerHand2 = new PokerHand("JH TH 8S 9D 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareStraight3() {
        PokerHand pokerHand1 = new PokerHand("KH QH JS TD 9H");
        PokerHand pokerHand2 = new PokerHand("KH QH JS TD 9H");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareStraight4() {
        PokerHand pokerHand1 = new PokerHand("AH 2H 3S 4D 5H");
        PokerHand pokerHand2 = new PokerHand("AH 2H 3S 4D 5H");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareStraight5() {
        PokerHand pokerHand1 = new PokerHand("TH JH QS KD AH");
        PokerHand pokerHand2 = new PokerHand("TH JH QS KD AH");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareStraight6() {
        PokerHand pokerHand1 = new PokerHand("AH 2H 3S 4D 5H");
        PokerHand pokerHand2 = new PokerHand("JH TH 9S 8D 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareStraight7() {
        PokerHand pokerHand1 = new PokerHand("TH JH QS KD AH");
        PokerHand pokerHand2 = new PokerHand("JH TH 9S 8D 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareStraight8() {
        PokerHand pokerHand2 = new PokerHand("AH 2H 3S 4D 5H");
        PokerHand pokerHand1 = new PokerHand("JH TH 9S 8D 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareThreeOfAKind1() {
        PokerHand pokerHand1 = new PokerHand("AH AS AD JD QH");
        PokerHand pokerHand2 = new PokerHand("JH JS JD 9D 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareThreeOfAKind2() {
        PokerHand pokerHand1 = new PokerHand("AH AD AS JD QH");
        PokerHand pokerHand2 = new PokerHand("AH AD AS 9D 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareThreeOfAKind3() {
        PokerHand pokerHand1 = new PokerHand("AH AS AD JD 8H");
        PokerHand pokerHand2 = new PokerHand("AH AS AD JD 7H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareThreeOfAKind4() {
        PokerHand pokerHand1 = new PokerHand("AH AS AD JD 8H");
        PokerHand pokerHand2 = new PokerHand("AH AS AD JD 8H");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareTwoPairs1() {
        PokerHand pokerHand1 = new PokerHand("AH AS JS JD 8H");
        PokerHand pokerHand2 = new PokerHand("JH JS 7S 7D 8H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareTwoPairs2() {
        PokerHand pokerHand1 = new PokerHand("AH AS JS JD 8H");
        PokerHand pokerHand2 = new PokerHand("AH AS 7S 7D 8H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareTwoPairs3() {
        PokerHand pokerHand1 = new PokerHand("AH AS 7S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH AS 7S 7D 8H");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareTwoPairs4() {
        PokerHand pokerHand1 = new PokerHand("AH AS 7S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH AS 7S 7D 6H");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareOnePair1() {
        PokerHand pokerHand1 = new PokerHand("AH AS 8S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("JH JS 7S 6D 8H");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareOnePair2() {
        PokerHand pokerHand1 = new PokerHand("AH AS 8S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH AS TS 6D 8H");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }

    @Test
    public void testCompareOnePair3() {
        PokerHand pokerHand1 = new PokerHand("AH AS 8S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH AS 8S 7D 6S");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareHighCard1() {
        PokerHand pokerHand1 = new PokerHand("AH KH 8S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH QH 8S 7D 6S");
        assertTrue(pokerHand2.compareTo(pokerHand1) > 0);
    }

    @Test
    public void testCompareHighCard2() {
        PokerHand pokerHand1 = new PokerHand("AH KH 8S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH KS 8S 7S 6H");
        assertEquals(0, pokerHand2.compareTo(pokerHand1));
    }

    @Test
    public void testCompareDifferentHand() {
        PokerHand pokerHand1 = new PokerHand("AH KH 8S 7D 6H");
        PokerHand pokerHand2 = new PokerHand("AH AS 8S 7D 6H");
        assertTrue(pokerHand2.compareTo(pokerHand1) < 0);
    }
}
