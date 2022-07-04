package com.icss.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class MyDispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
   //配置中文乱码过滤器
    @Override
    protected Filter[] getServletFilters() {
        //设置中文乱码过滤器
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        //配置restful风格的请求方式的解析方法过滤器
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{filter,methodFilter};
    }



   /* @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(Myconfig.class);//注册配置类
        applicationContext.setServletContext(servletContext);
        //初始化DispatcherServlet
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("dispatcher",new DispatcherServlet(applicationContext));
        servletRegistration.addMapping("/");//映射
        servletRegistration.setLoadOnStartup(1);//启动的时间点 ----   >= 0 表示部署到服务器之后，创建对象
    }*/
}
