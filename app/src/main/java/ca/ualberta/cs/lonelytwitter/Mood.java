package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ismailmare on 16-01-12.
 */
public abstract class Mood{

    public String mood;
    public Date date;

    public Mood(Date date){
        date = new Date();
    }

    public String GetMood(){
        return mood;
    }

    public Date GetDate(){
        return date;
    }

    public void ChangeDate(Date NewDate){
        date=NewDate;
    }

    public void ChangeMood(String NewMood){
        mood = NewMood;
    }

}
