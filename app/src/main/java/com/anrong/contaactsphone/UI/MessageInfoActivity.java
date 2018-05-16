package com.anrong.contaactsphone.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anrong.contaactsphone.R;

public class MessageInfoActivity extends AppCompatActivity {

    private String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymessageinfofragment);
        Intent intent = getIntent();
        //获取警员警号  根据警号  查询警员信息    缺接口
        num = intent.getStringExtra("num");

    }


}
