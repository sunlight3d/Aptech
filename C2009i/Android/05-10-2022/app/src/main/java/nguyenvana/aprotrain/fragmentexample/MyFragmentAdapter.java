package nguyenvana.aprotrain.fragmentexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFragmentAdapter extends FragmentStateAdapter {
    ArrayList<String> pages;
    public MyFragmentAdapter(@NonNull FragmentActivity fragmentActivity,
                             ArrayList<String> pages) {
        super(fragmentActivity);
        this.pages = pages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new ScreenSlidePageFragment(pages.get(position));
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }
}
