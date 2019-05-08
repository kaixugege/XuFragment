package com.xugege.xufragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @Author: KaixuGege
 * Time:           2019/5/8
 * ProjectName:    XuLazyFragment
 * ClassName:
 * Info:
 */
public class MyFgAdapter extends FragmentPagerAdapter {

    private ArrayList<MyFragment> fragments = new ArrayList<>();

    public MyFgAdapter(FragmentManager fm, ArrayList<MyFragment> fragmentList) {
        super(fm);

        if (fragments == null) {
            fragments = fragmentList;
        } else {
            fragments.addAll(fragmentList);
        }

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getFragmentTag();
    }

    @Override
    public int getCount() {
        if (fragments == null) throw new IllegalArgumentException("fragments 不能为空");
        return fragments.size();
    }

}
