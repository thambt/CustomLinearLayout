package com.example.tham.customlayoutw3;

import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnChange;
    private CustomLinearLAyout myLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = (Button)findViewById(R.id.activity_main_btn_change);
        myLayout = (CustomLinearLAyout)findViewById(R.id.activity_main_myll);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLayout.changeLayout();
            }
        });
    }
}
