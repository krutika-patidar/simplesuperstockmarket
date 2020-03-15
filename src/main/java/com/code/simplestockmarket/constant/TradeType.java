package com.code.simplestockmarket.constant;

import com.code.simplestockmarket.exception.StockMarketException;
/**
 * @author Krutika Patidar
 */
public enum TradeType {
    BUY(1, "Buy"),
    SELL(2, "Sell");

    private int type;
    private String value;

    TradeType(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public static TradeType getTradeType(int i) throws StockMarketException {
        for (TradeType s : TradeType.values()) {
            if (s.getType() == i) {
                return s;
            }
        }
        throw new StockMarketException("In valid Trade Type");
    }
}
