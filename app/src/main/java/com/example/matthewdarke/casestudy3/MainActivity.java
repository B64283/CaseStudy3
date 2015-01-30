package com.example.matthewdarke.casestudy3;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * Created by matthewdarke on 1/28/15.
 */





public class MainActivity extends ActionBarActivity implements ActionBar.OnNavigationListener {
    public CurrentStoryFragment fragment1;
    public FeaturedStoryFragment fragment2;
    public ImageGalleryFragment fragment3;
    public SettingsFragment fragment4;

    public FragmentManager fragmentManager;
    public FragmentTransaction fragTrans;

    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set up the action bar to show a dropdown list.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        fragment1 = (CurrentStoryFragment) android.app.Fragment.instantiate(this, CurrentStoryFragment.class.getName(), null);
        fragment2 = (FeaturedStoryFragment) android.app.Fragment.instantiate(this, FeaturedStoryFragment.class.getName(), null);
        fragment3 = (ImageGalleryFragment) android.app.Fragment.instantiate(this, ImageGalleryFragment.class.getName(), null);
        fragment4 = (SettingsFragment) android.app.Fragment.instantiate(this, SettingsFragment.class.getName(), null);
        // Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(
                // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter<>(
                        actionBar.getThemedContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        new String[]{
                                getString(R.string.title_section1),
                                getString(R.string.title_section2),
                                getString(R.string.title_section3),
                                getString(R.string.title_section4),
                        }),
                this);



    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getSupportActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getSupportActionBar().getSelectedNavigationIndex());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {
        // When the given dropdown item is selected, show its contents in the
        // container view.


        switch (position) {
            case 0:

                getString(R.string.title_section1);
                fragmentManager = getFragmentManager();
                fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.container, fragment1);
                fragTrans.commit();


                break;
            case 1:
                getString(R.string.title_section2);
                fragmentManager = getFragmentManager();
                fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.container, fragment2);
                fragTrans.commit();


                break;
            case 2:
                getString(R.string.title_section3);
                fragmentManager = getFragmentManager();
                fragmentManager = getFragmentManager();
                fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.container, fragment3);
                fragTrans.commit();


                break;
            case 3:
                getString(R.string.title_section4);
                fragmentManager = getFragmentManager();
                fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.container, fragment4);
                fragTrans.commit();

                break;
        }

        return true;
        }









    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }



    }

}
