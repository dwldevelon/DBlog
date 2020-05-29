package com.zyd.blog.fun;

import com.zyd.blog.plugin.kaptcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Consumer;

@Slf4j
public class KaptchaFun {
    public static Consumer<HttpServletResponse> setHeaderFun = resp -> {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/gif");
    };
    public static Consumer<HttpServletResponse> respKaptchaFun = resp -> {
        try {
            new GifCaptcha(146,33,4).out(resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取响应流异常：{}", e.getMessage());
        }
    };
}
