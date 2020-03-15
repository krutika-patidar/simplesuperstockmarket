package com.code.simplestockmarket.dao;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.dto.Stock;

public interface StockDao {

    void getStock(Stock stock);

    Stock addStock(String symbol, StockType type, double lastDividend, double fixedDividend, double parValue, double price);
}
