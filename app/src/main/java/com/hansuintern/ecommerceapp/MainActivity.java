package com.hansuintern.ecommerceapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private EcommerceAdapteter ecommerceAdapteter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //to view our data in the itemlist layout

        ecommerceAdapteter=new EcommerceAdapteter(this);
        myRecyclerView=findViewById(R.id.ecommerceRecyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setAdapter(ecommerceAdapteter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddNewOrder = new Intent(MainActivity.this,NewOrder.class);
                startActivity(AddNewOrder);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onResume(){
        super.onResume();
        List<Order> orderList= getDb().ecommerceDao().selectAllOrders();
        ecommerceAdapteter.setOrderListData(orderList);
    }
    public EcommerceDatabBase getDb(){
        String dataBaseName="room_db";
        EcommerceDatabBase ecommerceDatabBase= Room.databaseBuilder
                (getApplicationContext(),EcommerceDatabBase.class,dataBaseName).allowMainThreadQueries().build();
            return ecommerceDatabBase;
    }
}
