package com.quotes.project.QuotesProject.service;

import com.quotes.project.QuotesProject.entity.MovieQuote;
import com.quotes.project.QuotesProject.repository.MovieQuotesRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieQuoteService {

    @Autowired
    private MovieQuotesRepository repository;

    public List<MovieQuote> getAllMovieQuotes() {
        return repository.findAll();
    }

    public String toAllMovieQuotesString() {
        List<MovieQuote> allQuotes = getAllMovieQuotes();
        if (CollectionUtils.isEmpty(allQuotes)) {
            return Strings.EMPTY;
        }
        StringBuilder stringBuilder = new StringBuilder();
        allQuotes.forEach(movieQuote -> stringBuilder.append(movieQuote.toString())
                .append(Strings.LINE_SEPARATOR)
                .append("************************************************************************************************")
                .append(Strings.LINE_SEPARATOR));
        return stringBuilder.toString();
    }

    public MovieQuote getMovieQuoteByMessage(String message) {
        return repository.findAll().stream()
                .filter(movieQuote -> movieQuote.getMessage().equals(message))
                .findFirst()
                .orElse(null);
    }

    public MovieQuote addNewMovieQuote(MovieQuote movieQuote) {
        movieQuote.setInsertTime(LocalDateTime.now());
        return repository.save(movieQuote);
    }

    public MovieQuote removeMovieQuote(String message) {
        MovieQuote movieQuote = getMovieQuoteByMessage(message);
        if (movieQuote != null) {
            repository.deleteById(movieQuote.getId());
        }
        return movieQuote;
    }


}
