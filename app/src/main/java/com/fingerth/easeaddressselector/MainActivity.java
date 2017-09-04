package com.fingerth.easeaddressselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fingerth.jdaddressselector.BottomDialog;
import com.fingerth.jdaddressselector.interfac.OnAddressSelectedListener;
import com.fingerth.jdaddressselector.model.City;
import com.fingerth.jdaddressselector.model.County;
import com.fingerth.jdaddressselector.model.Province;
import com.fingerth.jdaddressselector.model.Street;

public class MainActivity extends AppCompatActivity implements OnAddressSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        BottomDialog.show(this, null, this);
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        String s =
                (province == null ? "" : province.name) +
                        (city == null ? "" : "\n" + city.name) +
                        (county == null ? "" : "\n" + county.name) +
                        (street == null ? "" : "\n" + street.name);

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
