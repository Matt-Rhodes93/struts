package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new FilterDispatcher());
        frBean.setOrder(1);
        return frBean;
    }

    @Bean
    public FilterRegistrationBean strutsCleanup() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new ActionContextCleanUp());
        frBean.setOrder(2);
        return frBean;
    }

    @Bean
    public FilterRegistrationBean siteMesh() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new PageFilter());
        frBean.setOrder(3);
        return frBean;
    }
}
