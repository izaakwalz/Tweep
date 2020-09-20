package com.example.tweep;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dots_layout;
    TextView[] dots;
    SliderAdapter sliderAdapter;
    Button getStarted;
    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        hooks ids
        viewPager = findViewById(R.id.slider);
        dots_layout = findViewById(R.id.dots);

//        call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots( 0);
        viewPager.addOnPageChangeListener(changeListener);

        getStarted = findViewById(R.id.get_started_btn);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, Menu.class));
            }
        });

        skip = findViewById(R.id.next_btn);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome.this, Menu.class));
            }
        });

    }

    private  void  addDots(int position) {

        dots = new  TextView[4];
        dots_layout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dots_layout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.black_grey));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int position) {
          addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}