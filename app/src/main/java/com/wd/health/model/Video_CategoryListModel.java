package com.wd.health.model;

import com.wd.health.contract.Video_CategoryListContract;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.Video_TablayoutResultBean;
import com.wd.health.utils.CommonObserver;
import com.wd.health.utils.CommonSchedulers;
import com.wd.health.utils.RetrofitManager;

import java.util.Map;

public class Video_CategoryListModel implements Video_CategoryListContract.Video_CategoryModel {
    @Override
    public void categoryListShow(Video_Category video_category) {
        RetrofitManager.getInstance().create()
                .tablyList()
                .compose(CommonSchedulers.<Video_TablayoutResultBean>io2main())
                .subscribe(new CommonObserver<Video_TablayoutResultBean>() {
                    @Override
                    public void onNext(Video_TablayoutResultBean video_tablayoutResultBean) {
                        video_category.succeed(video_tablayoutResultBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        video_category.failure(e);
                    }

                });
    }

    @Override
    public void chaXun(Map<String, Object> map, IModelBack iModelBack) {
        RetrofitManager.getInstance().create()
                .chaXun_Vidio(map)
                .compose(CommonSchedulers.<ChaXunShiPin_ResutBean>io2main())
                .subscribe(new CommonObserver<ChaXunShiPin_ResutBean>() {
                    @Override
                    public void onNext(ChaXunShiPin_ResutBean chaXunShiPin_resutBean) {
                        iModelBack.onChaXunShiPinSuccess(chaXunShiPin_resutBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                           iModelBack.onChaXunShiPinFailure(e);
                    }
                });
    }
}
