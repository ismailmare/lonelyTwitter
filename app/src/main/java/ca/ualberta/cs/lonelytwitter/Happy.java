package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ismailmare on 16-01-12.
 */
import java.util.Date;
public class Happy extends Mood {

    public Date MadDate;

    public Happy(Date date){
        super(date);
        MadDate = date;
    }

    public String MoodString(){
        String moodString = "I am very Happy :)";
        return moodString;
    }

}