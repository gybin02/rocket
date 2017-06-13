package com.meiyou.plugin.rocket;

import android.content.Context;

import com.meiyou.plugin.rocket.common.ConfigListener;

import java.util.List;
import java.util.Map;

/**
 * 默认配置，可以根据这个配置生成 页面
 * This class should be used to provide bridge between bee and the app.
 */
public abstract class RocketConfig implements ConfigListener {

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return context;
    }

    /**
     * 关闭Panel触发
     */
    @Override
    public void onClose() {
    }

    /**
     * 打开Content Panel触发
     */
    public void onOpen() {

    }

    @Deprecated
    @Override
    public void onInfoContentCreated(Map<String, String> content) {
    }

    @Deprecated
    @Override
    public void onLogContentCreated(List<String> logList) {

    }

}
