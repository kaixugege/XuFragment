package com.xugege.xufragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";

    private TabLayout tab;
    private ViewPager vp;

    ArrayList fragments = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);

        int tabCount = tab.getTabCount();
        Log.d(TAG, "  tab_count " + tabCount);

        fragments.add(new MyFragment().setFragmentTag(" tag_1"));
        fragments.add(new MyFragment().setFragmentTag(" tag_2"));
        fragments.add(new MyFragment().setFragmentTag(" tag_3"));
        fragments.add(new MyFragment().setFragmentTag(" tag_4"));
        fragments.add(new MyFragment().setFragmentTag(" tag_5"));

        MyFgAdapter adapter = new MyFgAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);


    }
}