package com.ldroid.kwei.rrm.services;


import com.ldroid.kwei.rrm.common.entities.OutputListEntity;
import com.ldroid.kwei.rrm.entities.out.ExpressOutEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ExpressService {


    @GET("/query")
    Observable<OutputListEntity<ExpressOutEntity>> reqExpress(
            @Query("type") String type,
            @Query("postid") String postid);

}
