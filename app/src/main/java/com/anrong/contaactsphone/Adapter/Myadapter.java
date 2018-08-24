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

import com.anrong.contaactsphone.Bean.MessageInfoBean;
import com.anrong.contaactsphone.Fragment.GlideCircleTransform;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Utils.SqliteUtils;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */

public class Myadapter extends BaseAdapter {
    private Context context;
    private List<MessageInfoBean> list;

    public Myadapter(Context context, List<MessageInfoBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).getPoleceNum();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_yuemingxi, viewGroup, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImageUrl()).transform(new GlideCircleTransform(context)).into(holder.image_message);
        holder.image_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("移除常用联系人").setMessage("本操作将把该联系人从常用联系人中删除，是否继续").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SqliteUtils sql = new SqliteUtils(context);
                        sql.getinstance();
                        long deletemessage = sql.deletemessage(list.get(position).id);
                        //暴露接口出去刷新界面
                        if (Long.bitCount(deletemessage)==1){
                            list.remove(position);
                            notifyDataSetChanged();
                        }else{
                        }
                    }
                }).setNegativeButton("取消", null).create().show();
            }
        });
        holder.tv_username.setText(list.get(position).getName());
        holder.tv_userphone.setText(list.get(position).getPhoneNum());
        holder.tv_userpolece.setText(list.get(position).getPoleceNum());
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


//    public void deletemessageUI(Cymessage cymessage){
//        this.cymessage=cymessage;
//    }
//    private Cymessage cymessage;
//    public interface Cymessage{
//        void deletemessage(boolean isdelete);
//    }

}
