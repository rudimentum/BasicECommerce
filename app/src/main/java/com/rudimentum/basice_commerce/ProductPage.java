package com.rudimentum.basice_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductPage extends AppCompatActivity {
    ConstraintLayout productPageBackground;
    ImageView productPageImage;
    TextView productPageName;
    TextView productPageDate;
    TextView productPageLevel;
    TextView productPageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        productPageBackground = findViewById(R.id.productPageBackground);
        productPageImage = findViewById(R.id.productPageImage);
        productPageName = findViewById(R.id.productPageName);
        productPageDate = findViewById(R.id.productPageDate);
        productPageLevel = findViewById(R.id.productPageLevel);
        productPageText = findViewById(R.id.productPageText);

        productPageBackground.setBackgroundColor(getIntent().getIntExtra("productBackground",0));
        productPageImage.setImageResource(getIntent().getIntExtra("productImage", 0));
        productPageName.setText(getIntent().getStringExtra("productName"));
        productPageDate.setText(getIntent().getStringExtra("productDate"));
        productPageLevel.setText(getIntent().getStringExtra("productLevel"));
        productPageText.setText(getIntent().getStringExtra("productText"));

    }
}