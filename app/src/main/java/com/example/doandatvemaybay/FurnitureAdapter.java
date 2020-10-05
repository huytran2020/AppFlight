package com.example.doandatvemaybay;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import java.util.ArrayList;

public class FurnitureAdapter extends ArrayAdapter<Furniture> {
   /* Context context;
    ArrayList<Furniture> arrayList;
    int layout;*/
    public FurnitureAdapter(Context context, ArrayList<Furniture> Furniture) {
        super(context, 0, Furniture);
    }
    /*public FurnitureAdapter(@NonNull Context context, int resource, ArrayList<Furniture> object) {
        super(context, resource,object);
        this.context = context;
        this.arrayList = object;
        this.layout = resource;
    }*/

   /* @Override
    public int getCount() {
        return arrayList.size();
    }*/

    /*@Override
    public Object getItem(int position) {
        return null;
    }*/

   /* @Override
    public long getItemId(int position) {
        return 0;
    }*/

    public class ViewHolder{
        TextView txtNgayDi,txtNgayDen, txtDiemDi, txtDiemDen, txtChiTiet, txtGiaVe, txtMaChuyenBay,txtGioDi, txtGioDen, txtGioBay, txtLoaiBay;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
// lấy đối tượng dữ liệu tương ứng với vị trí dòng
        ViewHolder holder;
        Furniture furniture = getItem(position);
       // Furniture furniture = getItem(position);
// Kiểm trong view của row hiện tại có đang được tái sử dụng hay không, nếu không phải tạo mới

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_item_home, parent, false);
// Kết nối các đối tượng XML element với Java code
        holder = new ViewHolder();
        holder.txtNgayDi = (TextView) convertView.findViewById(R.id.textViewMoTaNgayDi);
        holder.txtNgayDen = (TextView) convertView.findViewById(R.id.textViewMoTaNgayDen);
        holder.txtDiemDi = (TextView) convertView.findViewById(R.id.textViewMoTaDiemDi);
        holder.txtDiemDen = (TextView) convertView.findViewById(R.id.textViewMoTaDiemDen);
        holder.txtChiTiet = (TextView) convertView.findViewById(R.id.textViewMoTaChiTietChuyenBay);
        holder.txtGiaVe = (TextView) convertView.findViewById(R.id.textViewMoTaGiaTien);
        holder.txtMaChuyenBay = (TextView) convertView.findViewById(R.id.textViewMoTaTenChuyenBay);
        holder.txtGioDi = (TextView) convertView.findViewById(R.id.textViewMoTaGioDi);
        holder.txtGioDen = (TextView) convertView.findViewById(R.id.textViewMoTaGioDen);
        holder.txtGioBay = (TextView) convertView.findViewById(R.id.textViewMoTaGioBay);
        holder.txtLoaiBay = (TextView) convertView.findViewById(R.id.textViewMoTaLoaiBay);
        //holder.imgHinhItem = convertView.findViewById(R.id.imageViewItemHome);
        convertView.setTag(holder);

        holder.txtNgayDi.setText(furniture.getNgaydi());
        holder.txtNgayDen.setText(furniture.getNgayden());
        holder.txtDiemDi.setText(furniture.getDiemdi());
        holder.txtDiemDen.setText(furniture.getDiemden());
        holder.txtGiaVe.setText(furniture.getGiave());
        holder.txtMaChuyenBay.setText(furniture.getMamaybay());
        holder.txtChiTiet.setText(furniture.getChitietchuyenbay());
        holder.txtGioDi.setText(furniture.getGiodi());
        holder.txtGioDen.setText(furniture.getGioden());
        holder.txtGioBay.setText(furniture.getGiobay());
        holder.txtLoaiBay.setText(furniture.getLoaibay());
        //holder.imgHinhItem.setImageBitmap(furniture.getImage());
//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim_scale_item);
//        convertView.startAnimation(animation);
        if(furniture.getDateView()!=null){
            TextView tvDateView = convertView.findViewById(R.id.tvDateView);
            tvDateView.setText(furniture.getDateView());
        }
        return convertView;
        //hinh.setImageBitmap(Furniture.convertStringToBitmapFromAccess(getContext(), furniture.imageName));
// Gắn dữ liệu lên row view


// Trả về row view đã xử lý hoàn tất để render lên màn hình


    }
    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.txtNgayDi = (TextView) convertView.findViewById(R.id.textViewMoTaNgayDi);
            holder.txtNgayDen = (TextView) convertView.findViewById(R.id.textViewMoTaNgayDen);
            holder.txtDiemDi = (TextView) convertView.findViewById(R.id.textViewMoTaDiemDi);
            holder.txtDiemDen = (TextView) convertView.findViewById(R.id.textViewMoTaDiemDen);
            holder.txtChiTiet = (TextView) convertView.findViewById(R.id.textViewMoTaChiTietChuyenBay);
            holder.txtGiaVe = (TextView) convertView.findViewById(R.id.textViewMoTaGiaTien);
            holder.txtMaChuyenBay = (TextView) convertView.findViewById(R.id.textViewMoTaTenChuyenBay);
            holder.txtGioDi = (TextView) convertView.findViewById(R.id.textViewMoTaGioDi);
            holder.txtGioDen = (TextView) convertView.findViewById(R.id.textViewMoTaGioDen);
            holder.txtGioBay = (TextView) convertView.findViewById(R.id.textViewMoTaGioBay);
            holder.txtLoaiBay = (TextView) convertView.findViewById(R.id.textViewMoTaLoaiBay);
            holder.imgHinhItem = convertView.findViewById(R.id.imageViewItemHome);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder)convertView.getTag();
        }
        Furniture furniture = arrayList.get(position);
        holder.txtNgayDi.setText(furniture.getNgaydi());
        holder.txtNgayDen.setText(furniture.getNgayden());
        holder.txtDiemDi.setText(furniture.getDiemdi());
        holder.txtDiemDen.setText(furniture.getDiemden());
        holder.txtChiTiet.setText(furniture.getName());
        holder.txtGiaVe.setText(furniture.getGiave());
        holder.txtMaChuyenBay.setText(furniture.getMamaybay());
        holder.txtChiTiet.setText(furniture.getChitietchuyenbay());
        holder.txtGioDi.setText(furniture.getGiodi());
        holder.txtGioDen.setText(furniture.getGioden());
        holder.txtGioBay.setText(furniture.getGiobay());
        holder.txtLoaiBay.setText(furniture.getLoaibay());
        holder.imgHinhItem.setImageBitmap(furniture.getImage());
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.anim_scale_item);
        convertView.startAnimation(animation);
        return convertView;
    }*/
}


