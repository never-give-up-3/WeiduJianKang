package com.wd.health.presenter;

import com.wd.health.app.Constant;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.IBannerContract;
import com.wd.health.model.BannerModel;
import com.wd.health.model.bean.homeBean.BannerBean;
import com.wd.health.model.bean.homeBean.HomeSuoSouBean;
import com.wd.health.model.bean.homeBean.JKZXBean;
import com.wd.health.model.bean.homeBean.JKZiXunListBean;

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
public class BannerPresenter extends BasePresenter<IBannerContract.IView> implements IBannerContract.IPresenter {

    private BannerModel bannerModel;
//    private BannerModel homeSousuoModel;
//    private BannerModel izxListModelBack;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
//        homeSousuoModel = new Home

//        bannerModel = new BannerModel();
//        homeSousuoModel = new HomeSousuoModel();
//        izxListModelBack = new
    }

    @Override
    public void banner() {
        bannerModel.banner(new IBannerContract.IModel.IModelBack() {
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



    /*
    搜索
     */
    @Override
    public void homeSouSuo(String keyWord) {
//        bannerModel.homeSouSuo(keyWord,new IBannerContract.IModel.ISousuoModelBack());

        bannerModel.homeSouSuo(keyWord, new IBannerContract.IModel.ISousuoModelBack() {
            @Override
            public void onSouSuoSuccess(HomeSuoSouBean homeSuoSouBean) {
                if (isViewAttached()){  //不知道从何而来
                    if (homeSuoSouBean != null && Constant.SUCCESS_CODE.equals(homeSuoSouBean.getStatus())) {
                        getView().onSousuoSuccess(homeSuoSouBean);
                    } else {
                        getView().onSousuoFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onSuosouFailure(Throwable e) {

            }
        });
    }

    @Override
    public void zixuna() {
        //契约类里面的正确错误回调
        bannerModel.zixun(new IBannerContract.IModel.IZXModelBack() {
            @Override
            public void onZXSuccess(JKZXBean jkzxBean) {
                if (isViewAttached()){  //不知道从何而来
                    if (jkzxBean != null && Constant.SUCCESS_CODE.equals(jkzxBean.getStatus())) {
                        getView().onJKZiXunSuccess(jkzxBean);
                    } else {
                        getView().onJKZiXunFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onZXFailure(Throwable e) {

            }
        });

    }

    @Override
    public void zixunList(int plateId, int page, int count) {
        //契约类里面的正确错误回调
        bannerModel.zixunList(plateId,page,count, new IBannerContract.IModel.IZXListModelBack() {
            @Override
            public void onZXListSuccess(JKZiXunListBean jkZiXunListBean) {
                if (isViewAttached()){  //不知道从何而来
                    if (jkZiXunListBean != null && Constant.SUCCESS_CODE.equals(jkZiXunListBean.getStatus())) {
                        getView().onZiXunSuccess(jkZiXunListBean);
                    } else {
                        getView().onZiXunFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onZXListFailure(Throwable e) {

            }
        });
    }


//    @Override
//    protected void initModel() {
//        homeSousuoModel = new HomeSousuoModel();
////        bannerModel = new BannerModel();
//    }

//    @Override
//    public void banner() {
//      bannerModel.banner(new IBannerContract.IModel.IModelBack() {
//          @Override
//          public void onBannerSuccess(BannerBean bannerBean) {
//              if (isViewAttached()) {
//                  if (bannerBean != null && Constant.SUCCESS_CODE.equals(bannerBean.getStatus())) {
//                      getView().onBannerSuccess(bannerBean);
//                  } else {
//                      getView().onBannerFailure(new Exception("服务器异常"));
//                  }
//              }
//          }
//
//          @Override
//          public void onBannerFailure(Throwable e) {
//              if (isViewAttached()) {
//                  getView().onBannerFailure(e);
//              }
//          }
//      });
//    }

//    @Override
//    public void suosou(String keyWord) {
//        homeSousuoModel.homeSouSuo(keyWord, new HomeSuosouContract.IModel.IModelBack() {
//            @Override
//            public void onSouSuoSuccess(HomeSuoSouBean homeSuoSouBean) {
//                if (isViewAttached()){  //不知道从何而来
//                    if (homeSuoSouBean != null && Constant.SUCCESS_CODE.equals(homeSuoSouBean.getStatus())) {
//                        getView().onSousuoSuccess(homeSuoSouBean);
////                        getView().onBannerSuccess(bannerBean);
//                    } else {
//                        getView().onSousuoFailure(new Exception("服务器异常"));
////                      getView().onBannerFailure(new Exception("服务器异常"));
//                    }
//
//
//                }
//            }
//
//            @Override
//            public void onSuosouFailure(Throwable e) {
//
//            }
//        });
//
//    }





}
