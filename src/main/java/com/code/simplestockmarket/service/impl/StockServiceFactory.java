package com.code.simplestockmarket.service.impl;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.service.StockOperationService;
/**
 * @author Krutika Patidar
 */
public class StockServiceFactory {
    private CommonStockOperationService commonStockOperationService = new CommonStockOperationService();
    private PreferredStockOperationService preferredStockOperationService = new PreferredStockOperationService();

    public StockOperationService getStock(StockType stockType) {
        switch (stockType) {
            case COMMON:
                return commonStockOperationService;
            case PREFERRED:
                return preferredStockOperationService;
            default:
                return null;
        }
    }
}
