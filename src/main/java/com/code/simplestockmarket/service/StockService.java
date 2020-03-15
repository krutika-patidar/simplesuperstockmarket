package com.code.simplestockmarket.service;

import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;

import java.util.List;
import java.util.Scanner;

/**
 * @author Krutika Patidar
 */
public interface StockService {
    /**
     * @implNote This method returns Stock details
     * @param stock object of class Stock
     */
    void getStock(Stock stock);

    /**
     * @implNote This method returns StockList details
     * @param stockList List of Stock
     */
    void showStockRecords(List<Stock> stockList);

    /**
     * @implNote This method creates Stock object
     * @param scanner Scanner class object
     * @exception StockMarketException exception
     * @return Stock
     */
    Stock addStock(Scanner scanner) throws StockMarketException;

    /**
     * @implNote This method validates if given Stock symbol exists in the Stock List
     * @param stockList List of Stock
     * @param stockSymbol String
     * @return Stock
     * @exception StockMarketException exception
     */
    Stock validateStock(List<Stock> stockList, String stockSymbol) throws StockMarketException;

}
