package com.example.uygulama2;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

            itemView.setLongClickable(true);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int index=getBindingAdapterPosition();
                    Toast.makeText(itemView.getContext(), ""+index, Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder ab=new AlertDialog.Builder(itemView.getContext());
                    ab.setMessage("Devam etmek için bir seçeneği seçiniz");
                    ab.setTitle("Seçim");
                    ab.setPositiveButton("Sil", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            müşterler.remove(index);
                            notifyDataSetChanged();
                        }
                    });

                    ab.setNegativeButton("Güncelle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    ab.setNeutralButton("İptal", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    ab.show();
                    return true;
                }
            });
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
