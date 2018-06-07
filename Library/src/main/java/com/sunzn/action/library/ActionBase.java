package com.sunzn.action.library;

import android.support.v4.app.DialogFragment;

public abstract class ActionBase extends DialogFragment {

    public interface DismissListener {
        void onDismiss();
    }

    public abstract int getLayoutRes();

}
