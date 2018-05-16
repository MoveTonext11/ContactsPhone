package com.anrong.contaactsphone.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anrong.contaactsphone.Fragment.GlideCircleTransform;
import com.anrong.contaactsphone.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */

public class Myadapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public Myadapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_yuemingxi, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load("http://pic5.nipic.com/20091228/2588536_142951087553_2.jpg").transform(new GlideCircleTransform(context)).into(holder.image_message);
        holder.image_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("移除常用联系人").setMessage("本操作将把该联系人从常用联系人中删除，是否继续").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //调取移除的方法  并且  删除    刷新界面

                    }
                }).setNegativeButton("取消", null).create().show();
            }
        });
        holder.tv_username.setText(list.get(position));
        holder.tv_userphone.setText("安荣手机");
        holder.tv_userpolece.setText("安荣警号");
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView image_message;
        public TextView tv_username;
        public TextView tv_userpolece;
        public TextView tv_userphone;
        public ImageView image_start;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.image_message = (ImageView) rootView.findViewById(R.id.image_message);
            this.tv_username = (TextView) rootView.findViewById(R.id.tv_username);
            this.tv_userpolece = (TextView) rootView.findViewById(R.id.tv_userpolece);
            this.tv_userphone = (TextView) rootView.findViewById(R.id.tv_userphone);
            this.image_start = (ImageView) rootView.findViewById(R.id.image_start);
        }

    }
}
