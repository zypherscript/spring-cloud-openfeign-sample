package com.example.openfeignsample.service.impl;

import com.example.openfeignsample.fetcher.JSONPlaceHolderClient;
import com.example.openfeignsample.model.Post;
import com.example.openfeignsample.service.JSONPlaceHolderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JSONPlaceHolderServiceImpl implements JSONPlaceHolderService {

  @Autowired
  private JSONPlaceHolderClient jsonPlaceHolderClient;

  @Override
  public List<Post> getPosts() {
    return jsonPlaceHolderClient.getPosts();
  }

  @Override
  public Post getPostById(Long id) {
    return jsonPlaceHolderClient.getPostById(id);
  }
}
