package com.tatlicilar.proje;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//import com.tatlicilar.proje.R;
import fragment.OneFragment;
import fragment.ThreeFragment;
import fragment.TwoFragment;

public class CustomViewIconTextTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_icon_text_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
       tabLayout.setupWithViewPager(viewPager);
       setupTabIcons();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Kişiler");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.arkadas, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Tags");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tags, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Aramalar");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_call, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    /**
     * Adding fragments to ViewPager
     * @param viewPager
     */
     private void setupViewPager(ViewPager viewPager) {
       ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
         adapter.addFrag(new OneFragment(), "ONE");
      adapter.addFrag(new TwoFragment(), "TWO");
      adapter.addFrag(new ThreeFragment(), "THREE");
     viewPager.setAdapter(adapter);
    }

       class ViewPagerAdapter extends FragmentPagerAdapter {
           private final List<Fragment> mFragmentList = new ArrayList<>();
           private final List<String> mFragmentTitleList = new ArrayList<>();

           public ViewPagerAdapter(FragmentManager manager) {
               super(manager);
           }

           @Override
           public Fragment getItem(int position) {
               return mFragmentList.get(position);
           }

           @Override
           public int getCount() {
               return mFragmentList.size();
           }

           public void addFrag(Fragment fragment, String title) {
               mFragmentList.add(fragment);
               mFragmentTitleList.add(title);
           }

           @Override
           public CharSequence getPageTitle(int position) {
               return mFragmentTitleList.get(position);
           }
       }
}
