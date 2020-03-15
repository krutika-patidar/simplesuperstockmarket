package com.code.simplestockmarket.dao.impl;

import com.code.simplestockmarket.constant.TradeType;
import com.code.simplestockmarket.dao.TradeDao;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;

import java.sql.Timestamp;
/**
 * @author Krutika Patidar
 */
public class TradeDaoImpl implements TradeDao {
    @Override
    public void getTrade(Trade trade) {
        System.out.println("Trade details --> ");
        System.out.print(" Stock traded - " + trade.getStock().getSymbol());
        System.out.print(", Buy/Sell - " + trade.getBuyOrSell());
        System.out.print(", quantity - " + trade.getQuantity());
        System.out.print(", Trade Price - " + trade.getTradePrice());
        System.out.print(", Trade Time - " + trade.getTradeTimestamp());
        System.out.println();
    }

    @Override
    public Trade addTrade(Stock stockSelected, int quantity, TradeType buyOrSell, double tradePrice, Timestamp timestamp) {
        return new Trade(timestamp, stockSelected, quantity, buyOrSell, tradePrice);
    }
}
