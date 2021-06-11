package com.example.assignment.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment.EditSinhVienActivity;
import com.example.assignment.R;
import com.example.assignment.dao.SinhVienDAO;
import com.example.assignment.model.SinhVien;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    ArrayList<SinhVien>data;
    SinhVienDAO dao;

    public SinhVienAdapter(Context context, ArrayList<SinhVien> data){
        this.context = context;
        this.data = data;
        dao = new SinhVienDAO(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.sinhvien_item, null);
            holder.ivEdit1 = convertView.findViewById(R.id.ivEditSv);
            holder.ivDelete1 = convertView.findViewById(R.id.ivDeleteSv);
            holder.tvMaSinhVien = convertView.findViewById(R.id.tvMaSinhVien);
            holder.tvTenSinhVien = convertView.findViewById(R.id.tvTenSinhVien);
            holder.tvMaLop = convertView.findViewById(R.id.tvMaLop);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.ivEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditSinhVienActivity.class);
                i.putExtra("sinhvien", data.get(position));
                ((Activity)context).startActivity(i);
            }
        });

        holder.ivDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(data.get(position).getMaLop());
                data.clear();
                data.addAll(dao.readAll());
                notifyDataSetChanged();
            }
        });



        holder.tvMaSinhVien.setText(data.get(position).getMaSinhVien());
        holder.tvTenSinhVien.setText(data.get(position).getTenSinhVien());
        holder.tvMaLop.setText(data.get(position).getMaLop());

        return convertView;
    }
    class ViewHolder{
        ImageView ivEdit1, ivDelete1;
        TextView tvMaSinhVien, tvTenSinhVien, tvMaLop;
    }
}
