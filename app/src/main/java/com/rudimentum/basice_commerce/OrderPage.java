package com.rudimentum.basice_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rudimentum.basice_commerce.model.Order;
import com.rudimentum.basice_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {
    ListView ordersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        ordersList = findViewById(R.id.ordersList);

        List<String> productNames = new ArrayList<>();

        for (Product product : MainActivity.fullProductList) {
            if (Order.items.contains(product.getId())) {
                productNames.add(product.getName());
            }
        }
        ordersList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productNames));
    }
}