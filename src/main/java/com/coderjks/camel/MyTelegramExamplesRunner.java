package com.coderjks.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.StartupListener;
import org.apache.camel.example.telegram.usage.GetUpdatesUsage;
import org.apache.camel.example.telegram.usage.LiveLocationUsage;
import org.apache.camel.example.telegram.usage.SendMessageUsage;
import org.apache.camel.example.telegram.usage.SendVenueUsage;

public class MyTelegramExamplesRunner implements StartupListener {

    @Override
    public void onCamelContextStarted(CamelContext context, boolean alreadyStarted) throws Exception {
        System.out.println("Camel is started. Ready to run examples!");

        // Methods usage examples
//        new SendMessageUsage().run(context);
//        new LiveLocationUsage().run(context);
        new GetUpdatesUsage().run(context);
//        new SendVenueUsage().run(context);
    }
}

