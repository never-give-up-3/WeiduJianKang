package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;

import java.util.Map;

/**
 * @ProjectName: WDHealth
 * @Package: com.wd.health.contract
 * @ClassName: BingContract
 * @Description: java类作用描述
 * @Author: jialiang
 * @CreateDate: 2020/1/9 10:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 10:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BingContract {
    interface IView extends IBaseView{
        void DeparSuccess(DepartmentsBean departmentsBean);
        void DeparFailure(Throwable e);

        void SickSuccess(SickCircleListBean sickCircleListBean);
        void SickFailure(Throwable e);

        void CircleSuccess(SearchSickCircleBean searchSickCircleBean);
        void CircleFailure(Throwable e);

        void SickInfoSuccess(SickCircleInfoBean sickCircleInfoBean);
        void SickInfoFailure(Throwable e);
    }

    interface IModel{
        void Depar(IModelCall iModelCall);
        interface IModelCall{
            void DeparSuccess(DepartmentsBean departmentsBean);
            void DeparFailure(Throwable e);
        }
        void Sick(Map<String,String> map,SModelCall sModelCall );
        interface SModelCall{
            void SickSuccess(SickCircleListBean sickCircleListBean);
            void SickFailure(Throwable e);
        }
        void Circle(String keyWord,CModelCall cModelCall);
        interface CModelCall{
            void CircleSuccess(SearchSickCircleBean searchSickCircleBean);
            void CircleFailure(Throwable e);
        }

        void SickInfo(Integer sickCircleId,FModelCall fModelCall);
        interface FModelCall{
            void SickInfoSuccess(SickCircleInfoBean sickCircleInfoBean);
            void SickInfoFailure(Throwable e);
        }
    }

    interface Presenter{
        void Depar();
        void Sick(Map<String,String> map);
        void Circle(String keyWord);
        void SickInfo(Integer sickCircleId);
    }
}
