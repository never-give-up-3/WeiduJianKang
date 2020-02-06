package com.wd.health.model;

import com.wd.health.contract.BannerContract;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.BannerBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

import io.reactivex.Observable;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.model
 * @ClassName: BannerModel
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/8 19:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 19:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BannerModel implements BannerContract.IModel {
    @Override
    public void banner(IModelBack iModelBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .banner()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        iModelBack.onBannerSuccess(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                          iModelBack.onBannerFailure(e);
                    }
                });
    }
}
