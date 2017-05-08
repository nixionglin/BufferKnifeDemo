package com.example.jh.butterknife;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者：jinhui on 2017/3/16
 * 邮箱：1004260403@qq.com
 */

public class FragmentA extends Fragment {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.tv4)
    TextView tv4;
    private Unbinder unbinder;//重置绑定

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        unbinder = ButterKnife.bind(this, view);

        // 修改背景颜色
        ButterKnife.Action<View> CHANGECOLOR = new ButterKnife.Action<View>() {
            @Override
            public void apply(@NonNull View view, int index) {
                view.setBackgroundColor(Color.RED);
            }
        };
        ButterKnife.apply(tv4, CHANGECOLOR);

        return view;
    }

    @OnClick({R.id.button1, R.id.button2})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(getActivity(), "按钮一", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(getActivity(), "按钮二", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
