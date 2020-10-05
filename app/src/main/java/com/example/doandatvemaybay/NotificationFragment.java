package com.example.doandatvemaybay;


import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class NotificationFragment extends Fragment {

/*

    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    public static NotificationFragment newInstance() {
        return new NotificationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listViewItemNotification);
        Utils utils = new Utils(getContext());
        arrayList = utils.getFurnitureHistory();
        furnitureAdapter = new FurnitureAdapter(getContext(),R.layout.custom_item_home,arrayList);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long
                    l) {
                String ngaydi=arrayList.get(position).getNgaydi();
                String ngayden=arrayList.get(position).getNgayden();
                String diemdi=arrayList.get(position).getDiemdi();
                String diemden=arrayList.get(position).getDiemden();
                String machuyenbay=arrayList.get(position).getMamaybay();
                String chitietchuyenbay=arrayList.get(position).getChitietchuyenbay();
                String giave=arrayList.get(position).getGiave();
                String giodi = arrayList.get(position).getGiodi();
                String gioden = arrayList.get(position).getGioden();
                String giobay = arrayList.get(position).getGiobay();
                String loaibay = arrayList.get(position).getLoaibay();
                //String hinh=BitMapToString(arrayList.get(position).getImage());
                Intent t =new Intent(getContext(),Detail.class);
                //t.putExtra("hinh",hinh);
                t.putExtra("ngaydi",ngaydi);
                t.putExtra("ngayden",ngayden);
                t.putExtra("diemdi",diemdi);
                t.putExtra("diemden",diemden);
                t.putExtra("machuyenbay",machuyenbay);
                t.putExtra("chitietchuyenbay",chitietchuyenbay);
                t.putExtra("giave",giave);
                t.putExtra("giodi",giodi);
                t.putExtra("gioden", gioden);
                t.putExtra("giobay", giobay);
                t.putExtra("loaibay", loaibay);
                startActivity(t);

            }
        });
    }
*/


}
