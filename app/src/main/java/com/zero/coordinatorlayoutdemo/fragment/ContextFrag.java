package com.zero.coordinatorlayoutdemo.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.coordinatorlayoutdemo.R;
import com.zero.coordinatorlayoutdemo.adapter.CommomRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HJF on 2016/9/5.
 * http://blog.csdn.net/qq_18669217
 */
public class ContextFrag extends Fragment {

    private Context mContext;
    private String fragmengName;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    public static Fragment newInstance(String name) {
        ContextFrag contextFrag = new ContextFrag();
        Bundle data = new Bundle();
        data.putString("FragmengName", name);
        contextFrag.setArguments(data);
        return contextFrag;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmengName = getArguments().getString("FragmengName");
    }

    private ArrayList<String> loadData() {
        ArrayList<String> tempData = new ArrayList<>();
        for (int i = 0; i < 66; i++) {
            tempData.add(fragmengName + ": " + i);
        }
        return tempData;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.v_recyclerview, null);
        recyclerView = (RecyclerView) container.findViewById(R.id.recyclerView);
        initRecyclerView();
        return container;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter = new MyAdapter(mContext, new ArrayList<String>()));
        adapter.setDatas(loadData());
    }

    private class MyAdapter extends CommomRecyclerAdapter<String> {

        public MyAdapter(Context context, List<String> mDataSource) {
            super(context, mDataSource);
        }

        @Override
        public void onBindView(ViewHolder mViewHolder, String data, int position) {
            mViewHolder.setText(R.id.textView, data);
        }

        @Override
        public int onBindViewResource(int viewType) {
            return R.layout.v_textview;
        }
    }
}
