package com.code.simplestockmarket.service;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.constant.Utils;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.impl.StockServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krutika Patidar
 */
@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

    @InjectMocks
    private StockService stockService = new StockServiceImpl();

    @Mock
    private Utils utils;

    private Stock stock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        stock = new Stock("ABC", StockType.COMMON, 0, 0, 100, 100);
    }

    @Test
    public void testGetStock() {
        stockService.getStock(stock);
    }

    @Test
    public void testShowStockRecords() {
        List<Stock> stockList = new ArrayList<>();
        stockService.showStockRecords(stockList);
    }

    @Test
    public void testValidateStock() throws StockMarketException {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        Stock validateStock = stockService.validateStock(stockList, "ABC");
        Assert.assertEquals(validateStock, stock);
        Assert.assertEquals(validateStock.getSymbol(), "ABC");
    }

    @Test(expected = StockMarketException.class)
    public void testValidateStockWithException() throws StockMarketException {
        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);
        stockService.validateStock(stockList, "BCD");
    }

    @Test
    public void testStockType() throws StockMarketException {
        StockType stockType = StockType.getStockType(1);
        Assert.assertEquals(stockType.getType(), StockType.COMMON.getType());
        Assert.assertEquals(stockType.getValue(), StockType.COMMON.getValue());
    }

    @Test(expected = StockMarketException.class)
    public void testStockTypeWithException() throws StockMarketException {
        StockType.getStockType(3);
    }

}
