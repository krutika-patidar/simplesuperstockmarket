package com.code.simplestockmarket.constant;

import com.code.simplestockmarket.exception.StockMarketException;

public enum StockType {
    COMMON(1, "Common"),
    PREFERRED(2, "Preferred");

    private int type;
    private String value;

    StockType(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public static StockType getStockType(int i) throws StockMarketException {
        for (StockType s : StockType.values()) {
            if (s.getType() == i) {
                return s;
            }
        }
        throw new StockMarketException("In valid Stock Type");
    }
}
