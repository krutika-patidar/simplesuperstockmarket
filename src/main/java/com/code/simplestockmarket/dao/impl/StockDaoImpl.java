package com.code.simplestockmarket.dao.impl;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.dao.StockDao;
import com.code.simplestockmarket.dto.Stock;

public class StockDaoImpl implements StockDao {
    @Override
    public void getStock(Stock stock) {
        System.out.println();
        System.out.print("Stock data --> ");
        System.out.print(", Symbol - "+stock.getSymbol());
        System.out.print(", Type - "+stock.getType());
        System.out.print(", Fixed Dividend - "+stock.getFixedDividend());
        System.out.print(", Last Dividend - "+stock.getLastDividend());
        System.out.print(", Par Value - "+stock.getParValue());
        System.out.print(", Price - "+stock.getPrice());
    }

    @Override
    public Stock addStock(String symbol, StockType type, double lastDividend, double fixedDividend, double parValue, double price) {
        return new Stock(symbol, type, lastDividend, fixedDividend, parValue, price);
    }
}
