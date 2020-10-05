package com.example.doandatvemaybay;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Furniture implements Serializable,Parcelable{
    String  ngaydi, ngayden, diemdi, diemden, chitietchuyenbay, mamaybay, giave, giodi, gioden,giobay, loaibay;
    Bitmap image;
    String dateView;
    public Furniture( String ngaydi,String ngayden, String diemdi, String diemden,String chitietchuyenbay,
                      String mamaybay,String giave, String giodi,String gioden,String giobay, String loaibay) {
        this.ngaydi = ngaydi;
        this.ngayden = ngayden;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.chitietchuyenbay = chitietchuyenbay;
        this.mamaybay = mamaybay;
        this.giave = giave;
        this.giodi = giodi;
        this.gioden = gioden;
        this.giobay = giobay;
        this.loaibay = loaibay;
    }
    public String getDateView() {
        return dateView;
    }
    public void setDateView(String dateView) {
        this.dateView = dateView;
    }
    protected Furniture(Parcel in) {
        ngaydi = in.readString();
        ngayden = in.readString();
        diemdi = in.readString();
        diemden = in.readString();
        chitietchuyenbay = in.readString();
        mamaybay = in.readString();
        giave = in.readString();
        giodi = in.readString();
        gioden = in.readString();
        giobay = in.readString();
        loaibay = in.readString();
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ngaydi);
        parcel.writeString(ngayden);
        parcel.writeString(diemdi);
        parcel.writeString(diemden);
        parcel.writeString(chitietchuyenbay);
        parcel.writeString(mamaybay);
        parcel.writeString(giave);
        parcel.writeString(giodi);
        parcel.writeString(gioden);
        parcel.writeString(giobay);
        parcel.writeString(loaibay);
    }
    public static final Parcelable.Creator<Furniture> CREATOR = new Parcelable.Creator<Furniture>() {
        @Override
        public Furniture createFromParcel(Parcel in) {
            return new Furniture(in);
        }

        @Override
        public Furniture[] newArray(int size) {
            return new Furniture[size];
        }
    };
    /*public Furniture(String ngaydi,String ngayden, String diemdi, String diemden, String chitietchuyenbay,
                     String mamaybay,String giave, String giodi,String gioden,String giobay, String loaibay,Bitmap image) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ngaydi = ngaydi;
        this.ngayden = ngayden;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.chitietchuyenbay = chitietchuyenbay;
        this.mamaybay = mamaybay;
        this.giave = giave;
        this.giodi = giodi;
        this.gioden = gioden;
        this.giobay = giobay;
        this.loaibay = loaibay;
    }*/
    /*public Furniture(String name, String description, Bitmap image, String gio) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.gio=gio;
    }*/
    public String getGioBay() {
        return giobay;
    }
    public void setGioBay(String giobay) {
        this.giobay = giobay;
    }

    public String getLoaiBay() {
        return loaibay;
    }
    public void setLoaiBay(String loaibay) {
        this.loaibay = loaibay;
    }

    public String getNgaydi() {
        return ngaydi;
    }
    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getNgayden() {
        return ngayden;
    }
    public void setNgayden(String ngayden) {
        this.ngayden = ngayden;
    }

    public String getDiemdi() {
        return diemdi;
    }
    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getDiemden() {
        return diemden;
    }
    public void setDiemden(String diemden) {
        this.diemden= diemden;
    }

    public String getChitietchuyenbay() {
        return chitietchuyenbay;
    }
    public void setChitietchuyenbay(String chitietchuyenbay) {
        this.chitietchuyenbay = chitietchuyenbay;
    }
    public String getMamaybay() {
        return mamaybay;
    }
    public void setMamaybay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getGiave() {
        return giave;
    }
    public void setGiave(String giave) {
        this.giave = giave;
    }

    public String getGiobay() {
        return giobay;
    }
    public void setGiobay(String giobay) {
        this.giobay = giobay;
    }

    public String getLoaibay() {
        return loaibay;
    }
    public void setLoaibay(String loaibay) {
        this.loaibay = loaibay;
    }

    public String getGiodi() {
        return giodi;
    }
    public void setGiodi(String giodi) {
        this.giodi = giodi;
    }

    public String getGioden() {
        return gioden;
    }
    public void setGioden(String gioden) {
        this.gioden = gioden;
    }

    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }

    /*public static Bitmap convertStringToBitmapFromAccess(Context context, String
            filename){
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(filename);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return  bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    @Override
        public int describeContents() {
            return 0;
        }

}
