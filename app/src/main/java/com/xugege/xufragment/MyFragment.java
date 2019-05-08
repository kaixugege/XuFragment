package com.xugege.xufragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xu.gege.fragment.frg.ILoaderData;

/**
 * @Author: KaixuGege
 * Time:           2019/5/7
 * ProjectName:    XuLazyFragment
 * ClassName:
 * Info:
 */
public class MyFragment extends MyBaseFragment {
    private View rootView = null;

    private static final String TAG = "MyBaseFragment";

    public String getFragmentTag() {
        return fragmentTag;
    }

    public MyFragment setFragmentTag(String fragmentTag) {
        this.fragmentTag = fragmentTag;
        return this;
    }

    private String fragmentTag;

    @Override
    public Object setLayout() {
        return R.layout.delegate_tab_item;
    }


    @Override
    public ILoaderData setILoader() {
        return new ILoaderData() {
            @Override
            public void startLoad() {
                Log.d(TAG, getFragmentTag()+"  startLoad " + "开始加载数据");
            }
        };
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint " + "" + getFragmentTag() + isVisibleToUser);
    }


}
