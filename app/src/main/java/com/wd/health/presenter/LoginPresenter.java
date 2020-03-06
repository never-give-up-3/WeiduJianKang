package com.wd.health.presenter;

import com.wd.health.app.Constant;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.RegisterContracts;
import com.wd.health.model.RegisterModel;
import com.wd.health.model.bean.LogainBean;
import com.wd.health.model.bean.RegisterBean;
import com.wd.health.model.bean.YanZhengMaBean;

import java.util.Map;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:17
 */

/**
 * 声明规范：
 * 1、命名规范为 "${业务模块}Presenter"  如：登录模块 Presenter 命名为 "LoginPresenter"
 * 2、必须指定泛型 V 的具体类型
 * 3、必须 implements 对应锲约中的 IPresenter 接口  如: {@link ILoginContract.IPresenter}
 * <p>
 * <p>
 * 使用规范：
 * 1、在 {@link #initModel()}方法中初始化Model
 * 2、调用 Model 中的的方法，并设置 {@link ILoginContract.IModel.IModelCallback}回调监听
 * 3、成功失败处，先调用 {@link #isViewAttached()} 判断是否挂载、然后才可以使用{@link #getView()}方法获取view，进行数据回调
 */

public class LoginPresenter extends BasePresenter<RegisterContracts.IView> implements RegisterContracts.IPresenter  {

    private RegisterModel registerModel;

    @Override
    protected void initModel() {
        registerModel = new RegisterModel();
    }


    @Override
    public void yanzheng(String email) {
        registerModel.yanzheng(email, new RegisterContracts.IModel.IModelBack() {
            @Override
            public void onRegisterSuccess(YanZhengMaBean bannerBean) {
                if (isViewAttached()) {
                    if (bannerBean != null && Constant.SUCCESS_CODE.equals(bannerBean.getStatus())) {
                        getView().onRegisterSuccess(bannerBean);
                    } else {
                        getView().onBannerFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onBannerFailure(Throwable e) {

            }


        });
    }

    @Override
    public void zhuce(Map<String, String> map) {
        registerModel.zhuce(map, new RegisterContracts.IModel.toZhuce() {
            @Override
            public void onZhuce(RegisterBean registerBean) {
                if (isViewAttached()) {
                    if (registerBean != null && Constant.SUCCESS_CODE.equals(registerBean.getStatus())) {
                        getView().onZhuce(registerBean);
                    } else {
                        getView().onBannerFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onFanial(Throwable e) {

            }
        });
    }

    @Override
    public void logain(Map<String, String> map) {
        registerModel.logain(map, new RegisterContracts.IModel.toLogain() {
            @Override
            public void onZhuce(LogainBean logainBean) {
                if (isViewAttached()) {
                    if (logainBean != null && Constant.SUCCESS_CODE.equals(logainBean.getStatus())) {
                        getView().onLogain(logainBean);
                    } else {
                        getView().onBannerFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onFanial(Throwable e) {

            }
        });
    }





}
