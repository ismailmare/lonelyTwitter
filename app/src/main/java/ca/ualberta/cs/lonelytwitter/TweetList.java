package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h> Interacting with the TweetList</h>
 * <p> This class allows the adding and removal of tweets in an arraylist
 * </p>
 * @author Ismail Mare
 * @version 1.7
 * @since 2016-02-04
 */
public class TweetList{

    private ArrayList<Tweets> tweetsList= new ArrayList<Tweets>();

    /**
     * Adds tweets to the list
     * @param tweet
     */
    public void add(Tweets tweet){
        tweetsList.add(tweet);
    }

    /**
     * removing tweets
     * @param tweet
     */
    public void remove(Tweets tweet){
        tweetsList.remove(tweet);
    }

    /**
     * checking if the list contains a certain tweet
     * @param tweet
     * @return boolean
     */
    public boolean hasTweet(Tweets tweet){
        return tweetsList.contains(tweet);
    }

    /**
     * getting a certain tweet depending on list index
     * @param tweet
     * @return
     */
    public Tweets getTweet(int tweet){
        return tweetsList.get(tweet);
    }

}
