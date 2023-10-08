package model;
import java.util.Calendar;

public class Photo {
    
    private String telescope;
    
    private Calendar photoDate;

    public Photo(String telescope, Calendar photoDate) {
        this.telescope = telescope;
        this.photoDate = photoDate;
    }


    public String getTelescope() {
            return telescope;
        }
    public void setTelescope(String telescope) {
        this.telescope = telescope;
    }

    public Calendar getPhotoDate() {
        return photoDate;
    }
    public void setPhotoDate(Calendar photoDate) {
        this.photoDate = photoDate;
    }



}
