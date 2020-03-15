package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.TradeType;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;

import java.sql.Timestamp;

public interface TradeDao {
    void getTrade(Trade trade);

    Trade addTrade(Stock stockSelected, int quantity, TradeType buyOrSell, double tradePrice, Timestamp timestamp);
}
