import java.util.Date;
public class Task {
    String title , description;
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public  String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
