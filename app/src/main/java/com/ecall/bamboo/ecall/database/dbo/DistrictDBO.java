package com.ecall.bamboo.ecall.database.dbo;

import android.content.ContentValues;

import com.ecall.bamboo.ecall.database.ECallContract;

/**
 * Created by WolfNguyen on 7/13/2016.
 *
 * District database object
 */
public class DistrictDBO implements DatabaseObject {

    private String districtID;
    private String districtName;

    public DistrictDBO(String districtID, String districtName) {
        this.districtID = districtID;
        this.districtName = districtName;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public ContentValues getContainValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ECallContract.DISTRICT_ID, districtID);
        contentValues.put(ECallContract.DistrictEntry.DISTRICT_NAME, districtName);
        return contentValues;
    }
}
