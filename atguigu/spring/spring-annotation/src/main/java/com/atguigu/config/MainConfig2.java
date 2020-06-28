package com.atguigu.config;

import com.atguigu.bean.Color;
import com.atguigu.bean.ColorFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.WindowsCondition;
import com.atguigu.condition.myImportSelector;
import org.springframework.context.annotation.*;
//类中组件统一设置：满足当前条件，这个类中配置的所有bean才能生效
@Conditional({WindowsCondition.class})
@Configuration
//导入组件，id默认是组件的全类名
@Import({Color.class, Red.class, myImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    //默认是单实例的

    /**
     * * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE     prototype
     * * @see ConfigurableBeanFactory#SCOPE_SINGLETON   singleton
     * * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION   session
     *  prototype  多实例 ：ioc容器启动并不会去调用方法创建对象放在容器中，每次获取的时候才会调用方法，创建对象
     *  singleton 单实例的默认  :ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取就直接从容器中拿(map.get)
     *  request 同一个请求创建一个实例
     *  session 同一个session创建一个实例
     *  scope：调整作用域
     *
     *
     * 懒加载：针对单实例
     *      单实例bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象，在第一次使用(获取)bean的时候创建对象，并初始化。
     */
    //@Scope("prototype")

    @Lazy//懒加载
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person....");
        return new Person("zhangsan", 25);
    }
    /**
     * @Conditional({}):按照一定的条件进行判断，满足条件给容器中注册Bean
     * 如果系统是windows，给容器注册("bill)
     * 如果系统是linux，给容器注册("linus)
     */

    @Bean("bill")
    public Person person1(){
        return new Person("Bill",62);
    }
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){

        return new Person("linus",48);
    }


    /**
     * 给容器中注册组件：
     * 1）、包扫描+组件标注注释(@Controller/@Service/@Repository/@Component) [自己写的类]
     * 2)、@Bean[导入的第三方包里边的组件]
     * 3)、@Import[快速给容器中导入一个组件]
     *          1)、@Import(要导入到容器中的组件);容器中就会自动注册这个组件，id默认是全类名
     *          2)、ImportSelector:返回需要导入的组件的全类名数组。
     *          3)、ImportBeanDefinitionRegistrar:手动注册到bean容器中
     * 4)、使用Spring提供的factoryBean(工厂bean)
     *      1)、默认获取到的是工厂Bean调用getObject创建的对象
     *      2)、要获取工厂Bean本身，需要给id前面加一个&标识
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
