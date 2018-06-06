package com.sunzn.action.library;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ActionFragment extends ActionBase {

    private boolean mCancel = true;

    private float mDimAmount = 0.5F;

    private int mStyle = R.style.Animation_ActionBox;

    private int mGravity = Gravity.START | Gravity.BOTTOM;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Dialog dialog = getDialog();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside());
        Window window = dialog.getWindow();
        assert window != null;
        window.setGravity(getGravity());
        window.setDimAmount(getDimAmount());
        window.setWindowAnimations(getStyle());
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = 0;
        lp.width = getResources().getDisplayMetrics().widthPixels;
        window.setAttributes(lp);
        Log.e("ActionFragment", "onCreateView");
        return inflater.inflate(getLayoutRes(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("ActionFragment", "onViewCreated");
    }

    public ActionFragment setCanceledOnTouch(boolean cancel) {
        mCancel = cancel;
        return this;
    }

    public boolean isCanceledOnTouchOutside() {
        return mCancel;
    }

    public ActionFragment setCancelAble(boolean cancel) {
        setCancelable(cancel);
        return this;
    }

    public ActionFragment setGravity(int gravity) {
        mGravity = gravity;
        return this;
    }

    public int getGravity() {
        return mGravity;
    }

    public ActionFragment setDimAmount(float amount) {
        mDimAmount = amount;
        return this;
    }

    private float getDimAmount() {
        return mDimAmount;
    }

    public ActionFragment setStyle(int style) {
        mStyle = style;
        return this;
    }

    public int getStyle() {
        return mStyle;
    }

    public void show(FragmentManager manager) {
        show(manager, ActionFragment.this.getClass().getName());
    }

    public ActionFragment setShowTime(long millis) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (getContext() != null) dismiss();
            }
        }, millis);
        return this;
    }

    public void postDelayFade(long millis) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (getContext() != null) dismiss();
            }
        }, millis);
    }

}
