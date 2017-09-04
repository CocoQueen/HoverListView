package com.example.coco.floatmenulistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLinear_hide;
    private String[] strs;
    private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinear_hide = (LinearLayout) findViewById(R.id.mLinear_hide);
        strs = new String[100];

        for (int i = 0; i < 100; i++) {
            strs[i] = "data-----" + i;
        }

        mLv = (ListView) findViewById(R.id.mLv);
        View header = View.inflate(this, R.layout.header, null);//头部内容
        mLv.addHeaderView(header);//添加头部
        mLv.addHeaderView(View.inflate(this, R.layout.action, null));//ListView条目中的悬浮部分 添加到头部

        mLv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
        mLv.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 1) {
                    mLinear_hide.setVisibility(View.VISIBLE);
                } else {

                    mLinear_hide.setVisibility(View.GONE);
                }
            }
        });
    }
}