package com.code.simplestockmarket.service.impl;

import com.code.simplestockmarket.constant.Constants;
import com.code.simplestockmarket.constant.TradeType;
import com.code.simplestockmarket.constant.Utils;
import com.code.simplestockmarket.dao.TradeDao;
import com.code.simplestockmarket.dao.impl.TradeDaoImpl;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.TradeService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TradeServiceImpl implements TradeService {

    private TradeDao tradeDao = new TradeDaoImpl();

    @Override
    public Trade addTrade(Scanner scanner, Stock stockSelected) throws StockMarketException {
        System.out.println("Choose from below: ");
        System.out.println(" Press 1 to Buy a Stock.");
        System.out.println(" Press 2 to Sell a Stock.");
        int buySellInput = (int) Utils.validateNumber(scanner.nextInt());

        TradeType tradeType = TradeType.getTradeType(buySellInput);
        System.out.println("Enter Trade details to " + tradeType.getValue() + "Stock with symbol " + stockSelected.getSymbol());
        System.out.println("Enter the quantity of shares");
        int quantity = (int) Utils.validateNumber(scanner.nextInt());

        System.out.println("Enter Trade price to " + buySellInput + " the Stock");
        double tradePrice = Utils.validateNumber(scanner.nextDouble());

        Timestamp timestamp = new Timestamp(new Date().getTime());
        Trade trade = tradeDao.addTrade(stockSelected, quantity, tradeType, tradePrice, timestamp);

        System.out.println("Stock traded successfully at time " + timestamp + "!!");
        return trade;
    }

    @Override
    public void getTrade(Trade trade) {
        System.out.println("Trade details are as below: ");
        tradeDao.getTrade(trade);
    }

    @Override
    public double calculateVolumeWeightedStockPrice(Stock stock, List<Trade> tradeList) {
        long currentTimestamp = System.currentTimeMillis();
        List<Trade> lastFifteenMinTrades = tradeList.stream().filter(trade ->
                trade.getStock().getSymbol().equalsIgnoreCase(stock.getSymbol()) &&
                        (currentTimestamp - trade.getTradeTimestamp().getTime()) <= Constants.FIFTEEN_MINUTES_DIFF_IN_MILLIS
        ).collect(Collectors.toList());
        double sumOfPriceXQuantity = lastFifteenMinTrades.stream().mapToDouble(trade ->
                trade.getTradePrice() * trade.getQuantity()).sum();
        double totalQuantity = lastFifteenMinTrades.stream().mapToDouble(Trade::getQuantity).sum();
        double volumeWeightedStocks = totalQuantity != 0 ? sumOfPriceXQuantity / totalQuantity : 0;
        return Utils.round(volumeWeightedStocks, 2);
    }

    @Override
    public double calculateGBCEALLShareIndex(List<Trade> tradeList) throws StockMarketException {
        if (Objects.isNull(tradeList) || tradeList.isEmpty()) {
            throw new StockMarketException("Trades are empty");
        }
        int totalStock = tradeList.size();
        double price = 1;
        for (Trade trade : tradeList) {
            price = price * trade.getTradePrice();
        }
        double geoMetricMean = Math.pow(price, 1.0 / totalStock);
        return Utils.round(geoMetricMean, 2);
    }
}
