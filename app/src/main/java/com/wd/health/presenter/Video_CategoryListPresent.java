package com.wd.health.presenter;

import com.wd.health.app.Constant;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.Video_CategoryListContract;
import com.wd.health.model.Video_CategoryListModel;
import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.CollectBean;
import com.wd.health.model.bean.Commentbean;
import com.wd.health.model.bean.VideoCommentList;
import com.wd.health.model.bean.Video_TablayoutResultBean;
import com.wd.health.model.bean.Videobuybean;

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
    //收藏视频
    @Override
    public void colleCtion(Integer id,String session,Map<String,Object> map) {
        video_categoryListModel.colleCtion(id,session,map, new Video_CategoryListContract.Video_CategoryModel.CollectioncallBack() {
            @Override
            public void collectionSucceed(CollectBean collectBean) {
                if (isViewAttached()) {
                    if (collectBean != null && Constant.SUCCESS_CODE.equals(collectBean.getMessage())) {
                        getView().collectionSucceed(collectBean);
                    } else {
                        getView().failure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void collectionFailure(Throwable throwable) {
                if (isViewAttached()) {
                    getView().failure(throwable);
                }
            }
        });
    }
   //视频的弹幕
    @Override
    public void comment(Map<String, Object> map) {
        video_categoryListModel.comment(map, new Video_CategoryListContract.Video_CategoryModel.Comments() {
            @Override
            public void commentSucceed(Commentbean comment) {
                if (isViewAttached()) {
                    if (comment != null && Constant.SUCCESS_CODE.equals(comment.getMessage())) {
                       getView().commentSucceed(comment);
                    } else {
                        getView().failure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void commentFailure(Throwable throwable) {
                if (isViewAttached()) {
                    getView().failure(throwable);
                }
            }
        });
    }
   //视频的购买
    @Override
    public void vidioBuy(Map<String, Object> map) {
      video_categoryListModel.vidioBuy(map, new Video_CategoryListContract.Video_CategoryModel.Vidiobuy() {
          @Override
          public void videobuySucceed(Videobuybean videobuybean) {
              if (isViewAttached()) {
                  if (videobuybean != null && Constant.SUCCESS_CODE.equals(videobuybean.getMessage())) {
                      getView().videobuySucceed(videobuybean);
                  } else {
                      getView().failure(new Exception("服务器异常"));
                  }
              }
          }

          @Override
          public void videobuyFailure(Throwable throwable) {
              if (isViewAttached()) {
                  getView().failure(throwable);
              }
          }
      });


    }


    //查询视频的评论列表
    @Override
    public void commentList(Integer id) {
        video_categoryListModel.commentList(id, new Video_CategoryListContract.Video_CategoryModel.CommentList() {
            @Override
            public void commentListSucceed(VideoCommentList videoCommentList) {
                if (isViewAttached()) {
                    if (videoCommentList != null && Constant.SUCCESS_CODE.equals(videoCommentList.getMessage())) {
                        getView().commentListSucceed(videoCommentList);
                    } else {
                        getView().failure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void commentListFailure(Throwable throwable) {
                if (isViewAttached()) {
                    getView().failure(throwable);
                }
            }
        });
    }


}
