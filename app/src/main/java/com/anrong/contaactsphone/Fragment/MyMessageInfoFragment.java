package com.anrong.contaactsphone.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anrong.contaactsphone.R;
import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2018/4/24.
 */

public class MyMessageInfoFragment extends Fragment {

    private TextView updata_textview;
    private TextView setname_textview;
    private TextView plocenum_textview;
    private TextView phonenum_textview;
    private TextView telnum_textview;
    private TextView emilenum_textview;
    private ImageView mapimageview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mymessageinfofragment, container, false);
        initView(view);
        initdata();
        return view;
    }

    //数据请求      模拟    获取接口数据   根据什么？
    private void initdata() {
        Glide.with(this)
                .load("http://pic17.nipic.com/20111023/8379629_143733545000_2.jpg")
                .transform(new GlideCircleTransform(getActivity()))
                .into(mapimageview);
        //进行网络获取  数据之后设置数据
        setname_textview.setText("安荣测试");
        plocenum_textview.setText("8765432");
        phonenum_textview.setText("12345678909");
        telnum_textview.setText("1234-2141412");
        emilenum_textview.setText("mocvetofrist@163.com");
    }

    //数据填充
    private void initView(View view) {
        mapimageview = (ImageView) view.findViewById(R.id.mapimageview);
        setname_textview = (TextView) view.findViewById(R.id.setname_textview);
        plocenum_textview = (TextView) view.findViewById(R.id.plocenum_textview);
        phonenum_textview = (TextView) view.findViewById(R.id.phonenum_textview);
        telnum_textview = (TextView) view.findViewById(R.id.telnum_textview);
        emilenum_textview = (TextView) view.findViewById(R.id.emilenum_textview);
    }
}
