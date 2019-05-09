package com.xugege.xufragment;

import android.util.Log;
import android.view.View;

import com.xu.gege.fragment.frg.ILazyLoda;

/**
 * @Author: KaixuGege
 * Time:           2019/5/7
 * ProjectName:    XuLazyFragment
 * ClassName:
 * Info:
 */
public class MyFragment extends MyBaseFragment {
    private View rootView = null;

    public MyFragment(){
        setStartLazy(true);
    }

    public String getFragmentTag() {
        return fragmentTag;
    }

    public MyFragment setFragmentTag(String fragmentTag) {
        this.fragmentTag = fragmentTag;
        return this;
    }

    private String fragmentTag;

    @Override
    public Object getLayout() {
        return R.layout.delegate_tab_item;
    }

    @Override
    public void onBindView(View rootView) {

    }

    public ILazyLoda setILoader() {
        return new ILazyLoda() {

            @Override
            public void onFragmentFirstVisible() {
                Log.d(TAG, getFragmentTag() + " onFragmentFirstVisible startLoad " + "开始加载数据");
            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {
                Log.d(TAG, getFragmentTag() + " onFragmentVisibleChange   " + isVisible);
            }

        };
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint " + " " + getFragmentTag() + "  " + isVisibleToUser);
    }

}
