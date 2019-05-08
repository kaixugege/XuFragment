package com.xu.gege.fragment.frg;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: KaixuGege
 * Time:           2019/5/8
 * ProjectName:    XuFragment
 * ClassName:
 * Info:
 */
public abstract class XuBaseFragment extends XuLazyFragment {

    private View rootView = null;
    private ICreatView iCreatView = null;

    public abstract Object setLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {

            if (setLayout() == null) {
                throw new RuntimeException("XU: The setLayout not be null.");
            } else if (setLayout() instanceof Integer) {
                rootView = inflater.inflate((Integer) setLayout(), container, false);
            } else if (setLayout() instanceof View) {
                rootView = (View) setLayout();
            }
            if (iCreatView != null) iCreatView.created(rootView);

        } else {

            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }

        }
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
}