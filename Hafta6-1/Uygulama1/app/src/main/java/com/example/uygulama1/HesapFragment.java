package com.example.uygulama1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HesapFragment extends Fragment {

    Hesap hesap;

    public HesapFragment(Hesap hesap) {
        this.hesap=hesap;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_hesap, container, false);
        TextView txt_hesapsahibi=view.findViewById(R.id.txt_hesapsahibi);
        TextView txt_hesaptürü=view.findViewById(R.id.txt_hesaptürü);
        TextView txt_bakiye=view.findViewById(R.id.txt_bakiye);

        txt_hesapsahibi.setText(hesap.getHesapsahibi());
        txt_hesaptürü.setText(hesap.getHesaptürü());
        txt_bakiye.setText(String.valueOf(hesap.getBakiye()));
        return view;
    }
}