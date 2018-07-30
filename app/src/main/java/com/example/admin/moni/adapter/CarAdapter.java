package com.example.admin.moni.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.example.admin.moni.R;
import com.example.admin.moni.bean.CarBean;
import com.example.admin.moni.holder.ChildHolder;
import com.example.admin.moni.holder.GroupHolder;

import java.util.List;


public class CarAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<CarBean.DataBean> mData;

    public CarAdapter(Context context, List<CarBean.DataBean> data) {
        this.context = context;
        mData = data;
    }

    @Override
    public int getGroupCount() {
        return mData.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mData.get(i).getList().size();
    }

    @Override
    public Object getGroup(int i) {
        return mData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mData.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder groupHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.group_item, null);
            groupHolder = new GroupHolder();
            groupHolder.group_title = view.findViewById(R.id.group_title);
            view.setTag(groupHolder);
        }else {
            groupHolder = (GroupHolder) view.getTag();
        }
        groupHolder.group_title.setText(mData.get(i).getSellerName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildHolder childViewHolder=null;
        if (view==null){
            view=LayoutInflater.from(context).inflate(R.layout.child_item,viewGroup,false);
            childViewHolder=new ChildHolder();
            childViewHolder.child_box=view.findViewById(R.id.child_box);
            childViewHolder.child_img=view.findViewById(R.id.child_img);
            childViewHolder.child_title=view.findViewById(R.id.child_title);
            childViewHolder.child_price=view.findViewById(R.id.child_price);
            view.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildHolder) view.getTag();
        }
        List<CarBean.DataBean.ListBean> list = mData.get(i).getList();
        childViewHolder.child_img.setImageURI(list.get(i1).getImages().split("\\|")[0]);
        childViewHolder.child_title.setText(list.get(i1).getTitle());
        childViewHolder.child_price.setText(list.get(i1).getPrice());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
