package ca.ualberta.cs.lonelytwitter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * <h> Creating a tweet</h>
 * <p> creating a tweet object using either just a string or also
 * can use string and date</p>
 * @author Ismail Mare
 * @version 1.7
 * @since 2016-02-04
 */
public class Tweets {

    protected Date date;
    protected String message;

    /**
     * Creating a tweet object using a string and the date
     * @param date
     * @param message
     */
    public Tweets(Date date, String message){
        this.date=date;
        this.message=message;
    }

    /**
     * Creating a tweet object using just a string
     * @param message
     */
    public Tweets(String message){
        this.date= new Date();
        this.message=message;
    }

    @Override
    /**
     * Printing the tweet object's message and date
     * returns string
     */
    public String toString(){
        return date.toString() + " | " + message;
    }

    /**
     * getting the date
     * @return date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * getting the tweet message
     * @return string
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * changing the message of this tweet object
     * @param message
     */
    public void changeMessage(String message){
            this.message=message;

    }

    /**
     * changing the date of this tweet object
     * @param date
     */
    public void changeDate(String date){
        try {
            DateFormat format= new SimpleDateFormat("yyyy-mm-dd");
            Date date1 = format.parse(date);
            this.date=date1;
        } catch (ParseException e) {
        }
    }


}
