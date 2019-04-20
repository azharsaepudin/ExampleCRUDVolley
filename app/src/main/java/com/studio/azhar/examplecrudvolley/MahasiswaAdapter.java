package com.studio.azhar.examplecrudvolley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    public static final String KEY_ID = "id";
    public static final String KEY_NPM = "npm";
    public static final String KEY_NAMA = "nama";
    private List<ModelMahasiswa> modelMahasiswas;
    public Context context;

   MahasiswaAdapter(List<ModelMahasiswa> modelMahasiswas, Context context){
       this.modelMahasiswas = modelMahasiswas;
       this.context = context;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemmhs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MahasiswaAdapter.ViewHolder holder, int position) {
        final ModelMahasiswa modelMahasiswa = modelMahasiswas.get(position);
        holder.id.setText(modelMahasiswa.getId());
        holder.npm.setText(modelMahasiswa.getNpm());
        holder.nama.setText(modelMahasiswa.getNama());

        holder.linearCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelMahasiswas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, npm, nama;
        LinearLayout linearCard;

        public ViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.txtId);
            npm = itemView.findViewById(R.id.txtNpm);
            nama = itemView.findViewById(R.id.txtNama);
            linearCard = itemView.findViewById(R.id.layoutCard);
        }
    }
}
