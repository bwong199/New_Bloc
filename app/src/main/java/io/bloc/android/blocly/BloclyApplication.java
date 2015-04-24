package io.bloc.android.blocly;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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
        dataSource = new DataSource(this);


        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .defaultDisplayImageOptions(defaultOptions)
                .build();

        ImageLoader.getInstance().init(configuration);

    }

    public DataSource getDataSource (){
        return dataSource;
    }
}
