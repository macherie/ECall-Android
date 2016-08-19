package com.ecall.bamboo.ecall.database.dbo;

import android.content.ContentValues;

import com.ecall.bamboo.ecall.database.ECallContract;

/**
 * Created by WolfNguyen on 7/13/2016.
 *
 * Ward data object
 */
public class WardDBO implements DatabaseObject {

    private String wardID;
    private String wardName;

    public WardDBO(String wardID, String wardName) {
        this.wardID = wardID;
        this.wardName = wardName;
    }

    public String getWardID() {
        return wardID;
    }

    public void setWardID(String wardID) {
        this.wardID = wardID;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    @Override
    public ContentValues getContainValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ECallContract.WARD_ID, wardID);
        contentValues.put(ECallContract.WardEntry.WARD_NAME, wardName);
        return contentValues;
    }
}
