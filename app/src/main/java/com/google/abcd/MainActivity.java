package com.google.abcd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTvBtn;
    private BottomPop mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IncludeFragmentAty.class));
            }
        });
    }

    private void initView() {
        mTvBtn = findViewById(R.id.tv_btn);
        mPop = new BottomPop(this, new BottomPop.UploadImageListener() {
            @Override
            public void item0() {
                //窗口的点击回调0
                mTvBtn.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "点击了0", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void item1() {
                //窗口的点击回调1
                mTvBtn.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "点击了1", Toast.LENGTH_SHORT).show();
            }
        });
        mPop.closePopupWindow(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // TODO: 2018-07-20 可以根据anim的弹出/收回时间设置点击的按钮的隐藏/显示的动画
                mTvBtn.setVisibility(View.VISIBLE);//显示按钮
            }
        });
        mTvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*showAtLocation(parent, Gravity.BOTTOM, 0, 0);*/
                mPop.showAtLocation(getWindow().getDecorView().getRootView(), Gravity.BOTTOM, 0, 0);
                // TODO: 2018-07-20 可以根据anim的弹出/收回时间设置点击的按钮的隐藏/显示的动画
                mTvBtn.setVisibility(View.GONE);//隐藏按钮
            }
        });
    }
}
