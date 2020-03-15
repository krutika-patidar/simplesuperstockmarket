package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.TradeType;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import com.code.simplestockmarket.exception.StockMarketException;

import java.sql.Timestamp;

/**
 * @author Krutika Patidar
 */
public interface TradeDao {
    /**
     * @param trade Trade Object
     * @implNote This method displays trade info
     */
    void getTrade(Trade trade);

    /**
     * @param stockSelected Stock object
     * @param quantity      quantity of Trades
     * @param buyOrSell     TradeType
     * @param tradePrice    price of Trade
     * @param timestamp     time of trade
     * @return Trade class object
     * @implNote This method returns Trade object
     */
    Trade addTrade(Stock stockSelected, int quantity, TradeType buyOrSell, double tradePrice, Timestamp timestamp);
}
