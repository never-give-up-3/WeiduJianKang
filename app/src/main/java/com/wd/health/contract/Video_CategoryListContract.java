package com.wd.health.contract;

import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.Video_TablayoutResultBean;
import com.wd.health.base.IBaseView;

import java.util.Map;

public interface Video_CategoryListContract {
    interface Video_CategoryView extends IBaseView {

        void succeed(Video_TablayoutResultBean video_tablayoutResultBean);
        void failure(Throwable throwable);

        void onChaXunShiPinSuccess(ChaXunShiPin_ResutBean chaXunShiPin_resutBean);
        void onChaXunShiPinFailure(Throwable e);
    }
    interface Video_CategoryModel{
        void categoryListShow(Video_Category video_category);

        interface Video_Category{
            void succeed(Video_TablayoutResultBean video_tablayoutResultBean);
            void failure(Throwable throwable);
        }
        void chaXun(Map<String,Object> map, Video_CategoryListContract.Video_CategoryModel.IModelBack iModelBack);
        interface IModelBack{
            void onChaXunShiPinSuccess(ChaXunShiPin_ResutBean chaXunShiPin_resutBean);
            void onChaXunShiPinFailure(Throwable e);
        }
    }
    interface Video_CategoryPresent{
        void categoryListShow();
        void chaXun(Map<String,Object> map);
    }
}
