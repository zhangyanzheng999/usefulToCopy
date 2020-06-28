package com.atguigu.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author:zyz
 * @time:2020/5/17--15:51
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("count = " + count);
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("beanDefinitionNames = " + Arrays.asList(beanDefinitionNames));
    }
}
