/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockDAO;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import com.origamisoftware.teach.advanced.xml.Stock;
import com.origamisoftware.teach.advanced.xml.Stocks;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rickrusso
 */
public class DatabaseStockService implements StockService {

     /**
     * Add a user to the system.
     *
     * @param stocks the stock to add.
     * @throws com.origamisoftware.teach.advanced.services.StockServiceException if there is a problem creating the stock record.
     */
    
    @Override
    public void AddStocks(Stocks stocks) throws StockServiceException {
        
       Transaction transaction = null;
        Session session = null;
        try {
            session = DatabaseUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            for(Stock stock : stocks.getStocks()){
                StockDAO stockDAO = new StockDAO();
                
                stockDAO.setSymbol(stock.getSymbol());
                stockDAO.setPrice(new BigDecimal(stock.getPrice()));
                
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    cal.setTime(sdf.parse(stock.getTime()));
                } catch (ParseException ex) {
                    throw new StockServiceException("Invalid date", ex);
                }
                
                stockDAO.setDate(cal);
                
                session.saveOrUpdate(stockDAO);
            }
            
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException(e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                // if we get there there's an error to deal with
                transaction.rollback();  //  close transaction
            }
            if (session != null) {
                session.close();
            }
        }
        
    }
    
}
