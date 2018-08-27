package com.anrong.contaactsphone.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.anrong.contaactsphone.Adapter.CallhostLogAdapter;
import com.anrong.contaactsphone.Bean.MessageInfoBean;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Utils.SqliteUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class CallLogFragment extends BaseFragment implements View.OnClickListener {

    private ListView list_calllog;
    private CallhostLogAdapter adapter;
    private List<MessageInfoBean> listinfo;
    private MessageInfoBean bean;
    private SQLiteDatabase db;
    private Cursor cursor;
    private boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isPrepared = true;
        lazyLoad();
        View view = inflater.inflate(R.layout.calllogfragment, container, false);

        initView(view);

        initdata();
        return view;
    }

    /**
     * 获取接口数据  或者创建数据库  从数据库内部抽取数据
     * 暂时待定
     */
    private void initdata() {
        //便利数据库进行查询出集合数据
        SqliteUtils sql = new SqliteUtils(getActivity());
        sql.getinstance();
        listinfo = sql.querycalllog();

        adapter = new CallhostLogAdapter(getActivity(), this.listinfo);
        list_calllog.setAdapter(adapter);
    }

    private void initView(View view) {
        list_calllog = (ListView) view.findViewById(R.id.list_calllog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        if (!isPrepared || !isVisible) {
            return;
        }
        initdata();
    }
}
