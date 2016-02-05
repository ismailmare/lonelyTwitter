package ca.ualberta.cs.lonelytwitter;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedWriter;

import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *<h1> Lonley Twitter Activity</h1>
 *
 * <p>This program allows users to enter a tweet or message
 * and will display it in order based on the date.
 * Using gson to store the tweets.</p>
 *
 * @author Ismail Mare
 * @since 2016-02-04
 * @version 1.7
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file3.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweets> tweetsList = new ArrayList<Tweets>();
	private ArrayAdapter<Tweets> adapter;

	/** This function is called when the activity is
     *  first created.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

            /**
             * <h>onClick Save</h>
             * <p> when the user clicks the save button
             * the tweet list is updated and is displayed using gson</p>
             * @param v
             */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweets newTweet = new Tweets(text);

				tweetsList.add(newTweet);
				adapter.notifyDataSetChanged();
                bodyText.setText("");
				saveInFile();


			}
		});

        clearButton.setOnClickListener(new View.OnClickListener() {
            /**
             * <h>onClick Clear</h>
             * <p> when the user clicks the clear button
             * the tweet list is cleared and is saved and displayed using gson</p>
             * @param v
             */
            public void onClick(View v) {
                tweetsList.clear();
                adapter.notifyDataSetChanged();
                bodyText.setText("");
                saveInFile();
            }
        });
	}


	@Override
    /**
     * <h> onStart</h>
     * <p> when the program first starts this function will load the old tweets
     * from the file saved using gson</p>
     */
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweets>(this,R.layout.list_item, tweetsList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * <h> loadfromfile</h>
     * <p> Loading the list of tweets using gson</p>
     * @return String
     * @exception RuntimeException
     * @exception FileNotFoundException
     */
	private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
            Type listType = new TypeToken<ArrayList<Tweets>>() {}.getType();
            tweetsList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            tweetsList = new ArrayList<Tweets>();
		} catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
	}

    /**
     * <h>saveingfile</h>
     * <p> saving the tweet list after either an addition to the tweet list
     * or if the user clears the tweets</p>
     * @return nothing
     * @exception RuntimeException
     * @exception FileNotFoundException
     * @see RuntimeException
     * @see FileNotFoundException
     */
	private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweetsList, out);
            out.flush();
            fos.close();
        }catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException();
		}
	}
}