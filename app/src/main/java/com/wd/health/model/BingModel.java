package com.wd.health.model;

import com.wd.health.contract.BingContract;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.PublishBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

import java.util.Map;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.model
 * @ClassName: BingModel
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/9 10:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 10:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BingModel implements BingContract.IModel {
    @Override
    public void Depar(IModelCall iModelCall) {
        RetrofitManager.getInstance().create(IApi.class)
                .depar()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DepartmentsBean>() {
                    @Override
                    public void onNext(DepartmentsBean departmentsBean) {
                        iModelCall.DeparSuccess(departmentsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCall.DeparFailure(e);
                    }
                });
    }

    @Override
    public void Sick(Map<String, String> map, SModelCall sModelCall) {
        RetrofitManager.getInstance().create(IApi.class)
                .sick(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SickCircleListBean>() {
                    @Override
                    public void onNext(SickCircleListBean sickCircleListBean) {
                        sModelCall.SickSuccess(sickCircleListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        sModelCall.SickFailure(e);
                    }
                });
    }

    @Override
    public void Circle(String keyWord, CModelCall cModelCall) {
        RetrofitManager.getInstance().create(IApi.class)
                .circle(keyWord)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SearchSickCircleBean>() {
                    @Override
                    public void onNext(SearchSickCircleBean searchSickCircleBean) {
                        cModelCall.CircleSuccess(searchSickCircleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cModelCall.CircleFailure(e);
                    }
                });
    }

    @Override
    public void SickInfo(Integer sickCircleId, FModelCall fModelCall) {
        RetrofitManager.getInstance().create(IApi.class)
                .getSickCircleInfo(sickCircleId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SickCircleInfoBean>() {
                    @Override
                    public void onNext(SickCircleInfoBean sickCircleInfoBean) {
                        fModelCall.SickInfoSuccess(sickCircleInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        fModelCall.SickInfoFailure(e);
                    }
                });
    }

    @Override
    public void Publish(Integer userId, String sessionId, Integer sickCircleId, String content, PModelCall pModelCall) {
        RetrofitManager.getInstance().create(IApi.class)
                .getpublish(userId, sessionId, sickCircleId, content)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PublishBean>() {
                    @Override
                    public void onNext(PublishBean publishBean) {
                        pModelCall.PublishSuccess(publishBean);
                    }

                    @Override
                    public void onError(Throwable e) {
pModelCall.PublishFailure(e);
                    }
                });
    }
}
