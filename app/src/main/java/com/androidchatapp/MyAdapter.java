package com.androidchatapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends ArrayAdapter<String> {


    String[] names;
    int[] icon;
    Context mContext;

    public MyAdapter(Context context, String[] User, int[] User_icon) {
        super(context, R.layout.listview_item);
        this.names = User;
        this.icon = User_icon;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.micon = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.muser = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.micon.setImageResource(icon[position]);
        mViewHolder.muser.setText(names[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView micon;
        TextView muser;
    }


}


