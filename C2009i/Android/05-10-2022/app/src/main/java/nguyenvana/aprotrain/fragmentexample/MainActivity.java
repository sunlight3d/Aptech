package nguyenvana.aprotrain.fragmentexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;

import nguyenvana.aprotrain.fragmentexample.animations.ZoomOutPageTransformer;

public class MainActivity extends FragmentActivity {
    private ViewPager2 viewPager;
    private MyFragmentAdapter myFragmentAdapter;
    private ArrayList<String> pages = new
            ArrayList<>(Arrays.asList(new String[]{
            "Home", "Activity", "Chat","Settings"}));
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewPager = findViewById(R.id.pager);
        //viewPager.setPageTransformer(new ZoomOutPageTransformer());
        myFragmentAdapter = new MyFragmentAdapter(this, pages);
        viewPager.setAdapter(myFragmentAdapter);
        this.tabLayout = findViewById(R.id.tabLayout);
//        new TabLayoutMediator(tabLayout, viewPager,
//                (tab, position) -> tab.setText(pages.get(position))
//        ).attach();
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(pages.get(position));
            }
        }).attach();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}