package com.hansuintern.ecommerceapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Order.class}, version = 1, exportSchema = false)
public abstract class EcommerceDatabBase extends RoomDatabase {

    public abstract EcommerceDao ecommerceDao();


}
