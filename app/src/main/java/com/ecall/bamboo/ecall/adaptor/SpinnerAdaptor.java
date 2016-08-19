package com.ecall.bamboo.ecall.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ecall.bamboo.ecall.R;
import com.ecall.bamboo.ecall.database.dbo.DatabaseObject;

import java.util.List;

/**
 * Created by NguyenN on 7/14/2016.
 *
 * Adaptor for spinners like city spinner or district spinner.
 */
public abstract class SpinnerAdaptor extends ArrayAdapter<DatabaseObject> {

    int resource;

    public SpinnerAdaptor(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(this.resource, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.tv_spinner_item_name);
        textView.setText(getItemName(position));
        return super.getView(position, convertView, parent);
    }

    protected abstract String getItemName(int position);
}
