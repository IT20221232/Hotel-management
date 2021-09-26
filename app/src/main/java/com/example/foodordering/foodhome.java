package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class foodhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodhome);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyFoodData[] myFoodData=new MyFoodData[]{

                new MyFoodData("Pizza","Rs.900",R.drawable.pizza,"1"),
                new MyFoodData("Hamburger","Rs.800",R.drawable.burger,"1"),
                new MyFoodData("Sandwich","Rs.300",R.drawable.sandwich,"1"),
                new MyFoodData("Dhosai","Rs.200",R.drawable.dhosai,"1"),
                new MyFoodData("Idly","Rs.100",R.drawable.idly,"1"),
                new MyFoodData("Kottu Rotti","Rs.200",R.drawable.kottu,"1"),
                new MyFoodData("Noodles","Rs.300",R.drawable.noodles,"1"),
                new MyFoodData("Parrota","Rs.150",R.drawable.parota,"1"),
                new MyFoodData("Rice and Curry","Rs.300",R.drawable.rice,"1"),
                new MyFoodData("Briyani","Rs.400",R.drawable.briyani,"1"),
                new MyFoodData("Fried Rice","Rs.350",R.drawable.friedrice,"1"),
                new MyFoodData("Soups","Rs.300",R.drawable.soup," 1"),
                new MyFoodData("Fries","Rs.300",R.drawable.fries,"1"),
                new MyFoodData("Icecream","Rs.150",R.drawable.icecream,"1"),
        };

        MyFoodAdapter myFoodAdapter =new MyFoodAdapter(myFoodData,foodhome.this);
        recyclerView.setAdapter(myFoodAdapter);

    }
}