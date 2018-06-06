package com.sunzn.action.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ProgressBar;

import com.sunzn.action.library.ActionFragment;

public class MyFragment extends ActionFragment {

    public interface ActionListener {

        void exec();

    }

    public ActionListener mListener;

    public MyFragment setActionListener(ActionListener listener) {
        mListener = listener;
        return this;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressBar progress = view.findViewById(R.id.progressBar);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) mListener.exec();
            }
        });
    }
}
