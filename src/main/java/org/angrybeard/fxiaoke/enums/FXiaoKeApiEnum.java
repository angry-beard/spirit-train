package org.angrybeard.fxiaoke.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.angrybeard.fxiaoke.resp.CorpAccessTokenResult;

@Getter
@AllArgsConstructor
public enum FXiaoKeApiEnum {

    GET_CORP_TOKE("/cgi/corpAccessToken/get/V2", CorpAccessTokenResult.class, "获取corpAccessToken");

    private String api;
    private Class clazz;
    private String desc;
}
