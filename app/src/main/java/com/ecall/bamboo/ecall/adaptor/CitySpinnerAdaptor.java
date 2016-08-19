package com.ecall.bamboo.ecall.adaptor;

import android.content.Context;

import com.ecall.bamboo.ecall.database.dbo.CityDBO;
import com.ecall.bamboo.ecall.database.dbo.DatabaseObject;

import java.util.List;

/**
 * Created by NguyenN on 7/14/2016.
 */
public class CitySpinnerAdaptor extends SpinnerAdaptor {

    List<CityDBO> cityDBOs;

    public CitySpinnerAdaptor(Context context, int resource, List<CityDBO> objects) {
        super(context, resource, objects);
        this.cityDBOs = objects;
    }

    @Override
    protected String getItemName(int position) {
        return cityDBOs.get(position).getCityName();
    }
}
