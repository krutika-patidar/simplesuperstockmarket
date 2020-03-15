package com.code.simplestockmarket.dto;

import com.code.simplestockmarket.constant.StockType;

import java.io.Serializable;
/**
 * @author Krutika Patidar
 */
public class Stock implements Serializable {
    private static final long serialVersionID = 1;

    private String symbol;
    private StockType type;
    private double lastDividend;
    private double fixedDividend;
    private double parValue;
    private double price;

    public Stock(String symbol, StockType type, double lastDividend, double fixedDividend, double parValue, double price) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public StockType getType() {
        return type;
    }

    public double getLastDividend() {
        return lastDividend;
    }

    public double getFixedDividend() {
        return fixedDividend;
    }

    public double getParValue() {
        return parValue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", type=" + type +
                ", lastDividend=" + lastDividend +
                ", fixedDividend=" + fixedDividend +
                ", parValue=" + parValue +
                ", price=" + price +
                '}';
    }
}
