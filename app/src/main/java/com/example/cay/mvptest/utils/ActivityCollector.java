package com.example.cay.mvptest.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/** Activity的管理器
 * Created by Cay-chen on 2017/3/25.
 */

public class ActivityCollector {
    //存储Activity的List
    public static List<Activity> activities = new ArrayList<>();

    //添加Activity
    public static void addActivity(Activity activity) {
        if (activity != null) {
            activities.add(activity);
        }
    }

    //移除Activity
    public static void removieActivity(Activity activity) {
        if (activity != null) {
            activities.remove(activity);
        }
    }

    //销毁所有Activity
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }
}
