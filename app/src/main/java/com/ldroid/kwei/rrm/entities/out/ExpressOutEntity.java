package com.ldroid.kwei.rrm.entities.out;

import com.google.gson.annotations.Expose;
import com.ldroid.kwei.rrm.entities.BaseEntity;


public class ExpressOutEntity extends BaseEntity {

    @Expose
    public String time;
    @Expose
    public String ftime;
    @Expose
    public String context;


    @Override
    public String toString() {
        return "time：" + time + "\nftime：" + ftime + "\ncontext：" + context;
    }
}
