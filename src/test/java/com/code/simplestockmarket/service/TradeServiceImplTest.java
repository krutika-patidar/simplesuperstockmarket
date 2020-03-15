package com.code.simplestockmarket.service;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.constant.TradeType;
import com.code.simplestockmarket.dao.TradeDao;
import com.code.simplestockmarket.dao.impl.TradeDaoImpl;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.impl.TradeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Krutika Patidar
 */
@RunWith(MockitoJUnitRunner.class)
public class TradeServiceImplTest {

    @InjectMocks
    private TradeService tradeService = new TradeServiceImpl();

    @Mock
    private TradeDao tradeDao = new TradeDaoImpl();

    private List<Trade> tradeList = new ArrayList<>();

    private Trade trade1;
    private Trade trade2;
    private Stock stock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        stock = new Stock("ABC", StockType.PREFERRED, 0, 0, 100, 100);
        trade1 = new Trade(new Timestamp(new Date().getTime()), stock, 10, TradeType.SELL, 110);
        trade2 = new Trade(new Timestamp(new Date().getTime()), stock, 10, TradeType.BUY, 110);
        tradeList.add(trade1);
        tradeList.add(trade2);
    }

    @Test
    public void testGetTrade() {
        Mockito.doAnswer(i -> {
            Trade trade = (Trade) i.getArguments()[0];
            Assert.assertEquals(trade.toString(), trade1.toString());
            Assert.assertEquals(trade.getQuantity(), 10);
            Assert.assertEquals(trade.getBuyOrSell(), TradeType.SELL);
            Assert.assertEquals(trade.getTradePrice(), 110, 0);
            Assert.assertEquals(trade.getStock().getSymbol(), stock.getSymbol());
            Assert.assertEquals(trade.getStock().getFixedDividend(), stock.getFixedDividend(), 0);
            Assert.assertEquals(trade.getStock().getLastDividend(), stock.getLastDividend(), 0);
            Assert.assertEquals(trade.getStock().getPrice(), stock.getPrice(), 0);
            Assert.assertEquals(trade.getStock().getParValue(), stock.getParValue(), 0);
            Assert.assertEquals(trade.getStock().getType(), stock.getType());
            return null;
        }).when(tradeDao).getTrade(Mockito.any(Trade.class));
        tradeService.getTrade(trade1);
    }

    @Test
    public void testCalculateGBCEAllShareIndex() throws StockMarketException {
        double geometricMean = tradeService.calculateGBCEALLShareIndex(tradeList);
        Assert.assertEquals(geometricMean, 110.0, 0);
    }

    @Test(expected = StockMarketException.class)
    public void testCalculateGBCEAllShareIndexWithException() throws StockMarketException {
        tradeService.calculateGBCEALLShareIndex(null);
    }

    @Test
    public void testCalculateVolumeWeightedStocks() {
        double volumeWeighted = tradeService.calculateVolumeWeightedStockPrice(stock, tradeList);
        Assert.assertEquals(volumeWeighted, 110.0, 0);
    }

    @Test
    public void testTradeType() throws StockMarketException {
        TradeType tradeType = TradeType.getTradeType(1);
        Assert.assertEquals(tradeType.getType(), TradeType.BUY.getType());
        Assert.assertEquals(tradeType.getValue(), TradeType.BUY.getValue());
    }

    @Test(expected = StockMarketException.class)
    public void testTradeTypeWithException() throws StockMarketException {
        TradeType.getTradeType(3);
    }

}
