package com.saspi.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public List<Movie> allMovies() {

        return movieRepository.findAll();

    }

    public Optional<Movie> OneMovie(ObjectId id) {
        return movieRepository.findById(id);
    }
}
