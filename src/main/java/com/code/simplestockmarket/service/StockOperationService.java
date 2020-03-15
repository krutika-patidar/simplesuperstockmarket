package com.code.simplestockmarket.service;

import com.code.simplestockmarket.dto.Stock;

public interface StockOperationService {
    double calculateDividend(Stock stock);

    double calculatePERatio(Stock stock);
}
