package io.bloc.android.blocly;

import android.app.Application;

import io.bloc.android.blocly.api.DataSource;

/**
 * Created by benwong on 2015-04-18.
 */
public class BloclyApplication extends Application {

    public static BloclyApplication getSharedInstance(){
        return sharedInstance;
    }

    public static DataSource getSharedDataSource(){
        return BloclyApplication.getSharedInstance().getSharedDataSource();
    }

    private static BloclyApplication sharedInstance;
    private DataSource dataSource;

    @Override
    public void onCreate(){
        super.onCreate();
        sharedInstance = this;
        dataSource = new DataSource();

    }

    public DataSource getDataSource (){
        return dataSource;
    }
}