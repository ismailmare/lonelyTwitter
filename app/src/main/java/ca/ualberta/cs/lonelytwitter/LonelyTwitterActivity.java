package ca.ualberta.cs.lonelytwitter;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;

import android.app.Activity;
<<<<<<< HEAD

=======
import android.content.Context;
import android.content.Intent;
>>>>>>> e00b4c29219849a4e1f5516cbfca1e83537b784b
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

<<<<<<< HEAD
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

=======
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

>>>>>>> e00b4c29219849a4e1f5516cbfca1e83537b784b
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file3.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

<<<<<<< HEAD
	private ArrayList<Tweets> tweetsList = new ArrayList<Tweets>();
	private ArrayAdapter<Tweets> adapter;

	/** This function is called when the activity is
     *  first created.*/
=======
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

	public ArrayAdapter<Tweet> getAdapter() {
		return adapter;
	}

	public void setAdapter(ArrayAdapter<Tweet> adapter) {
		this.adapter = adapter;
	}

	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
>>>>>>> e00b4c29219849a4e1f5516cbfca1e83537b784b
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
<<<<<<< HEAD
				Tweets newTweet = new Tweets(text);

				tweetsList.add(newTweet);
				adapter.notifyDataSetChanged();
                bodyText.setText("");
				saveInFile();

=======
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
				// latestTweet.setMessage(latestTweet.getMessage() + "!");
				tweets.add(latestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

				//
				//
>>>>>>> e00b4c29219849a4e1f5516cbfca1e83537b784b

				//
				//
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
<<<<<<< HEAD
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
=======
		//String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
>>>>>>> e00b4c29219849a4e1f5516cbfca1e83537b784b
		}
	}
}