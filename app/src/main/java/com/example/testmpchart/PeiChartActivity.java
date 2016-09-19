package com.example.testmpchart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;
import java.util.List;

public class PeiChartActivity extends AppCompatActivity {
  PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart = (PieChart) findViewById(R.id.pieChart);

        pieChart.setBackgroundColor(Color.LTGRAY);

        pieChart.setCenterText("手机系统市场占有率");
        pieChart.setCenterTextColor(Color.GREEN);
        pieChart.setCenterTextSize(15f);
        pieChart.setData(getPieData());

        pieChart.setHoleRadius(60f);//饼状图中间的空心圆的大小
//        pieChart.setRotationAngle(90);
//        pieChart.animateXY(3000,3000);
        pieChart.setHovered(true);
        pieChart.animateY(2000);

//        pieChart.setUsePercentValues(true);//使用百分比

    }


    public PieData getPieData(){
        List<String> xValues = new ArrayList<>();
        xValues.add("android");
        xValues.add("IOS");
        xValues.add("WinPhone");
        xValues.add("other");

        List<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(85f,0));
        yValues.add(new Entry(30f,1));
        yValues.add(new Entry(20f,2));
        yValues.add(new Entry(15f,3));

        PieDataSet dataSet = new PieDataSet(yValues,"手机系统");
        dataSet.setColors(new int[]{Color.GREEN,Color.RED,Color.BLUE,Color.YELLOW});
        dataSet.setValueTextSize(10f);
        dataSet.setSelectionShift(20f);//设置 当模块被选中 变大的尺寸
        dataSet.setSliceSpace(5f);//设置 每个模块之间的间隔


        PieData data = new PieData(xValues);
        data.addDataSet(dataSet);
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
