package com.example.webclientdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GitHubUser {
    private Long id;
    private String login;
    private String node_id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String company;
    @JsonProperty("public_repos")
    private Integer publicRepos;
}
