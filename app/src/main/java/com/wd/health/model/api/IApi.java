package com.wd.health.model.api;

import com.wd.health.model.bean.BannerBean;

import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.CollectBean;
import com.wd.health.model.bean.Commentbean;
import com.wd.health.model.bean.LogainBean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.RegisterBean;
import com.wd.health.model.bean.VideoCommentList;
import com.wd.health.model.bean.Video_TablayoutResultBean;

import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;
import com.wd.health.model.bean.Videobuybean;
import com.wd.health.model.bean.YanZhengMaBean;
import com.wd.health.utils.CommonSchedulers;


import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


import retrofit2.http.Query;

import retrofit2.http.QueryMap;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:05
 */
public interface IApi {

   @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> login(@QueryMap Map<String, Object> map);

    //banner轮播
    @GET("share/v1/bannersShow")
    Observable<BannerBean> banner();


    @GET("user/video/v1/findVideoCategoryList")
    Observable<Video_TablayoutResultBean> tablyList();

    @GET("user/video/v1/findVideoVoList")
    @Headers({"userId:91145","sessionId:1581151729091145"})
    Observable<ChaXunShiPin_ResutBean> chaXun_Vidio(@QueryMap Map<String, Object> map);

    //科室列表
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<DepartmentsBean> depar();

    //病友圈列表
    @GET("user/sickCircle/v1/findSickCircleList")
    Observable<SickCircleListBean> sick(@QueryMap Map<String, String> map);

    //关键词查询病友圈
    @GET("user/sickCircle/v1/searchSickCircle")
    Observable<SearchSickCircleBean> circle(@Query("keyWord") String keyWord);

    //查询病友圈详情
    //http://172.17.8.100/health/user/sickCircle/v1/findSickCircleInfo?sickCircleId=4
    @GET("health/user/sickCircle/v1/findSickCircleInfo")
    Observable<SickCircleInfoBean> getSickCircleInfo(@Query("sickCircleId") Integer sickCircleId);
    //视频收藏的接口
    @POST("user/video/verify/v1/addUserVideoCollection")
    @Headers({"userId:58145","sessionId:1582427298358145"})
    Observable<CollectBean> colleCtion(@Header("userId") Integer userid, @Header("sessionId") String sessionid, @QueryMap Map<String, Object> map);
    //视频弹幕
   @POST("user/video/verify/v1/addVideoComment")
   @Headers({"userId:58145","sessionId:1582427298358145"})
   Observable<Commentbean> comment(@QueryMap Map<String, Object> map);

   //视频的购买
   @POST("user/video/verify/v1/videoBuy")
   @Headers({"userId:58145","sessionId:1582427298358145"})
   Observable<Videobuybean> buy(@QueryMap Map<String, Object> map);


   //查询视频的评论
   @GET("user/video/v1/findVideoCommentList")

   Observable<VideoCommentList> commentList(@Query("videoId") Integer id);

    @POST("user/v1/sendOutEmailCode")

    Observable<YanZhengMaBean> yanZhengMa(@Query("email") String mail);

    @POST("user/v1/register")
    Observable<RegisterBean> register(@QueryMap Map<String, String> map);

    @POST("user/v1/login")
    Observable<LogainBean> logainBean(@QueryMap Map<String, String> map);
}
