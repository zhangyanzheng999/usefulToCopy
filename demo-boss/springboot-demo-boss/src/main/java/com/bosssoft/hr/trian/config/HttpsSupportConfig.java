package com.bosssoft.hr.trian.config;

import io.undertow.Undertow;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/8--16:01
 */
@ConfigurationProperties(prefix = "nossl")
@Component
public class HttpsSupportConfig {

    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /**
     * 内置undertow支持
     * <p>
     * 内置undertow https ssl支持
     */
    @Bean
    public UndertowServletWebServerFactory servletWebServerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
            @Override
            public void customize(Undertow.Builder builder) {
                builder.addHttpListener(port, "0.0.0.0");
            }
        });
        return factory;
    }
    //undertow-----end
}
