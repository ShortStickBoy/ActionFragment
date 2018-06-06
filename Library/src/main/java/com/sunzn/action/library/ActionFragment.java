package com.sunzn.action.library;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
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

    private int mStyle = R.style.Theme_ActionBox;

    private int mGravity = Gravity.START | Gravity.BOTTOM;

    private int mWidth = WindowManager.LayoutParams.MATCH_PARENT;

    private int mHeight = WindowManager.LayoutParams.WRAP_CONTENT;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, getStyle());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Dialog dialog = getDialog();
        dialog.setCanceledOnTouchOutside(isCanceledOnTouch());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setLayout(getWidth(), getHeight());
            window.setDimAmount(getDimAmount());
            window.setGravity(getGravity());
        }
        return inflater.inflate(getLayoutRes(), container, false);
    }

    public ActionFragment setCanceledOnTouch(boolean cancel) {
        mCancel = cancel;
        return this;
    }

    public boolean isCanceledOnTouch() {
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

    public ActionFragment setWidth(int width) {
        mWidth = width;
        return this;
    }

    public int getWidth() {
        return mWidth;
    }

    public ActionFragment setHeight(int height) {
        mHeight = height;
        return this;
    }

    public int getHeight() {
        return mHeight;
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
