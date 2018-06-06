package com.sunzn.action.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view) {
        final MyFragment fragment = new MyFragment();
        fragment.setActionListener(new MyFragment.ActionListener() {
            @Override
            public void exec() {
                finish();
            }
        }).setGravity(Gravity.CENTER).setCanceledOnTouch(false).setStyle(0).setDimAmount(0.8F).show(getSupportFragmentManager());
    }

}
