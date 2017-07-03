package com.example.tham.customlayoutw3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by GameNet on 6/26/2017.
 */

public class CustomLinearLAyout extends LinearLayout {
    Boolean flagAnimation ;
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;
    LinearLayout llParaentLayout;
    Rect hitRect;

    public CustomLinearLAyout(Context context) {
        super(context);
        init(context);
    }

    public CustomLinearLAyout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View.inflate(context, R.layout.activity_custom_linearlayout, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        view1 = (TextView)findViewById(R.id.activity_custom_linearlayout_view1);
        view2 = (TextView)findViewById(R.id.activity_custom_linearlayout_view2);
        view3 = (TextView)findViewById(R.id.activity_custom_linearlayout_view3);
        view4 = (TextView)findViewById(R.id.activity_custom_linearlayout_view4);
        llParaentLayout = (LinearLayout)findViewById(R.id.activity_custom_linearlayout_ll);

        /*view1.setWidth(1000);
        view1.setHeight(100);
        view2.setWidth(1000);
        view2.setHeight(100);
        view3.setWidth(1000);
        view3.setHeight(100);
        view4.setWidth(1000);
        view4.setHeight(100);*/

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes( // lay chuoi cac thuoc tinh da duoc dinh nghia
                    attrs,
                    R.styleable.MyCheckBox,
                    0, 0);
            int color1 = Color.BLUE;
            int myGravity = 3;
            try {
                color1 = a.getInt(R.styleable.MyCheckBox_background_view,Color.BLUE);
                myGravity = a.getInt(R.styleable.MyCheckBox_mygravity,3);

            } catch (Exception e) {
                Log.e("MyCheckBox", "There was an error loading attributes.");
            } finally {
                a.recycle();
            }
            setColorView(color1);
            setMyGravity(myGravity);
        }
    }

    public void changeLayout() {
        if(llParaentLayout.getOrientation() == LinearLayout.HORIZONTAL) {
            changeVertacal();
        } else {
            changeHorizontal();
        }
    }

    private void changeHorizontal() {
        view1.setAnimation(initAppearAnimation(0));
        view2.setAnimation(initAppearAnimation(2000));
        view3.setAnimation(initAppearAnimation(4000));
        view4.setAnimation(initAppearAnimation(6000));
        llParaentLayout.setOrientation(LinearLayout.HORIZONTAL);
       /* view1.setHeight(1000);
        view1.setWidth(100);
        view2.setHeight(1000);
        view2.setWidth(100);
        view3.setHeight(1000);
        view3.setWidth(100);
        view4.setHeight(1000);
        view4.setWidth(100);*/
    }

    private void changeVertacal() {
        view1.setAnimation(initAppearAnimation(0));
        view2.setAnimation(initAppearAnimation(2000));
        view3.setAnimation(initAppearAnimation(4000));
        view4.setAnimation(initAppearAnimation(6000));
        llParaentLayout.setOrientation(LinearLayout.VERTICAL);
       /* view1.setHeight(100);
        view1.setWidth(1000);
        view2.setHeight(100);
        view2.setWidth(1000);
        view3.setHeight(100);
        view3.setWidth(1000);
        view4.setHeight(100);
        view4.setWidth(1000);*/
    }

    /*private Animation initMoveAnimation(long delay) {
        TranslateAnimation animation = new TranslateAnimation(1000,0,0,0);
        animation.setDuration(2000);
        animation.setFillAfter(false);
        animation.setStartOffset(delay);
        return animation;
    }*/

    private Animation initAppearAnimation(long delay) {
        TranslateAnimation animation = new TranslateAnimation(1000,0,0,0);
        animation.setDuration(2000);
        animation.setFillAfter(false);
        animation.setStartOffset(delay);
        return animation;
    }

    private void setColorView(int color1) {
        view1.setBackgroundColor(color1);
        view2.setBackgroundColor(color1);
        view3.setBackgroundColor(color1);
        view4.setBackgroundColor(color1);
    }

    private void setMyGravity(int gravity) {
        ((LinearLayout.LayoutParams) llParaentLayout.getLayoutParams()).gravity = gravity;
    }

    public CustomLinearLAyout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.activity_custom_linearlayout, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        view1 = (TextView) findViewById(R.id.activity_custom_linearlayout_view1);
        view2 = (TextView)findViewById(R.id.activity_custom_linearlayout_view2);
        view3 = (TextView)findViewById(R.id.activity_custom_linearlayout_view3);
        view4 = (TextView)findViewById(R.id.activity_custom_linearlayout_view4);
        hitRect = new Rect();
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getHitRect(hitRect);
                if (hitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    motionEvent.setLocation(0.0f, 0.0f);
                }
                return true;
            }
        });
    }
}
