package com.example.webclientdemo.service;

import com.example.webclientdemo.dto.GitHubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GitHubService {
    private final WebClient webClient;

    public GitHubService(WebClient webClient) {
        this.webClient = webClient;
    }


    public ResponseEntity<GitHubUser> getUser(String loginName){
        GitHubUser gitHubUser2 = getGitHubUser(loginName).block();
        return ResponseEntity.status(HttpStatus.OK).body(gitHubUser2);
    }
    public Mono<GitHubUser> getGitHubUser(String loginName){
        Mono<GitHubUser> gitHubUserMono = webClient.get()
                .uri("http://localhost:8080/api/" + loginName)
                .retrieve()
                .bodyToMono(GitHubUser.class);
        return gitHubUserMono;

    }
}
