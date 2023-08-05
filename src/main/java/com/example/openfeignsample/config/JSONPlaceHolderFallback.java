package com.example.openfeignsample.config;

import com.example.openfeignsample.fetcher.JSONPlaceHolderClient;
import com.example.openfeignsample.model.Post;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient {

  @Override
  public List<Post> getPosts() {
    return Collections.emptyList();
  }

  @Override
  public Post getPostById(Long postId) {
    return null;
  }
}