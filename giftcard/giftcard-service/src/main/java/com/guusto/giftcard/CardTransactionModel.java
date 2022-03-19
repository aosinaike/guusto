package com.guusto.giftcard;

import javax.persistence.*;

@Entity
@Table(name = "card_transaction")
public class CardTransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name ="quantity")
    private int quantity;
    @Column(name ="amount")
    private String amount;
    @Column(name ="gift")
    private String balance;
    @Column(name ="balance")
    private String gift;

    public CardTransactionModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "GiftCardTransactionModel{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", balance=" + balance +
                ", gift='" + gift + '\'' +
                '}';
    }
}
