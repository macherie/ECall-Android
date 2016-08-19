package com.ecall.bamboo.ecall.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ecall.bamboo.ecall.database.dbo.CityDBO;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by NguyenN on 7/11/2016.
 *
 * This database helper is used to work with database.
 */
public class ECallDBHelper extends SQLiteOpenHelper {

    private Context context;

    private final static String DB_NAME = "ecall.db";
    private static final int DB_VERSION = 1;

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";

    private static final String SQL_CREATE_CITY_TABLE = "CREATE TABLE IF NOT EXISTS " + ECallContract.CityEntry.TABLE_NAME + " ( " + ECallContract.CITY_ID + TEXT_TYPE
            + COMMA_SEP + ECallContract.CityEntry.CITY_NAME + TEXT_TYPE + " )";

    private static final String SQL_CREATE_DISTRICT_TABLE = "CREATE TABLE IF NOT EXISTS " + ECallContract.DistrictEntry.TABLE_NAME + " ( " + ECallContract.DISTRICT_ID + TEXT_TYPE
            + COMMA_SEP + ECallContract.DistrictEntry.DISTRICT_NAME + TEXT_TYPE + " )";

    private static final String SQL_CREATE_WARD_TABLE = "CREATE TABLE IF NOT EXISTS " + ECallContract.WardEntry.TABLE_NAME + " ( " + ECallContract.WARD_ID + TEXT_TYPE
            + COMMA_SEP + ECallContract.WardEntry.WARD_NAME + TEXT_TYPE + " )";

    private static final String SQL_CREATE_E_CALL_ENTITY_TABLE = "CREATE TABLE IF NOT EXISTS " + ECallContract.ECallEntityEntry.TABLE_NAME + " ( "
            + ECallContract.ECallEntityEntry.E_CALL_ENTITY_ID + TEXT_TYPE + COMMA_SEP
            + ECallContract.CITY_ID + TEXT_TYPE + COMMA_SEP
            + ECallContract.DISTRICT_ID + TEXT_TYPE + COMMA_SEP
            + ECallContract.WARD_ID + TEXT_TYPE + COMMA_SEP
            + ECallContract.ECallEntityEntry.E_CALL_ENTITY_NAME + TEXT_TYPE + COMMA_SEP
            + ECallContract.ECallEntityEntry.E_CALL_ENTITY_PHONE_NUMBER + TEXT_TYPE + " )";

    public ECallDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CITY_TABLE);
        db.execSQL(SQL_CREATE_DISTRICT_TABLE);
        db.execSQL(SQL_CREATE_WARD_TABLE);
        db.execSQL(SQL_CREATE_E_CALL_ENTITY_TABLE);
        initializeDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void initializeDatabase(SQLiteDatabase db) {
        String spreadSheetName = "data.xlsx";
        InputStream fileInputStream = null;
        Workbook workbook = null;
        try {
            fileInputStream = new FileInputStream(String.valueOf(context.getAssets().open(spreadSheetName)));
            workbook = new HSSFWorkbook(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (workbook != null) {
            Sheet citySheet = workbook.getSheetAt(0);
            Sheet districtSheet = workbook.getSheetAt(1);
            Sheet wardSheet = workbook.getSheetAt(2);
            Sheet entitySheet = workbook.getSheetAt(3);

            // Insert city data
            for (Iterator<Row> rowIterator = citySheet.rowIterator(); rowIterator.hasNext(); ) {
                Row row = rowIterator.next();
                CityDBO city = new CityDBO(row.getCell(0, Row.CREATE_NULL_AS_BLANK).getStringCellValue(),
                        row.getCell(1, Row.RETURN_NULL_AND_BLANK).getStringCellValue());
                db.insert(ECallContract.CityEntry.TABLE_NAME, null, city.getContainValues());
            }


        }
    }

    public static void insertCityToDatabase(CityDBO city) {

    }
}
