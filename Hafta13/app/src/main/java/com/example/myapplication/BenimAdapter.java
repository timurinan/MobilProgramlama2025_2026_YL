package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BenimAdapter extends RecyclerView.Adapter<BenimAdapter.MyViewHolder> {

    ArrayList<Müşteri> müşteriler;
    LayoutInflater inflater;

    public BenimAdapter(ArrayList<Müşteri> müşteriler, Context context) {
        this.müşteriler = müşteriler;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View görünüm=inflater.inflate(R.layout.recyclerview_item,parent,false);
        MyViewHolder mvh=new MyViewHolder(görünüm);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Müşteri müşteri=müşteriler.get(position);
        holder.setMüşteri(müşteri);
    }

    @Override
    public int getItemCount() {
        return müşteriler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_adsoyad,txt_mail,txt_telefon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_adsoyad=itemView.findViewById(R.id.txt_adsoyad_item);
            txt_mail=itemView.findViewById(R.id.txt_mail_item);
            txt_telefon=itemView.findViewById(R.id.txt_telefon_item);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position=getAdapterPosition();
                    FirebaseDatabase veritabanı=FirebaseDatabase.getInstance();
                    DatabaseReference referans=veritabanı.getReference("müşteriler");
                    AlertDialog.Builder ab=new AlertDialog.Builder(itemView.getContext());
                    ab.setTitle("Seçim Yapınız");
                    ab.setMessage("Lütfen yapmak istediğiniz işlemi seçiniz");
                    ab.setPositiveButton("Güncelle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent guncelle_intent=new Intent(itemView.getContext(), GuncelleActivity.class);
                            Müşteri seçilenmüşteri=müşteriler.get(position);
                            guncelle_intent.putExtra("seçilenmüşteri",seçilenmüşteri);
                            itemView.getContext().startActivity(guncelle_intent);
                        }
                    });
                    ab.setNegativeButton("Sil", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            referans.child(müşteriler.get(position).getAnahtar()).removeValue();
                            Intent main_intent=new Intent(itemView.getContext(), MainActivity.class);
                            itemView.getContext().startActivity(main_intent);
                        }
                    });
                    ab.setNeutralButton("İptal", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ab.show();
                    return false;
                }
            });
        }

        public void setMüşteri(Müşteri gelenMüşteri){
            txt_adsoyad.setText(gelenMüşteri.getAdsoyad());
            txt_mail.setText(gelenMüşteri.getMail());
            txt_telefon.setText(gelenMüşteri.getTelefon());
        }
    }
}
