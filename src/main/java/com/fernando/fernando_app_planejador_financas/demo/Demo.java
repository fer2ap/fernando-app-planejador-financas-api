package com.fernando.fernando_app_planejador_financas.demo;

import java.math.BigDecimal;
import java.util.Date;

public record Demo(
    Category category,
    BigDecimal expense,
    Date date
) {
    enum Category {
        FOOD, CLEANING, ENTERTAINMENT
    }
}