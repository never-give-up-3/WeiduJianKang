package com.wd.health.presenter;

import com.wd.health.app.Constant;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.BannerContract;
import com.wd.health.model.BannerModel;
import com.wd.health.model.bean.BannerBean;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.presenter
 * @ClassName: BannerPresenter
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/8 19:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 19:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BannerPresenter extends BasePresenter<BannerContract.IView> implements BannerContract.IPresenter {

    private BannerModel bannerModel;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
    }

    @Override
    public void banner() {
      bannerModel.banner(new BannerContract.IModel.IModelBack() {
          @Override
          public void onBannerSuccess(BannerBean bannerBean) {
              if (isViewAttached()) {
                  if (bannerBean != null && Constant.SUCCESS_CODE.equals(bannerBean.getStatus())) {
                      getView().onBannerSuccess(bannerBean);
                  } else {
                      getView().onBannerFailure(new Exception("服务器异常"));
                  }
              }
          }

          @Override
          public void onBannerFailure(Throwable e) {
              if (isViewAttached()) {
                  getView().onBannerFailure(e);
              }
          }
      });
    }
}
