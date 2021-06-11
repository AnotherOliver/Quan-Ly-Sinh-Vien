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

import com.example.assignment.EditLopHocActivity;
import com.example.assignment.R;
import com.example.assignment.dao.LopHocDAO;
import com.example.assignment.model.LopHoc;

import java.util.ArrayList;

public class LopHocAdapter extends BaseAdapter {
    Context context;
    ArrayList<LopHoc>data;
    LopHocDAO dao;

    public LopHocAdapter(Context context, ArrayList<LopHoc> data) {
        this.context = context;
        this.data = data;
        dao = new LopHocDAO(context);
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
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.lophoc_item, null);
            holder.ivEdit = convertView.findViewById(R.id.ivEdit);
            holder.ivDelete = convertView.findViewById(R.id.ivDelete);
            holder.tvMaLop = convertView.findViewById(R.id.tvMaLop);
            holder.tvTenLop = convertView.findViewById(R.id.tvTenLop);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditLopHocActivity.class);
                i.putExtra("lophoc", data.get(position));
                ((Activity)context).startActivity(i);
            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(data.get(position).getMaLop());
                data.clear();
          data.addAll(dao.readAll());
                notifyDataSetChanged();
            }
        });

        holder.tvMaLop.setText(data.get(position).getMaLop());
        holder.tvTenLop.setText(data.get(position).getTenLop());
        return convertView;
    }
    class ViewHolder{
        ImageView ivEdit, ivDelete;
        TextView tvMaLop, tvTenLop;
    }
}
