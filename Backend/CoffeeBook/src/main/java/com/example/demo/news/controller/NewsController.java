package com.example.demo.news.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.news.model.News;
import com.example.demo.news.service.NewsService;

@RestController
public class NewsController {

	@Autowired
	private NewsService service;

	@GetMapping("news")
	public ResponseEntity<Object> Get() {
		List<News> news = service.findAll();
		return new ResponseEntity<>(news, HttpStatus.OK);
	}

	@GetMapping("news/{id}")
	public ResponseEntity<Object> GetById(@PathVariable("id") long id) {
		Optional<News> news = service.findById(id);
		if (news == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(news, HttpStatus.OK);
	}

	@PostMapping("news/add")
	public ResponseEntity<Object> AddNews(@RequestBody News news) {
		News res = service.save(news);
		if (res == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PutMapping("news/edit/{id}")
	public ResponseEntity<Object> UpdateNews(@RequestBody News news, @PathVariable("id") long id) {
		News result = service.update(news, id);
		if (result == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("news/delete/{id}")
	public ResponseEntity<Object> DeleteById(@PathVariable("id") Long id) {
		try {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
