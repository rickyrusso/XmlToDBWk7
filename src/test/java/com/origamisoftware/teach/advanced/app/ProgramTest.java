package com.origamisoftware.teach.advanced.app;

import com.origamisoftware.teach.advanced.services.StockServiceException;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import javax.xml.bind.JAXBException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ProgramTest {

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    
    @Before
    public void setup() throws Exception {
        initDb();
    }

    @After
    public void tearDown() throws Exception {
        initDb();
    }
    
    @Test
    public void testMain() throws StockServiceException, JAXBException{
        String[] args = new String[] {"./src/main/resources/xml/stock_info.xml"};
        Program.main(args);
    }
    
    @Test(expected = NullPointerException.class)
    public void testMainNegative() throws StockServiceException, JAXBException{
        Program.main(null);
    }
}
