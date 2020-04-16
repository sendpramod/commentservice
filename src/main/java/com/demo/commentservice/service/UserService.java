package com.demo.commentservice.service;

import com.demo.commentservice.model.external.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "feignUserService", url = "http://localhost:8282/users")
public interface UserService {
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId);
}
