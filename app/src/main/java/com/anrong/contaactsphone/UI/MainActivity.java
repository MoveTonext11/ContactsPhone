package com.anrong.contaactsphone.UI;

import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    private String[] titles = {"我的信息", "我的部门", "常用联系人", "通话记录"};
    private ArrayList<Fragment> fragments;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setwindow();
        setContentView(R.layout.activity_main);
        //控件布局
        initView();
        //数据框架填充
        initdata();
    }

    private void setwindow() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View decorview = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT>=21){//5.0以上的系统支持
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;//表示让应用主题内容占据系统状态栏的空间
            decorview.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.parseColor("#00ffffff"));//设置状态栏颜色为透明
        }
    }

    private void initdata() {
        fragments = new ArrayList<>();
        fragments.add(new MyMessageInfoFragment());
        fragments.add(new MysectionFragment(this));
        fragments.add(new MycontactFragment());
        fragments.add(new CallLogFragment());

        adapter = new MyAdapter(getSupportFragmentManager());
        contacts_viewpager.setAdapter(adapter);
        contacts_tab.setupWithViewPager(contacts_viewpager);
        contacts_viewpager.setOffscreenPageLimit(3);
        contacts_tab.setSelectedTabIndicatorHeight(0);//设置下划线宽度为0
        contacts_tab.setTabTextColors(Color.BLACK, Color.WHITE);//底部导航切换颜色状态变更
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
