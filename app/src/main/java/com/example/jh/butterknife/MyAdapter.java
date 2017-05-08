package com.example.jh.butterknife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：jinhui on 2017/3/16
 * 邮箱：1004260403@qq.com
 */

public class MyAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.iv.setImageResource(R.mipmap.ic_launcher);
        holder.tv.setText(list.get(position));
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.iv)
        ImageView iv;

        // 在构造方法里面进行butterknife的初始化
        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
