package com.origamisoftware.teach.advanced.services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ServiceFactoryTest {
    @Test
    public void testGetStaockService(){
        StockService stockService = ServiceFactory.getStaockService();
        assertNotNull(stockService);
    }
}
