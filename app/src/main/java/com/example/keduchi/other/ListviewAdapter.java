package com.example.keduchi.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.keduchi.R;

import java.util.List;

/**
 * Created by Lenovo on 2017/8/21.
 */

public class ListviewAdapter extends BaseAdapter {
    private Context context;
    private List<Student> list;

    public ListviewAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_number = convertView.findViewById(R.id.tv_number);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_name.setText(list.get(position).getName());
        holder.tv_number.setText(list.get(position).getNumber());



        return convertView;
    }

    class ViewHolder {
        TextView tv_name;

        TextView tv_number;


    }


}
