package com.example.uygulama2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class BenimAdapter extends RecyclerView.Adapter<BenimAdapter.BenimViewHolder> {

    ArrayList<Müşteri> müşterler=new ArrayList<Müşteri>();
    LayoutInflater inflater;

    public BenimAdapter(ArrayList<Müşteri> müşterler, LayoutInflater inflater) {
        this.müşterler = müşterler;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public BenimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recycler_view_item,parent,false);
        BenimViewHolder viewHolder=new BenimViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BenimViewHolder holder, int position) {
        Müşteri seçilenmüşteri=müşterler.get(position);
        holder.setMüşteri(seçilenmüşteri);
    }

    @Override
    public int getItemCount() {
        return müşterler.size();
    }

    public class BenimViewHolder extends RecyclerView.ViewHolder{

        public BenimViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setMüşteri(Müşteri müşteri){
            TextView txt_adsoyad=itemView.findViewById(R.id.txt_adsoyad);
            TextView txt_telefon=itemView.findViewById(R.id.txt_telefon);
            TextView txt_mail=itemView.findViewById(R.id.txt_mail);

            txt_adsoyad.setText(müşteri.getAdsoyad());
            txt_telefon.setText(müşteri.getTelefon());
            txt_mail.setText(müşteri.getMail());

        }
    }
}
