package com.ecall.bamboo.ecall.database.dbo;

import android.content.ContentValues;

import com.ecall.bamboo.ecall.database.ECallContract;

/**
 * Created by WolfNguyen on 7/13/2016.
 *
 * Entity database object
 */
public class EntityDBO implements DatabaseObject {

    private String cityID;
    private String districtID;
    private String wardID;
    private String entityID;
    private String entityName;
    private String entityPhoneNumber;

    public EntityDBO(String cityID, String districtID, String wardID, String entityID, String entityName, String entityPhoneNumber) {
        this.cityID = cityID;
        this.districtID = districtID;
        this.wardID = wardID;
        this.entityID = entityID;
        this.entityName = entityName;
        this.entityPhoneNumber = entityPhoneNumber;
    }

    public String getCityID() {
        return cityID;
    }

    public void setCityID(String cityID) {
        this.cityID = cityID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getWardID() {
        return wardID;
    }

    public void setWardID(String wardID) {
        this.wardID = wardID;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityPhoneNumber() {
        return entityPhoneNumber;
    }

    public void setEntityPhoneNumber(String entityPhoneNumber) {
        this.entityPhoneNumber = entityPhoneNumber;
    }

    @Override
    public ContentValues getContainValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ECallContract.CITY_ID, cityID);
        contentValues.put(ECallContract.DISTRICT_ID, districtID);
        contentValues.put(ECallContract.WARD_ID, wardID);
        contentValues.put(ECallContract.ECallEntityEntry.E_CALL_ENTITY_ID, entityID);
        contentValues.put(ECallContract.ECallEntityEntry.E_CALL_ENTITY_NAME, entityName);
        contentValues.put(ECallContract.ECallEntityEntry.E_CALL_ENTITY_PHONE_NUMBER, entityPhoneNumber);
        return contentValues;
    }
}
