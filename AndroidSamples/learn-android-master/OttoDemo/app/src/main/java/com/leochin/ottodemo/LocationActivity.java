/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leochin.ottodemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;

import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.view.View.OnClickListener;

public class LocationActivity extends FragmentActivity {

    @InjectView(R.id.jump_location) Button jumpButton;
    @InjectView(R.id.show_location) TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BusProvider.getInstance().register(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_history);
        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }

    @OnClick(R.id.jump_location)
    public void onJumpActivity(View view) {
        OtherActivity.launch(this);
    }

    @Subscribe
    public void onTextShow(Bundle bundle) {
        int count = bundle.getInt("count");
        showTextView.setText(count+"");
    }
}
