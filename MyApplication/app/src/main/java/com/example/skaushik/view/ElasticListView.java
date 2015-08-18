package com.example.skaushik.view;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.skaushik.myapplication.R;

public class ElasticListView extends ListView {

    private ScrollCallbacks mCallbacks;

    private int DEFAULT_VERITICAL_OVERSCROLL = 100;
    private int maxYOverscrollDistance = 0;
    private int maxXOverscrollDistance = 0;

    public ElasticListView(Context context) {
        super(context);
    }

    public ElasticListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ElasticListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCallbacks(ScrollCallbacks listener) {
        mCallbacks = listener;
    }



    public static interface ScrollCallbacks {
        public void onScrollChanged(int l, int t, int oldl, int oldt);
    }

    public void setMaxOverScrollDistance(int xMaxDistance, int yMaxDistance) {
        final DisplayMetrics metrics = getContext().getResources()
                .getDisplayMetrics();
        final float density = metrics.density;
        maxYOverscrollDistance = (int) (density*yMaxDistance);
        maxXOverscrollDistance = (int) (density*xMaxDistance);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mCallbacks != null) {
            mCallbacks.onScrollChanged(l, t, oldl, oldt);
        }
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
                scrollRangeX, scrollRangeY, maxXOverscrollDistance,
                maxYOverscrollDistance, isTouchEvent);
    }
}
