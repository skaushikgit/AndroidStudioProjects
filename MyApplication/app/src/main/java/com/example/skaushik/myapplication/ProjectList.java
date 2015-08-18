package com.example.skaushik.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.skaushik.fragment.ProjectFragment;
import com.example.skaushik.myapplication.R;

public class ProjectList extends Activity {

    ProjectFragment projectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        projectFragment = new ProjectFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.rootContainer, projectFragment);
        ft.commit();
    }
}
