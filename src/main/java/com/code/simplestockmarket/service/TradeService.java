package com.code.simplestockmarket.service;

import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import com.code.simplestockmarket.exception.StockMarketException;

import java.util.List;
import java.util.Scanner;

/**
 * @author Krutika Patidar
 */
public interface TradeService {

    /**
     * @implNote This method returns Trade object
     * @param scanner Scanner class object
     * @param stockSelected Stock object
     * @return Trade class object
     * @exception StockMarketException exception
     */
    Trade addTrade(Scanner scanner, Stock stockSelected) throws StockMarketException;

    /**
     * @implNote This method returns info of given trade
     * @param trade Trade class object
     */
    void getTrade(Trade trade);

    /**
     * @implNote This method returns  Volume Weighted Stock Price for given stock in tradeList
     * @param stock object of class Stock
     * @param tradeList List of Trade Object
     * @return double Volume Weighted Stock Price
     */
    double calculateVolumeWeightedStockPrice(Stock stock, List<Trade> tradeList);

    /**
     * @implNote This method returns GBCE All Share Index for all stocks in given past 15 mins
     * @param tradeList List of Trade Object
     * @return double GBCE All Share Index for all stocks in given past 15 mins
     */
    double calculateGBCEALLShareIndex(List<Trade> tradeList) throws StockMarketException;
}
