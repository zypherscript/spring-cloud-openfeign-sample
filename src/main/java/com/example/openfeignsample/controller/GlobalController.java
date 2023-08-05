package com.example.openfeignsample.controller;

import com.example.openfeignsample.fetcher.JSONPlaceHolderClient;
import com.example.openfeignsample.model.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {

  @Autowired
  private JSONPlaceHolderClient jsonPlaceHolderClient;

  @GetMapping(value = "posts")
  public List<Post> getPosts() {
    return jsonPlaceHolderClient.getPosts();
  }

  @GetMapping(value = "posts/{id}")
  public Post getPostById(@PathVariable(value = "id") Long id) {
    return jsonPlaceHolderClient.getPostById(id);
  }
}
