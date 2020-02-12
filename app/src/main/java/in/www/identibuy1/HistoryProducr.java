package in.www.identibuy1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class HistoryProducr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_producr);
        ImageView img=findViewById(R.id.back);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Product"));
        tabs.addTab(tabs.newTab().setText("Recent History"));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager= findViewById(R.id.view_pager);
        PageAdapter pageAdapter=new PageAdapter(getSupportFragmentManager(),tabs.getTabCount());
        viewPager.setAdapter(pageAdapter);

        /*        viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener) new TabLayout.TabLayoutOnPageChangeListener(tabs));*/
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }
}
