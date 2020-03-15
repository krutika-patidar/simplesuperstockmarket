package com.code.simplestockmarket.service;

import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;

/**
 * @author Krutika Patidar
 */
public interface StockOperationService {

    /**
     * @param stock object of class Stock
     * @return double Dividend Yield
     * @throws StockMarketException exception
     * @implNote This method returns DividendYield for a given Stock
     */
    double calculateDividend(Stock stock) throws StockMarketException;

    /**
     * @param stock object of class Stock
     * @return double P/E Ratio Value
     * @throws StockMarketException exception
     * @implNote This method returns P/E Ratio for a given Stock
     */
    double calculatePERatio(Stock stock) throws StockMarketException;
}
