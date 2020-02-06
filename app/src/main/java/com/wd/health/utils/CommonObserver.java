package com.wd.health.utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:09
 */

/**
 * 使用规范：
 * 使用 {@link CommonObserver} 代替 Observer，
 * 可以避免创建 {@link Observer} 对象强制重写 onSubscribe() 和 onComplete()方法，简化代码
 */

public abstract class CommonObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }

}


