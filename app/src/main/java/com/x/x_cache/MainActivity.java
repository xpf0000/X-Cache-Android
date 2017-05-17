package com.x.x_cache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.robin.lazy.cache.CacheLoaderConfiguration;
import com.robin.lazy.cache.CacheLoaderManager;
import com.robin.lazy.cache.disk.naming.HashCodeFileNameGenerator;
import com.robin.lazy.cache.memory.MemoryCache;
import com.robin.lazy.cache.util.MemoryCacheUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MemoryCache memoryCache= MemoryCacheUtils.createLruMemoryCache(1024*1024*256);
        CacheLoaderConfiguration config = new CacheLoaderConfiguration(this, new HashCodeFileNameGenerator(), 1024 * 1024 * 1024*64, 200000, memoryCache,60*24*30*365*20);
        CacheLoaderManager.getInstance().init(config);




    }
}
