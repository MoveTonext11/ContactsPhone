package com.anrong.contaactsphone.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.anrong.contaactsphone.Adapter.VisitPollcyTwoAdapter;
import com.anrong.contaactsphone.R;
import com.anrong.contaactsphone.Bean.PollcyFour;
import com.anrong.contaactsphone.Bean.PollcyOne;
import com.anrong.contaactsphone.Bean.PollcyThree;
import com.anrong.contaactsphone.Bean.PollcyTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/24.
 */

public class MysectionFragment extends Fragment {
    private ExpandableListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mymsectionfragment, container, false);

        initView(view);
        initData();
        return view;
    }

    /**加载数据*/
    public void initData() {
        final List<PollcyOne> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            PollcyOne pollcyOne = new PollcyOne();
            pollcyOne.content = "公安部" + (i+1);
            list.add(pollcyOne);
            for (int j = 0; j < 3; j++) {
                PollcyTwo pollcyTwo = new PollcyTwo();
                pollcyTwo.content = "交警部" + (j+1);
                pollcyOne.pollcyTwos.add(pollcyTwo);
                for (int k = 0; k < 4; k++) {
                    PollcyThree pollcyThree = new PollcyThree();
                    pollcyThree.content = "交警" + (k+1);
                    pollcyTwo.pollcyThrees.add(pollcyThree);
                    for (int l = 0; l < 3; l++) {
                        PollcyFour pollcyFour = new PollcyFour();
                        pollcyFour.content = "小民警" + (l+1);
                        pollcyThree.pollcyFours.add(pollcyFour);
                    }
                }
            }
        }
        VisitPollcyTwoAdapter adapter = new VisitPollcyTwoAdapter(getActivity(),list);
        listView.setAdapter(adapter);
    }


    private void initView(View view) {
        listView = (ExpandableListView) view.findViewById(R.id.list_item);
    }
}
