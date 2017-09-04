package com.fingerth.jdaddressselector.interfac;

import com.fingerth.jdaddressselector.model.City;
import com.fingerth.jdaddressselector.model.County;
import com.fingerth.jdaddressselector.model.Province;
import com.fingerth.jdaddressselector.model.Street;

import java.util.List;


public interface AddressProvider {
    void provideProvinces(AddressReceiver<Province> addressReceiver);
    void provideCitiesWith(int provinceId, AddressReceiver<City> addressReceiver);
    void provideCountiesWith(int cityId, AddressReceiver<County> addressReceiver);
    void provideStreetsWith(int countyId, AddressReceiver<Street> addressReceiver);

    interface AddressReceiver<T> {
        void send(List<T> data);
    }
}