package in.www.identibuy1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int counttab;
    public PageAdapter(@NonNull FragmentManager fm, int counttab) {
        super(fm);
        this.counttab=counttab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                Tab1Fragment tab1Fragment= new Tab1Fragment();
                return tab1Fragment;
            case 1:
                Tab2Fragment tab2Fragment= new Tab2Fragment();
                return tab2Fragment;
                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return counttab;
    }
}
