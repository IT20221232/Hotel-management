package com.example.foodordering;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class orderfood extends Fragment {
    RecyclerView recylview;
    List<homehormodels> homehormodelsList;
    homehoradapter Homehoradapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_orderfood, container, false);


        homehormodelsList =new ArrayList<>();
        homehormodelsList.add(new homehormodels(R.drawable.pizza,"Pizza"));
        homehormodelsList.add(new homehormodels(R.drawable.burger,"Hamburger"));
        homehormodelsList.add(new homehormodels(R.drawable.fries,"Fries"));
        homehormodelsList.add(new homehormodels(R.drawable.sandwich,"Sandwich"));
        homehormodelsList.add(new homehormodels(R.drawable.dhosai,"Dhosai"));
        homehormodelsList.add(new homehormodels(R.drawable.icecream,"Icecream"));

        Homehoradapter =new homehoradapter(getActivity(),homehormodelsList);
        recylview.setAdapter(Homehoradapter);
        recylview = root.findViewById(R.id.rview);
        recylview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recylview.setHasFixedSize(true);
        recylview.setNestedScrollingEnabled(false);

        return root;


    }
}