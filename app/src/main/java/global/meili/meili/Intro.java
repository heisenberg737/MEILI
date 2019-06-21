package global.meili.meili;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
   FragmentManager fragmentManager1=getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_drawer);

        drawerLayout=findViewById(R.id.intro);
        navigationView=findViewById(R.id.navigation);


        if(findViewById(R.id.intro)!=null)
        {
            if(savedInstanceState!=null)
                return;

        }
        FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
        fragmentTransaction1.add(R.id.MainContent,new home(),null).commit();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment=new home();
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().popBackStack();
                        toolbar.setTitle("Home");
                        drawerLayout.closeDrawers();
                        fragment=new home();
                        break;
                    case R.id.contact:
                        menuItem.setChecked(true);
                        getSupportFragmentManager().popBackStack();
                        fragment=new contact_us();
                        toolbar.setTitle("Contact Us");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.login:
                        menuItem.setChecked(true);
                        displaymessage("Login Under development");
                        toolbar.setTitle("Log In");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.profile:
                        menuItem.setChecked(true);
                        displaymessage("Profile Under development");
                        toolbar.setTitle("Profile");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.signup:
                        menuItem.setChecked(true);
                        displaymessage("Sign up Under development");
                        toolbar.setTitle("Sign Up");
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.guides:
                        menuItem.setChecked(true);
                        displaymessage("Guides Under development");
                        toolbar.setTitle("Guides");
                        drawerLayout.closeDrawers();
                        break;
                }
                fragmentTransaction.replace(R.id.MainContent,fragment,null).commit();



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
