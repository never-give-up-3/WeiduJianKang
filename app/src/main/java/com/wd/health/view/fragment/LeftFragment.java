package com.wd.health.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wd.health.R;
import com.wd.health.base.BaseFragment;
import com.wd.health.contract.RegisterContracts;
import com.wd.health.model.bean.LogainBean;
import com.wd.health.model.bean.LogainBeanResultBean;
import com.wd.health.model.bean.RegisterBean;
import com.wd.health.model.bean.YanZhengMaBean;
import com.wd.health.presenter.LoginPresenter;
import com.wd.health.utils.RsaCoder;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LeftFragment extends BaseFragment<LoginPresenter> implements RegisterContracts.IView {


    @BindView(R.id.txs)
    EditText txs;
    @BindView(R.id.buttons)
    Button buttons;
    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_yanzhengma)
    EditText registerYanzhengma;
    @BindView(R.id.register_pass1)
    EditText registerPass1;
    @BindView(R.id.register_pass2)
    EditText registerPass2;
    @BindView(R.id.register_tuijianma)
    EditText registerTuijianma;
    @BindView(R.id.button_zhuce)
    Button buttonZhuce;
    @BindView(R.id.logain_email)
    EditText logainEmail;
    @BindView(R.id.logain_pwd)
    EditText logainPwd;
    @BindView(R.id.logain_button)
    Button logainButton;
    Unbinder unbinder;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }
    @Override
    protected void initData() {
        super.initData();
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = txs.getText().toString();
                mPresenter.yanzheng(s);
            }
        });

        buttonZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("email", registerEmail.getText().toString());
                    map.put("code", registerYanzhengma.getText().toString());
                    String s = registerPass1.getText().toString();
                    String s1 = registerPass2.getText().toString();

                    Log.d("789", s);
                    Log.d("798", s1);
                    String p1 = RsaCoder.encryptByPublicKey(s);
                    String p2 = RsaCoder.encryptByPublicKey(s1);


                    map.put("pwd1", p1);
                    map.put("pwd2", p1);

                    map.put("invitationCode", registerTuijianma.getText().toString());
                    Log.d("m1", p1);
                    Log.d("m2", p2);
                    mPresenter.zhuce(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        logainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = logainEmail.getText().toString();
                String pwd = logainPwd.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                map.put("email",email);
                map.put("pwd",pwd);
                mPresenter.logain(map);
            }
        });
    }
    @Override
    protected int provideLayoutId() {
        return R.layout.left;
    }

    @Override
    public void onRegisterSuccess(YanZhengMaBean bannerBean) {

    }

    @Override
    public void onBannerFailure(Throwable e) {

    }

    @Override
    public void onZhuce(RegisterBean registerBean) {

    }

    @Override
    public void onFanial(Throwable e) {

    }

    @Override
    public void onLogain(LogainBean logainBean) {
        String message = logainBean.getMessage();

        EventBus.getDefault().post(logainBean);
        LogainBeanResultBean result = logainBean.getResult();

    }

    @Override
    public void onFanials(Throwable e) {

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
}
