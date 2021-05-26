package com.example.firstprojectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyMenuAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] menu;

    public MyMenuAdapter(Context c, String[] m){
        menu = m;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return menu.length;
    }

    @Override
    public Object getItem(int position) {
        return menu[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.menu_listview_detail, null);
        TextView menuTextView = (TextView) v.findViewById(R.id.menuTextView);

        String option = menu[position];

        menuTextView.setText(option);

        return v;
    }
}
