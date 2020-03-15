package com.code.simplestockmarket.dto;

import com.code.simplestockmarket.constant.TradeType;

import java.io.Serializable;
import java.sql.Timestamp;

public class Trade implements Serializable {

    private static final long serialVersionID = 1;

    private Timestamp tradeTimestamp;
    private Stock stock;
    private int quantity;
    private TradeType buyOrSell;
    private double tradePrice;

    public Trade(Timestamp tradeTimestamp, Stock stock, int quantity, TradeType buyOrSell, double tradePrice) {
        this.tradeTimestamp = tradeTimestamp;
        this.stock = stock;
        this.quantity = quantity;
        this.buyOrSell = buyOrSell;
        this.tradePrice = tradePrice;
    }

    public Timestamp getTradeTimestamp() {
        return tradeTimestamp;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public TradeType getBuyOrSell() {
        return buyOrSell;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeTimestamp=" + tradeTimestamp +
                ", stock=" + stock +
                ", quantity=" + quantity +
                ", buyOrSell=" + buyOrSell +
                ", tradePrice=" + tradePrice +
                '}';
    }
}
