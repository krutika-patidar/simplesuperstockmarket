package com.code.simplestockmarket.service;

import com.code.simplestockmarket.constant.Utils;
import com.code.simplestockmarket.dto.Stock;
import com.code.simplestockmarket.dto.Trade;
import com.code.simplestockmarket.exception.StockMarketException;
import com.code.simplestockmarket.service.impl.StockServiceFactory;
import com.code.simplestockmarket.service.impl.StockServiceImpl;
import com.code.simplestockmarket.service.impl.TradeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Krutika Patidar
 */
public class StockMarketMenu {

    private StockServiceFactory stockServiceFactory = new StockServiceFactory();
    private StockService stockService = new StockServiceImpl();
    private TradeService tradeService = new TradeServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public static void buildStockMarketExchange() throws StockMarketException {
        StockMarketMenu stockMarketMenu = new StockMarketMenu();
        List<Stock> stockList = stockMarketMenu.getStocksInputFromUser();
        stockMarketMenu.displayStockMarketMenu(stockList);
    }

    private List<Stock> getStocksInputFromUser() throws StockMarketException {
        List<Stock> stockList = new ArrayList<>();
        System.out.println("Enter the no of stocks for entry");
        int count = (int) Utils.validateNumber(scanner.nextInt());
        System.out.println("Enter details for all " + count + " Stocks");
        for (int i = 1; i <= count; i++) {
            System.out.println("Enter details for Stock no " + i);
            Stock stock = stockService.addStock(scanner);
            stockList.add(stock);
        }
        return stockList;
    }

    private void displayStockMarketMenu(List<Stock> stockList) throws StockMarketException {
        List<Trade> tradeStockList = new ArrayList<>();
        String choice;
        do {
            stockService.showStockRecords(stockList);
            System.out.println();
            System.out.println("Select from the Menu");
            System.out.println("Press 1 for Stock Operations.");
            System.out.println("Press 2 to Calculate the GBCE All Share Index.");
            int firstOption = scanner.nextInt();
            switch (firstOption) {
                case 1:
                    this.getStockOperations(stockList, tradeStockList);
                    break;
                case 2:
                    double geometricMean = tradeService.calculateGBCEALLShareIndex(tradeStockList);
                    System.out.println("GBCE All Share Index is: " + geometricMean);
                    break;
                default:
                    break;
            }
            choice = validateChoiceInput();
        } while (choice.equalsIgnoreCase("Y"));
    }

    private void getStockOperations(List<Stock> stockList, List<Trade> tradeStockList) throws StockMarketException {
        Stock stockSelected = validateStockChoice(stockList);
        String stockSymbol = stockSelected.getSymbol();
        StockOperationService stockOperationService = stockServiceFactory.getStock(stockSelected.getType());
        String choiceForStockOperation;
        do {
            System.out.println("Choose operation from below for selected stock " + stockSelected.getSymbol());
            System.out.println(" Press 1 to Calculate Dividend Yield");
            System.out.println(" Press 2 to Calculate P/E Ratio");
            System.out.println(" Press 3 to Record a Trade");
            System.out.println(" Press 4 to Calculate Volume Weighted Stock Price based on trades in past 15 minutes");

            int secondOption = scanner.nextInt();
            switch (secondOption) {
                case 1:
                    double dividendYield = stockOperationService.calculateDividend(stockSelected);
                    System.out.println("Dividend Yield for Stock " + stockSymbol + "is " + dividendYield);
                    break;
                case 2:
                    double peRatio = stockOperationService.calculatePERatio(stockSelected);
                    System.out.println("P/E Ratio for Stock " + stockSymbol + " is " + peRatio);
                    break;
                case 3:
                    Trade trade = tradeService.addTrade(scanner, stockSelected);
                    tradeStockList.add(trade);
                    tradeService.getTrade(trade);
                    break;
                case 4:
                    double volumeWeightedStockPrice = tradeService.calculateVolumeWeightedStockPrice(stockSelected, tradeStockList);
                    System.out.println("Volume Weighted stock price for stock " + stockSymbol + " is " + volumeWeightedStockPrice);
                    break;
                default:
                    break;
            }
            choiceForStockOperation = validateChoiceInputForStockOps();
        } while (choiceForStockOperation.equalsIgnoreCase("Y"));
    }

    private Stock validateStockChoice(List<Stock> stockList) throws StockMarketException {
        System.out.println("Choose a stock from the list for operations");
        stockList.forEach(s -> System.out.print(" [" + s.getSymbol() + "] "));
        System.out.println();
        String stockSymbol = Utils.validateString(scanner.next());
        return stockService.validateStock(stockList, stockSymbol);
    }

    private String validateChoiceInputForStockOps() {
        System.out.println("Do you wish to continue with Stock Operations? Choose (y/n)");
        String choice = scanner.next();
        choice = validateChoiceInput(choice);
        return Objects.isNull(choice) ? validateChoiceInputForStockOps() : choice;
    }

    private String validateChoiceInput() {
        System.out.println("Do you wish to continue with Stock Market Program? Choose (y/n)");
        String choice = scanner.next();
        choice = validateChoiceInput(choice);
        return Objects.isNull(choice) ? validateChoiceInput() : choice;
    }

    private String validateChoiceInput(String choice) {
        if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y"))
            return choice;
        else {
            System.out.println("In valid input. Please try again");
            return null;
        }
    }


}
