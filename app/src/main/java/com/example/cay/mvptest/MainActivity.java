package com.example.cay.mvptest;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cay.mvptest.bese.BaseActivity;
import com.example.cay.mvptest.utils.ActivityCollector;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"pladda",Snackbar.LENGTH_LONG).setAction("nizaiganma", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onClick:size:-> "+ ActivityCollector.activities.size());
                        Toast.makeText(MainActivity.this,"hahahah",Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
    }

    @Override
    protected int setContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public CharSequence setToolbarTitle() {
        Log.d(TAG, "setToolbarTitle: ");
        return "你的名字";
    }
}
