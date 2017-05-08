package com.example.jh.butterknife;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;

/**
 * 本demo测试ButterKnife的相关操作及使用。
 * 避免了冗杂的findViewById。
 *
 */
public class MainActivity extends AppCompatActivity {
    //初始化TextView控件
    @Nullable @BindView(R.id.tv1)
    TextView tv1;

    @BindViews({R.id.tv2, R.id.tv3})
    TextView[] tvs;

    @BindColor(R.color.colorAccent)
    int tvBg;
    @BindString(R.string.app_name)
    String tvStr;
    @BindDrawable(R.mipmap.ic_launcher)
    Drawable tvDrawable;
    @BindDimen(R.dimen.activity_horizontal_margin)
    int tvMargin;

    // 绑定listView
    @BindView(R.id.lv)
    ListView listView;

    @BindView(R.id.bt)
    Button bt;

    @BindViews({R.id.tv4, R.id.tv5, R.id.tv6})
    List<TextView> textViews;

    @BindView(R.id.tv7)
    TextView tv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//绑定控件

        tv1 = ButterKnife.findById(MainActivity.this, R.id.tv1);
        TextView tv2 = ButterKnife.findById(MainActivity.this, R.id.tv2);
        TextView tv3 = ButterKnife.findById(MainActivity.this, R.id.tv3);


        tv1.setText("Hello ButterKnife");

        tvs[0].setText("你好 android");
        tvs[1].setText("你好 ButterKnife");

        tv1.setBackgroundColor(tvBg);
        tvs[0].setText(tvStr);
        tvs[1].setBackground(tvDrawable);

        List<String> list = initData();
        MyAdapter adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);

        // 修改背景颜色
        ButterKnife.Action<View> CHANGECOLOR = new ButterKnife.Action<View>() {
            @Override
            public void apply(@NonNull View view, int index) {
                view.setBackgroundColor(Color.RED);
            }
        };
        ButterKnife.apply(tv7, CHANGECOLOR);

        ButterKnife.Setter<View,List<Integer>> CHANGECOLOR2 = new ButterKnife.Setter<View, List<Integer>>() {
            @Override
            public void set(@NonNull View view, List<Integer> value, int index) {
                view.setBackgroundColor(value.get(index));
            }
        };
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        ButterKnife.apply(textViews,CHANGECOLOR2,colors);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("item =" + i);
        }
        return list;
    }

    @OnClick(R.id.tv2)
    public void click1() {
        Toast.makeText(MainActivity.this, "tv2被点击", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tv1, R.id.tv3})
    public void click2(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                Toast.makeText(MainActivity.this, "tv1被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv3:
                Toast.makeText(MainActivity.this, "tv3被点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @OnClick(R.id.bt)
    public void click3(Button button){
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }

    @OnItemClick(R.id.lv)
    void onItemClick(int position) {
        Toast.makeText(MainActivity.this, "ListView点击了:" + position, Toast.LENGTH_SHORT).show();
    }

    @OnItemLongClick(R.id.lv)
    boolean onItemLongClick(int position){
        Toast.makeText(MainActivity.this, "长按ListView点击了:" + position, Toast.LENGTH_SHORT).show();
        return false;
    }

}
