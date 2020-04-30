package com.example.fetcherss;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NHome extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    Button signout;
    TextView email;
    //ImageView imageView;
    GoogleSignInClient mGoogleSignInClient;

    //private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_home);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        //  imageView =(ImageView)findViewById(R.id.imageView);
        email = (TextView)findViewById(R.id.textEmail);
        //name = (TextView)findViewById(R.id.textName);

        signout = (Button)findViewById(R.id.button2);

        signout.setOnClickListener(new View.OnClickListener()
                                   {

                                       @Override
                                       public void onClick(View view) {
                                           switch(view.getId())
                                           {
                                               case R.id.button2:
                                                   signOut();
                                                   break;
                                           }
                                       }
                                   }
        );
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null)
        {
            //String personName = acct.getDisplayName();

            String personEmail = acct.getEmail();
            //String personId = acct.getId();
            // Uri personPhoto = acct.getPhotoUrl();

           // name.setText(personName);
            email.setText(personEmail);
            //id.setText(personId);
        }

       /* Bundle firstData = getIntent().getExtras();
        String firstMessage = firstData.getString("CEmail");
        email.setText(firstMessage);*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.nav_app_bar_open_drawer_description,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /* mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/
    }

    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    private void signOut()
    {

        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Toast.makeText(NHome.this,"Signed Out successfully",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.n_home, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
       else if(id == R.id.order_action)
        {
            Intent intent = new Intent(NHome.this,Order.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }





    /*@Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();}*/



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_home)
        {
            Intent intent = new Intent(NHome.this,NHome.class);
            startActivity(intent);
        }
        else if(id == R.id.nav_order)
        {
            Intent intent = new Intent(NHome.this,Order.class);
            startActivity(intent);

        }

        else if(id == R.id.nav_offer)
        {
            Intent intent = new Intent(NHome.this,Offers.class);
            startActivity(intent);

        }
        else if(id == R.id.customer_support)
        {
            Intent intent = new Intent(NHome.this,CustomerSupport.class);
            startActivity(intent);

        }
        else if(id == R.id.rate_us)
        {
            Intent intent = new Intent(NHome.this,RateUs.class);
            startActivity(intent);

        }
        else if(id == R.id.share_us)
        {

        }
        else if(id == R.id.about_us)
        {
            Intent intent = new Intent(NHome.this,AboutUs.class);
            startActivity(intent);
        }


    DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
