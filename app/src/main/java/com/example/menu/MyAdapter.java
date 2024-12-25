package com.example.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;

    private List<Menu> data;

    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Menu> data) {
        this.context = context;
        this.data = data;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        }

        TextView tvFood = convertView.findViewById(R.id.tv_item_menu);
        ImageView imgFood = convertView.findViewById(R.id.img_item_menu);
        TextView tvPriceFood = convertView.findViewById(R.id.tv_price_item_menu);
        
        Menu menu = data.get(position);
        
        tvFood.setText(menu.getName());

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

        currencyFormatter.setCurrency(Currency.getInstance("VND"));

        currencyFormatter.setMinimumFractionDigits(0);

        String formattedPrice = currencyFormatter.format(menu.getPrice());
        tvPriceFood.setText(formattedPrice);

        Glide.with(convertView).load(menu.getImage()).into(imgFood);
        return convertView;
    }
}
