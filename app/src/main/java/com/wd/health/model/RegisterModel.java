package com.wd.health.model;

import android.util.Log;


import com.wd.health.contract.RegisterContracts;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.LogainBean;
import com.wd.health.model.bean.RegisterBean;
import com.wd.health.model.bean.YanZhengMaBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

import java.util.Map;



public class RegisterModel implements RegisterContracts.IModel {
    @Override
    public void yanzheng(String emails, final IModelBack iModelBack) {
        Log.d("456789",emails);
        RetrofitManager.getInstance().create(IApi.class)
                .yanZhengMa(emails)
                .compose(CommonSchedulers.<YanZhengMaBean>io2main())
                .subscribe(new CommonObserver<YanZhengMaBean>() {
                    @Override
                    public void onNext(YanZhengMaBean yanZhengMaBean) {
                         iModelBack.onRegisterSuccess(yanZhengMaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                         iModelBack.onBannerFailure(e);
                        Log.d("123",e.getMessage());
                    }
                });
    }

    @Override
    public void zhuce(Map<String, String> map, toZhuce iModelBack) {
        String email = (String) map.get("email");
        String code = (String) map.get("code");
        String pwd1 = (String) map.get("pwd1");
        String pwd2 = (String) map.get("pwd2");

        String invitationCode = (String) map.get("invitationCode");
        Log.d("11111",email);
        Log.d("12222",code);
        Log.d("33333",pwd2);
        Log.d("44444",pwd1);
        Log.d("55555",invitationCode);
        RetrofitManager.getInstance().create(IApi.class)
                .register(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iModelBack.onZhuce(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelBack.onFanial(e);
                    }
                });
    }

    @Override
    public void logain(Map<String, String> map, toLogain toLogain) {
        RetrofitManager.getInstance().create(IApi.class)
                .logainBean(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<LogainBean>() {
                    @Override
                    public void onNext(LogainBean logainBean) {
                        toLogain.onZhuce(logainBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        toLogain.onFanial(e);
                    }
                });
    }


}


