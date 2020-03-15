package com.code.simplestockmarket.service.impl;

import com.code.simplestockmarket.constant.StockType;
import com.code.simplestockmarket.constant.Utils;
import com.code.simplestockmarket.dao.StockDao;
import com.code.simplestockmarket.dao.impl.StockDaoImpl;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.StockService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StockServiceImpl implements StockService {

    private StockDao stockDao = new StockDaoImpl();

    @Override
    public void getStock(Stock stock) {
        stockDao.getStock(stock);
    }

    @Override
    public void showStockRecords(List<Stock> stockList) {
        System.out.println("Stock list entered ");
        stockList.forEach(stock -> stockDao.getStock(stock));
    }

    @Override
    public Stock addStock(Scanner scanner) throws StockMarketException {
        System.out.println("Enter symbol for stock ");
        String symbol = Utils.validateString(scanner.next());

        System.out.println("Enter type for stock");
        System.out.println("Press 1 for Common");
        System.out.println("Press 2 for Preferred");
        int type = (int) Utils.validateNumber(scanner.nextInt());
        StockType stockType = StockType.getStockType(type);

        System.out.println("Enter Last Dividend for stock");
        double lastDividend = Utils.validateNumber(scanner.nextDouble());

        System.out.println("Enter Fixed Dividend for stock");
        double fixedDividend = Utils.validateNumber(scanner.nextDouble());

        System.out.println("Enter Par  Value for stock");
        int parValue = (int) Utils.validateNumber(scanner.nextInt());

        System.out.println("Enter Price for stock");
        double price = Utils.validateNumber(scanner.nextDouble());

        return stockDao.addStock(symbol, stockType, lastDividend, fixedDividend, parValue, price);
    }

    @Override
    public Stock validateStock(List<Stock> stockList, String stockSymbol) throws StockMarketException {
        Optional<Stock> optionalStock = Optional.of(stockList.stream().filter(s ->
                s.getSymbol().equalsIgnoreCase(stockSymbol)).findFirst()).get();
        Stock stockSelected;
        if (optionalStock.isPresent()) {
            stockSelected = optionalStock.get();
        } else {
            throw new StockMarketException("In valid input. " + stockSymbol +
                    " does not exist in the given list. Please select from the List.");
        }
        return stockSelected;
    }
}
