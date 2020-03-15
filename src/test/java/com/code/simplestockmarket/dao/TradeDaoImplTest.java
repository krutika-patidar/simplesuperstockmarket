package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.constant.TradeType;
import com.code.simplestockmarket.dao.impl.TradeDaoImpl;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Krutika Patidar
 */
@RunWith(MockitoJUnitRunner.class)
public class TradeDaoImplTest {

    @InjectMocks
    private TradeDaoImpl tradeDao = new TradeDaoImpl();

    private Trade trade;
    private Stock stock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        stock = new Stock("ABC", StockType.PREFERRED, 0, 0, 100, 100);
        trade = new Trade(new Timestamp(new Date().getTime()), stock, 10, TradeType.SELL, 110);
    }

    @Test
    public void testGetTrade() {
        tradeDao.getTrade(trade);
    }

    @Test
    public void testGTrade() {
        Trade expectedTrade = tradeDao.addTrade(stock, 10, TradeType.SELL, 110, new Timestamp(new Date().getTime()));
        Assert.assertEquals(expectedTrade.getQuantity(), 10);
        Assert.assertEquals(expectedTrade.getBuyOrSell(), TradeType.SELL);
        Assert.assertEquals(expectedTrade.getTradePrice(), 110, 0);
        Assert.assertEquals(expectedTrade.getStock().getSymbol(), stock.getSymbol());
        Assert.assertEquals(expectedTrade.getStock().getFixedDividend(), stock.getFixedDividend(), 0);
        Assert.assertEquals(expectedTrade.getStock().getLastDividend(), stock.getLastDividend(), 0);
        Assert.assertEquals(expectedTrade.getStock().getPrice(), stock.getPrice(), 0);
        Assert.assertEquals(expectedTrade.getStock().getParValue(), stock.getParValue(), 0);
        Assert.assertEquals(expectedTrade.getStock().getType(), stock.getType());
    }

}
