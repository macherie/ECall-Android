package com.ecall.bamboo.ecall.database;

import android.provider.BaseColumns;

/**
 * Created by NguyenN on 7/11/2016.
 *
 * The database constant
 */
public final class ECallContract {

    public static final String CITY_ID = "city_id";
    public static final String DISTRICT_ID = "district_id";
    public static final String WARD_ID = "ward_id";

    public static abstract class CityEntry implements BaseColumns {
        public static final String TABLE_NAME = "city";
        public static final String CITY_NAME = "city_name";
    }

    public static abstract class DistrictEntry implements BaseColumns {
        public static final String TABLE_NAME = "district";
        public static final String DISTRICT_NAME = "district_name";
    }

    public static abstract class WardEntry implements BaseColumns {
        public static final String TABLE_NAME = "ward";
        public static final String WARD_NAME = "ward_name";
    }

    public static abstract class ECallEntityEntry implements BaseColumns {
        public static final String TABLE_NAME = "e_call_entity";
        public static final String E_CALL_ENTITY_ID = "e_call_entity_id";
        public static final String E_CALL_ENTITY_NAME = "e_call_entity_name";
        public static final String E_CALL_ENTITY_PHONE_NUMBER = "e_call_entity_phone_number";
    }
}
