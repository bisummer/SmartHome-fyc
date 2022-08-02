package com.zhongyong.smarthome.fragment;

import android.view.View;
import android.widget.RelativeLayout;

import com.zhongyong.smarthome.R;
import com.zhongyong.smarthome.activity.MaintenanceActivity;
import com.zhongyong.smarthome.activity.PushSettingActivity;
import com.zhongyong.smarthome.activity.RepairActivity;
import com.zhongyong.smarthome.base.BaseFragment;

/**
 * Created by fyc on 2017/7/26.
 */

public class HomeFragment extends BaseFragment {
    RelativeLayout repairLayout;
    RelativeLayout maintenanceLayout;
    RelativeLayout pushSettingLayout;

    @Override
    protected int getContentViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews(View view) {
        repairLayout = view.findViewById(R.id.fm_repair_lyt);
        maintenanceLayout = view.findViewById(R.id.fm_maintenance_lyt);
        pushSettingLayout = view.findViewById(R.id.fm_setting_lyt);
    }

    @Override
    protected void initAdapter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        repairLayout.setOnClickListener(v -> {
            go(RepairActivity.class);
        });
        maintenanceLayout.setOnClickListener(v->{
            go(MaintenanceActivity.class);
        });
        pushSettingLayout.setOnClickListener(v->{
            go(PushSettingActivity.class);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
