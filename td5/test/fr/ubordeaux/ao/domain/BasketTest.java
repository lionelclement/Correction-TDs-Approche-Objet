package fr.ubordeaux.ao.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {

    Basket basket;

    @Before
    public void initBasket() {
        basket = new Basket();
    }
    
    @Test
    public void testBasket() {


        ReferenceName book = new ReferenceName("book");
        Reference ref = new Reference(book, "good book", new Price(10));

        basket.order(ref, 1);
        assertEquals(10, basket.getPrice().getValue());
        basket.order(ref, 3);
        assertEquals(30, basket.getPrice().getValue());

        ReferenceName music = new ReferenceName("music");
        Reference ref2 = new Reference(music, "good music", new Price(20));

        basket.order(ref2, 1);
        assertEquals(50, basket.getPrice().getValue());

    }

}