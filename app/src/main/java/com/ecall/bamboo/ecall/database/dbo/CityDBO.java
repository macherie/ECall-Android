package com.ecall.bamboo.ecall.database.dbo;

import android.content.ContentValues;

import com.ecall.bamboo.ecall.database.ECallContract;

/**
 * Created by WolfNguyen on 7/13/2016.
 *
 * City data object
 */
public class CityDBO implements DatabaseObject{

    private String cityID;
    private String cityName;

    /**
     * Default constructor
     */
    public CityDBO() {
    }

    public CityDBO(String cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public ContentValues getContainValues() {
        ContentValues contentValues =new ContentValues();
        contentValues.put(ECallContract.CITY_ID, cityID);
        contentValues.put(ECallContract.CityEntry.CITY_NAME, cityName);
        return contentValues;
    }

    public  static String[] getAllColumnNames() {
        return new String[] {ECallContract.CITY_ID, ECallContract.CityEntry.CITY_NAME};
    }
}
