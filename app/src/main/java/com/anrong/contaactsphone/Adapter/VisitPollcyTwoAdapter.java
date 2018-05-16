package com.anrong.contaactsphone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Bean.PollcyOne;

import java.util.List;

/**
 * Created by Administrator on 2018/5/8.
 */

public class VisitPollcyTwoAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<PollcyOne> pollcyOnes;

    public VisitPollcyTwoAdapter(Context context,List<PollcyOne> pollcyOnes) {
        this.context = context;
        this.pollcyOnes = pollcyOnes;
    }

    @Override
    public int getGroupCount() {
        return pollcyOnes.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return pollcyOnes.get(groupPosition).pollcyTwos.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return pollcyOnes.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return pollcyOnes.get(groupPosition).pollcyTwos.get(childPosition);
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
        convertView= LayoutInflater.from(context).inflate(R.layout.oneitemxml,parent,false);
        TextView tv_oneitem = (TextView) convertView.findViewById(R.id.tv_oneitem);
        tv_oneitem.setText(pollcyOnes.get(groupPosition).content);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        CustExpListview listView = new CustExpListview(context);
        VisitPollcyThreeAdapter visitPollcyThreeAdapter = new VisitPollcyThreeAdapter(context,pollcyOnes.get(groupPosition).pollcyTwos);
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
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(2000, MeasureSpec.AT_MOST);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(1200, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }


    }


}
