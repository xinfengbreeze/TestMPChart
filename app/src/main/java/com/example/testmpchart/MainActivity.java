package com.example.testmpchart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
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

    public void initLineChart() {
        lineChart.setBackgroundColor(Color.YELLOW);//整个View的背景演示
//        lineChart.setGridBackgroundColor(Color.GREEN);//图表中间网格点的背景图

        lineChart.setDrawBorders(false);//是否绘制网格的边框

        //设置图标标题
        lineChart.setDescription("成绩折线图");
        lineChart.setDescriptionColor(Color.GREEN);
        lineChart.setDescriptionTextSize(30f);
        lineChart.setDescriptionPosition(100, 100);

        lineChart.setNoDataText("没有可以展示的数据");//当没有数据的时候展现的内容

        //        lineChart.setDrawGridBackground(true);
        //        lineChart.setGridBackgroundColor(Color.RED);

        lineChart.setTouchEnabled(true);//是否可以点击
        lineChart.setScaleEnabled(true);//是否可以缩放
        lineChart.setPinchZoom(true);//y轴的值是否跟随图表变换缩放;如果禁止，y轴的值会跟随图表变换缩放
        lineChart.setDragEnabled(false);//是否可以拖动 左右移动

        Legend legend = lineChart.getLegend();//为每一条折线设置标签图标
        legend.setForm(Legend.LegendForm.LINE);//设置每个折线的事例图标 为线 还有正方形圆形
        legend.setFormSize(Color.GREEN);
        legend.setFormSize(10f);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);//设置比例图标的位置
        legend.setDirection(Legend.LegendDirection.RIGHT_TO_LEFT);//设置比例图标和文字之间的位置方向

        lineChart.setData(getLineData(30, 100));//设置线的数据

//        lineChart.animateXY(3000,2000);//设置动画时间，就是图表慢慢画完的是时间
//        lineChart.animateY(500);//设置动画时间，就是图表慢慢画完的是时间
        lineChart.animateY(1500, Easing.EasingOption.EaseInOutQuad);

    }

    public LineData getLineData(int count, int range) {
        ArrayList<String> xValues = new ArrayList<>();//一个String形式的ArrayList 就是X轴上要显示的内容
        for (int i = 0; i < count; i++) {
            xValues.add(i + "天");
        }

        ArrayList<Entry> yValues = new ArrayList<>();//Y轴上的数据 是一个
        for (int i = 0; i < count; i++) {
            yValues.add(new Entry((float) (Math.random() * range), i));
            //画线的时候是 先被添加到list中的点先画，位置是由Entry（value,index）的value和index决定的  index 与X轴的ArrayList的index相关
        }

        LineDataSet lineDataSet = new LineDataSet(yValues, "小明的成绩");//创建一个dataSet就是一条直线

        //下面是对这条线的设置
        lineDataSet.setColor(Color.GREEN);//线的颜色
        lineDataSet.setLineWidth(3f);//线的宽度

        lineDataSet.setCircleColor(Color.RED);//线上圆点的颜色
        lineDataSet.setCircleColorHole(Color.BLACK);//圆心的颜色
        lineDataSet.setDrawCircleHole(true);//是否画圆心
        lineDataSet.setCircleSize(4f);//圆的大小
        lineDataSet.setValueTextColor(Color.BLUE);//折线上点的数值颜色
        lineDataSet.setValueTextSize(10f);//文字的大小
        lineDataSet.setDrawFilled(true);//折线下面的填充的颜色
        lineDataSet.setFillColor(Color.DKGRAY);//填充的颜色

        lineDataSet.setHighLightColor(Color.RED);//线上圆点 与XY轴的十字线的 颜色
        lineDataSet.setHighlightLineWidth(2f);//线的宽度
        lineDataSet.setDrawHighlightIndicators(true);//是否显示十字线
        //        lineDataSet.setDrawCubic(true);//为true画的是平滑的曲线

        //第二条线
        ArrayList<Entry> yValues2 = new ArrayList<>();//Y轴上的数据 是一个
        for (int i = 0; i < count; i++) {
            yValues2.add(new Entry((float) (Math.random() * range), i));
            //画线的时候是 先被添加到list中的点先画，位置是由Entry（value,index）的value和index决定的  index 与X轴的ArrayList的index相关
        }

        LineDataSet lineDataSet2 = new LineDataSet(yValues2, "小红的成绩");//创建一个dataSet就是一条直线

        //下面是对这条线的设置
        lineDataSet2.setColor(Color.RED);//线的颜色
        lineDataSet2.setLineWidth(3f);//线的宽度

        lineDataSet2.setCircleColor(Color.GREEN);//线上圆点的颜色
        lineDataSet2.setCircleColorHole(Color.WHITE);//圆心的颜色
        lineDataSet2.setDrawCircleHole(true);//是否画圆心
        lineDataSet2.setCircleSize(4f);//圆的大小
        lineDataSet2.setValueTextColor(Color.BLACK);//折线上点的数值颜色
        lineDataSet2.setValueTextSize(10f);//文字的大小
        lineDataSet2.setDrawFilled(true);//折线下面的填充的颜色
        lineDataSet2.setFillColor(Color.MAGENTA);//填充的颜色

        lineDataSet2.setHighLightColor(Color.GREEN);//线上圆点 与XY轴的十字线的 颜色
        lineDataSet2.setHighlightLineWidth(2f);//线的宽度
        lineDataSet2.setDrawHighlightIndicators(true);//是否显示十字线
        lineDataSet2.setDrawCubic(true);//为true画的是平滑的曲线


        LineData lineData = new LineData(xValues);//添加X轴上的值
        lineData.addDataSet(lineDataSet);//添加第一条线
        lineData.addDataSet(lineDataSet2);//添加第二提线
        return lineData;
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
