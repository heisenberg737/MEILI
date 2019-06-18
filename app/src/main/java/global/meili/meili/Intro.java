package global.meili.meili;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Intro extends AppCompatActivity {
   private Toolbar toolbar;
   private DrawerLayout drawerLayout;
   private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("About Us");

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_drawer);

        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Intent intent;
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        menuItem.setChecked(true);
                        displaymessage("Home Under development");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.contact:
                        menuItem.setChecked(true);
                        intent=new Intent(Intro.this,contactus.class);
                        startActivity(intent);
                        finish();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.login:
                        menuItem.setChecked(true);
                        displaymessage("Login Under development");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.profile:
                        menuItem.setChecked(true);
                        displaymessage("Profile Under development");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.signup:
                        menuItem.setChecked(true);
                        displaymessage("Sign up Under development");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.guides:
                        menuItem.setChecked(true);
                        displaymessage("Guides Under development");
                        drawerLayout.closeDrawers();
                        return true;
                }

                return false;
            }
        });
    }
    private void displaymessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
