package com.example.abathur.postlogin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private EditText Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.password);
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

    //Log In function
    //Execute when Button Clicked
    public void LogIn(View v)
    {
        String name = Username.getText().toString();
        String pw = Password.getText().toString();

        //The fields cannot be empty
        if( TextUtils.isEmpty(name) || TextUtils.isEmpty(pw) )
        {
            Toast.makeText(this, "User Name and Password shall not be empty!", Toast.LENGTH_SHORT).show();

            return;
        }

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("password", pw));

        Transfer T = new Transfer(params, Definition.LOGIN_POST);

        if( T.SendRequest() == 0)
        {
            //Log in Successful
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();

            GoToActivity2(name);
        }
        else
        {
            //Log in Failed
            Toast.makeText(this, "Unmatched username and password", Toast.LENGTH_SHORT).show();
        }
    }

    //Go to the Activity2, while passing the username as a parameter to it
    public void GoToActivity2(String username)
    {
        Intent intent = new Intent(this , Activity2.class);

        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        intent.putExtras(bundle);

        startActivityForResult(intent, 200); //Two parameters：The First is the object of the intent，The second is the requestCode
    }
}
