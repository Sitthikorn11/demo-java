package com.example.demo.product.dto;

import java.math.BigDecimal;

public class SellProductsRequest {

    private BigDecimal moneyMyself;
    private Long amount;
    private Long ProductsID;

    public BigDecimal getMoneyMyself() {
        return moneyMyself;
    }

    public void setMoneyMyself(BigDecimal moneyMyself) {
        this.moneyMyself = moneyMyself;
    }

    public Long getProductsID() {
        return ProductsID;
    }

    public void setProductsID(Long productsID) {
        ProductsID = productsID;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
