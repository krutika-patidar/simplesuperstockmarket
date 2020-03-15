package com.code.simplestockmarket;

import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.StockMarketMenu;
import org.apache.log4j.Logger;


/**
 * @author Krutika Patidar
 */
public class SimpleSuperStockMarket {
    private static Logger logger = Logger.getLogger(SimpleSuperStockMarket.class);

    public static void main(String args[]) {
        System.out.println("Welcome to Simple Super Stock Market!!");

        try {
            StockMarketMenu.buildStockMarketExchange();
        } catch (StockMarketException e) {
            System.err.println("Stock Market Exception :: " + e.getCustomMessage());
            logger.error("Stock Market Exception::: {}",e);
            System.exit(1);
        }
    }
}
