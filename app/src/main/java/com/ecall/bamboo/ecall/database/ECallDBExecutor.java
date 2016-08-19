package com.ecall.bamboo.ecall.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ecall.bamboo.ecall.database.dbo.CityDBO;

import java.util.ArrayList;

/**
 * Created by WolfNguyen on 7/13/2016.
 *
 * Database executor. Every actions like insert or update database will be called via this executor.
 */
public class ECallDBExecutor {
    private Context context;
    private ECallDBHelper dbHelper;
    SQLiteDatabase database = null;

    public ECallDBExecutor(Context context) {
        this.context = context;
        this.dbHelper = new ECallDBHelper(context);
    }

    public void open() {
        if ((database == null || !database.isOpen()) && dbHelper != null) {
            database = dbHelper.getWritableDatabase();
        }
    }

    public void close() {
        if (database != null) {
            database.close();
        }
    }

    /**
     * Insert a city object to database
     *
     * @param city the city
     */
    public void insertCity(CityDBO city) {
        open();
        database.insert(ECallContract.CityEntry.TABLE_NAME, null, city.getContainValues());
    }

    public ArrayList<CityDBO> getCities() {
        open();
        ArrayList<CityDBO> cityDBOs = new ArrayList<>();
        Cursor cursor = database.query(ECallContract.CityEntry.TABLE_NAME, CityDBO.getAllColumnNames(), null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                CityDBO cityDBO = new CityDBO();
                cityDBO.setCityID(cursor.getString(0));
                cityDBO.setCityName(cursor.getString(1));
                cityDBOs.add(cityDBO);
            } while (cursor.moveToNext());
        }
        return cityDBOs;
    }
}
