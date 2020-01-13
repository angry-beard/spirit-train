package org.angrybeard.fxiaoke;

import com.google.gson.Gson;
import org.angrybeard.fxiaoke.enums.FXiaoKeApiEnum;
import org.angrybeard.fxiaoke.req.Arg;
import org.angrybeard.fxiaoke.req.CorpAccessTokenArg;
import org.angrybeard.fxiaoke.resp.BaseResult;
import org.angrybeard.fxiaoke.resp.CorpAccessTokenResult;
import org.angrybeard.fxiaoke.resp.Result;
import org.angrybeard.fxiaoke.utils.BaseException;
import org.angrybeard.fxiaoke.utils.Constants;
import org.angrybeard.fxiaoke.utils.HttpTookit;
import org.angrybeard.fxiaoke.vo.HttpResponseMessageVO;

public class FXiaoKeDelegate {

    private static String host = "https://open.fxiaoke.com";
    private String a = "";
    private String b = "";
    private String c = "";

    public static void main(String[] args) {
        CorpAccessTokenArg arg = new CorpAccessTokenArg();
        arg.setAppId("FSAID_13189db");
        arg.setAppSecret("aac9a9fd62cf421b8fdc16485726f08f");
        arg.setPermanentCode("3129A513D03C3362F82D6D9FF8365E53");
        CorpAccessTokenResult result = new FXiaoKeDelegate().call(arg, FXiaoKeApiEnum.GET_CORP_TOKE);
        System.out.println(result);
    }

    public <T extends BaseResult> T call(Arg arg, FXiaoKeApiEnum api) {
        return (T) doPost(host + api.getApi(), arg, api.getClazz());
    }


    private <T extends BaseResult> T doPost(String url, Arg arg, Class<T> clazz) {
        T t = null;
        Result<String> result = doPost(url, arg);
        if (result.getCode() == 0) {
            t = new Gson().fromJson(result.getData(), clazz);
        }

        if (t != null) {
            return t;
        }

        try {
            t = clazz.newInstance();
            t.setErrorCode(result.getCode());
            t.setErrorMessage(result.getMsg());
        } catch (Exception e) {
            System.out.println("doPost error, details:" + e);
        }
        return t;
    }

    private Result<String> doPost(String url, Arg arg) {
        Result<String> result = new Result<>();

        try {
            HttpResponseMessageVO resp = HttpTookit.sendPostByJson(url, new Gson().toJson(arg), 1000);

            if ("200".equals(resp.getHttpCode())) {
                result.setData(resp.getContent());
            } else {
                result.setCode(Constants.interfaceException.INTERFACE_EXCEPTION.code);
                result.setMsg(Constants.interfaceException.INTERFACE_EXCEPTION.msg.concat(",HTTP Status Code:").concat(
                        resp.getHttpCode()));
            }
        } catch (BaseException e) {
            System.out.println("doPost error, details:" + e);
            result.setMsg(e.getMessage());
            result.setCode(e.getCode());
        }
        return result;
    }
}
