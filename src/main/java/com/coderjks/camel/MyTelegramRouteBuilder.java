package com.coderjks.camel;

import org.apache.camel.builder.RouteBuilder;

public class MyTelegramRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        String url = "telegram:bots/" + MyTelegramApplication.AUTHORIZATION_TOKEN + "?chatId=" + MyTelegramApplication.CHAT_ID;
        System.out.println("URL = " + url);
        from("direct:start").to(url);
    }
}
