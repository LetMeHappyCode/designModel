package com.example.demo.validator.Impl;

import com.example.demo.validator.Validator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator,InitializingBean,BeanPostProcessor, BeanNameAware, DisposableBean, ApplicationContextAware {
    @Override
    public void validate(String email, String password, String name) {
        System.out.println("PasswordValidator");
        if (!password.matches("^.{6,20}$")) {
//            throw new IllegalArgumentException("invalid password");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("13. 调用 setBeanName 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("13. 调用 destroy 方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("13. 调用 destroy 方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName)) {
            System.out.println("8. 调用 BeanPostProcessor.postProcessBeforeInitialization() 方法");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("userBean".equals(beanName)) {
            System.out.println("11. 调用 BeanPostProcessor.postProcessAfterInitialization() 方法");
        }
        return bean;
    }
}
