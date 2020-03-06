package com.wd.health.contract;


import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.LogainBean;
import com.wd.health.model.bean.RegisterBean;
import com.wd.health.model.bean.YanZhengMaBean;

import java.util.Map;

public interface RegisterContracts {
    interface IView extends IBaseView {
        void onRegisterSuccess(YanZhengMaBean bannerBean);
        void onBannerFailure(Throwable e);

        void onZhuce(RegisterBean registerBean);
        void onFanial(Throwable e);


        void onLogain(LogainBean logainBean);
        void onFanials(Throwable e);
    }

    interface IModel{
        void yanzheng(String email, IModelBack iModelBack);

        interface IModelBack{
            void onRegisterSuccess(YanZhengMaBean bannerBean);
            void onBannerFailure(Throwable e);

        }

        void zhuce(Map<String, String> map, toZhuce iModelBack);
        interface toZhuce{
            void onZhuce(RegisterBean registerBean);
            void onFanial(Throwable e);
        }

        void logain(Map<String, String> map, toLogain toLogain);
        interface toLogain{
            void onZhuce(LogainBean logainBean);
            void onFanial(Throwable e);
        }



    }

    interface IPresenter{
        void yanzheng(String email);
        void zhuce(Map<String, String> map);
        void logain(Map<String, String> map);
    }
}
