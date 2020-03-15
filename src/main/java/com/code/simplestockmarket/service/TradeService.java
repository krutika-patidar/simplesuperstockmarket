package com.code.simplestockmarket.service;

import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import com.code.simplestockmarket.exception.StockMarketException;

import java.util.List;
import java.util.Scanner;

public interface TradeService {
    Trade addTrade(Scanner scanner, Stock stockSelected) throws StockMarketException;

    void getTrade(Trade trade);

    double calculateVolumeWeightedStockPrice(Stock stock, List<Trade> tradeList);

    double calculateGBCEALLShareIndex(List<Trade> tradeList) throws StockMarketException;
}
