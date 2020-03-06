package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.homeBean.BannerBean;
import com.wd.health.model.bean.homeBean.HomeSuoSouBean;
import com.wd.health.model.bean.homeBean.JKZXBean;
import com.wd.health.model.bean.homeBean.JKZiXunListBean;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.contract
 * @ClassName: BannerContract
 * @Description: java类作用描述  Home 页面Banner 契约类
 * @Author: jialiang
 * @CreateDate: 2020/1/8 19:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 19:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface IBannerContract {
    //banner
    interface IView extends IBaseView {
        void onBannerSuccess(BannerBean bannerBean);
        void onBannerFailure(Throwable e);
        //搜索
        void onSousuoSuccess(HomeSuoSouBean homeSuoSouBean);
        void onSousuoFailure(Throwable e);

        //健康咨询
        void onJKZiXunSuccess(JKZXBean jkzxBean);
        void  onJKZiXunFailure(Throwable e);

        //健康咨询列表
        void onZiXunSuccess(JKZiXunListBean jkZiXunListBean);
        void onZiXunFailure(Throwable e);


    }
    //banner
    interface IModel{
        void banner(IModelBack iModelBack);
        interface IModelBack{
            void onBannerSuccess(BannerBean bannerBean);
            void onBannerFailure(Throwable e);
        }
        //搜索
        void homeSouSuo(String keyWord, ISousuoModelBack iModelBack);
        interface ISousuoModelBack{
            void onSouSuoSuccess(HomeSuoSouBean homeSuoSouBean);
            void onSuosouFailure(Throwable e);
        }
        //健康咨询
        void zixun(IZXModelBack izxModelBack);
        interface IZXModelBack{
            void onZXSuccess(JKZXBean jkzxBean);
            void onZXFailure(Throwable e);
        }

        //健康咨询列表
        void zixunList(int plateId, int page, int count, IZXListModelBack iModelBack);
        interface IZXListModelBack{
            void onZXListSuccess(JKZiXunListBean jkZiXunListBean);
            void onZXListFailure(Throwable e);
        }


    }


    interface IPresenter{
        void banner();
        void homeSouSuo(String keyWord);
        void zixuna();
        void zixunList(int plateId, int page, int count);
    }
}


//interface IView extends IBaseView{
//    void onBannerSuccess(BannerBean bannerBean);
//    void onBannerFailure(Throwable e);
//}
//
//interface IModel{
//    void banner(BannerContract.IModel.IModelBack iModelBack);
//
//    void banner(IBannerContract.IModel.IModelBack iModelBack);
//
//    interface IModelBack{
//        void onBannerSuccess(BannerBean bannerBean);
//        void onBannerFailure(Throwable e);
//    }
//}
//
//interface IPresenter{
//    void banner();
//}