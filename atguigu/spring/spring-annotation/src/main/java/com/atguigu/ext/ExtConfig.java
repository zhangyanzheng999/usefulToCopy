package com.atguigu.ext;

import com.atguigu.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * BeanPostProcessor:bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor：beanFactory的后置处理器
 *      在beanFactory标准初始化之后调用:所有的bean定义已经保存加载到beanFactory中，但是bean的实例还未创建
 *1、BeanFactoryPostProcessor原理
 * 1)、ioc容器创建对象
 * 2)、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor
 *      如何找到BeanFactoryPostProcessor并执行它们的方法
 *          1)、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件,并执行它们的方法
 *          2)、在初始化创建其他组件前面执行
 *
 *2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry();
 *      在所有bean定义信息将要被加载，但是bean实例还未创建的时候执行
 *
 *      优先于BeanFactoryPostProcessor执行，利用BeanDefinitionRegistryPostProcessor给容器中额外添加一些组件
 *
 *  原理：
 *      1)、ioc创建对象
 *      2)、refresh()->invokeBeanFactoryPostProcessors(beanFactory);
 *      3)、先从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件，
 *          1)、依次触发所有的postProcessBeanDefinitionRegistry()方法
 *          2)、再触发postProcessBeanFactory()方法
 *      4)、再来从容器中找到BeanFactoryPostProcessor组件：然后依次触发postProcessBeanFactory()方法
 *
 *3、ApplicationListener：监听容器中发布的事件，完成事件驱动模型的开发
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *        监听ApplicationEvent及其子事件
 *
 *    步骤：
 *      1)、写一个监听器(ApplicationListener实现类)来监听某个事件(ApplicationEvent及其子类)
 *          @EventListener
 *           原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener注解
 *      2)、把监听器加入到容器中；
 *      3)、只要容器中有相关事件的发布，我们就能监听到这个事件
 *          ContextRefreshedEvent：容器刷新完成(所有bean都完全创建)会发布这个事件
 *          ContextClosedEvent：关闭容器会发布这个事件
 *      4)、发布一个事件
 *           applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
 *          });
 *
 *    原理：
 *      ContextRefreshedEvent、IOCTest_Ext$1[source=我发布的事件]、ContextClosedEvent
 *    1)、ContextRefreshedEvent事件：
 *      1)、容器创建对象：refresh()
 *      2)、finishRefresh();容器刷新完成会发布ContextRefreshedEvent事件
 *    2)、自己发布事件
 *    3)、容器关闭会发布ContextClosedEvent
 *      【事件发布流程】：
 *      3)、publishEvent(new ContextRefreshedEvent(this));
 *             1)、获取事件的多播器(派发器)：getApplicationEventMulticaster()
 *             2)、multicastEvent()派发事件
 *             3)、获取到所有的ApplicationListener
 *              for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
 *                  1)、如果有Executor,可以支持使用Executor进行异步派发
 *                      Executor executor = getTaskExecutor();
 *                  2)、否则，同步的方式直接执行listener方法；invokeListener(listener, event);
 *                  拿到listener回调onApplicationEvent()方法
 *
 *
 *     【事件多播器(派发器)】
 *      1)、容器创建对象：refresh()方法
 *      2)、initApplicationEventMulticaster(); 初始化ApplicationEventMulticaster
 *          1)、先去容器找有没有id=applicationEventMulticaster的组件
 *          2)、如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *              并且加入到容器中，我们就可以在其他组件在派发事件时，自动注入这个applicationEventMulticaster
 *
 *      【容器中有哪些监听器】
 *      1)、容器创建对象：refresh()方法
 *      2)、registerListeners();
 *          从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster中；
 *          String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *          //将listener注册到applicationEventMulticaster中
 *          getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *
 *
 *
 *      SmartInitializingSingleton原理：->afterSingletonsInstantiated();
 *          1)、ioc容器创建对象并refresh();
 *          2)、finishBeanFactoryInitialization(beanFactory); 初始化剩下的单实例bean
 *              1)、先创建所有的单实例bean，调用getBean()方法创建
 *              2)、获取所有创建好的单实例bean，判断是否是SmartInitializingSingleton类型的；
 *                  如果是就调用afterSingletonsInstantiated();
 *
 */
@ComponentScan("com.atguigu.ext")
@Configuration
public class ExtConfig {

        @Bean
        public Blue blue(){
            return new Blue();
        }
}
