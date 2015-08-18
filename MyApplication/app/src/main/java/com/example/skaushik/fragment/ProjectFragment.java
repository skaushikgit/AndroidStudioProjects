package com.example.skaushik.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skaushik.myapplication.R;
import com.example.skaushik.view.ProjectListView;

public class ProjectFragment extends Fragment {

    private ProjectListView projectListView;

    public ProjectFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_project, container, false);
//        projectListView = (ProjectListView) contentView.findViewById(R.id.projectListViewId);
        return contentView;
    }

}
