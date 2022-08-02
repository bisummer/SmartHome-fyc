package com.zhongyong.smarthome.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;
import com.zhongyong.smarthome.R;
import com.zhongyong.smarthome.activity.NewSceneActivity;
import com.zhongyong.smarthome.base.BaseFragment;
import com.zhongyong.smarthome.base.recyclerview.CommonAdapter;
import com.zhongyong.smarthome.model.Scene;
import com.zhongyong.smarthome.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fyc on 2017/7/26.
 */

public class SceneFragment extends BaseFragment {
    RecyclerView mRecyclerView;
    CommonAdapter<Scene> mAdapter;
    List<Scene> mList = new ArrayList<>();

    @Override
    protected int getContentViewLayout() {
        return R.layout.fragment_scene;
    }

    @Override
    protected void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.as_scenes_rv);
        mRecyclerView.setLayoutManager(new OverLayCardLayoutManager());
    }

    @Override
    protected void initAdapter() {
        mAdapter = new CommonAdapter<Scene>(getActivity(), R.layout.item_scene, mList) {
            @Override
            protected void convert(final com.zhongyong.smarthome.base.recyclerview.ViewHolder holder, final Scene bean, int position) {
                holder.setText(R.id.tvName, bean.getName());
                holder.setText(R.id.tvPresent, bean.getPosition() + " /" + mList.size());
                holder.setNetImage(R.id.iv, bean.getUrl());
                if (bean.getStatus() == 0) {
                    holder.setText(R.id.item_status_tv, "一键开启");
                } else {
                    holder.setText(R.id.item_status_tv, "一键关闭");
                }
                holder.setOnClickListener(R.id.item_status_tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (bean.getStatus() == 0) {
                            bean.setStatus(1);
                            holder.setText(R.id.item_status_tv, "一键关闭");
                        } else {
                            bean.setStatus(0);
                            holder.setText(R.id.item_status_tv, "一键开启");
                        }
                    }
                });
                holder.setOnClickListener(R.id.delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //需要删除item，和重置position
                        mList.remove(bean);
                        resetListRemove(mList, bean.getPosition());
                    }
                });
                holder.setOnClickListener(R.id.item_scene_cv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();
                        bundle.putString("sceneName", bean.getName());
                        go(NewSceneActivity.class, bundle);

                    }
                });
            }
        };
        mRecyclerView.setAdapter(mAdapter);
        //初始化配置
        CardConfig.initConfig(getActivity());
        ItemTouchHelper.Callback callback = new RenRenCallback(mRecyclerView, mAdapter, mList);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void initData() {
        int i = 1;
        mList.add(new Scene(i++, ImageUtils.canting, "餐厅", 1));
        mList.add(new Scene(i++, ImageUtils.wo_shi, "卧室", 0));
        mList.add(new Scene(i++, ImageUtils.chufang, "厨房", 1));
        mList.add(new Scene(i++, ImageUtils.zoulang, "走廊", 0));
        mList.add(new Scene(i++, ImageUtils.mainroom, "主卧", 1));
        mList.add(new Scene(i++, ImageUtils.xishoujian, "洗手间", 1));
        mList.add(new Scene(i++, ImageUtils.worhi, "A房间", 0));
        mList.add(new Scene(i++, ImageUtils.room, "主卧", 1));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {

    }

    public void resetListRemove(List<Scene> list, int position) {
        for (int i = 0; i < list.size(); i++) {
            int flag = list.get(i).getPosition();
            if (flag > position) {
                list.get(i).setPosition(flag-1);
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
