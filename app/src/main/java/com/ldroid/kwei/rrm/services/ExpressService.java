package com.ldroid.kwei.rrm.services;


import com.ldroid.kwei.rrm.common.entities.OutputDataEntity;
import com.ldroid.kwei.rrm.entities.in.ExpressInEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ExpressService {


    @GET("/query")
    Observable<OutputDataEntity<ExpressInEntity>> reqExpress(
            @Query("type") String type,
            @Query("postid") String postid);

}
