package com.wd.health.model;

import com.wd.health.contract.Video_CategoryListContract;
import com.wd.health.model.api.IApi;
import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.CollectBean;
import com.wd.health.model.bean.Commentbean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.VideoCommentList;
import com.wd.health.model.bean.Video_TablayoutResultBean;
import com.wd.health.model.bean.Videobuybean;
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

    //视频收藏的
    @Override
    public void colleCtion(Integer id,String session,Map<String,Object> map, CollectioncallBack collectioncallBack) {
        RetrofitManager.getInstance().create()
                .colleCtion(id,session,map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CollectBean>() {
                    @Override
                    public void onNext(CollectBean collectBean) {
                        collectioncallBack.collectionSucceed(collectBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                       collectioncallBack.collectionFailure(e);
                    }
                });
    }
    //视频的弹幕
    @Override
    public void comment(Map<String, Object> map, Comments comments) {
        RetrofitManager.getInstance().create()
               .comment(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<Commentbean>() {
                    @Override
                    public void onNext(Commentbean commentbean) {
                        comments.commentSucceed(commentbean);
                    }

                    @Override
                    public void onError(Throwable e) {
                       comments.commentFailure(e);
                    }
                });
    }
//视频的购买
    @Override
    public void vidioBuy(Map<String, Object> map, Vidiobuy comments) {
        RetrofitManager.getInstance().create()
                .buy(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<Videobuybean>() {
                    @Override
                    public void onNext(Videobuybean videobuybean) {
                        comments.videobuySucceed(videobuybean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        comments.videobuyFailure(e);
                    }
                });
    }

    @Override
    public void commentList(Integer id, CommentList commentList) {
        RetrofitManager.getInstance().create()
                .commentList(id)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<VideoCommentList>() {
                    @Override
                    public void onNext(VideoCommentList videoCommentList) {
                        commentList.commentListSucceed(videoCommentList);
                    }

                    @Override
                    public void onError(Throwable e) {
                      commentList.commentListFailure(e);
                    }
                });
    }
}
