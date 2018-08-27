package com.anrong.contaactsphone.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.anrong.contaactsphone.Bean.MyNodeBean;
import com.anrong.contaactsphone.Bean.MyTreeListViewAdapter;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.tree.Node;
import com.anrong.contaactsphone.tree.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的部门
 * Created by Administrator on 2018/4/24.
 */

@SuppressLint("ValidFragment")
public class MysectionFragment extends Fragment {
    private Context context;

    @SuppressLint("ValidFragment")
    public MysectionFragment(Context context) {
        this.context = context;
    }

    private ListView tree_lv;
    private MyTreeListViewAdapter<MyNodeBean> adapter;
    private List<MyNodeBean> mDatas = new ArrayList<MyNodeBean>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mymsectionfragment, container, false);
        initView(view);
        initDatas();
        setonclick();
        return view;
    }

    private void setonclick() {
        try {
            adapter = new MyTreeListViewAdapter<MyNodeBean>(tree_lv, context, mDatas, 10, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        adapter.setOnTreeNodeClickListener(new TreeListViewAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                if (node.isLeaf()) {
                    diallPhone("10010");
                }
            }
        });
        tree_lv.setAdapter(adapter);
    }

    private void initView(View view) {
        tree_lv = (ListView) view.findViewById(R.id.tree_lv);
    }
    private void initDatas() {
        mDatas.add(new MyNodeBean(1, 0, "省厅"));
        mDatas.add(new MyNodeBean(2, 1, "石家庄"));
        mDatas.add(new MyNodeBean(3, 1, "天津"));
        mDatas.add(new MyNodeBean(4, 1, "秦皇岛"));
        mDatas.add(new MyNodeBean(5, 2, "李世民"));
        mDatas.add(new MyNodeBean(6, 2, "李白"));

        mDatas.add(new MyNodeBean(7, 3, "赵匡胤"));
        mDatas.add(new MyNodeBean(8, 3, "苏轼"));

        mDatas.add(new MyNodeBean(9, 4, "朱元璋"));
        mDatas.add(new MyNodeBean(10, 4, "唐伯虎"));
        mDatas.add(new MyNodeBean(11, 4, "文征明"));
        mDatas.add(new MyNodeBean(12, 7, "赵建立"));
        mDatas.add(new MyNodeBean(13, 8, "苏东东"));
        mDatas.add(new MyNodeBean(14, 10, "秋香"));
        mDatas.add(new MyNodeBean(15, 10, "秋香"));
        mDatas.add(new MyNodeBean(16, 10, "秋香"));
        mDatas.add(new MyNodeBean(17, 10, "秋香"));
        mDatas.add(new MyNodeBean(18, 10, "秋香"));
        mDatas.add(new MyNodeBean(19, 10, "秋香"));
        mDatas.add(new MyNodeBean(20, 10, "秋香"));
        mDatas.add(new MyNodeBean(21, 10, "秋香"));
        mDatas.add(new MyNodeBean(22, 10, "秋香"));
        mDatas.add(new MyNodeBean(23, 10, "秋香"));
        mDatas.add(new MyNodeBean(24, 10, "秋香"));
        mDatas.add(new MyNodeBean(25, 10, "秋香"));
    }

    public void diallPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        context.startActivity(intent);
    }
}
