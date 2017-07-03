package com.example.tham.customlayoutw3;

import android.os.Handler;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnChange;
    private CustomLinearLAyout myLayout;
    private Animation.AnimationListener animationListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = (Button)findViewById(R.id.activity_main_btn_change);
        myLayout = (CustomLinearLAyout)findViewById(R.id.activity_main_myll);

        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim_move_x);
        animation.setAnimationListener(animationListener);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLayout.view1.startAnimation(animation);
                myLayout.view2.startAnimation(animation);
                myLayout.view3.startAnimation(animation);
                myLayout.view4.startAnimation(animation);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myLayout.changeLayout();
                    }
                }, 3000);
            }
        });
    }
}
