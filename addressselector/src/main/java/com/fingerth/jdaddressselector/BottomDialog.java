package com.fingerth.jdaddressselector;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.fingerth.jdaddressselector.interfac.AddressProvider;
import com.fingerth.jdaddressselector.interfac.OnAddressSelectedListener;
import com.fingerth.jdaddressselector.util.AddressStaticUtils;


public class BottomDialog extends Dialog {
    private AddressSelector selector;
    private Activity activity;

//    public BottomDialog(Activity context) {
//        super(context, R.style.bottom_dialog);
//        init(context);
//    }

    public BottomDialog(Activity context, int themeResId) {
        super(context, themeResId);
        init(context, null);
    }

    public BottomDialog(Activity context, int themeResId, AddressProvider defaultProvider) {
        super(context, themeResId);
        init(context, defaultProvider);
    }

//    public BottomDialog(Activity context, boolean cancelable, OnCancelListener cancelListener) {
//        super(context, cancelable, cancelListener);
//        init(context);
//    }

    private void init(Activity context, AddressProvider defaultProvider) {
        activity = context;
        selector = new AddressSelector(context, defaultProvider);
        setContentView(selector.getView());

        Window window = getWindow();
        assert window != null;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        try {
            params.height = (int) (AddressStaticUtils.getSysHeight(activity) * 0.618f);
        } catch (Exception e) {
            params.height = AddressStaticUtils.dp2px(context, 256);
        }

        window.setAttributes(params);

        window.setGravity(Gravity.BOTTOM);
    }

    public void setOnAddressSelectedListener(OnAddressSelectedListener listener) {
        this.selector.setOnAddressSelectedListener(listener);
    }

    public static BottomDialog show(Activity context, AddressProvider provider, OnAddressSelectedListener listener) {
        BottomDialog dialog = new BottomDialog(context, R.style.bottom_dialog);
        dialog.selector.setOnAddressSelectedListener(listener);
        if (provider != null) {
            dialog.selector.setAddressProvider(provider);
        }
        dialog.show();

        return dialog;
    }

    public static BottomDialog show(Activity context, AddressProvider provider, OnAddressSelectedListener listener, AddressProvider defaultProvider) {
        BottomDialog dialog = new BottomDialog(context, R.style.bottom_dialog, defaultProvider);
        dialog.selector.setOnAddressSelectedListener(listener);
        if (provider != null) {
            dialog.selector.setAddressProvider(provider);
        }
        dialog.selector.setLang("");
        dialog.show();

        return dialog;
    }

    public static BottomDialog show(Activity context, AddressProvider provider, OnAddressSelectedListener listener, AddressProvider defaultProvider, String please_choose) {
        BottomDialog dialog = new BottomDialog(context, R.style.bottom_dialog, defaultProvider);
        dialog.selector.setOnAddressSelectedListener(listener);
        if (provider != null) {
            dialog.selector.setAddressProvider(provider);
        }
        dialog.selector.setLang(please_choose);
        dialog.show();
        return dialog;
    }
}
