/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

/**
 *
 * @author rickrusso
 */
public class ServiceFactory {
    public static StockService getStaockService(){
        return new DatabaseStockService();
    }
}
