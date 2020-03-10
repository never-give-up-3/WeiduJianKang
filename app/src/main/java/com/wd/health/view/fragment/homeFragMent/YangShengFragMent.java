package com.wd.health.view.fragment.homeFragMent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wd.health.R;

/**
 * @Description: 类作用描述  健康养生
 * @Author: 高晨凯
 * @CreateDate: 2020/1/11 14:38
 */
public  class YangShengFragMent extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate( R.layout.home_zx_one, container, false);
        return inflate;
    }






}
