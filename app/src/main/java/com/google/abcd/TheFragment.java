package com.google.abcd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by @Harry on 2018-07-20
 */

public class TheFragment extends Fragment {

    private View mView;
    private Button mBtn;
    private BottomPop mPop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.the_fragment, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        mBtn = mView.findViewById(R.id.btn);
        mPop = new BottomPop(getActivity(), new BottomPop.UploadImageListener() {
            @Override
            public void item0() {
                //窗口的点击回调0
                mBtn.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "点击了0", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void item1() {
                //窗口的点击回调1
                mBtn.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "点击了1", Toast.LENGTH_SHORT).show();
            }
        });
        mPop.closePopupWindow(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // TODO: 2018-07-20 可以根据anim的弹出/收回时间设置点击的按钮的隐藏/显示的动画
                mBtn.setVisibility(View.VISIBLE);//显示按钮
            }
        });
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*showAtLocation(parent, Gravity.BOTTOM, 0, 0);*/
                View rootView = getActivity().getWindow().getDecorView().getRootView();//
                View view = mView.findViewById(R.id.layout);//show在fragment的view里面也是可以的
                mPop.showAtLocation(view, Gravity.BOTTOM, 0, 0);
                // TODO: 2018-07-20 可以根据anim的弹出/收回时间设置点击的按钮的隐藏/显示的动画
                mBtn.setVisibility(View.GONE);//隐藏按钮
            }
        });
    }
}
