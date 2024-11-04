package com.mvc.upgrade.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

//    Controller 실행 전 수행되는 메소드
//    return 값에 따라 false인 경우 controller 실행하지 않고 요청 종료
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        logger.info("[Interceptor] : preHandle");

        if(request.getRequestURI().contains("/loginform.do") ||
            request.getRequestURI().contains("/ajaxlogin.do") ||
            request.getSession().getAttribute("login") != null ||
            request.getRequestURI().contains("/test.do")) {
            return true;
        }

        if(request.getSession().getAttribute("login") == null) {
            response.sendRedirect("loginform.do");
        }
        return false;
    }


//    Controller 실행 후 수행되는 메소드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info("[Interceptor] : postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info("[Interceptor] : afterCompletion");
    }
}
