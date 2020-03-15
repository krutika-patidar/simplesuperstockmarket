package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;

/**
 * @author Krutika Patidar
 */
public interface StockDao {
    /**
     * @param stock object of class Stock
     * @implNote This method returns Stock details
     */
    void getStock(Stock stock);

    /**
     * @param symbol        Stock symbol
     * @param stockType     Stock Type
     * @param lastDividend  Last Dividend of stock
     * @param fixedDividend Fixed Dividend of stock
     * @param parValue      Par Value of Stock
     * @param price         Price Value of Stock
     * @return Stock
     * @throws StockMarketException exception
     * @implNote This method creates Stock object
     */
    Stock addStock(String symbol, StockType stockType, double lastDividend, double fixedDividend, double parValue, double price) throws StockMarketException;
}
