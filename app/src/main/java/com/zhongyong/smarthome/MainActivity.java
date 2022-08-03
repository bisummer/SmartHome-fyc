package com.zhongyong.smarthome;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.zhongyong.jamod.activity.LoginActivity;
import com.zhongyong.jamod.model.User;
import com.zhongyong.smarthome.activity.MyFamilyActivity;
import com.zhongyong.smarthome.activity.NewSceneActivity;
import com.zhongyong.smarthome.activity.SearchDeviceActivity;
import com.zhongyong.smarthome.activity.ThemeSettingActivity;
import com.zhongyong.smarthome.base.BaseActivity;
import com.zhongyong.smarthome.fragment.HomeFragment;
import com.zhongyong.smarthome.fragment.IntelligentCampusFragment;
import com.zhongyong.smarthome.fragment.MonitorFragment;
import com.zhongyong.smarthome.fragment.SceneFragment;
import com.zhongyong.smarthome.model.ColorManager;
import com.zhongyong.smarthome.widget.ColorLinearLayout;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity {
    DrawerLayout mDrawerLayout;
    RadioGroup mRadioGroup;
    LinearLayout changeThemeLay;
    RelativeLayout item1;
    RelativeLayout item2;
    ColorLinearLayout mLayout;
    ImageView addIv;
    TextView rightTv;
    NavigationView mNavigationView;
    View header;
    TextView loginTv;
    TextView telephoneTv;
    HomeFragment mHomeFragment;
    MonitorFragment mMonitorFragment;
    //DeviceFragment mDeviceFragment;
    SceneFragment mSceneFragment;
    // ModBusGatewayFragment mModBusGatewayFragment;
    IntelligentCampusFragment mIntelligentCampusFragment;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    List<Fragment> mFragmentList;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRadioGroup = findViewById(R.id.nb_rg_naviBottom);
        changeThemeLay = findViewById(R.id.am_changeTheme_ll);
        item1 = findViewById(R.id.item1_rv);
        item2 = findViewById(R.id.item2_rv);
        mLayout = findViewById(R.id.titleBar);
        addIv = findViewById(R.id.cab_add_iv);
        rightTv = findViewById(R.id.title_right);
        mNavigationView = findViewById(R.id.nav_view);
        header = mNavigationView.getHeaderView(0);
        loginTv = (TextView) header.findViewById(R.id.nav_login);
        telephoneTv = (TextView) header.findViewById(R.id.navi_telephone);
        if (App.getUser() != null) {
            loginTv.setText(App.getUser().getUserName());
            telephoneTv.setText(App.getUser().getTelephone());
        }
        initFragment();
        initTheme();

    }

    public void initTheme() {
        ColorManager.getInstance().setSkinColor(MainActivity.this,
                App.mPreference.getSkinColorPosition());
    }

    @Override
    protected void initAdapter() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.nb_rb_monitor:
                        //  setCustomTitle("视频监控");
                        addIv.setVisibility(View.GONE);
                        rightTv.setVisibility(View.GONE);
                        showFragment(mMonitorFragment);
                        break;
                    case R.id.nb_rb_device:
                        //setCustomTitle("智能设备");
                        addIv.setVisibility(View.GONE);
                        if (SearchDeviceActivity.count > 0) {
                            rightTv.setVisibility(View.VISIBLE);
                        } else {
                            rightTv.setVisibility(View.GONE);
                        }
                        showFragment(mIntelligentCampusFragment);
                        break;
                    case R.id.nb_rb_scene:
                        // setCustomTitle("场景布置");
                        addIv.setVisibility(View.VISIBLE);
                        rightTv.setVisibility(View.GONE);
                        showFragment(mSceneFragment);
                        break;
                    case R.id.nb_rb_homePage:
                        //setCustomTitle("我的");
                        addIv.setVisibility(View.GONE);
                        rightTv.setVisibility(View.GONE);
                        showFragment(mHomeFragment);
                        break;
                }
            }
        });

        changeThemeLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ThemeSettingActivity.class);
                startActivity(intent);
            }
        });
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
                go(MyFamilyActivity.class);
            }
        });
        addIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(NewSceneActivity.class);
            }
        });
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go(LoginActivity.class);
            }
        });
    }

    /* @Override
     protected View getLoadingTargetView() {
         FrameLayout layout = (FrameLayout) findViewById(R.id.am_fl_fragmentcontainer);
         return layout;
     }
 */
    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentList = new ArrayList<>();
        mMonitorFragment = new MonitorFragment();
        // mModBusGatewayFragment = new ModBusGatewayFragment();
        mIntelligentCampusFragment = new IntelligentCampusFragment();
        //mDeviceFragment = new DeviceFragment();
        mSceneFragment = new SceneFragment();
        mHomeFragment = new HomeFragment();
        mFragmentList.add(mHomeFragment);
        mFragmentList.add(mMonitorFragment);
        //mFragmentList.add(mDeviceFragment);
        mFragmentList.add(mSceneFragment);
        //mFragmentList.add(mModBusGatewayFragment);
        mFragmentList.add(mIntelligentCampusFragment);
        showFragment(mMonitorFragment);


    }

    private void showFragment(Fragment fragment) {
        hideAllFragment();
        mFragmentTransaction = mFragmentManager.beginTransaction();

        if (fragment.isAdded()) {
            mFragmentTransaction.show(fragment);

        } else {
            mFragmentTransaction.add(R.id.am_fl_fragmentcontainer, fragment);
        }

        mFragmentTransaction.commit();
    }

    //隐藏所有已经add的帧布局
    private void hideAllFragment() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        for (Fragment fragment : mFragmentList) {
            if (fragment != null)
                if (fragment.isAdded()) {
                    mFragmentTransaction.hide(fragment);
                }
        }
        mFragmentTransaction.commit();
    }

    @Override
    protected boolean isBindEventBusHere() {
        return true;
    }

    @Subscribe
    public void getUser(User user) {
        if (App.getUser() != null) {
            loginTv.setText(user.getUserName());
            // telephoneTv.setText("手机号:" + user.getTelephone());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
