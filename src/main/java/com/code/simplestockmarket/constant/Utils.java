package com.code.simplestockmarket.constant;

import com.code.simplestockmarket.exception.StockMarketException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
/**
 * @author Krutika Patidar
 */
public class Utils {
    public static double round(double value, int places) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public static String validateString(String value) throws StockMarketException {
        if (Objects.isNull(value)) {
            throw new StockMarketException("Please input correct value");
        }
        return value;
    }

    public static double validateNumber(double value) throws StockMarketException {
        if (value < 0) {
            throw new StockMarketException("Please input correct value");
        }
        return value;
    }
}
