package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.xml.Stocks;


public interface StockService {
    void AddStocks(Stocks stocks) throws StockServiceException;
}
