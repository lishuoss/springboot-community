package com.test.community.service;/*
 * @author 李硕
 *
 */

import com.test.community.pojo.AccessToken;
import com.test.community.pojo.GithubUser;
import org.springframework.stereotype.Component;

@Component
public interface GitHubService {

    String getAccessToken(AccessToken accessToken);
    GithubUser getGithubUser(String accessToken);
}
