package com.example.abathur.postlogin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Activity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        //Codes are added here:
        Intent intent = getIntent(); //For the Intent who activated this activity：The intent here is to get the Intent passed by the MainActivity
        Bundle bundle = intent.getExtras();
        String result = bundle.getString("username");

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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

    public void closeActivity(View v){
        Intent data = new Intent();

        data.putExtra("info", "Activity 2 successfully closed");

        setResult(30, data); //Set the return data

        this.finish(); //Close current Activity
    }

    public void ViewIndoorMap(View v)
    {
        // Go to the activity(interface) for the indoor map

    }

    public void ReturnMain(View v)
    {
        this.finish();
    }
}
