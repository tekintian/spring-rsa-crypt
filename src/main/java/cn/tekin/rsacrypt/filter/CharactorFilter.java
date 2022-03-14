package cn.tekin.rsacrypt.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符编码过滤器, 可解决编码问题
 */
public class CharactorFilter implements Filter { //继承Filter类
    //字符编码
    String encoding=null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if(encoding!=null){
        //设置request字符编码
            request.setCharacterEncoding(encoding);
         //设置response字符编码
            response.setContentType("text/html;charset="+encoding);
        }
        System.out.println("charactor filter ------------------");
       //传递给下一个过滤器
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      //获取初始化参数
        encoding=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void destroy() {
        encoding=null;
    }

}