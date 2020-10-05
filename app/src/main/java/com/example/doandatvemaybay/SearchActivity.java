package com.example.doandatvemaybay;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import me.gujun.android.taggroup.TagGroup;

public class SearchActivity extends AppCompatActivity {
    SearchView searchView;
    ArrayList<Furniture> arrayList;
    Utils utils;
    ListView listView;
    FurnitureAdapter furnitureAdapter;
    TagGroup mTagGroup;
    SqlLite sqlLite;
    List<String> tags;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        utils = new Utils(SearchActivity.this);
        //thêm 8/4
        sqlLite = new SqlLite(SearchActivity.this);
        arrayList = new ArrayList<>();
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        listView = findViewById(R.id.listView);
        //arrayList=getMockData();
        //furnitureAdapter = new FurnitureAdapter(SearchActivity.this,R.layout.custom_item_home, arrayList);
        furnitureAdapter = new FurnitureAdapter(SearchActivity.this, arrayList);
        listView.setAdapter(furnitureAdapter);
        Log.d("FunitureApp", utils.LoadFileInternal().size() + "");
        //getSupportActionBar().setTitle("Tìm kiếm");
        searchView = findViewById(R.id.search_view);
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);
        searchView.requestFocusFromTouch();
        //listView.setVisibility(View.VISIBLE); cũ
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchFurniture(s);
                return false;
            }
        });
        mTagGroup = (TagGroup) findViewById(R.id.tag_group);
        tags = new ArrayList();
        mTagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                searchView.setQuery(tag, false);
                hideSoftKeyboard(searchView);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long
                    l) {

                Intent intent = new Intent(SearchActivity.this, Detail.class);
                intent.putExtra("xuly", (Parcelable) arrayList.get(i));
                startActivity(intent);
            }
        });
    }
        private void searchFurniture(String newText){
            ArrayList<Furniture> tmp = new ArrayList<>();
//        for(Furniture furniture: utils.LoadFileInternal()){
            for(Furniture furniture: sqlLite.getALLFurniture()){
                if(furniture.getDiemdi().toLowerCase().contains (newText.toLowerCase())){
                    tmp.add (furniture);
                }
            }
            Toast.makeText(this, tmp.size()+"", Toast.LENGTH_SHORT).show();
//        Log.d("FunitureApp",tmp.size()+"");
            if(tmp.size() > 0){
                furnitureAdapter.clear();
                furnitureAdapter.addAll(tmp);
                furnitureAdapter.notifyDataSetChanged();
                listView.setVisibility(View.VISIBLE);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long
                            l) {
                        if (Utils.furnitureHistory.indexOf(arrayList.get(i)) < 0) {
                            arrayList.get(i).setDateView(getTimeViewProduct());
                            Utils.furnitureHistory.add(arrayList.get(i));
                            //Toast.makeText(getContext(), i + "", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SearchActivity.this, Detail.class);
                            intent.putExtra("xuly", (Parcelable) arrayList.get(i));
                            startActivity(intent);
                        }
                    }
                });
            }
            if(newText.isEmpty()){
                listView.setVisibility(View.GONE);
            }
        }
        public void hideSoftKeyboard(View view){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(listView.getWindowToken(),0);
        }

        public static final String DATE_FORMAT_8 = "yyyy-MM-dd HH:mm:ss";
        //Hàm lấy ngày xem sản phẩm
        public String getTimeViewProduct(){
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_8);
            //dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+7"));
            Date currentTime = Calendar.getInstance().getTime();
            return  dateFormat.format(currentTime);
        }
        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(tags.size()==11)
                    tags.remove(10);
                else {
                    for (int i=0;i<tags.size();i++)
                        if(tags.get(i).equals(query))
                            tags.remove(i);
                    tags.add(0,query);
                }
                mTagGroup.setTags(tags);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchFurniture(newText);
                return false;
            }
        });*/
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
                String hinh=BitMapToString(arrayList.get(position).getImage());
                Intent t =new Intent(SearchActivity.this,Detail.class);
                t.putExtra("hinh",hinh);
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
                finish();
            }
        });
    }
    private void searchFurniture(String newText) {
        ArrayList<Furniture> tmp = new ArrayList<>();

        for (Furniture furniture : getMockData()) {
            if (furniture.getDiemdi().toLowerCase().contains(newText.toLowerCase())||(furniture.getDiemden().toLowerCase().contains(newText.toLowerCase()))) {
                tmp.add(furniture);
            }
        }
        Toast.makeText(this, tmp.size() + "", Toast.LENGTH_SHORT).show();
        if (tmp.size() > 0) {
            furnitureAdapter.clear();
            furnitureAdapter.addAll(tmp);
            furnitureAdapter.notifyDataSetChanged();
            listView.setVisibility(View.VISIBLE);
        }
        if (tmp.size()==0) {
            listView.setVisibility(View.GONE);
            Toast.makeText(this, "Không tìm thấy dữ liệu", Toast.LENGTH_SHORT).show();
            tmp=getMockData();
        }if (newText.isEmpty()) {
            listView.setVisibility(View.VISIBLE);

            tmp=getMockData();
        }
    }
    public void hideSoftKeyboard(View view){
        InputMethodManager imm
                =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public ArrayList<Furniture> getMockData(){
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture("13/08/2020","15/08/2020","SGN","HAN","Chi tiết chuyến bay","VN233/AirbusA321","2.000.000 VNĐ","6:00","8:08","2 tiếng 08 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("13/08/2020","15/08/2020","HAN","PQN","Chi tiết chuyến bay","VN207/BoeingB787","1.500.000 VNĐ","7:00","9:10","2 tiếng 10 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("14/08/2020","15/08/2020","HAN","DNN","Chi tiết chuyến bay","VN251/AirbusA321","2.100.000 VNĐ","7:30","9:30","2 tiếng 30 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("14/08/2020","15/08/2020","SGN","CXR","Chi tiết chuyến bay","VN275/AirbusA359","1.700.000 VNĐ","6:30","8:15","2 tiếng 15 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("12/08/2020","15/08/2020","SGN","THN","Chi tiết chuyến bay","VN234/AirbusA321","2.400.000 VNĐ","1:30","3:08","2 tiếng 08 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("15/09/2020","15/09/2020","VTN","SGN","Chi tiết chuyến bay","VN297/BoeingB787","3.000.000 VNĐ","6:30","8:40","2 tiếng 10 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("14/09/2020","15/09/2020","NTN","SGN","Chi tiết chuyến bay","VN636/AirbusA321","2.300.000 VNĐ","6:15","8:45","2 tiếng 30 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));
        tmp.add(new Furniture("15/09/2020","15/09/2020","SGN","SPN","Chi tiết chuyến bay","VN747/AirbusA359","2.500.000 VNĐ","6:20","8:35","2 tiếng 15 phút","Bay thẳng",Furniture.convertStringToBitmapFromAccess(SearchActivity.this,"duongbay.png")));

        return tmp;
    }
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }*/
}
