package com.example.viewmodelexample;

import android.graphics.Color;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ButtonViewModel extends ViewModel {

    MutableLiveData<Boolean> stateChecked = new MutableLiveData<>(false);

    int myColorRed = Color.parseColor("#FF0000");
    int myColorGreen = Color.parseColor("#00FF00");



}