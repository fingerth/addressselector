package com.fingerth.jdaddressselector.interfac;


import com.fingerth.jdaddressselector.model.City;
import com.fingerth.jdaddressselector.model.County;
import com.fingerth.jdaddressselector.model.Province;
import com.fingerth.jdaddressselector.model.Street;

public interface OnAddressSelectedListener {
    void onAddressSelected(Province province, City city, County county, Street street);
}
