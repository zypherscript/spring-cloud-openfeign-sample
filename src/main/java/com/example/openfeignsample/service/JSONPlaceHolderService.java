package com.example.openfeignsample.service;

import com.example.openfeignsample.model.Post;
import java.util.List;

public interface JSONPlaceHolderService {

  List<Post> getPosts();

  Post getPostById(Long id);
}
