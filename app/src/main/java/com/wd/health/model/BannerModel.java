package com.wd.health.model;

import com.wd.health.contract.IBannerContract;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.homeBean.BannerBean;
import com.wd.health.model.bean.homeBean.HomeSuoSouBean;
import com.wd.health.model.bean.homeBean.JKZXBean;
import com.wd.health.model.bean.homeBean.JKZiXunListBean;
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
public class BannerModel implements IBannerContract.IModel {


//    @Override
//    public void banner(IBannerContract.IModel.IModelBack iModelBack) {
//        RetrofitManager.getInstance().create(IApi.class)
//                .banner()
//                .compose(CommonSchedulers.io2main())
//                .subscribe(new CommonObserver<BannerBean>() {
//                    @Override
//                    public void onNext(BannerBean bannerBean) {
//                        iModelBack.onBannerSuccess(bannerBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        iModelBack.onBannerFailure(e);
//                    }
//                });
//    }

    @Override
    public void banner(IModelBack iModelBack) {

    }

    @Override
    public void homeSouSuo(String keyWord, ISousuoModelBack iModelBack) {

    }

    @Override
    public void zixun(IZXModelBack izxModelBack) {

    }

    @Override
    public void zixunList(int plateId, int page, int count, IZXListModelBack iModelBack) {

    }

//    @Override
//    public void homeSouSuo(String keyWord, ISousuoModelBack iModelBack) {
//        RetrofitManager.getInstance().create(IApi.class)
//                .homePageSearch(keyWord)
//                .compose(CommonSchedulers.io2main())
//                .subscribe(new CommonObserver<HomeSuoSouBean>() {
//                    @Override
//                    public void onNext(HomeSuoSouBean homeSuoSouBean) {
//                        iModelBack.onSouSuoSuccess(homeSuoSouBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        iModelBack.onSuosouFailure(e);
//                    }
//
//                });
//    }
//    //健康咨询
//    @Override
//    public void zixun(IZXModelBack izxModelBack) {
//        RetrofitManager.getInstance().create(IApi.class)
//                .findInformationPlateList()
//                .compose(CommonSchedulers.io2main())
//                .subscribe(new CommonObserver<JKZXBean>() {
//                    @Override
//                    public void onNext(JKZXBean jkzxBean) {
//                        izxModelBack.onZXSuccess(jkzxBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        izxModelBack.onZXFailure(e);
//                    }
//                });
//
//
//    }
//    //健康咨询列表
//    @Override
//    public void zixunList(int plateId, int page, int count, IZXListModelBack iModelBack) {
//        RetrofitManager.getInstance().create(IApi.class)
//                .findInformationList(plateId,page,count)
//                .compose(CommonSchedulers.io2main())
//                .subscribe(new CommonObserver<JKZiXunListBean>() {
//                    @Override
//                    public void onNext(JKZiXunListBean jkZiXunListBean) {
//                        iModelBack.onZXListSuccess(jkZiXunListBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        iModelBack.onZXListFailure(e);
//                    }
//                });
//    }



}
