package com.mighty.cupoferta;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.mighty.cupoferta.ui.OnNavListener;
import com.mighty.cupoferta.ui.fragments.InicioFragment;
import com.mighty.cupoferta.ui.fragments.ConfiguracionFragment;
import com.mighty.cupoferta.ui.fragments.MedallasFragment;
import com.mighty.cupoferta.ui.fragments.MisCuponesFragment;
import com.mighty.cupoferta.ui.fragments.SobreAppFragment;

public class NavigationActivity extends AppCompatActivity implements OnNavListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, new InicioFragment());
        fragmentTransaction.commit();

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.menuInicio:
                        changeFragment(0);
                        return true;
                    case R.id.menuCupones:
                        changeFragment(1);
                        return true;
                    case R.id.menuMedallas:
                        changeFragment(2);
                        return true;
                    case R.id.menuConfiguracion:
                        changeFragment(3);
                        return true;
                    case R.id.menuApp:
                        changeFragment(4);
                        return true;
                    default:
                        return true;
                }
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void changeFragment(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new InicioFragment();
                break;
            case 1:
                fragment = new MisCuponesFragment();
                break;
            case 2:
                fragment = new MedallasFragment();
                break;
            case 3:
                fragment = new ConfiguracionFragment();
                break;
            case 4:
                fragment = new SobreAppFragment();
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
