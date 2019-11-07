/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stocks")
public class Stocks {
    @XmlElement(name = "stock")
    protected List<Stock> stocks;
    
    
    public List<Stock> getStocks() {
        return this.stocks;
    }
    
    public void setStock(List<Stock> stocks){
        this.stocks = stocks;
    }
    
}
