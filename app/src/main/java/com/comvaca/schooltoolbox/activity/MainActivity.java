package com.comvaca.schooltoolbox.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.comvaca.schooltoolbox.R;
import com.comvaca.schooltoolbox.adpaters.TabsAdapter;
import com.comvaca.schooltoolbox.fragment.BookmarkFragment;
import com.comvaca.schooltoolbox.fragment.MainFragment;

public class MainActivity extends BaseActivity {

  private TabLayout tabLayout;
  private TabsAdapter adapter;
  private ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tabLayout = (TabLayout) findViewById(R.id.tabs);
    viewPager = (ViewPager) findViewById(R.id.viewpager);

    setupViewPager(viewPager);
    tabLayout.setupWithViewPager(viewPager);
  }

  private void setupViewPager(ViewPager viewPager) {
    adapter = new TabsAdapter(getSupportFragmentManager());
    adapter.addFrag(new BookmarkFragment(), "Bookmark");
    adapter.addFrag(new MainFragment(), "All");
    viewPager.setAdapter(adapter);
  }
}
