package ca.ualberta.cs.lonelytwitter;

<<<<<<< HEAD
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
     * @return Tweets object
     */
    public Tweets getTweet(int tweet){
        return tweetsList.get(tweet);
=======
import java.util.ArrayList;

/**
 * Created by watts1 on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets= new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
>>>>>>> e00b4c29219849a4e1f5516cbfca1e83537b784b
    }

}
