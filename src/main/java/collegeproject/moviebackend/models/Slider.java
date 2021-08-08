package collegeproject.moviebackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("slider")
public class Slider {

    @Id
    private String id;
    private String title;
    private String poster;

    public Slider() {
    }

    public Slider(String id, String title, String poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Slider{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
