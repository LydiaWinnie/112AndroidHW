package com.example.hw_0523;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        String orderDetails = getIntent().getStringExtra("order_details");

        TextView textView = findViewById(R.id.textView_order_details);
        textView.setText(orderDetails);
    }
}
