package com.wd.health.presenter;

import com.wd.health.app.Constant;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.Video_CategoryListContract;
import com.wd.health.model.Video_CategoryListModel;
import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.Video_TablayoutResultBean;

import java.util.Map;

public class Video_CategoryListPresent extends BasePresenter<Video_CategoryListContract.Video_CategoryView> implements Video_CategoryListContract.Video_CategoryPresent {

    private Video_CategoryListModel video_categoryListModel;

    @Override
    protected void initModel() {
        video_categoryListModel = new Video_CategoryListModel();
    }

    @Override
    public void categoryListShow() {
        video_categoryListModel.categoryListShow(new Video_CategoryListContract.Video_CategoryModel.Video_Category() {
            @Override
            public void succeed(Video_TablayoutResultBean video_tablayoutResultBean) {
                if (isViewAttached()) {
                    if (video_tablayoutResultBean != null && Constant.SUCCESS_CODE.equals(video_tablayoutResultBean.getStatus())) {
                        getView().succeed(video_tablayoutResultBean);
                    } else {
                        getView().failure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void failure(Throwable throwable) {
                if (isViewAttached()) {
                    getView().failure(throwable);
                }
            }


        });
    }

    @Override
    public void chaXun(Map<String, Object> map) {
        video_categoryListModel.chaXun(map, new Video_CategoryListContract.Video_CategoryModel.IModelBack() {
            @Override
            public void onChaXunShiPinSuccess(ChaXunShiPin_ResutBean chaXunShiPin_resutBean) {
                if (isViewAttached()) {
                    if (chaXunShiPin_resutBean != null && Constant.SUCCESS_CODE.equals(chaXunShiPin_resutBean.getStatus())) {
                        getView().onChaXunShiPinSuccess(chaXunShiPin_resutBean);
                    } else {
                        getView().failure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onChaXunShiPinFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().failure(e);
                }
            }
        });
    }
}
