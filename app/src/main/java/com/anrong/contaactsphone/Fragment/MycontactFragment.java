package com.anrong.contaactsphone.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.anrong.contaactsphone.Adapter.Myadapter;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.UI.MessageInfoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class MycontactFragment extends Fragment {

    private ImageView back_image;
    private ListView list_contact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mycontactfragment, container, false);

        initView(view);

        initdata();
        return view;
    }

    private void initdata() {
        List<String> list = new ArrayList<>();
        list.add("安荣测试1");
        list.add("安荣测试2");
        list.add("安荣测试3");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        list.add("安荣测试4");
        Myadapter myadapter = new Myadapter(getActivity(),list);
        list_contact.setAdapter(myadapter);
        list_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),""+i,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),MessageInfoActivity.class));
            }
        });
    }

    private void initView(View view) {
        back_image = (ImageView) view.findViewById(R.id.back_image);
        list_contact = (ListView) view.findViewById(R.id.list_contact);
        list_contact.setVerticalScrollBarEnabled(false);
    }


}
