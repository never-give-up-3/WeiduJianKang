package com.wd.health.contract;

import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.CollectBean;
import com.wd.health.model.bean.Commentbean;
import com.wd.health.model.bean.VideoCommentList;
import com.wd.health.model.bean.Video_TablayoutResultBean;
import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.Videobuybean;

import java.util.Map;

public interface Video_CategoryListContract {
    interface Video_CategoryView extends IBaseView {

        void succeed(Video_TablayoutResultBean video_tablayoutResultBean);
        void failure(Throwable throwable);

        void onChaXunShiPinSuccess(ChaXunShiPin_ResutBean chaXunShiPin_resutBean);
        void onChaXunShiPinFailure(Throwable e);

        //视频收藏的
        void collectionSucceed(CollectBean collectBean);
        void collectionFailure(Throwable throwable);

        //视频弹幕
        void commentSucceed(Commentbean comment);
        void commentFailure(Throwable throwable);

        //视频的购买
        void videobuySucceed(Videobuybean videobuybean);
        void videobuyFailure(Throwable throwable);

        //查询视频的评论
        void commentListSucceed(VideoCommentList videoCommentList);
        void commentListFailure(Throwable throwable);
    }

    //model层的
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

        //视频收藏的m层
        void colleCtion(Integer id,String session,Map<String,Object> map,CollectioncallBack collectioncallBack );
        interface  CollectioncallBack{
            void collectionSucceed(CollectBean collectBean);
            void collectionFailure(Throwable throwable);
        }

        //视频弹幕
        void comment(Map<String,Object> map,Comments comments);
        interface  Comments{
            void commentSucceed(Commentbean comment);
            void commentFailure(Throwable throwable);
        }

        //视频的购买
        void vidioBuy(Map<String,Object> map, Vidiobuy comments);
        interface  Vidiobuy{
            void videobuySucceed(Videobuybean videobuybean);
            void videobuyFailure(Throwable throwable);
        }

        //查询视频评论列表
        void commentList(Integer id,CommentList commentList);
        interface CommentList{
            void commentListSucceed(VideoCommentList videoCommentList);
            void commentListFailure(Throwable throwable);
        }
    }

    //p层的
    interface Video_CategoryPresent{
        void categoryListShow();
        void chaXun(Map<String,Object> map);
        //视频收藏的m层
        void colleCtion(Integer id,String session,Map<String,Object> map);
        //视频弹幕
        void comment(Map<String,Object> map);
        //视频的购买
        void vidioBuy(Map<String,Object> map);

        //视频评论列表的查询
        void commentList(Integer id);
    }
}
