package com.example.skaushik.view;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.skaushik.myapplication.R;

import java.util.Observable;
import java.util.Observer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectListView extends FrameLayout {

    OnSelectProjectListener projectListener;
    ProjectListViewAdapter adapter;
    ElasticListView listView;


    public ProjectListView(Context context) {
        super(context);
        init();
    }

    public ProjectListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProjectListView(Context context, AttributeSet attrs,  int defStyle) {
        super(context, attrs, defStyle);
        init();

    }

    private void init() {
        adapter = new ProjectListViewAdapter();
        listView = new ElasticListView(getContext());
        listView.setMaxOverScrollDistance(0, 80);

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(listView, lp);
        listView.setAdapter(adapter);
    }


    public interface OnSelectProjectListener {
        public void onSelectProject(String projectName);
    }

    public void setOnSelectProjectListener(OnSelectProjectListener listener) {
        this.projectListener = listener;
    }


    private static class ViewHolder {
        TextView tvFirstName;
        TextView tvLastName;
    }

    private class ProjectListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return (long) position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
                viewHolder.tvFirstName = (TextView) convertView.findViewById(R.id.tvFirstNameId);
                viewHolder.tvLastName = (TextView) convertView.findViewById(R.id.tvLastNameId);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            setListViewItems(position, viewHolder);
            return convertView;
        }
    }

    private static void setListViewItems(int position, ViewHolder holder) {
        holder.tvFirstName.setText("Hello Saurabh");
        holder.tvLastName.setText("Last Name");
    }

}

