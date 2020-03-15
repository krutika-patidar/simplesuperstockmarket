package com.code.simplestockmarket.service;

import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;

import java.util.List;
import java.util.Scanner;

public interface StockService {
    void getStock(Stock stock);

    void showStockRecords(List<Stock> stockList);

    Stock addStock(Scanner scanner) throws StockMarketException;

    Stock validateStock(List<Stock> stockList, String stockSymbol) throws StockMarketException;

}
