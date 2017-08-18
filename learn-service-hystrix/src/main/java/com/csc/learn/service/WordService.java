package com.csc.learn.service;

import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.Future;

/**
 * Created by lihuan on 2017/8/16.
 */
public interface WordService {
    String getSubject();
    /**异步方式*/
    Future<String> getSubject2();
    String getVerb();
    String getAdjective();
    String getNoun();
    /**reactive方式*/
    Observable<String> getNoun2();
}
