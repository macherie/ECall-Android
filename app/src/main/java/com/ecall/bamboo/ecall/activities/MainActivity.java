package com.ecall.bamboo.ecall.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.ecall.bamboo.ecall.R;
import com.ecall.bamboo.ecall.adaptor.CitySpinnerAdaptor;
import com.ecall.bamboo.ecall.database.ECallDBExecutor;
import com.ecall.bamboo.ecall.database.ECallDBHelper;
import com.ecall.bamboo.ecall.database.dbo.CityDBO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ECallDBExecutor dbExecutor;
    private Spinner citySpinner;
    private Spinner districtSpinner;
    private Spinner wardSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbExecutor = new ECallDBExecutor(this);
        dbExecutor.open();

        citySpinner = (Spinner) findViewById(R.id.spinner_city);
        districtSpinner = (Spinner) findViewById(R.id.spinner_district);

        List<CityDBO> cityDBOs = dbExecutor.getCities();
        CitySpinnerAdaptor citySpinnerAdaptor = new CitySpinnerAdaptor(this, R.layout.spinner_item, cityDBOs);
        citySpinner.setAdapter(citySpinnerAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbExecutor != null) {
            dbExecutor.close();
        }
    }
}
