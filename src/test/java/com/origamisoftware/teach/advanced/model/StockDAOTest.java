package com.origamisoftware.teach.advanced.model;

import com.google.protobuf.Timestamp;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockDAOTest {
    StockDAO stockDAO;
    
    @Before
    public void setup() {
        stockDAO = new StockDAO();
        
        stockDAO.setId(123);
        stockDAO.setSymbol("GOOG");
        stockDAO.setPrice(new BigDecimal(100));
        stockDAO.setDate(new GregorianCalendar(2019, 10, 10, 0, 0, 0));
    }
    
    @Test
    public void testGetPrice() {
        assertEquals("Share price is correct", new BigDecimal(100), stockDAO.getPrice());
    }
    
    @Test
    public void testGetDate() {
        Calendar cal = new GregorianCalendar(2019, 10, 10);
        assertEquals("Share date is correct", cal, stockDAO.getDate());
    }

    @Test
    public void testGetSymbol() {
        assertEquals("Symbol  is correct", "GOOG", stockDAO.getSymbol());
    }
    
}
