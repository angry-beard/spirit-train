package org.angrybeard.fxiaoke.utils;

import com.google.gson.Gson;
import org.angrybeard.fxiaoke.req.Arg;
import org.angrybeard.fxiaoke.resp.Result;
import org.angrybeard.fxiaoke.vo.HttpResponseMessageVO;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * https 请求工具类
 *
 * @author huanghp
 * @date 2015年8月28日
 */
public class HttpTookit {


    public static final String CHARSET = "UTF-8";
    private static final CloseableHttpClient httpClient;

    static {
        // 饱含模式实现 httpClient 单例
        httpClient = createSSLClientDefault();
    }

    private HttpTookit() {
    }

    public static CloseableHttpClient createSSLClientDefault() {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(600000).setSocketTimeout(150000).build();

        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf =
                    new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            return HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultRequestConfig(config).build();
        } catch (Exception e) {
            System.out.println("init httpClient error, details:" + e);
        }

        return HttpClients.createDefault();
    }

    /**
     * post + json 发送请求
     *
     * @param url
     * @param parameters
     * @return @see HttpResponseMessageVO
     */
    public static HttpResponseMessageVO sendPostByJson(String url, String parameters, int timeout) throws BaseException {
        if (StringUtils.isEmpty(url)) {
            throw new BaseException(Constants.interfaceException.ILLEGAL_ARGUMENT.code,
                    Constants.interfaceException.ILLEGAL_ARGUMENT.msg + ": url is illegal !");
        }

        HttpResponseMessageVO httpResponseMessageVO = new HttpResponseMessageVO();
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            StringEntity params = new StringEntity(parameters, CHARSET);
            HttpPost request = new HttpPost(url);
            request.addHeader("Content-type", "application/json");
            request.setEntity(params);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(timeout)
                    .setSocketTimeout(timeout)//服务端响应时间
                    .setConnectTimeout(timeout)//建立socket链接超时时间
                    .build();
            request.setConfig(requestConfig);
            response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            entity = response.getEntity();
            httpResponseMessageVO.setHttpCode(Integer.toString(statusCode));

            if (statusCode == HttpStatus.SC_OK && entity != null) {
                httpResponseMessageVO.setContent(EntityUtils.toString(entity, CHARSET));
            }
        } catch (Exception e) {
            System.out.println("sendPostByJson error, details:" + e);
            throw new BaseException(Constants.interfaceException.INTERFACE_EXCEPTION.code,
                    Constants.interfaceException.INTERFACE_EXCEPTION.msg);
        } finally {
            try {
                if (entity != null) {
                    EntityUtils.consume(entity);
                }
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {

            }
        }

        return httpResponseMessageVO;
    }

    private static Result<String> sendPostByJson(String url, Arg arg) {
        Result<String> result = new Result<>();
        if (StringUtils.isEmpty(url)) {
            result.setCode(Constants.interfaceException.ILLEGAL_ARGUMENT.code);
            result.setMsg(Constants.interfaceException.ILLEGAL_ARGUMENT.msg + ":" + url);
            return result;
        }
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            StringEntity params = new StringEntity(new Gson().toJson(arg), CHARSET);
            HttpPost request = new HttpPost(url);
            request.addHeader("Content-type", "application/json");
            request.setEntity(params);
            response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            entity = response.getEntity();

            if (statusCode == HttpStatus.SC_OK && entity != null) {
                result.setData(EntityUtils.toString(entity, CHARSET));
            } else {
                result.setCode(Constants.interfaceException.INTERFACE_EXCEPTION.code);
                result.setMsg(Constants.interfaceException.INTERFACE_EXCEPTION.msg + ":" + url + ",HTTP Status Code:"
                        + statusCode);
            }
        } catch (Exception e) {
            System.out.println("sendPostByJson error, details:" + e);
            result.setCode(Constants.interfaceException.INTERFACE_EXCEPTION.code);
            result.setMsg("发送请求异常,请检查url、参数的合法性！异常错误:" + e.getMessage());
        } finally {
            try {
                if (entity != null) {
                    EntityUtils.consume(entity);
                }
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {

            }
        }
        return result;
    }
}
