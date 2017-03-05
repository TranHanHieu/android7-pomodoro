package com.example.hieuit.android7_pomodoro.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Hieu It on 3/4/2017.
 */

public class PoitraitSquareLayout extends RelativeLayout {
    public PoitraitSquareLayout(Context context) {
        super(context);
    }

    public PoitraitSquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PoitraitSquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int weight = MeasureSpec.getSize(widthMeasureSpec);
        int height = weight;
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }
}
