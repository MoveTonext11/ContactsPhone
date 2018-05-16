package com.anrong.contaactsphone.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.anrong.contaactsphone.Fragment.CallLogFragment;
import com.anrong.contaactsphone.Fragment.MyMessageInfoFragment;
import com.anrong.contaactsphone.Fragment.MycontactFragment;
import com.anrong.contaactsphone.Fragment.MysectionFragment;
import com.anrong.contaactsphone.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager contacts_viewpager;
    private TabLayout contacts_tab;
    private MyAdapter adapter;
    private String[] titles = {"我的信息", "我的部门", "常用联系人","通话记录"};
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_main);
        //控件布局
        initView();
        //数据框架填充
        initdata();
    }

    private void initdata() {
        fragments = new ArrayList<>();
        fragments.add(new MyMessageInfoFragment());
        fragments.add(new MysectionFragment());
        fragments.add(new MycontactFragment());
        fragments.add(new CallLogFragment());
        ArrayList<String> list = new ArrayList<>();
        adapter = new MyAdapter(getSupportFragmentManager());
        contacts_viewpager.setAdapter(adapter);
        contacts_tab.setupWithViewPager(contacts_viewpager);
        contacts_tab.setSelectedTabIndicatorHeight(0);//设置下划线宽度为0
        contacts_tab.setTabTextColors(Color.BLACK,Color.WHITE);//底部导航切换颜色状态变更

    }


    private void initView() {
        contacts_viewpager = (ViewPager) findViewById(R.id.contacts_viewpager);
        contacts_tab = (TabLayout) findViewById(R.id.contacts_tab);
    }


    //创建内部类
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
