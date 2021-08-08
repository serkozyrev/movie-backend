package collegeproject.moviebackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("featuredshows")
public class FeaturedShow {

    @Id
    private String id;
    private String title;
    private String poster;
    private String overview;
    private int release_date;
    private String genres;
    private int numberOfSeasons;
    private int numberOfSeries;

    public FeaturedShow() {
    }

    public FeaturedShow(String id, String title, String poster, String overview, int release_date, String genres, int numberOfSeasons, int numberOfSeries) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.release_date = release_date;
        this.genres = genres;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfSeries = numberOfSeries;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getNumberOfSeries() {
        return numberOfSeries;
    }

    public void setNumberOfSeries(int numberOfSeries) {
        this.numberOfSeries = numberOfSeries;
    }

    @Override
    public String toString() {
        return "FeaturedShow{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", genres='" + genres + '\'' +
                ", numberOfSeasons='" + numberOfSeasons + '\'' +
                ", numberOfSeries='" + numberOfSeries + '\'' +
                '}';
    }
}
