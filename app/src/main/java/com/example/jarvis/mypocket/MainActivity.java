package com.example.jarvis.mypocket;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.jarvis.mypocket.fragment.MainFragment;
import com.example.jarvis.mypocket.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(123), "MainFragment")
                    .commit();

        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment mainFragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            mainFragment.setTextview("Beer");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_setting) {

            Fragment fragment = getSupportFragmentManager()
                    .findFragmentById(R.id.contentContainer);

            if (fragment instanceof SecondFragment == false) {
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.from_right,R.anim.to_left,
                                R.anim.from_left,R.anim.to_right
                        )
                        .replace(R.id.contentContainer,
                                SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
