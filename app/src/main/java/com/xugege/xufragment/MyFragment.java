package com.xugege.xufragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: KaixuGege
 * Time:           2019/5/7
 * ProjectName:    XuFragment
 * ClassName:
 * Info:
 */
public class MyFragment extends BaseFragment {
    private View rootView = null;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(1, container, false);


        return rootView;
    }
}
