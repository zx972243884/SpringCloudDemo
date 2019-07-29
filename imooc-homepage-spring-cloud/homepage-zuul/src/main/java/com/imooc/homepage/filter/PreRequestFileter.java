package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 在过滤器中存储客户端发起请求的时间戳
 *
 * Component标识组件是Spring应用中的bean
 */

@Component
public class PreRequestFileter extends ZuulFilter {
    /**
     * 指定过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义过滤器执行顺序  order越小  优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否启用当前的过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        //RequestContext 用于在过滤器之间传递消息
        RequestContext context = RequestContext.getCurrentContext();
        context.set("startTime",System.currentTimeMillis());

        return null;
    }
}
