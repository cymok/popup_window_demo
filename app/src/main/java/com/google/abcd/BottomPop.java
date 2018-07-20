package com.google.abcd;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class BottomPop extends PopupWindow {

    private final Context mContext;
    private OnDismissListener mListener;

    public BottomPop(final Context context, /*View parent, */final UploadImageListener listener) {
        this.mContext = context;

        View view = View.inflate(this.mContext, R.layout.pop_set_header, null);

        this.setContentView(view);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        this.setAnimationStyle(R.style.mypopwindow_anim_style);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x6ddd));// 设置背景透明

        setAlpha(0.7f);

        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
        /*showAtLocation(parent, Gravity.BOTTOM, 0, 0);*/
        update();

        Button bt1 = view.findViewById(R.id.item_popupwindows_camera);
        Button bt2 = view.findViewById(R.id.item_popupwindows_photo);
        Button bt3 = view.findViewById(R.id.item_popupwindows_cancel);
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listener.item0();
                closePopupWindow(null);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listener.item1();
                closePopupWindow(null);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                closePopupWindow(null);
            }
        });
        //noinspection deprecation
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                closePopupWindow(null);
            }
        });
    }

    private void setAlpha(float v) {
        Window window = ((Activity) mContext).getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.alpha = v;
        window.setAttributes(params);
    }

    @Deprecated
    @Override
    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
    }

    public void closePopupWindow(OnDismissListener listener) {
        if (listener != null) {
            mListener = listener;
        }
        if (isShowing()) {
            dismiss();
        }
        setAlpha(1.0f);
        if (mListener != null) {
            mListener.onDismiss();
        }
    }

    public interface UploadImageListener {
        void item0();

        void item1();
    }


}
