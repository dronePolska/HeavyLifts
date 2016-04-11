package com.example.kuba.heavylifts;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class SetUpLifts extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.kuba.heavylifts.MESSAGE";
    public final static String RANDOM_MESSAGE = "com.example.kuba.heavylifts.MESSAGE";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //homescreen
    //determine the type of max effort lifts that have been completed
    //store these in a data structure (figure out how to store this)
    //provide button to go to "next week"

    //screen1
    //take "rep max" parameters. Predict week1 Dead/Clean/Mil/Squat

    //screen2. Once all "week 1's" are done, move to week2. There is option to move to week2
    //same as screen2

    //screen3.
    //same as screen3
    //once complete, store all data. Iterate back to screen1 with data blanked and new parameters thrown in.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_lifts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();  // Always call the superclass

        // Stop method tracing that the activity started during onCreate()
        Debug.stopMethodTracing();
    }

/*    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
        savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_up_lifts, menu);
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
    /*
    public void sendMessage(View view) {
    //Do something when clicking the button
        Intent intent = new Intent (this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }
*/

   /* public void sendStaticMessage(View view){
    //links to other button
        Intent intent = new Intent (this, SecondActivity.class);

        String message = "This is a random message";
        intent.putExtra (RANDOM_MESSAGE, message);
        startActivity(intent);
    }

*/

    public void setUpLiftsButtonClick(View view) {
        //links to other functions
        Intent intent = new Intent(this, ShowLifts.class);   //declares where the intent data will go
        int squatReps, deadReps, benchReps, milPressReps;

        EditText editText = (EditText) findViewById(R.id.squatReps);
        squatReps = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.deadReps);
        deadReps = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.benchReps);
       benchReps = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.milPressReps);
       milPressReps = Integer.parseInt(editText.getText().toString());


        //save data to a shared preferences file
        savePref(squatReps, deadReps, benchReps, milPressReps);


        intent.putExtra(RANDOM_MESSAGE, "message");
        //String message = "test";
        startActivity(intent);
    }

    private void savePref(int squatReps, int deadReps, int benchReps, int milPressReps) {



        SharedPreferences sharedPref = getSharedPreferences("android.app.heavylifts" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("squatReps", squatReps);
        editor.putInt("deadReps", deadReps);
        editor.putInt("benchReps", benchReps);
        editor.putInt("milPressReps", milPressReps);

        Log.d("test", "Saved Data to Shared Preferences File");

        //get data

//        Log.d("test", " " + test + " ");


        editor.commit();

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SetUpLifts Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.kuba.heavylifts/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SetUpLifts Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.kuba.heavylifts/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}




