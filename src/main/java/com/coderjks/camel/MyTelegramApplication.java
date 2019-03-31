package com.coderjks.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class MyTelegramApplication {

    public static final String AUTHORIZATION_TOKEN;
    public static final String CHAT_ID;

    static {
        Yaml yaml = new Yaml();
        ClassLoader loader = MyTelegramApplication.class.getClassLoader();
        Map<String, Object> obj = null;
        try (InputStream resourceStream = loader.getResourceAsStream("application.yml")) {
             obj = yaml.loadAs(resourceStream, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AUTHORIZATION_TOKEN = String.valueOf(obj.get("authorizationToken"));
        CHAT_ID = String.valueOf(obj.get("chatId"));
        System.out.println("AUTHORIZATION_TOKEN = " + AUTHORIZATION_TOKEN);
        System.out.println("CHAT_ID = " + CHAT_ID);

    }

    private MyTelegramApplication() {

    }

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.start();
        context.addRoutes(new MyTelegramRouteBuilder());
        context.addStartupListener(new MyTelegramExamplesRunner());
    }
}
