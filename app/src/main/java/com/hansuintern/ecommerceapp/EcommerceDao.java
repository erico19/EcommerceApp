package com.hansuintern.ecommerceapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EcommerceDao {

    @Insert
    void insertOrder(Order order);
    @Query("SELECT * FROM `order`")
    List<Order> selectAllOrders();





}
