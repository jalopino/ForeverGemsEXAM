package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class Custom extends AppCompatActivity {
    private EditText basePriceInput;
    private EditText materialFactorInput;
    private EditText colorFactorInput;
    private EditText clarityFactorInput;
    private TextView priceOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        basePriceInput = findViewById(R.id.base_price_input);
        materialFactorInput = findViewById(R.id.material_factor_input);
        colorFactorInput = findViewById(R.id.color_factor_input);
        clarityFactorInput = findViewById(R.id.clarity_factor_input);
        priceOutput = findViewById(R.id.price_output);
        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double basePrice = Double.parseDouble(basePriceInput.getText().toString());
                double materialFactor = Double.parseDouble(materialFactorInput.getText().toString());
                double colorFactor = Double.parseDouble(colorFactorInput.getText().toString());
                double clarityFactor = Double.parseDouble(clarityFactorInput.getText().toString());
                double price = basePrice * materialFactor * colorFactor * clarityFactor;
                priceOutput.setText(String.format("Price: $%.2f", price));
            }
        });
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basePriceInput.setText("");
                materialFactorInput.setText("");
                colorFactorInput.setText("");
                clarityFactorInput.setText("");
                priceOutput.setText("Price: $0.00");
            }
        });
    }
}