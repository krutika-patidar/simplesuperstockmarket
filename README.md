# Simple Super Stock Market
Implementation of Simple Super Stock Market Problem Statement

## Problem Statement
Provide working source code that will :-
1. For a given stock,

    a. Given any price as input, calculate the dividend yield.
    
    b. Given any price as input, calculate the P/E Ratio
    
    c. Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price
    
    d. Calculate Volume Weighted Stock Price based on trades in past 15 minutes.
    
2. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks.

# Solution

I have tried to provide Menu driven solution with the use of Factory Design Pattern for this problem. I have tried to keep the solution simple and easy for users. It also includes Junits and loggers framework implementation.
```bash
Tech Stack
1. Source: Java 8
2. Test Framework: 
        Junit version 4.12
        Mockito version 1.9.5
3. Build: Maven
```
# How to use

Run Application:
```bash
run SimpleSuperStockMarket.class Main class
```
Build Project:
```bash
mvn clean package
```
Run Test Case:
```bash
mvn test
```

