package com.hansuintern.ecommerceapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "order")
public class Order {
    String customer;
    String item;
    String quantity;
    String amount;
    String date;
    String location;
    String email;
    String comment;
    String contact;
    String payment;
    @PrimaryKey(autoGenerate = true)
    int id;


    public Order(String customer, String item, String quantity, String amount, String date, String location, String email, String comment, String contact, String payment, int id) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.email = email;
        this.comment = comment;
        this.contact = contact;
        this.payment = payment;
        this.id = id;
    }

    @Ignore
    public Order(String customer, String item, String quantity, String amount, String date, String location, String email, String comment, String contact, String payment) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.email = email;
        this.comment = comment;
        this.contact = contact;
        this.payment = payment;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
