package com.ruiqin.lazyload.network;

import com.ruiqin.lazyload.network.entity.ReqLogin;
import com.ruiqin.lazyload.network.entity.RespLogin;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ruiqin.shen
 * 类说明：
 */

public interface RestAPI {
    //登录
    @POST("v1.0/a736014c6d44")
    Flowable<RespLogin> login(@Body ReqLogin reqCheckMobileNo);

}
