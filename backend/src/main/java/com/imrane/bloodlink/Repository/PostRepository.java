package com.imrane.bloodlink.Repository;

import com.imrane.bloodlink.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {
}
