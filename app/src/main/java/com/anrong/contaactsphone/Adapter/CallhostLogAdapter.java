package com.anrong.contaactsphone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anrong.contaactsphone.Bean.MessageInfoBean;
import com.anrong.contaactsphone.R;

import java.util.List;

/**
 * Created by Administrator on 2018/5/14.
 */

public class CallhostLogAdapter extends BaseAdapter {

    private Context context;
    private List<MessageInfoBean> listinfo;

    public CallhostLogAdapter(Context context, List<MessageInfoBean> listinfo) {
        this.context = context;
        this.listinfo = listinfo;
    }

    @Override
    public int getCount() {
        return listinfo.size();
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.calllogitem, viewGroup, false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        String poleceNum = listinfo.get(i).getPoleceNum();
        int time = Integer.parseInt(poleceNum);
        holder.tv_polecenum_item.setText(time/1000+"秒");
        holder.tv_phoneenum_item.setText(listinfo.get(i).getPhoneNum());
        holder.tv_name_item.setText(listinfo.get(i).getName());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView imagephone;
        public ImageView image_photo;
        public TextView tv_name_item;
        public TextView tv_polecenum_item;
        public TextView tv_phoneenum_item;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.image_photo = (ImageView) rootView.findViewById(R.id.image_photo);
            this.tv_name_item = (TextView) rootView.findViewById(R.id.tv_name_item);
            this.tv_polecenum_item = (TextView) rootView.findViewById(R.id.tv_polecenum_item);
            this.tv_phoneenum_item = (TextView) rootView.findViewById(R.id.tv_phoneenum_item);
        }

    }
}
