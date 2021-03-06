package com.example.myrecycler.repository;

import android.os.AsyncTask;

import com.example.myrecycler.Items;
import com.example.myrecycler.data.AppDataBase;

import java.util.List;

public class Edit_data extends AsyncTask<Items,Void, List<Items>> {
    private AppDataBase db;
    private ConnectRepo.ItemsCallback callback;

    public Edit_data(AppDataBase db, ConnectRepo.ItemsCallback callback) {
        this.db = db;
        this.callback = callback;
    }

    @Override
    protected List<Items> doInBackground(Items... items) {
        for (Items c : items) {
            db.itemsDao().update(c);
        }
        return db.itemsDao().getItems();
    }


    @Override
    protected void onPostExecute(List<Items> items) {
        super.onPostExecute(items);
        callback.getContactList(items);
    }





}
