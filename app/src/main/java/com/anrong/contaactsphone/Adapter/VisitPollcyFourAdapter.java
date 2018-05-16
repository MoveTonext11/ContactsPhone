package com.anrong.contaactsphone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.anrong.contaactsphone.Fragment.GlideCircleTransform;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Bean.PollcyThree;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class VisitPollcyFourAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<PollcyThree> pollcyThrees;

    public VisitPollcyFourAdapter(Context context, List<PollcyThree> pollcyThrees) {
        this.context = context;
        this.pollcyThrees = pollcyThrees;
    }

    @Override
    public int getGroupCount() {
        return pollcyThrees.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return pollcyThrees.get(groupPosition).pollcyFours.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return pollcyThrees.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return pollcyThrees.get(groupPosition).pollcyFours.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.fourgroup, parent, false);
        TextView tv_fourgroup = (TextView) convertView.findViewById(R.id.tv_fourgroup);
        tv_fourgroup.setText(pollcyThrees.get(groupPosition).content);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.fouritemxml, parent, false);
        ImageView image_photo=(ImageView) convertView.findViewById(R.id.image_photo);
        TextView tv_polecenum = (TextView) convertView.findViewById(R.id.tv_polecenum_item);
        final TextView tv_phoneenum_item = (TextView) convertView.findViewById(R.id.tv_phoneenum_item);
        TextView tv_name_item = (TextView) convertView.findViewById(R.id.tv_name_item);
        tv_name_item.setText(pollcyThrees.get(groupPosition).pollcyFours.get(childPosition).content);

        Glide.with(context).load("http://pic5.nipic.com/20091228/2588536_142951087553_2.jpg")
               .transform(new GlideCircleTransform(context)).into(image_photo);
        tv_phoneenum_item.setText("测试警号");
        tv_phoneenum_item.setText("12345678911");
        tv_name_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diallPhone(tv_phoneenum_item.getText().toString().trim());
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public void diallPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }
}
