package com.codeup.springblogapp.repositories;

import com.codeup.springblogapp.models.Post;
import com.codeup.springblogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}

