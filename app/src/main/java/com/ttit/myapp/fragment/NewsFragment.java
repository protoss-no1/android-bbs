package com.ttit.myapp.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.ttit.myapp.R;
import com.ttit.myapp.adapter.NewsAdapter;
import com.ttit.myapp.entity.NewsEntity;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private NewsAdapter newsAdapter;
    private List<NewsEntity> datas = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    public NewsFragment() {
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        recyclerView = mRootView.findViewById(R.id.recyclerView);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(getActivity());
        for (int i = 0; i < 15; i++) {
            int type = i % 3 + 1;
            NewsEntity newsEntity = new NewsEntity();
            newsEntity.setType(type);
            datas.add(newsEntity);
        }
        newsAdapter.setDatas(datas);
        recyclerView.setAdapter(newsAdapter);
    }
}