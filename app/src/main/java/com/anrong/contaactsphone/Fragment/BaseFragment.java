package com.anrong.contaactsphone.Fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2018/5/16.
 */

public class BaseFragment extends Fragment {


    protected boolean isVisible;

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible(){
        lazyLoad();
    }

    protected  void lazyLoad(){

    };

    protected void onInvisible(){};
}
