package com.anrong.contaactsphone.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.anrong.contaactsphone.Adapter.Myadapter;
import com.anrong.contaactsphone.Bean.MessageInfoBean;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.UI.MessageInfoActivity;
import com.anrong.contaactsphone.Utils.SqliteUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class MycontactFragment extends BaseFragment {

    private ListView list_contact;
    private boolean isPrepared;
    private MessageInfoBean bean;
    private SQLiteDatabase db;
    private Cursor cursor;
    private Myadapter myadapter;
    private List<MessageInfoBean> listinfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isPrepared = true;
        lazyLoad();
        View view = inflater.inflate(R.layout.mycontactfragment, container, false);

        initView(view);

        initdata();

        return view;
    }

    private void initdata() {
        //数据库进行查询出集合数据
        SqliteUtils sqliteUtils = new SqliteUtils(getActivity());
        sqliteUtils.getinstance();
        listinfo = sqliteUtils.querycymessage();

        //适配器创建
        myadapter = new Myadapter(getActivity(), listinfo);
        list_contact.setAdapter(myadapter);
        list_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) myadapter.getItem(i);
                Intent intent = new Intent(getActivity(), MessageInfoActivity.class);
                intent.putExtra("num", item);
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        list_contact = (ListView) view.findViewById(R.id.list_contact);
        list_contact.setVerticalScrollBarEnabled(false);
    }


    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        if (!isPrepared || !isVisible) {
            return;
        }
        SqliteUtils sqliteUtils = new SqliteUtils(getActivity());
        sqliteUtils.getinstance();
        listinfo = sqliteUtils.querycymessage();
        myadapter = new Myadapter(getActivity(), listinfo);
        list_contact.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();
    }
}
