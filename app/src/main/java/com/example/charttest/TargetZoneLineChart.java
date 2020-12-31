package com.example.charttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class TargetZoneLineChart extends LineChart {
    protected Paint mYAxisSafeZonePaint;
    protected Paint mXAxisSafeZonePaint;
    private List<TargetZone> mTargetZones;

    public TargetZoneLineChart(Context context){
        super(context);
    }

    public TargetZoneLineChart(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public TargetZoneLineChart(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();
        mXAxisSafeZonePaint = new Paint();
        mXAxisSafeZonePaint.setStyle(Paint.Style.FILL);  //實心

        mYAxisSafeZonePaint = new Paint();
        mYAxisSafeZonePaint.setStyle(Paint.Style.STROKE); //空心
        mTargetZones = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (TargetZone targetZone : mTargetZones){

            float[] pts = new float[4];
            pts[1] = targetZone.lowerLimit;
            pts[3] = targetZone.upperLimit;
            mLeftAxisTransformer.pointValuesToPixel(pts);

            //X draw
            mXAxisSafeZonePaint.setColor(targetZone.color);
            //drawRect( 左, top, 右, bottom, Paint)
            canvas.drawRect(pts[1], mViewPortHandler.contentTop(), pts[3], mViewPortHandler.contentBottom(), mXAxisSafeZonePaint);

            // Y draw
            mYAxisSafeZonePaint.setColor(targetZone.color);
            //drawRect( 左, 頂, 右, 底, Paint)
            canvas.drawRect(mViewPortHandler.contentLeft(), pts[1], mViewPortHandler.contentRight(),
                    pts[3], mYAxisSafeZonePaint);
        }

        super.onDraw(canvas);
    }

    public void addTargetZone(TargetZone targetZone) {
        mTargetZones.add(targetZone);
    }

    public List<TargetZone> getTargetZones() {
        return mTargetZones;
    }

    public  void clearTargetZones(){
        mTargetZones = new ArrayList<>();
    }

    public static class TargetZone{
        public final int color;

        public final float lowerLimit;
        public final float upperLimit;

        public TargetZone(int color, float lowerLimit, float upperLimit) {
            this.color = color;
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }
    }

}
