package com.ttit.myapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.ttit.myapp.R;
import com.ttit.myapp.activity.LoginActivity;
import com.ttit.myapp.adapter.VideoAdapter;
import com.ttit.myapp.api.Api;
import com.ttit.myapp.api.ApiConfig;
import com.ttit.myapp.api.TtitCallback;
import com.ttit.myapp.entity.VideoEntity;
import com.ttit.myapp.entity.VideoListResponse;
import com.ttit.myapp.util.StringUtils;

import java.util.HashMap;
import java.util.List;

public class VideoFragment extends BaseFragment {

    private String title;
    private RecyclerView recyclerView;

    public VideoFragment() {
    }

    public static VideoFragment newInstance(String title) {
        VideoFragment fragment = new VideoFragment();
        fragment.title = title;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        getVideoList();
    }

    private void getVideoList() {
        String token = getStringFromSp("token");
        if (!StringUtils.isEmpty(token)) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("token", token);
            Api.config(ApiConfig.VIDEO_LIST, params).getRequest(new TtitCallback() {
                @Override
                public void onSuccess(String res) {
                    VideoListResponse response = new Gson().fromJson(res, VideoListResponse.class);
                    if (response != null && response.getCode() == 0) {
                        List<VideoEntity> datas = response.getPage().getList();
                        VideoAdapter videoAdapter = new VideoAdapter(getActivity(), datas);
                        recyclerView.setAdapter(videoAdapter);
                    }
                }

                @Override
                public void onFailure(Exception e) {

                }
            });
        } else {
            navigateTo(LoginActivity.class);
        }

    }
}