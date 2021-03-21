package com.example.mposh.fragment;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class MViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<String> day = new MutableLiveData<>();
    private final MutableLiveData<Integer> country = new MutableLiveData<>();

    public void setDay(String d) {
        day.setValue(d);
    }

    public LiveData<String> getDay() {
        return day;
    }

    public void setCountry(Integer idx) {
        country.setValue(idx);
    }

    public LiveData<Integer> getCountry() {
        return country;
    }
}