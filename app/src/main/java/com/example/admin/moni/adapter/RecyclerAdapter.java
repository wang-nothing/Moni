package com.example.admin.moni.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.moni.R;
import com.example.admin.moni.bean.GoodBean;
import com.example.admin.moni.holder.RecyclerHolder;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private Context context;
    private List<GoodBean.DataBean> mData;
    private View mView;

    public RecyclerAdapter(Context context, List<GoodBean.DataBean> data) {
        this.context = context;
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mView = LayoutInflater.from(context).inflate(R.layout.item_show, null);

        return new RecyclerHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder, int i) {
        String image = mData.get(i).getImages().split("\\|")[0];
        String title = mData.get(i).getTitle();
        String price = mData.get(i).getPrice();
        recyclerHolder.item_show_fresco_image.setImageURI(image);
        recyclerHolder.item_show_tv_title.setText(title);
        recyclerHolder.item_show_tv_price.setText("￥"+price);
        recyclerHolder.itemView.setTag(i);
        recyclerHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemclick.itemclick(mData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
  public onItemclick mOnItemclick;

    public void setOnItemclick(onItemclick onItemclick) {
        mOnItemclick = onItemclick;
    }


    public interface onItemclick{
        void itemclick(List<GoodBean.DataBean> mData);
   }
}
