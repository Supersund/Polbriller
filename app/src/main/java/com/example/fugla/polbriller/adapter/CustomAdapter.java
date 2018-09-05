package com.example.fugla.polbriller.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.fugla.polbriller.utils.Product;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private final Activity context;
    private final List<Product> list;

    public CustomAdapter(Activity context, List<Product> productList) {
        list = productList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
