package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ismailmare on 16-01-12.
 */
import java.util.Date;
public class Mad extends Mood {

    public Date MadDate;

    public Mad(Date date){
        super(date);
        MadDate = date;
    }

    public String MoodString(){
        String moodString = "I am very Angry >:(";
        return moodString;
    }

}
