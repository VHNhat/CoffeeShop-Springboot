package com.example.demo.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.news.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
