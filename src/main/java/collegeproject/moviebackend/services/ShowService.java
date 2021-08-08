package collegeproject.moviebackend.services;



import collegeproject.moviebackend.models.Movie;
import collegeproject.moviebackend.models.Show;
import collegeproject.moviebackend.models.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShowService {
    @Autowired
    private ShowRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Show> getShows(){
        return repository.findAll();
    }

    public void insertIntoShows(Show show){
        repository.insert(show);
    }

    public List<Show> getShowById(String id) throws Exception{
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        List<Show> show = mongoTemplate.find(query, Show.class);
        //Optional<Show> show=repository.findById(id);

        if(show.isEmpty()){
            throw new Exception(("Show with " + id + " is not found"));
        }

        return show;
    }

    public List<Show> getShowByTitle(String name){



        List<Show> shows=repository.findByTitleContainingIgnoreCase(name);

        return shows;
    }

    public void deleteShow( String id)
    {
        repository.deleteById(id);
    }

    public Show editShow(String id, Show newShow){
        Optional<Show> show = repository.findById(id);

        show.get().setTitle(newShow.getTitle());
        show.get().setOverview(newShow.getOverview());
        show.get().setGenres(newShow.getGenres());
        show.get().setRelease_date(newShow.getRelease_date());

        Show updateShow=repository.save(show.get());
        return updateShow;
    }
}
