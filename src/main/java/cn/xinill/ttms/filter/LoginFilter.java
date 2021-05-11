//package cn.xinill.ttms.filter;
//
//import cn.xinill.smart_photo.service.impl.TokenServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * @Author: Xinil
// * @Date: 2021/1/29 23:29
// */
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        int uid = -1;
//        try {
//            String token = ((HttpServletRequest)request).getHeader("token");
//            if(token == null){
//                System.err.println("token 为null");
////                request.getRequestDispatcher("/login.html").forward(request, response);
////                return;
//            }else{
//                uid = new TokenServiceImpl().verifyUserToken(token);
//                System.out.println("获取token uid=" + uid);
//            }
//            request.setAttribute("uid", uid);
//            filterChain.doFilter(request,response);
//        } catch (Exception e) {//需要登陆
//            e.printStackTrace();
//            System.err.println("需要登陆");
//            //request.getRequestDispatcher("/login.html").forward(request, response);
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
