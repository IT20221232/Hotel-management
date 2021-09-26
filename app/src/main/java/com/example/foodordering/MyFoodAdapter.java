package com.example.foodordering;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class MyFoodAdapter extends RecyclerView.Adapter<MyFoodAdapter.ViewHolder>{

    MyFoodData[] myFoodData;
    Context context;
    EditText  number;
    


    public MyFoodAdapter(MyFoodData[] myFoodData,foodhome activity) {
        this.myFoodData =myFoodData;
        this.context =activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_item_list,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     final MyFoodData myFoodDatalist =myFoodData[position];

     holder.Foodimage.setImageResource(myFoodDatalist.getFoodimage());
     holder.foodname.setText(myFoodDatalist.getFoodname());
     holder.quantity.setText(myFoodDatalist.getQuantity());
     holder.number.setText(myFoodDatalist.getNumber());

      holder.number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });





     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

       Intent i= new Intent(view.getContext(),MainActivity.class);

            String value1 =myFoodDatalist.getFoodname().toString();
             String value2=myFoodDatalist.getQuantity().toString();
             String value3=myFoodDatalist.getNumber().toString();



             i.putExtra("name",value1);
             i.putExtra("price",value2);
             i.putExtra("quantity",value3);



             Toast.makeText(context,"YOU SELECTED "+value1,Toast.LENGTH_SHORT).show();
             context.startActivity(i);
         }
     });
    }

    @Override
    public int getItemCount() {
        return myFoodData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Foodimage;
        TextView  foodname;
        TextView  quantity;
        EditText number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

         Foodimage = itemView.findViewById(R.id.imagep);
            foodname = itemView.findViewById(R.id.fname);
            quantity = itemView.findViewById(R.id.fquantity);
            number=(EditText) itemView.findViewById(R.id.etQ);



        }
    }
}
