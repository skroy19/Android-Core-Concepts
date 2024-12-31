package com.example.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //The RecyclerView is set up in onCreate because it’s initialized when the activity starts.

        RecyclerView recyclerView = findViewById(R.id.recycler);

        //Purpose: Configures the RecyclerView to display items in a vertical list.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // Bind Data to RecyclerView
        //Creates a list of FoodItem objects.

        List<FoodItem> foodList = new ArrayList<>();
        foodList.add(new FoodItem(R.drawable.menu1, "Pizza", "BDT 200"));
        foodList.add(new FoodItem(R.drawable.menu2, "Burger", "BDT 100"));
        foodList.add(new FoodItem(R.drawable.menu4, "Pasta", "BDT 150"));

        FoodAdapter adapter = new FoodAdapter(foodList);
        recyclerView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}