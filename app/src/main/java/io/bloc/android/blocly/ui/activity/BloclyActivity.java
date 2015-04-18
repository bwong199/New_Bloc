package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import io.bloc.android.blocly.R;

/**
 * Created by benwong on 2015-04-18.
 */
public class BloclyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
    }
}
