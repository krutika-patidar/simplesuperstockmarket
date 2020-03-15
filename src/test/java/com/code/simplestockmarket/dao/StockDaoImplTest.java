package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.dao.impl.StockDaoImpl;
import com.code.simplestockmarket.dto.Stock;
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
    public void testAddStock() {
        Stock expectedStock = stockDao.addStock("ABC", StockType.COMMON, 0, 0, 100, 100);
        Assert.assertEquals(expectedStock.toString(), stock.toString());
    }
}
