package com.example.demo.product.dto;

import java.math.BigDecimal;

public class SellProductsRequest {

    private BigDecimal moneyMyself;
    private Long amount;
    private Long productsID;

    public BigDecimal getMoneyMyself() {
        return moneyMyself;
    }

    public void setMoneyMyself(BigDecimal moneyMyself) {
        this.moneyMyself = moneyMyself;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getProductsID() {
        return productsID;
    }

    public void setProductsID(Long productsID) {
        this.productsID = productsID;
    }
}
