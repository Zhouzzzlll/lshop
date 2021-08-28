package com.my.xxb.config;

import com.my.xxb.JWT.filter.jwtFilter;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilerFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultSecurityManager") DefaultSecurityManager defaultSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultSecurityManager);
        Map<String, Filter> UserfilterMap = new LinkedHashMap<>();
        UserfilterMap.put("jwt",new jwtFilter());
        filterFactoryBean.setFilters(UserfilterMap);
        filterFactoryBean.setUnauthorizedUrl("/verify/unauthorized");

        Map<String,String> filterMap=new HashMap<>();
        //anon 不需要授权就可以访问
        //authc 认证了才能访问
        //user 必须拥有 记住我 才能访问
        //role 拥有某个角色的权限才能访问
        filterMap.put("/User/**","anon");
        filterMap.put("/verify/**","anon");
       // filterMap.put("/account/**","anon");
        filterMap.put("/**","jwt");
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        filterFactoryBean.setLoginUrl("/verify/unverified");

        return filterFactoryBean;
    }

    //DafaultSecurityManage
    @Bean
    public DefaultWebSecurityManager defaultSecurityManager(@Qualifier("realm") userRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);

        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }

    //创建real对象，需要进行自定义
    @Bean
    public userRealm realm(){
        return new userRealm();
    }
}
