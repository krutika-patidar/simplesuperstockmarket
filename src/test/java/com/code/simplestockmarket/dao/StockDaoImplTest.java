package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.dao.impl.StockDaoImpl;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author Krutika Patidar
 */
@RunWith(MockitoJUnitRunner.class)
public class StockDaoImplTest {
    @InjectMocks
    private StockDao stockDao = new StockDaoImpl();
    private Stock stock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        stock = new Stock("ABC", StockType.COMMON, 0, 0, 100, 100);
    }

    @Test
    public void testGetStock() {
        stockDao.getStock(stock);
    }

    @Test
    public void testAddStock() throws StockMarketException {
        Stock expectedStock = stockDao.addStock("ABC", StockType.COMMON, 0, 0, 100, 100);
        Assert.assertEquals(expectedStock.toString(), stock.toString());
    }

    @Test(expected = StockMarketException.class)
    public void testAddStockWithException() throws StockMarketException {
        Stock expectedStock = stockDao.addStock(null, StockType.COMMON, 0, 0, 100, 100);
    }

    @Test
    public void testStockMarketCustomException() {
        StockMarketException exception= new StockMarketException("Invalid Input");
        Assert.assertEquals(exception.getCustomMessage(), "Invalid Input");
    }
}
