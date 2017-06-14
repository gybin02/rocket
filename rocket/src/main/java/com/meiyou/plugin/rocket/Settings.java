package com.meiyou.plugin.rocket;

import android.content.Context;
import android.view.Gravity;

/**
 * 启动页面
 *
 * @author zhengxiaobin@xiaoyouzi.com
 * @since 17/6/13 下午3:26
 */
public class Settings {

    private static final int DEFAULT_BEE_SIZE = 80;

    private Context context;
    /**
     * 默认位置： 右下角
     */
    private int gravity = Gravity.END | Gravity.BOTTOM;
    private int beeSize = DEFAULT_BEE_SIZE;
    private int[] beeMargin = {0, 0, 0, 200};

    public Settings(Context context) {
        this.context = context;
    }

    public Settings setBeePosition(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public Settings setBeeMargin(int left, int top, int right, int bottom) {
        this.beeMargin = new int[]{left, top, right, bottom};
        return this;
    }

    public Settings setBeeSize(int size) {
        this.beeSize = size;
        return this;
    }

    public void inject(Class<?> config) {
        if (config == null) {
            throw new NullPointerException("config should not be null");
        }
        new Rocket(this).inject(config);
    }

    public Context getContext() {
        return context;
    }

    public int getGravity() {
        return gravity;
    }

    public int getBeeSize() {
        return beeSize;
    }

    public int[] getBeeMargin() {
        return beeMargin;
    }
}
