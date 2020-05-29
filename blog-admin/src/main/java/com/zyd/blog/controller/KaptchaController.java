package com.zyd.blog.controller;

import com.zyd.blog.fun.KaptchaFun;
import com.zyd.blog.plugin.kaptcha.Captcha;
import com.zyd.blog.plugin.kaptcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

/**
 * 验证码
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@Slf4j
@Controller
public class KaptchaController {

    @GetMapping("/getKaptcha")
    @ResponseBody
    public void getKaptcha(HttpServletResponse response) {
        Stream.of(response)
                .peek(KaptchaFun.setHeaderFun)
                .forEach(KaptchaFun.respKaptchaFun);
    }

}
