package com.example.doandatvemaybay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CategoriesFragment extends Fragment {
    /*ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    Utils utils;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    public static CategoriesFragment newInstance(int pos) {

        Bundle bundle = new Bundle();
        bundle.putInt("category", pos);
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        categoriesFragment.setArguments(bundle);
        return categoriesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        utils = new Utils(getContext());
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        listView = view.findViewById(R.id.listViewCategories);
        arrayList = utils.getFurnitureFromCategories(bundle.getInt("category"));
        furnitureAdapter = new FurnitureAdapter(getContext(),arrayList);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.furnitureHistory.add(arrayList.get(position));
                arrayList.get(position).setDateView(getTimeViewProduct());
                Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), Detail.class);
                intent.putExtra("xuly", (Parcelable) arrayList.get(position));
                startActivity(intent);
            }
        });

    }
    public static final String DATE_FORMAT_8 = "yyyy-MM-dd HH:mm:ss";
    //Hàm lấy ngày xem sản phẩm
    public String getTimeViewProduct(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_8);
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+7"));
        Date currentTime = Calendar.getInstance().getTime();
        return  dateFormat.format(currentTime);
    }*/

    /*ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    Utils utils;
    public CategoriesFragment(){

    }
    public static CategoriesFragment newInstance(int pos){
        Bundle bundle = new Bundle();
        bundle.putInt("Category", pos);
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        categoriesFragment.setArguments(bundle);
        return categoriesFragment;
    }
    *//*@Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        utils = new Utils(getContext());
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState ){
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        listView = view.findViewById(R.id.ListViewCategories);
        arrayList=utils.getFurnitureFromCategories(bundle.getInt("category"));
        furnitureAdapter= new FurnitureAdapter(getContext(),arrayList);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener();

    }*//*
    public static  final String DATE_FORMAT ="yyyy-MM-đ HH:mm:ss";
    public  String getTimeViewProduct(){
        SimpleDateFormat dateFormat= new SimpleDateFormat(DATE_FORMAT);
        Date currentTime= Calendar.getInstance().getTime();
        return dateFormat.format(currentTime);
    }*/
}
