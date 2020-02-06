package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.BannerBean;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.contract
 * @ClassName: BannerContract
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/8 19:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 19:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BannerContract {

    interface IView extends IBaseView{
        void onBannerSuccess(BannerBean bannerBean);
        void onBannerFailure(Throwable e);
    }

    interface IModel{
        void banner(IModelBack iModelBack);
        interface IModelBack{
            void onBannerSuccess(BannerBean bannerBean);
            void onBannerFailure(Throwable e);
        }
    }

    interface IPresenter{
        void banner();
    }
}
