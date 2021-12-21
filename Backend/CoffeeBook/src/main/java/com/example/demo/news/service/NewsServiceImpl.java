package com.example.demo.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.news.model.News;
import com.example.demo.news.repository.NewsRepository;

@Service
public class NewsServiceImpl extends GenericServiceImpl<News, Long> implements NewsService {

	@Autowired
	private NewsRepository repo;

	@Override
	public News update(News model, Long id) {
		try {
			News news = repo.getById(id);
			news.setTitle(model.getTitle());
			news.setThumbnail(model.getThumbnail());
			news.setContent(model.getContent());
			return repo.save(news);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

}
