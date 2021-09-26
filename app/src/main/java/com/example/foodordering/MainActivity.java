package com.example.foodordering;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Calendar;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
  private TextView etf;
    private  TextView etq;
    private  TextView etc;
    private  TextView ett;
    private  TextView etr;
    private Button btnadd;
    private  Button btncancel;
    private  Button btnorder;


    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("orders");
   Calendar calendar;
   SimpleDateFormat simpleDateFormat;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etf = findViewById(R.id.etf);
        etq = findViewById(R.id.etq);
        etc = findViewById(R.id.etc);
        ett = findViewById(R.id.ett);
        etr = findViewById(R.id.etr);
        btnadd = findViewById(R.id.btnadd);
        btncancel = findViewById(R.id.btncancel);
        btnorder = findViewById(R.id.btnorder);

        Bundle incomingmessages = getIntent().getExtras();
        if(incomingmessages !=null) {
            String name = incomingmessages.getString("name");
            String price = incomingmessages.getString("price");
            String Quantity = incomingmessages.getString("quantity");
            calendar =Calendar.getInstance();

            simpleDateFormat =new SimpleDateFormat("HH:mm");
            String time =simpleDateFormat.format(calendar.getTime());
            etf.setText(name);
            etc.setText(price);
            etq.setText(Quantity);
            ett.setText(time);
        }


        btnadd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String roomno = etr.getText().toString();


                if(roomno.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Insert Room number", Toast.LENGTH_SHORT).show();

                }

                else {

                    String name = etf.getText().toString();
                    String quantity = etq.getText().toString();
                    String amount = etc.getText().toString();
                    String time = ett.getText().toString();



                    HashMap<String, String> usermap = new HashMap<>();


                    usermap.put("foodname", name);
                    usermap.put("quantity", quantity);
                    usermap.put("cost", amount);
                    usermap.put("time", time);
                    usermap.put("room", roomno);


                    root.push().setValue(usermap).addOnSuccessListener(suc -> {
                        Toast.makeText(MainActivity.this, "order confirmed", Toast.LENGTH_SHORT).show();
                        Intent x = new Intent(MainActivity.this, foodhome.class);
                        startActivity(x);
                    });

                }

            }

        } );

        btncancel.setOnClickListener(new OnClickListener(){
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this,showactivity.class));

            }
        });
        btnorder.setOnClickListener(new OnClickListener(){
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this,foodhome.class));

            }
        });


         }

    }
