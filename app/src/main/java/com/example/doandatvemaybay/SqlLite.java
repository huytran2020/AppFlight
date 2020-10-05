package com.example.doandatvemaybay;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;
public class SqlLite {
    Context context;
    Utils utils;

    String dbName = "FurnitureDB.db";
    public  SqlLite(Context context){
        this.context = context;
        utils = new Utils(context);
        //Hàm xóa toàn bộ dữ liệu trên database
        context.deleteDatabase(dbName);
        createTable();
        insertFurniture();
    }
    private SQLiteDatabase openDB(){
        return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }
    private void closeDB(SQLiteDatabase db) {
        db.close();
    }
    public void createTable(){
        SQLiteDatabase db = openDB();
        String sqlFurniture = "CREATE TABLE IF NOT EXISTS tblFurniture (" +
                "NgayDi TEXT," +
                "NgayDen TEXT," +
                "DiemDi TEXT," +
                "DiemDen TEXT," +
                "ChiTietChuyenBay TEXT," +
                "MaMayBay TEXT," +
                "GiaVe TEXT," +
                "GioDi TEXT," +
                "GioDen TEXT," +
                "GioBay TEXT," +
                "LoaiBay TEXT);";
        db.execSQL(sqlFurniture);
        closeDB(db);
    }
    public ArrayList<Furniture> getALLFurniture(){
        SQLiteDatabase db = openDB();
        ArrayList<Furniture> arr = new ArrayList<>();
        String sql = "select * from tblFurniture";
        Cursor csr = db.rawQuery(sql, null);
        if(csr != null){
            if(csr.moveToFirst()){
                do{
                    String ngaydi = csr.getString(0);
                    String ngayden = csr.getString(1);
                    String diemdi = csr.getString(2);
                    String diemden = csr.getString(3);
                    String chitietchuyenbay = csr.getString(4);
                    String mamaybay = csr.getString(5);
                    String giave = csr.getString(6);
                    String giodi = csr.getString(7);
                    String gioden = csr.getString(8);
                    String giobay = csr.getString(9);
                    String loaibay = csr.getString(10);
                    arr.add(new Furniture(ngaydi,ngayden,diemdi,diemden,chitietchuyenbay,mamaybay,giave,giodi,gioden,giobay,loaibay));
                }while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public  void insertFurniture(){
        ArrayList<Furniture> arrFurniture = utils.getMockData();
        SQLiteDatabase db = openDB();
        Random random = new Random();

        for (Furniture fur: arrFurniture){
            ContentValues cv = new ContentValues();// hàm ghi dl xuống bảng
            cv.put("NgayDi", fur.getNgaydi());
            cv.put("NgayDen", fur.getNgayden());
            cv.put("DiemDi", fur.getDiemdi());
            cv.put("DiemDen", fur.getDiemden());
            cv.put("ChiTietChuyenBay", fur.getChitietchuyenbay());
            cv.put("MaMayBay", fur.getMamaybay());
            cv.put("GiaVe", fur.getGiave());
            cv.put("GioDi", fur.getGiodi());
            cv.put("GioDen", fur.getGioden());
            cv.put("GioBay", fur.getGioBay());
            cv.put("LoaiBay", fur.getLoaiBay());
            db.insert("tblFurniture", null, cv);
        }
        closeDB(db);
    }
    public void clearDatabase(SQLiteDatabase db){
        clearDatabase(db);
    }
}
