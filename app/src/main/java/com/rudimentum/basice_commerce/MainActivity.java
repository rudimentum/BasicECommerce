package com.rudimentum.basice_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rudimentum.basice_commerce.adapter.CategoryAdapter;
import com.rudimentum.basice_commerce.adapter.ProductAdapter;
import com.rudimentum.basice_commerce.model.Category;
import com.rudimentum.basice_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, productRecycler;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Games"));
        categoryList.add(new Category(2, "Web"));
        categoryList.add(new Category(3, "Mobile"));
        categoryList.add(new Category(4, "Others"));

        setCategoryRecycler(categoryList);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "#424345", "java", "Course:\nJava developer","January 1st", "Junior", "test"));
        productList.add(new Product(2, "#9FA52D", "python", "Course:\nPython developer","January 1st", "Junior", "test"));
        productList.add(new Product(3,"#FF4D00", "front_end","Course:\nFront-end developer","January 1st", "Middle", "test"));

        setProductRecycler(productList);
    }

    private void setProductRecycler(List<Product> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setLayoutManager(layoutManager);

        productAdapter = new ProductAdapter(this, productList);
        productRecycler.setAdapter(productAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}
