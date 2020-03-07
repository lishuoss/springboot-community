package com.test.community.controller;/*
 * @author 李硕
 *
 */

import com.test.community.pojo.AccessToken;
import com.test.community.pojo.GithubUser;
import com.test.community.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GitHubService gitHubService;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callBack")
    public String callback(@RequestParam("code") String code,@RequestParam("state") String state){
        AccessToken accessToken = new AccessToken();
        accessToken.setClient_id(clientId);
        accessToken.setClient_secret(clientSecret);
        accessToken.setRedirect_uri(redirectUri);
        accessToken.setCode(code);
        accessToken.setState(state);
        String token = gitHubService.getAccessToken(accessToken);

        GithubUser githubUser = gitHubService.getGithubUser(token);
        System.out.println(githubUser);
        return "index";
    }


}
