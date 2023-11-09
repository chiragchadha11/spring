package com.example.webclientdemo.controller;

import com.example.webclientdemo.dto.GitHubUser;
import com.example.webclientdemo.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GitHubController {
    @Autowired
    GitHubService gitHubService;
    @GetMapping("/{loginName}")
    public ResponseEntity<GitHubUser> getUser(@PathVariable ("loginName") String loginName){
        ResponseEntity<GitHubUser> user = gitHubService.getUser(loginName);
        return ResponseEntity.status(HttpStatus.OK).body(user.getBody());
    }
}
