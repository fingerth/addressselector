package com.fingerth.jdaddressselector.util;

import java.util.List;

/**
 * ======================================================
 * Created by Administrator able_fingerth on 2017/9/4.
 * <p/>
 * 版权所有，违者必究！
 * <详情描述/>
 */
public class Lists {
    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean notEmpty(List list) {
        return list != null && list.size() > 0;
    }
}
