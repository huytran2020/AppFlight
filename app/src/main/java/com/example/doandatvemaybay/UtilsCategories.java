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

public class UtilsCategories {
    Context context;
    public UtilsCategories(Context context) {
        this.context = context;
    }
    static String filename="database";
    static ArrayList<Categories> CategoriesHistory = new ArrayList<>();
    public void addFurintureHistorry(Categories categories) {
        for (Categories t: CategoriesHistory
        ) {
            if(t.getName()!=categories.getName())
                if(CategoriesHistory.indexOf(categories) > 0) {
                    this.CategoriesHistory.add(0,categories);
                }
        }

    }
    public ArrayList<Categories> getCategoriesHistory(){
        return this.CategoriesHistory; }
    public void WriteToFileInternal(ArrayList<Categories> arrayList){
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
    public ArrayList<Categories> LoadFileInternal(){
        ArrayList<Categories> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new
                    ObjectInputStream(fileInputStream);
            arrayList = (ArrayList<Categories>)
                    objectInputStream.readObject();
            Log.d("CategoriesApp", arrayList.size()+"");
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
}
