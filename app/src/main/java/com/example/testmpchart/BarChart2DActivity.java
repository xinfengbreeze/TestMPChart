package com.example.testmpchart;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class BarChart2DActivity extends AppCompatActivity {

    BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart2_d);
        barChart = (BarChart) findViewById(R.id.barChart2d);
        barChart.setBackgroundColor(Color.YELLOW);
//        barChart.setGridBackgroundColor(Color.BLACK);
        barChart.setNoDataTextDescription("没有可以展示的数据!");

        barChart.setDrawBorders(true);

        barChart.setDescription("公司月销售额");
        barChart.setDescriptionTypeface(Typeface.SERIF);
        barChart.setDescriptionColor(Color.GREEN);
        barChart.setDescriptionPosition(200f,50f);

        barChart.setScaleEnabled(true);
        barChart.setTouchEnabled(true);
        barChart.setPinchZoom(true);

        barChart.setDrawBarShadow(true); //柱状图的背景
        barChart.setDrawValueAboveBar(true);//柱状图的顶部的数值  默认是true
        barChart.setDrawHighlightArrow(true);

        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//X轴的一些设置

        barChart.getAxisRight().setEnabled(false);//右侧的Y轴


        barChart.setData(getBarData(10,50));
        barChart.animateXY(1000,2000);


    }

    public BarData getBarData(int count,int maxValue){
        List<String> xValues = new ArrayList<>();
        for(int i = 0;i<count ; i++){
           xValues.add(i+"月");
        }

        List<BarEntry> yValues = new ArrayList<>();
        for(int i = 0 ; i < count; i++){
            yValues.add(i,new BarEntry((float) (Math.random()*maxValue),i));
        }

        BarDataSet dataSet = new BarDataSet(yValues,"A公司业绩");
        dataSet.setColor(Color.RED);
        dataSet.setBarShadowColor(Color.LTGRAY);
        dataSet.setBarSpacePercent(20f);//柱状图 个柱之间的间隔 百分比

        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(10f);
//        dataSet.setDrawValues(false);

        List<BarEntry> yValues1 = new ArrayList<>();
        for(int i = 0 ; i < count; i++){
            yValues1.add(i,new BarEntry((float) (Math.random()*maxValue),i));
        }

        BarDataSet dataSet1 = new BarDataSet(yValues1,"A公司业绩");
        dataSet1.setColor(Color.GREEN);
        dataSet1.setBarShadowColor(Color.LTGRAY);
        dataSet1.setBarSpacePercent(20f);//柱状图 个柱之间的间隔

        BarData data = new BarData(xValues);
        data.addDataSet(dataSet);
        data.addDataSet(dataSet1);
        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(getApplication()).inflate(R.menu.charts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_lineChart:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                break;
            case R.id.menu_barChart2d:
                startActivity(new Intent(getApplicationContext(), BarChart2DActivity.class));
                finish();
                break;
            case R.id.menu_barChart3d:
                break;
            case R.id.menu_pieChart:
                startActivity(new Intent(getApplicationContext(), PeiChartActivity.class));
                finish();
                break;
        }

        return true;
    }
}
