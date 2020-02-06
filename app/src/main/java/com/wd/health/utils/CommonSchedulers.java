package com.wd.health.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:08
 */

/**
 * 通用线程调度器
 * <p>
 * <p>
 * 使用规范：
 * 配合 {@link Observable} 的compose() 方法，来简化io和main线程切换
 */

public class CommonSchedulers {

    public static <T> ObservableTransformer<T, T> io2main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
