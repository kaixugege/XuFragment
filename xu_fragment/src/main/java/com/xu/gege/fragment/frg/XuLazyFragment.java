package com.xu.gege.fragment.frg;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: KaixuGege
 * Time:           2019/5/7
 * ProjectName:    XuLazyFragment
 * ClassName:
 * Info:
 */
public abstract class XuLazyFragment extends BaseFragment {

    protected boolean isFist = true;//是否第一次登陆，默认第一次进入
    private boolean isReuseView = true;//是否进行复用，默认复用
    private boolean isFragmentVisible; // Fragment是否可见

    private View rootView = null;

    private ILoaderData iLoaderData;

    public abstract ILoaderData setILoader();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //setUserVisibleHint()有可能在fragment的生命周期外被调用

        if (rootView == null) return;

        if (isFist && isVisibleToUser) {

            //如果第一次进入并且可见的
            onFragmentFirstVisible();//回调当前fragment首次可见
            iLoaderData = setILoader();
            if (iLoaderData != null) iLoaderData.startLoad();
            isFist = false;//这里把首次可见给关闭
        }

        //如果只是可见，不是首次可见
        if(isVisibleToUser){
            isFragmentVisible = true;
            onFragmentVisibleChange(isFragmentVisible);//回调当前fragment可见

            return;
        }

        if(isFragmentVisible){
            //如果当前fragment不可见且标识位true
            isFragmentVisible = false;//更改标识
            onFragmentVisibleChange(isFragmentVisible);//回调当前fragment不可见
        }


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //如果setUserVisibleHint()在rootView创建前调用时，那么
        //就等到rootView创建完后才回调onFragmentVisibleChange(true)
        //保证onFragmentVisibleChange()的回调发生在rootView创建完成之后，以便支持ui操作
        if (rootView == null) {
            rootView = view;

            //这个函数判断 fragment 是否可见的
            if (getUserVisibleHint()) {
                if (isFist) {
                    onFragmentFirstVisible();
                    isFist = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;//设置fragment可见
            }
        }

        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 在fragment首次可见时回调，可在这里进行加载数据，保证只在第一次打开Fragment时才会加载数据，
     * 这样就可以防止每次进入都重复加载数据
     * 该方法会在 onFragmentVisibleChange() 之前调用，所以第一次打开时，可以用一个全局变量表示数据下载状态，
     * 然后在该方法内将状态设置为下载状态，接着去执行下载的任务
     * 最后在 onFragmentVisibleChange() 里根据数据下载状态来控制下载进度ui控件的显示与隐藏
     */
    protected void onFragmentFirstVisible() {

    }

    /**
     * 去除setUserVisibleHint()多余的回调场景，保证只有当fragment可见状态发生变化时才回调
     * 回调时机在view创建完后，所以支持ui操作，解决在setUserVisibleHint()里进行ui操作有可能报null异常的问题
     * <p>
     * 可在该回调方法里进行一些ui显示与隐藏，比如加载框的显示和隐藏
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {

    }
}
