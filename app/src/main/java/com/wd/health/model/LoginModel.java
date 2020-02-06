package com.wd.health.model;

import com.wd.health.contract.ILoginContract;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

import java.util.Map;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:06
 */
public class LoginModel implements ILoginContract.IModel {


    @Override
    public void login(Map<String, Object> paramsMap, IModelCallback callback) {
        RetrofitManager.getInstance().create()
                .login(paramsMap)
                .compose(CommonSchedulers.<LoginBean>io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        callback.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginFailure(e);
                    }
                });


    }
}
