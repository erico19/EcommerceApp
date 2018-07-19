package com.hansuintern.ecommerceapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class NewOrder extends AppCompatActivity {
    EditText customerName;
    EditText itemName;
    EditText itemQuantity;
    EditText itemAmount;
    EditText orderDate;
    EditText customerLocation;
    EditText customerContact;
    EditText customerEmail;
    EditText customerComment;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        customerName = findViewById(R.id.customerName);
        itemName = findViewById(R.id.itemName);
        itemQuantity = findViewById(R.id.itemQuantity);
        itemAmount = findViewById(R.id.orderAmount);
        orderDate = findViewById(R.id.orderDate);
        customerLocation = findViewById(R.id.customerLocation);
        customerContact = findViewById(R.id.customerContact);
        customerEmail = findViewById(R.id.customerEmail);
        customerComment = findViewById(R.id.customerComment);
    }

    public void chooseModeOfPayment(View view) {

        if (view.getId() == R.id.mobileMoney) {
            payment = "Mobile Money";

        }
        if (view.getId() == R.id.creditCard) {
            payment = "Credit Card";
        }


    }


    public void makeOrder(View view) {
        customer = customerName.getText().toString();
        item = itemName.getText().toString();
        quantity = itemQuantity.getText().toString();
        amount = itemAmount.getText().toString();
        date = orderDate.getText().toString();
        location = customerLocation.getText().toString();
        email = customerEmail.getText().toString();
        comment =customerComment.getText().toString();
        contact =customerContact.getText().toString();

        if (!customer.isEmpty() && !item.isEmpty() && ! quantity.isEmpty() && !amount.isEmpty() && !date.isEmpty() &&
                !location.isEmpty() && !email.isEmpty() && !comment.isEmpty() && !contact.isEmpty() ){
            Order order = new Order(customer,item,quantity,amount,date,location,email,comment,contact,payment);
            getDB().ecommerceDao().insertOrder(order);

            Toast.makeText(this,"customer" + order.getCustomer(),Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"please enter all fields",Toast.LENGTH_SHORT).show();

        }
    }
    public EcommerceDatabBase getDB(){
        String databaseName = "ecommerce_db";
        EcommerceDatabBase ecommerceDatabBase = Room.databaseBuilder(getApplicationContext(),EcommerceDatabBase.class,databaseName)
                .allowMainThreadQueries().build();
        return ecommerceDatabBase;
    }
}
