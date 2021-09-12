package com.rudimentum.basice_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rudimentum.basice_commerce.adapter.CategoryAdapter;
import com.rudimentum.basice_commerce.adapter.ProductAdapter;
import com.rudimentum.basice_commerce.model.Category;
import com.rudimentum.basice_commerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, productRecycler;
    CategoryAdapter categoryAdapter;
    static ProductAdapter productAdapter;
    static List<Product> productList = new ArrayList<>();
    static List<Product> fullProductList = new ArrayList<>();

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


        productList.add(new Product(1, 3, "#424345", "java", "Course:\nJava developer","January 1st", "Junior", "test"));
        productList.add(new Product(2, 4, "#9FA52D", "python", "Course:\nPython developer","January 1st", "Junior", "test"));
        productList.add(new Product(3, 2, "#FF4D00", "front_end","Course:\nFront-end developer","January 1st", "Middle", "test"));

        fullProductList.addAll(productList);

        setProductRecycler(productList);
    }

    public void openCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    public void clearCategoryFilter(View view) {
        productList.clear();
        productList.addAll(fullProductList);

        productAdapter.notifyDataSetChanged();
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

    public static void showProductsByCategory(int category) {
        productList.clear();
        productList.addAll(fullProductList);

        List<Product> filterProducts = new ArrayList<>();

        for (Product product : productList) {
            if (product.getCategory() == category) {
                filterProducts.add(product);
            }
        }

        productList.clear();
        productList.addAll(filterProducts);

        productAdapter.notifyDataSetChanged();
    }
}
