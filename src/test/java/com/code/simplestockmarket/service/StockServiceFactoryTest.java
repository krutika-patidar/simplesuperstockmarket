package com.code.simplestockmarket.service;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.impl.StockServiceFactory;
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
public class StockServiceFactoryTest {

    @InjectMocks
    private StockServiceFactory stockServiceFactory = new StockServiceFactory();

    private Stock commonStock;
    private Stock preferredStock;
    private StockOperationService commonStockOperationService;
    private StockOperationService preferredStockOperationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        commonStock = new Stock("ABC", StockType.COMMON, 13, 0, 100, 100);
        preferredStock = new Stock("ABC", StockType.PREFERRED, 8, 2, 100, 100);
        commonStockOperationService = stockServiceFactory.getStock(commonStock.getType());
        preferredStockOperationService = stockServiceFactory.getStock(preferredStock.getType());
    }

    @Test
    public void testCalculateCommonStockDividend() throws StockMarketException {
        double dividend = commonStockOperationService.calculateDividend(commonStock);
        Assert.assertEquals(0.13, dividend, 0);
    }

    @Test
    public void testCalculateCommonStockPERatio() throws StockMarketException {
        double peRatio = commonStockOperationService.calculatePERatio(commonStock);
        Assert.assertEquals(769.23, peRatio, 0);
    }

    @Test
    public void testCalculatePreferredStockDividend() throws StockMarketException {
        double dividend = preferredStockOperationService.calculateDividend(preferredStock);
        Assert.assertEquals(0.02, dividend, 0);
    }

    @Test
    public void testCalculatePERatioPreferredStock() throws StockMarketException {
        double preferredPERatio = preferredStockOperationService.calculatePERatio(preferredStock);
        Assert.assertEquals(5000.0, preferredPERatio, 0);
    }

    @Test(expected = StockMarketException.class)
    public void testCalculatePERatioWithException() throws StockMarketException {
        preferredStock.setPrice(-1);
        double preferredPERatio = preferredStockOperationService.calculatePERatio(preferredStock);
    }

    @Test(expected = NullPointerException.class)
    public void testNullStockFactory() {
        StockServiceFactory stockServiceFactoryService = (StockServiceFactory) stockServiceFactory.getStock(null);
    }
}
