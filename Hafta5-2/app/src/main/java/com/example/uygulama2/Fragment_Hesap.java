package com.example.uygulama2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Hesap extends Fragment {

    TextView txt_hesapsahibi, txt_hesaptürü, txt_hesapbakiyesi;
    Hesap hesap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView=inflater.inflate(R.layout.activity_hesap,container,false);

        txt_hesapsahibi=myView.findViewById(R.id.txt_hesapsahibi);
        txt_hesaptürü=myView.findViewById(R.id.txt_hesaptürü);
        txt_hesapbakiyesi=myView.findViewById(R.id.txt_hesapbakiyesi);

        txt_hesapsahibi.setText(hesap.getHesapsahibi());
        txt_hesaptürü.setText(hesap.getHesaptürü());
        txt_hesapbakiyesi.setText(hesap.getHesapbakiyesi()+"");

        return myView;
    }
    public void setHesap(Hesap gelenHesap){
        hesap=gelenHesap;
    }
}
