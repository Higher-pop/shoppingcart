package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author SherWin
 * @date 2019/12/4 8:57
 */
public class SystemConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 这个方法是用来继续对DispatcherServlet进行自定义配置的.
     *
     * 设置让Spring mvc支持文件上传
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("",
                500000, 500000, 0));

    }

    /*//===========注册过滤器的方法二=============
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        String filterName = "myfilter";
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(filterName, new MyFilter());
        filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
        //父类的方法一定要调用,否则getRootConfigClasses与getServletConfigClasses等方法都会失效
        super.onStartup(servletContext);
    }*/
}
