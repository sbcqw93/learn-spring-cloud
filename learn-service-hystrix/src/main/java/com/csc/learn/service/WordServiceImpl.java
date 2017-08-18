package com.csc.learn.service;

import com.csc.learn.feign.AdjectiveFeignClient;
import com.csc.learn.feign.NounFeignClient;
import com.csc.learn.feign.SubjectFeignClient;
import com.csc.learn.feign.VerbFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

/**
 * Created by lihuan on 2017/8/16.
 */
@Service("wordService")
public class WordServiceImpl implements WordService {

    @Autowired
    SubjectFeignClient subjectFeignClient;
    @Autowired
    VerbFeignClient verbFeignClient;
    @Autowired
    NounFeignClient nounFeignClient;
    @Autowired
    AdjectiveFeignClient adjectiveFeignClient;

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public String getSubject() {
        return subjectFeignClient.getWord();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackSubject")
    public Future<String> getSubject2() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return subjectFeignClient.getWord();
            }
        };
    }

    @Override
    public String getVerb() {
        return verbFeignClient.getWord();
    }

    @Override
    public String getAdjective() {
        return adjectiveFeignClient.getWord();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallbackNoun")
    public String getNoun() {
        return nounFeignClient.getWord();
    }

    @Override
    public Observable<String> getNoun2() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(nounFeignClient.getWord());
                        subscriber.onCompleted();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public String getFallbackSubject(){
        return "某人";
    }

    public String getFallbackNoun() {
        return "某物";
    }
}
