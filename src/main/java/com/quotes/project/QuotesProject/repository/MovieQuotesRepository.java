package com.quotes.project.QuotesProject.repository;

import com.quotes.project.QuotesProject.entity.MovieQuote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieQuotesRepository extends JpaRepository<MovieQuote, UUID> {
}
