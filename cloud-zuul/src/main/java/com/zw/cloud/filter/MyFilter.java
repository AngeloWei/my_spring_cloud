package com.zw.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.AssertFalse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        /**
         * pre：路由之前
         * routing：路由之时
         * post： 路由之后
         * error：发送错误调用
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        /**
         * 调用循序
         */
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /**
         * 过滤条件
         */
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info(String.format("Method:%s ,Url: %s",request.getMethod(),request.getRequestURL().toString()));
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(401);
            HttpServletResponse response = context.getResponse();
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = null;
            try {
               writer = context.getResponse().getWriter();
                writer.write("token 失效");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (writer != null) {
                    writer.close();
                }
            }
            return null;
        }
        return null;
    }
}
