package com.imrane.bloodlink.Service;


import com.imrane.bloodlink.Entity.Posts;
import com.imrane.bloodlink.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;


    public List<Posts> getAllPosts() {
        return postRepository.findAll();
    }
}
