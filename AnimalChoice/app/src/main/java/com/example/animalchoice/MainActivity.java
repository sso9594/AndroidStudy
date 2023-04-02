package com.example.animalchoice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabSpec tabSpecFirst = tabHost.newTabSpec("First").setIndicator("첫번째");
        tabSpecFirst.setContent(R.id.강아지);
        tabHost.addTab(tabSpecFirst);

        TabSpec tabSpecSecond = tabHost.newTabSpec("second").setIndicator("두번째");
        tabSpecSecond.setContent(R.id.고양이);
        tabHost.addTab(tabSpecSecond);

        TabSpec tabSpecThird = tabHost.newTabSpec("third").setIndicator("세번째");
        tabSpecThird.setContent(R.id.토끼);
        tabHost.addTab(tabSpecThird);

        TabSpec tabSpecFourth = tabHost.newTabSpec("Fourth").setIndicator("네번째");
        tabSpecFourth.setContent(R.id.말);
        tabHost.addTab(tabSpecFourth);
        tabHost.setCurrentTab(0);
    }
}