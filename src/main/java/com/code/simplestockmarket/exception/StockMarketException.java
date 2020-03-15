package com.code.simplestockmarket.exception;
/**
 * @author Krutika Patidar
 */
public class StockMarketException extends Exception {
    private String msg;

    public StockMarketException(String message) {
        super(message);
        msg = message;
    }

    public String getCustomMessage() {
        return msg;
    }
}
