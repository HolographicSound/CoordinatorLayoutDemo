/**
 * @(#) CommonAdapter.java 2016/1/15
 * CopyRight 2015 All rights reserved
 * @modify
 */
package com.zero.coordinatorlayoutdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于生成通用适配器(适用于RecyclerView)
 */
public abstract class CommomRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context context;
    protected List<T> mDataSource;

    public CommomRecyclerAdapter(Context context, List<T> mDataSource) {
        this.context = context;
        this.mDataSource = mDataSource;
    }

    public void setDatas(List<T> datas) {
        //设置为null时代表设置空数组操作
        if (datas == null) datas = new ArrayList<>();
        this.mDataSource.clear();
        this.mDataSource.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void clearDatas() {
        this.mDataSource.clear();
        this.notifyDataSetChanged();
    }

    public void addDatas(List<T> datas) {
        //需在AdapterDataObserver中的onItemRangeInserted方法监听数据的添加量
        if (datas == null) datas = new ArrayList<>();
        this.mDataSource.addAll(datas);
        this.notifyItemRangeInserted(this.mDataSource.size() - datas.size(), datas.size());
    }

    public void addData(T data) {
        if (data == null) return;
        this.mDataSource.add(data);
        this.notifyItemInserted(this.mDataSource.size());
    }

    public void addData(T data, int index) {
        if (data == null) return;
        this.mDataSource.add(index, data);
        this.notifyItemInserted(index);
    }

    public T getData(int index) {
        return this.mDataSource.get(index);
    }


    public void removeData(T data) {
        int index = this.mDataSource.indexOf(data);
        this.removeData(index);
    }

    public void removeData(int index) {
        if (index == -1) return;
        this.mDataSource.remove(index);
        this.notifyItemRemoved(index);
    }

    public List<T> getDatas() {
        return mDataSource;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(onBindViewResource(viewType), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindView((ViewHolder) holder, getItem(position), position);
    }

    @Override
    public int getItemCount() {
        return mDataSource != null ? mDataSource.size() : 0;
    }

    protected T getItem(int position) {
        if (mDataSource == null) return null;
        if (position >= mDataSource.size()) return null;
        return mDataSource.get(position);
    }

    public abstract void onBindView(ViewHolder mViewHolder, T data, int position);

    public abstract int onBindViewResource(int viewType);

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private SparseArray<View> viewCache;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.viewCache = new SparseArray<>();
        }

        public <T extends View> T getView(int viewId) {
            View view = viewCache.get(viewId);
            if (view == null) {
                view = this.itemView.findViewById(viewId);
                viewCache.put(viewId, view);
            }
            return (T) view;
        }

        public View getConvertView() {
            return this.itemView;
        }

        //TextView 设置方法
        public void setText(int textViewResId, String textString) {
            ((TextView) getView(textViewResId)).setText(textString);
        }

        //ImageView 设置方法
        public void setImage(int imageViewResId, String imageUrl) {
        }

        //View可见性设置
        public void setVisibility(int viewResId, int visibility) {
            getView(viewResId).setVisibility(visibility);
        }
    }

}
