package com.anrong.contaactsphone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Bean.PollcyTwo;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class VisitPollcyThreeAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<PollcyTwo> pollcyTwos;
    public VisitPollcyThreeAdapter(Context context,List<PollcyTwo> pollcyTwos) {
        this.context = context;
        this.pollcyTwos = pollcyTwos;
    }

    @Override
    public int getGroupCount() {
        return pollcyTwos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return pollcyTwos.get(groupPosition).pollcyThrees.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return pollcyTwos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return pollcyTwos.get(groupPosition).pollcyThrees.get(childPosition);
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
        convertView= LayoutInflater.from(context).inflate(R.layout.twoitemxml,parent,false);
        TextView tv_twoitem = (TextView) convertView.findViewById(R.id.tv_twoitem);
        tv_twoitem.setText(pollcyTwos.get(groupPosition).content);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CustExpListview listView = new CustExpListview(context);
        VisitPollcyFourAdapter visitPollcyThreeAdapter = new VisitPollcyFourAdapter(context,pollcyTwos.get(groupPosition).pollcyThrees);
        listView.setAdapter(visitPollcyThreeAdapter);
        listView.setGroupIndicator(null);
        return listView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class CustExpListview extends ExpandableListView {

        public CustExpListview(Context context) {
            super(context);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(1000,
                    MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(700,
                    MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
