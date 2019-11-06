package com.origamisoftware.teach.advanced.xml;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.GregorianCalendar;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StockTest {
    Stock stock;
    
    
    @Before
    public void setup() {
        stock = new Stock();
        
        stock.setSymbol("GOOG");
        stock.setPrice(100.12);
        stock.setTime("2015-02-10 00:00:01");
    }
    
    @Test
    public void testSymbol(){
        assertEquals("symbol is correct", "GOOG", stock.getSymbol());
    }

    @Test
    public void testTime(){
        assertEquals("time is correct", "2015-02-10 00:00:01", stock.getTime());
    }
    
    @Test
    public void testPrice(){
        BigDecimal expected = new BigDecimal(100.12);
        expected = expected.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal actual = new BigDecimal(stock.getPrice());
        actual = actual.setScale(2,RoundingMode.HALF_EVEN);
        
        assertEquals("price is correct", expected, actual);
    }
    
}
