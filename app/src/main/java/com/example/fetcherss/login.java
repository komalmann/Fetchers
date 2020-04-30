package com.example.fetcherss;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SignInButton signin;
    int RC_SIGN_IN=0;

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        signin = (SignInButton) findViewById(R.id.sign_in_button);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.sign_in_button:
                        signIn();
                        break;
                }
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }

    private void signIn()
    {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask)
    {
        try{
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Intent intent = new Intent(login.this,NHome.class);
            startActivity(intent);
        } catch(ApiException e)
        {
            Log.w("Error","signInResult:failed code="+ e.getStatusCode());
        }
    }

    public void emailLogin(View view)
    {
        EditText loginemail = (EditText)findViewById(R.id.loginemail);
        EditText loginpass = (EditText)findViewById(R.id.loginpassword);
        String email = loginemail.getText().toString();
        String pass = loginpass.getText().toString();
        TextView hemail = (TextView)findViewById(R.id.textEmail);

        String oemail="mannkomal35@gmail.com";
        String opass ="mannkomal26";
        if(email.equals(oemail) && pass.equals(opass))
        {

            Intent intent = new Intent(login.this,NHome.class);
             //intent.putExtra("CEmail",email);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(login.this,"Invalid login credentials",Toast.LENGTH_LONG).show();
        }


    }

    public void forgotpassword(View view)
    {
        Intent intent = new Intent(login.this,ForgotPassword.class);
        startActivity(intent);
    }

    public void onsignup(View view)
    {
        Intent intent = new Intent(login.this,Register.class);
        startActivity(intent);

    }

}









    /*  @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }
}*/
