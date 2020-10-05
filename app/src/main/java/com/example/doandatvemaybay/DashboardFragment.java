package com.example.doandatvemaybay;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;

public class DashboardFragment extends Fragment {
    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter adapter;
    DBHelper dbHelper;
    Utils utils;
    Button btnchon;
    SqlLite sqlLite;
    /*public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }*/
    public DashboardFragment(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //Thêm mới ngày 8/4
        utils = new Utils(getActivity());
        sqlLite = new SqlLite(getActivity());

        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listView1);
        // Thêm ngày 8/4
        arrayList = sqlLite.getALLFurniture();
        adapter = new FurnitureAdapter(getContext(),arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long
                    l) {
                if (Utils.furnitureHistory.indexOf(arrayList.get(i)) < 0) {
                    arrayList.get(i).setDateView(getTimeViewProduct());
                    Utils.furnitureHistory.add(arrayList.get(i));
                    // Toast.makeText(getContext(), i + "", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), Detail.class);
                    intent.putExtra("xuly", (Parcelable) arrayList.get(i));

                    // startActivityForResult(intent,100);
                    startActivity(intent);
                }
            }
            /*@Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils s = new Utils(getContext());
                ArrayList<Furniture> ls = s.getFurnitureHistory();
                Utils.furnitureHistory.add(0, arrayList.get(position));
                for (int i = 1; i < ls.size(); i++)
                    if (arrayList.get(position).getDiemdi() == ls.get(i).getDiemdi())
                        Utils.furnitureHistory.remove(i);
                String ngaydi=arrayList.get(position).getNgaydi();
                String ngayden=arrayList.get(position).getNgayden();
                String diemdi = arrayList.get(position).getDiemdi();
                String diemden = arrayList.get(position).getDiemden();
                String machuyenbay=arrayList.get(position).getMamaybay();
                String chitietchuyenbay=arrayList.get(position).getChitietchuyenbay();
                String giave=arrayList.get(position).getGiave();
                String giodi = arrayList.get(position).getGiodi();
                String gioden = arrayList.get(position).getGioden();
                String giobay = arrayList.get(position).getGiobay();
                String loaibay = arrayList.get(position).getLoaibay();
                String hinh = BitMapToString(arrayList.get(position).getImage());
                Intent t = new Intent(getContext(), Detail.class);
                t.putExtra("hinh", hinh);
                t.putExtra("ngaydi",ngaydi);
                t.putExtra("ngayden",ngayden);
                t.putExtra("diemdi", diemdi);
                t.putExtra("diemden", diemden);
                t.putExtra("machuyenbay",machuyenbay);
                t.putExtra("chitietchuyenbay",chitietchuyenbay);
                t.putExtra("giave",giave);
                t.putExtra("giodi", giodi);
                t.putExtra("gioden", gioden);
                t.putExtra("giobay", giobay);
                t.putExtra("loaibay", loaibay);
                startActivity(t);
               *//* Intent d = new Intent(getContext(), DatChoActivity.class);
                d.putExtra("hinh", hinh);
                d.putExtra("ngaydi",ngaydi);
                d.putExtra("ngayden",ngayden);
                d.putExtra("diemdi", diemdi);
                d.putExtra("diemden", diemden);
                d.putExtra("machuyenbay",machuyenbay);
                d.putExtra("chitietchuyenbay",chitietchuyenbay);
                d.putExtra("giave",giave);
                d.putExtra("giodi", giodi);
                d.putExtra("gioden", gioden);
                d.putExtra("giobay", giobay);
                d.putExtra("loaibay", loaibay);
                startActivity(d);*//*
            }*/
        });

    }
    @Override
    public void onPause() {
        super.onPause();
        utils.WriteToFileInterna(arrayList);
    }
       /* @Override
        public void onPause() {
            super.onPause();
            utils.WriteToFileInternal(arrayList);
        }*/
    /*public ArrayList<Furniture> getData() {
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture("13/08/2020","15/08/2020","SGN","HAN","Chi tiết chuyến bay","VN233/AirbusA321","2.000.000 VNĐ","6:00","8:08","2 tiếng 08 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("13/08/2020","15/08/2020","HAN","PQN","Chi tiết chuyến bay","VN207/BoeingB787","1.500.000 VNĐ","7:00","9:10","2 tiếng 10 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("14/08/2020","15/08/2020","HAN","DNN","Chi tiết chuyến bay","VN251/AirbusA321","2.100.000 VNĐ","7:30","9:30","2 tiếng 30 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("14/08/2020","15/08/2020","SGN","CXR","Chi tiết chuyến bay","VN275/AirbusA359","1.700.000 VNĐ","6:30","8:15","2 tiếng 15 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("12/08/2020","15/08/2020","SGN","THN","Chi tiết chuyến bay","VN234/AirbusA321","2.400.000 VNĐ","1:30","3:08","2 tiếng 08 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("15/09/2020","15/09/2020","VTN","SGN","Chi tiết chuyến bay","VN297/BoeingB787","3.000.000 VNĐ","6:30","8:40","2 tiếng 10 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("14/09/2020","15/09/2020","NTN","SGN","Chi tiết chuyến bay","VN636/AirbusA321","2.300.000 VNĐ","6:15","8:45","2 tiếng 30 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        tmp.add(new Furniture("15/09/2020","15/09/2020","SGN","SPN","Chi tiết chuyến bay","VN747/AirbusA359","2.500.000 VNĐ","6:20","8:35","2 tiếng 15 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(getContext(),"duongbay.png")));
        return tmp;
    }
    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }*/
    public static final String DATE_FORMAT_8 = "yyyy-MM-dd HH:mm:ss";
    //Hàm lấy ngày xem sản phẩm
    public String getTimeViewProduct(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_8);
        //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+7"));
        Date currentTime = Calendar.getInstance().getTime();
        return  dateFormat.format(currentTime);
    }
}


