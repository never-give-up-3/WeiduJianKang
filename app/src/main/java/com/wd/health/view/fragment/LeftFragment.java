package com.wd.health.view.fragment;

//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.view.ViewPager;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.bumptech.glide.Glide;
//import com.wd.health.R;
//import com.wd.health.app.App;
//import com.wd.health.base.BaseFragment;
//import com.wd.health.base.CeShiFragment;
//import com.wd.health.model.bean.BannerBean;
//import com.wd.health.presenter.BannerPresenter;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.Unbinder;

//
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.wd.health.R;
import com.wd.health.adapter.FragMentAdapter;
import com.wd.health.app.App;
import com.wd.health.base.BaseFragment;
import com.wd.health.contract.IBannerContract;
import com.wd.health.model.bean.homeBean.BannerBean;
import com.wd.health.model.bean.homeBean.HomeSuoSouBean;
import com.wd.health.model.bean.homeBean.JKZXBean;
import com.wd.health.model.bean.homeBean.JKZiXunListBean;
import com.wd.health.presenter.BannerPresenter;
import com.wd.health.view.activity.HomeSousuoActivity;
import com.wd.health.view.fragment.homeFragMent.JiBingFragMent;
import com.wd.health.view.fragment.homeFragMent.JianFeiFragMent;
import com.wd.health.view.fragment.homeFragMent.MeiRongFragMent;
import com.wd.health.view.fragment.homeFragMent.MeiShiFragMent;
import com.wd.health.view.fragment.homeFragMent.YangShengFragMent;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;





//        extends CeShiFragment
public class LeftFragment extends BaseFragment<BannerPresenter> implements IBannerContract.IView {

    @BindView(R.id.home_img)
    ImageView homeImg;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.home_xbanner)
    XBanner homeXbanner;

    Unbinder unbinder;
    @BindView(R.id.home_tab)
    TabLayout homeTab;
    @BindView(R.id.home_pager)
    ViewPager homePager;
    Unbinder unbinder1;
    //健康咨询

    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.left;
    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {

        if (bannerBean.getStatus().equals("0000")) {
//            Toast.makeText(getContext(), "banner:"+bannerBean.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("left", "banner:" + bannerBean.getMessage());
            homeXbanner.setData(bannerBean.getResult(), null);
            homeXbanner.setmAutoPlayAble(true);
            // 缩小本页，同时放大另一页
            homeXbanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
//                    DraweeController controller = Fresco.newDraweeControllerBuilder()
//                            .setUri(bannerBean.getResult().get(position).getImageUrl())
//                            .setAutoPlayAnimations(true)
//                            .build();
                    Glide.with(App.getAppContext()).load(bannerBean.getResult().get(position).getImageUrl()).into((ImageView) view);
                }
            });
            homeXbanner.setPageTransformer(Transformer.Cube);    //立体旋转
            homeXbanner.setPointsIsVisible(false);
            // 设置XBanner页面切换的时间，即动画时长
            homeXbanner.setPageChangeDuration(1000);
        }
    }

    @Override
    public void onBannerFailure(Throwable e) {
//        Toast.makeText(getContext(), "失败banner:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("left", "失败banner:" + e.getMessage());
    }

    @Override
    protected void initView() {
        super.initView();
    }


    //逻辑
    @Override
    protected void initData() {
        super.initData();
        //banner 绑定p层和v层
        mPresenter.banner();
        mPresenter.zixuna();
        mPresenter.zixunList(1,1,5);
        searchEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), HomeSousuoActivity.class));

                mPresenter.homeSouSuo("医生");

            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        providePresenter().banner();
        unbinder.unbind();
    }

    //搜索
    @Override
    public void onSousuoSuccess(HomeSuoSouBean homeSuoSouBean) {
        Toast.makeText(getContext(), "错误" + homeSuoSouBean.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("left", "错误" + homeSuoSouBean.getMessage());

    }

    @Override
    public void onSousuoFailure(Throwable e) {
        Toast.makeText(getContext(), "错误" + e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("left", "错误" + e.getMessage());



    }
    //健康咨询
    @Override
    public void onJKZiXunSuccess(JKZXBean jkzxBean) {
        //健康咨询
        ArrayList<Fragment> frag = new ArrayList<>();

        YangShengFragMent yangShengFragMent = new YangShengFragMent();
        JianFeiFragMent jianFeiFragMent = new JianFeiFragMent();
        MeiShiFragMent meiShiFragMent = new MeiShiFragMent();
        MeiRongFragMent meiRongFragMent = new MeiRongFragMent();
        JiBingFragMent jiBingFragMent = new JiBingFragMent();

        frag.add(yangShengFragMent);
        frag.add(jianFeiFragMent);
        frag.add(meiShiFragMent);
        frag.add(meiRongFragMent);
        frag.add(jiBingFragMent);

        FragMentAdapter fragMentAdapter = new FragMentAdapter(getChildFragmentManager(),frag);
        homePager.setAdapter(fragMentAdapter);

        for (int i = 0; i < 5; i++) {
            homeTab.addTab(homeTab.newTab());
        }

        homeTab.setupWithViewPager(homePager);

        homeTab.getTabAt(0).setText(jkzxBean.getResult().get(0).getName());
        homeTab.getTabAt(1).setText(jkzxBean.getResult().get(1).getName());
        homeTab.getTabAt(2).setText(jkzxBean.getResult().get(2).getName());
        homeTab.getTabAt(3).setText(jkzxBean.getResult().get(3).getName());
        homeTab.getTabAt(4).setText(jkzxBean.getResult().get(4).getName());


        Toast.makeText(getContext(), "健康咨询正确" + jkzxBean.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("left", "健康咨询正确" + jkzxBean.getMessage());


    }

    @Override
    public void onJKZiXunFailure(Throwable e) {
        Toast.makeText(getContext(), "健康咨询错误" + e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("left", "健康咨询错误" + e.getMessage());
    }

    //健康咨询列表
    @Override
    public void onZiXunSuccess(JKZiXunListBean jkZiXunListBean) {

    }

    @Override
    public void onZiXunFailure(Throwable e) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
