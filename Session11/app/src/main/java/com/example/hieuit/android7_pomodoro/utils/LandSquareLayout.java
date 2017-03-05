package com.example.hieuit.android7_pomodoro.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Hieu It on 3/4/2017.
 */

public class LandSquareLayout extends RelativeLayout {
    public LandSquareLayout(Context context) {
        super(context);
    }

    public LandSquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LandSquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int weight = height;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(weight,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
