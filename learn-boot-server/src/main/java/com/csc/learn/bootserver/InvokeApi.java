package com.csc.learn.bootserver;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by lihuan on 2017/8/14.
 */
public class InvokeApi {

    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://localhost:8080");

        RestTemplate restTemplate = null;
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.basicAuthorization("user", "123456").build();

        String resp = restTemplate.getForObject(uri, String.class);

        System.out.print(resp);
    }
}
