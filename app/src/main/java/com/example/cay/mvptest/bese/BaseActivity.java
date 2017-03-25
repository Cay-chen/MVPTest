package com.example.cay.mvptest.bese;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.cay.mvptest.R;
import com.example.cay.mvptest.utils.ActivityCollector;

public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = "Cay";
    protected FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initToolbar();
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //添加到管理器
        ActivityCollector.addActivity(this);


        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(setContentLayout(), null);
        view.setLayoutParams(layoutParams);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fr_content);
        frameLayout.addView(view);
    }

    protected abstract int setContentLayout();

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setTitle(setToolbarTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 设置toolbartitle
     *
     * @return toolbar的值
     */
    protected CharSequence setToolbarTitle() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除Activity管理
        ActivityCollector.removieActivity(this);
    }
}
