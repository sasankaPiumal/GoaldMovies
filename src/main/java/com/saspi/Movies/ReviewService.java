package com.saspi.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    public ReviewRepository reviewRepository;

    //create mongo template
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
//        Review review = new Review(reviewBody);
//        reviewRepository.insert(review);   //before

        Review review = reviewRepository.insert(new Review(reviewBody));   // new

        mongoTemplate.update(Movie.class) //inside this paranthesis include the class that I wanna update.
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
