package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Earrings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earrings);
        // Initialize the ListView and set an adapter
        ListView listView = findViewById(R.id.list_view_earrings);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

// Read the CSV file
        InputStream inputStream = getResources().openRawResource(R.raw.earrings);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

// Read the first line (column names)
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

// Read the rest of the lines (data)
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Split the line into values
            String[] values = line.split(",");

            // Add the values to the adapter
            adapter.addAll(values);
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}