package com.example.doandatvemaybay;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utils {
    Context context;
    public Utils(Context context) {
        this.context = context;
    }
    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }
    static String filename="database";
    static ArrayList<Furniture> furnitureHistory = new ArrayList<>();
    public void addFurintureHistorry(Furniture furniture) {
        if(furnitureHistory.indexOf(furniture) > 0) {
            this.furnitureHistory.add(0, furniture);
        }
    }
    public ArrayList<Furniture> getFurnitureHistory(){ return
            this.furnitureHistory; }

    public ArrayList<Furniture> LoadFileInternal(){
        ArrayList<Furniture> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new
                    ObjectInputStream(fileInputStream);
            arrayList = (ArrayList<Furniture>)
                    objectInputStream.readObject();
            Log.d("FurnitureApp", arrayList.size()+"");
            return arrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Furniture> getMockData() {
        ArrayList<Furniture> tmp = new ArrayList<>();
        tmp.add(new Furniture("13/08/2020","15/08/2020","SGN","HAN","Chi tiết chuyến bay","VN233/AirbusA321","2.000.000 VNĐ","6:00","8:08","2 tiếng 08 phút","Bay thẳng"));
        tmp.add(new Furniture("13/08/2020","15/08/2020","HAN","PQN","Chi tiết chuyến bay","VN207/BoeingB787","1.500.000 VNĐ","7:00","9:10","2 tiếng 10 phút","Bay thẳng"));
        tmp.add(new Furniture("14/08/2020","15/08/2020","HAN","DNN","Chi tiết chuyến bay","VN251/AirbusA321","2.100.000 VNĐ","7:30","9:30","2 tiếng 30 phút","Bay thẳng"));
        tmp.add(new Furniture("14/08/2020","15/08/2020","SGN","CXR","Chi tiết chuyến bay","VN275/AirbusA359","1.700.000 VNĐ","6:30","8:15","2 tiếng 15 phút","Bay thẳng"));
        tmp.add(new Furniture("12/08/2020","15/08/2020","SGN","THN","Chi tiết chuyến bay","VN234/AirbusA321","2.400.000 VNĐ","1:30","3:08","2 tiếng 08 phút","Bay thẳng"));
        tmp.add(new Furniture("15/09/2020","15/09/2020","VTN","SGN","Chi tiết chuyến bay","VN297/BoeingB787","3.000.000 VNĐ","6:30","8:40","2 tiếng 10 phút","Bay thẳng"));
        tmp.add(new Furniture("14/09/2020","15/09/2020","NTN","SGN","Chi tiết chuyến bay","VN636/AirbusA321","2.300.000 VNĐ","6:15","8:45","2 tiếng 30 phút","Bay thẳng"));
        tmp.add(new Furniture("15/09/2020","15/09/2020","SGN","SPN","Chi tiết chuyến bay","VN747/AirbusA359","2.500.000 VNĐ","6:20","8:35","2 tiếng 15 phút","Bay thẳng"));
        return tmp;
    }
    public void WriteToFileInterna(ArrayList<Furniture> arrayList) {
        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new
                    ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

