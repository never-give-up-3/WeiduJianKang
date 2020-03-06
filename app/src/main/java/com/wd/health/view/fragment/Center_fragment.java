package com.wd.health.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.health.R;
import com.wd.health.adapter.DeparAdapter;
import com.wd.health.adapter.SeachAdapter;
import com.wd.health.adapter.SickAdapter;
import com.wd.health.base.BaseFragment;
import com.wd.health.contract.BingContract;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.PublishBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;
import com.wd.health.presenter.BingPresenter;
import com.wd.health.view.activity.DetailsActivity;
import com.wd.health.view.activity.SickCircleInfoActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Center_fragment extends BaseFragment<BingPresenter> implements BingContract.IView {

    @BindView(R.id.keshi)
    TextView keshi;
    @BindView(R.id.tv_shou)
    TextView tvShou;
    @BindView(R.id.b_Klie)
    RecyclerView bKlie;
    @BindView(R.id.circle_img_search)
    ImageView circleImgSearch;
    @BindView(R.id.b_Plie)
    RecyclerView bPlie;
    Unbinder unbinder;
    private DeparAdapter deparAdapter;
    private SickAdapter sickAdapter;


    @Override
    protected BingPresenter providePresenter() {
        return new BingPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.center;
    }

    @Override
    public void DeparSuccess(DepartmentsBean departmentsBean) {
        List<DepartmentsBean.ResultBean> result = departmentsBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bKlie.setLayoutManager(linearLayoutManager);
        Log.d("sss", result.get(0).getDepartmentName());
        deparAdapter = new DeparAdapter(getActivity(), result);
        bKlie.setAdapter(deparAdapter);
        deparAdapter.setLiangId(new DeparAdapter.liangId() {
            @Override
            public void liang(String s, int id) {
                HashMap<String, String> map = new HashMap<>();
                map.put("departmentId", String.valueOf(id));
                map.put("page", "2");
                map.put("count", "5");
                mPresenter.Sick(map);
                keshi.setText(s);
            }
        });

    }

    @Override
    public void DeparFailure(Throwable e) {

    }

    @Override
    public void SickSuccess(SickCircleListBean sickCircleListBean) {
        List<SickCircleListBean.ResultBean> result = sickCircleListBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bPlie.setLayoutManager(linearLayoutManager);
        Log.d("aaa", result.get(0).getTitle());
        sickAdapter = new SickAdapter(getActivity(), result);
        bPlie.setAdapter(sickAdapter);
        sickAdapter.setItemOnClick(new SeachAdapter.ItemOnClick() {
            @Override
            public void onitem(int p) {
                Intent intent = new Intent(getActivity(), SickCircleInfoActivity.class);
                intent.putExtra("sickCircleId", p);
                startActivity(intent);
            }
        });
    }

    @Override
    public void SickFailure(Throwable e) {

    }

    @Override
    public void CircleSuccess(SearchSickCircleBean searchSickCircleBean) {

    }

    @Override
    public void CircleFailure(Throwable e) {

    }

    @Override
    public void SickInfoSuccess(SickCircleInfoBean sickCircleInfoBean) {

    }

    @Override
    public void SickInfoFailure(Throwable e) {

    }

    @Override
    public void PublishSuccess(PublishBean publishBean) {

    }

    @Override
    public void PublishFailure(Throwable e) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.Depar();
        HashMap<String, String> map = new HashMap<>();
        map.put("departmentId", "2");
        map.put("page", "2");
        map.put("count", "5");
        mPresenter.Sick(map);
        circleImgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });
        tvShou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });
    }


}
