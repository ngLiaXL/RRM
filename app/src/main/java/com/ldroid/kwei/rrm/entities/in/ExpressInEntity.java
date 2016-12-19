package com.ldroid.kwei.rrm.entities.in;


import com.google.gson.annotations.Expose;
import com.ldroid.kwei.rrm.common.entities.InputEntity;

/**
 * type=shentong&postid=123123
 */
public class ExpressInEntity extends InputEntity {


    /**
     * ps:快递公司编码:申通=”shentong” EMS=”ems” 顺丰=”shunfeng”
     * 圆通=”yuantong” 中通=”zhongtong” 韵达=”yunda”
     * 天天=”tiantian” 汇通=”huitongkuaidi”
     * 全峰=”quanfengkuaidi” 德邦=”debangwuliu”
     * 宅急送=”zhaijisong”
     */
    @Expose
    public String type;
    @Expose
    public String postid;

    public ExpressInEntity(String type, String postid) {
        this.type = type;
        this.postid = postid;
    }
}
