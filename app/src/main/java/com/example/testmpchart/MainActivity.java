package com.example.testmpchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = (LineChart) findViewById(R.id.lineChart);
        initLineChart();
    }

    public void initLineChart(){
        lineChart.setBackgroundColor(Color.YELLOW);

        lineChart.setDrawBorders(true);

        //设置图标标题
        lineChart.setDescription("成绩折线图");
        lineChart.setDescriptionColor(Color.GREEN);
        lineChart.setDescriptionTextSize(30f);
        lineChart.setDescriptionPosition(100,100);

        lineChart.setNoDataText("没有可以展示的数据");

//        lineChart.setDrawGridBackground(true);
//        lineChart.setGridBackgroundColor(Color.RED);

        lineChart.setTouchEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setPinchZoom(false);
        lineChart.setDragEnabled(true);

        lineChart.setData(getLineData(30,100));

        lineChart.animateX(3000);


}

    public LineData getLineData(int count , int range){
        ArrayList<String> xValues  = new ArrayList<>();
        for (int i = 0;i<count ;i++) {
            xValues.add(i+"");
        }

        ArrayList<Entry> yValues = new ArrayList<>();
        for(int i= 0 ; i<count; i++){
            yValues.add(new Entry((float) (Math.random()*range),i));
        }

        LineDataSet  lineDataSet  =  new LineDataSet(yValues,"小明的成绩");

        lineDataSet.setColor(Color.GREEN);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setHighlightLineWidth(5f);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setCircleColor(Color.GREEN);
        lineDataSet.setCircleColorHole(Color.RED);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setCircleSize(4f);
        lineDataSet.setValueTextColor(Color.BLUE);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.DKGRAY);


        LineData lineData = new LineData(xValues);
        lineData.addDataSet(lineDataSet);
        return lineData;
    }
}
