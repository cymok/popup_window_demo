package com.google.abcd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by @Harry on 2018-07-20
 */

public class IncludeFragmentAty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_include_fragment);
        init();
    }

    private void init() {
        TheFragment fragment = new TheFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout, fragment).commit();
    }
}
