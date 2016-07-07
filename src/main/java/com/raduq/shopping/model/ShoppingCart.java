package com.raduq.shopping.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raduq on 04/07/2016.
 */
public class ShoppingCart implements Serializable {

    private List<CommerceItem> items;
    private BigDecimal amount;

    public ShoppingCart(){
        this.items = new ArrayList<>();
        this.calculate();
    }

    public ShoppingCart addItem(CommerceItem item) {
        this.items.add(item);
        this.calculate();
        return this;
    }

    public void removeItem(Long id) {
        this.items.removeIf(it-> it.getId().equals(id));
    }

    public List<CommerceItem> getItems() {
        return items;
    }

    public void setItems(List<CommerceItem> items) {
        this.items = items;
        this.calculate();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Calculates the amount based on items on the cart.
     */
    private void calculate(){
        if(this.amount == null){
            this.amount = new BigDecimal(0);
        }
        for(CommerceItem item : this.items){
            this.amount = this.amount.add(item.getAmount().multiply(new BigDecimal(item.getQuantity())));
        }
    }

}
