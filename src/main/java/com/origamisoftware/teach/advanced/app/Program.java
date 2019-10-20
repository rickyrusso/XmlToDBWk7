/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.app;

import com.origamisoftware.teach.advanced.xml.Stock;
import com.origamisoftware.teach.advanced.xml.Stocks;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author rickrusso
 */
public class Program {
    public static void main(String[] args) throws JAXBException {
        
        File stockInfoXxml = new File("./src/main/resources/xml/stock_info.xml");
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(stockInfoXxml);
        System.out.println(stocks.toString());
        
        
    }
}
