package com.quotes.project.QuotesApp.repository;

import com.quotes.project.QuotesApp.entity.MovieQuote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieQuotesRepository extends JpaRepository<MovieQuote, UUID> {
}
