package com.sunzn.action.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import com.sunzn.action.library.ActionBase;

import java.util.Timer;
import java.util.TimerTask;

import static com.sunzn.action.sample.MyFragment.FINISH;

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
                fragment.dismissWithCode(FINISH);
            }
        }).setDismissListener(new ActionBase.DismissListener() {
            @Override
            public void onDismiss(int code) {
                if (code == FINISH) {
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 400);
                }
            }
        }).setGravity(Gravity.BOTTOM).setCanceledOnTouch(true).setCancelAble(true).setDimAmount(0.8F).show(getSupportFragmentManager());
    }

}
