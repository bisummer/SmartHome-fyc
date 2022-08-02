package com.zhongyong.smarthome.activity;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhongyong.smarthome.R;
import com.zhongyong.smarthome.base.BaseActivity;
import com.zhongyong.smarthome.base.recyclerview.CommonAdapter;
import com.zhongyong.smarthome.base.recyclerview.ViewHolder;
import com.zhongyong.smarthome.model.Member;
import com.zhongyong.smarthome.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;



public class MyFamilyActivity extends BaseActivity {
    ImageView moreIv;
    ImageView backIv;
    ImageView createPersonIv;
    CommonAdapter<Member> mAdapter;
    RecyclerView mRecyclerView;
    List<Member> mList = new ArrayList<>();


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_my_familly;
    }

    @Override
    protected void initViews() {
        moreIv= findViewById(R.id.cab_more_iv);
        backIv= findViewById(R.id.cab_titleBack_iv);
        ImageView createPersonIv= findViewById(R.id.amf_pic_iv);
        mRecyclerView= findViewById(R.id.amf_myFamily_rv);
        setCustomTitle("我的家");
        moreIv.setVisibility(View.VISIBLE);
        backIv.setVisibility(View.VISIBLE);
        ImageUtils.setCircleImage(createPersonIv, ImageUtils.Screenshot_2017);
    }

    @Override
    protected void initAdapter() {
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layout);
        mAdapter = new CommonAdapter<Member>(this, R.layout.item_family, mList) {
            @Override
            protected void convert(final ViewHolder holder, final Member member, int position) {
                holder.setCircleImage(R.id.item_pic_iv, member.getPicUrl());
                holder.setText(R.id.item_nickName_tv, member.getNickName());
                holder.setText(R.id.item_ID_tv, "ID:" + member.getId());
                if (member.getIsOpen() == 0) {
                    holder.setBackgroundRes(R.id.item_switch_iv, R.drawable.switch_off);
                } else {
                    holder.setBackgroundRes(R.id.item_switch_iv, R.drawable.switch_on);
                }
                holder.setOnClickListener(R.id.item_switch_iv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (member.getIsOpen() == 0) {
                            holder.setBackgroundRes(R.id.item_switch_iv, R.drawable.switch_on);
                            member.setIsOpen(1);

                        } else {
                            holder.setBackgroundRes(R.id.item_switch_iv, R.drawable.switch_off);
                            member.setIsOpen(0);
                        }

                    }
                });
            }
        };
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mList.add(new Member(ImageUtils.campus1, "哥哥", "jfajdflajdfljfa", 1));
        mList.add(new Member(ImageUtils.campus2, "爸爸", "jfajdflajdfljfa", 0));
        mList.add(new Member(ImageUtils.campus3, "妈妈", "jfajdflajdfljfa", 0));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {
        backIv.setOnClickListener((view) -> {
            finish();
        });
    }
}
