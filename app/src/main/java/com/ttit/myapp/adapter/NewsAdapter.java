package com.ttit.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ttit.myapp.R;
import com.ttit.myapp.entity.NewsEntity;

import java.util.List;

/**
 * @author: wei
 * @date: 2020-06-27
 **/
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<NewsEntity> datas;

    public void setDatas(List<NewsEntity> datas) {
        this.datas = datas;
    }

    public NewsAdapter(Context context) {
        this.mContext = context;
    }

    public NewsAdapter(Context context, List<NewsEntity> datas) {
        this.mContext = context;
        this.datas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).getType();
        return type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_one, parent, false);
            return new ViewHolderOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_two, parent, false);
            return new ViewHolderTwo(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_three, parent, false);
            return new ViewHolderThree(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 1) {
            ViewHolderOne vh = (ViewHolderOne) holder;
        } else if (type == 2) {
            ViewHolderTwo vh = (ViewHolderTwo) holder;
        } else {
            ViewHolderThree vh = (ViewHolderThree) holder;
        }
    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderOne extends RecyclerView.ViewHolder {

        public ViewHolderOne(@NonNull View view) {
            super(view);
        }
    }

    public class ViewHolderTwo extends RecyclerView.ViewHolder {

        public ViewHolderTwo(@NonNull View view) {
            super(view);
        }
    }

    public class ViewHolderThree extends RecyclerView.ViewHolder {

        public ViewHolderThree(@NonNull View view) {
            super(view);
        }
    }
}
