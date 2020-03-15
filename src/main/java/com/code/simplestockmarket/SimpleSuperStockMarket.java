package com.code.simplestockmarket;

import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.StockMarketMenu;

public class SimpleSuperStockMarket {
    public static void main(String args[]) {
        System.out.println("Welcome to Simple Super Stock Market!!");

        try {
            StockMarketMenu.buildStockMarketExchange();
        } catch (StockMarketException e) {
            System.err.println("Stock Market Exception ::" + e.getCustomMessage());
            System.exit(1);
        }
    }
}
