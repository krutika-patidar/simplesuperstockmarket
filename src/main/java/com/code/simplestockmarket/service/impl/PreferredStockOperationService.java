package com.code.simplestockmarket.service.impl;

import com.code.simplestockmarket.constant.Utils;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.StockOperationService;
/**
 * @author Krutika Patidar
 */
public class PreferredStockOperationService implements StockOperationService {

    @Override
    public double calculateDividend(Stock stock) throws StockMarketException {
        double fixedDividend = stock.getFixedDividend() / 100;
        double parValue = stock.getParValue();
        double price = Utils.validateNumber(stock.getPrice());
        return price != 0 ? (fixedDividend * parValue) / price : 0;
    }

    @Override
    public double calculatePERatio(Stock stock) throws StockMarketException {
        double price = stock.getPrice();
        double dividend = calculateDividend(stock);
        double peRatio = dividend != 0 ? price / dividend : 0;
        return Utils.round(peRatio, 2);
    }
}
