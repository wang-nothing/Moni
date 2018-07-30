package com.example.admin.moni.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.moni.R;
import com.facebook.drawee.view.SimpleDraweeView;


public class RecyclerHolder extends RecyclerView.ViewHolder {
    public SimpleDraweeView item_show_fresco_image;
    public TextView item_show_tv_title,item_show_tv_price;
    public RecyclerHolder(@NonNull View itemView) {
        super(itemView);
        item_show_fresco_image = itemView.findViewById(R.id.item_show_fresco_image);
        item_show_tv_title = itemView.findViewById(R.id.item_show_tv_title);
        item_show_tv_price = itemView.findViewById(R.id.item_show_tv_price);
    }

}
