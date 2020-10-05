package com.example.doandatvemaybay;


import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class FurnitureAdapterGrid extends ArrayAdapter {
    ArrayList<Categories> arrayList;

    public FurnitureAdapterGrid(@NonNull Context context, @NonNull ArrayList<Categories> objects) {
        super(context, 0, objects);
        arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView = layoutInflater.inflate(R.layout.custom_item_grid, null);

        Categories categories = arrayList.get(position);

        ImageView imageView = convertView.findViewById(R.id.imageViewItemGrid);
        TextView textView = convertView.findViewById(R.id.textViewItemGrid);


        textView.setText(categories.getName());

        imageView.setImageBitmap(categories.getImage());

        convertView.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.anim_scale));
        return convertView;
    }
}


