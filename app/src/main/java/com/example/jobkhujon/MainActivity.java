package com.example.jobkhujon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jobkhujon.fragment.Dashboard;
import com.example.jobkhujon.fragment.Home;
import com.example.jobkhujon.fragment.ProfileFragment;
import com.example.jobkhujon.helper.BottomNavigationBehavior;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ActionBar toolbar;

    LinearLayout linearLayout;

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.line1);
        cardView = findViewById(R.id.card_view1);
        toolbar = getSupportActionBar();

        toolbar.setTitle("Home");

        mTextMessage = (TextView) findViewById(R.id.message);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(getApplicationContext(), "MainActivity CardView Clicked", Toasty.LENGTH_LONG).show();
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
    }

    private boolean loadFragment(Fragment fragment) {
        /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();*/
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    item.setChecked(true);
                    fragment = new Home();
                    toolbar.setTitle("Home");
                    linearLayout.setVisibility(View.GONE);
                    break;
                case R.id.navigation_dashboard:
                    fragment = new Dashboard();
                    toolbar.setTitle("Dashboard");
                    linearLayout.setVisibility(View.GONE);
                    break;
                case R.id.navigation_notifications:
                    fragment = new Home();
                    toolbar.setTitle("Notification");
                    linearLayout.setVisibility(View.GONE);
                    break;
                case R.id.navigation_job:
                    fragment = new Home();
                    toolbar.setTitle("Jobs");
                    linearLayout.setVisibility(View.GONE);
                    break;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    toolbar.setTitle("Profile");
                    linearLayout.setVisibility(View.GONE);
                    break;
            }
            return loadFragment(fragment);
        }
    };
    @Override
    public void onBackPressed() {
        tellFragments();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }

    private void tellFragments() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for (Fragment f : fragments) {
            if (f != null && f instanceof Dashboard) {
                ((Dashboard) f).onBackPressed();
            } else if (f != null && f instanceof Home) {
                ((Home) f).onBackPressed();
            } else if (f != null && f instanceof ProfileFragment) {
                ((ProfileFragment) f).onBackPressed();
            } /*else if (f != null && f instanceof Friday) {
                ((Friday) f).onBackPressed();
            }*/

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            return true;
        }
       /* if (drawerToggle.onOptionsItemSelected(item))
            return true;*/
        return super.onOptionsItemSelected(item);
    }

}
