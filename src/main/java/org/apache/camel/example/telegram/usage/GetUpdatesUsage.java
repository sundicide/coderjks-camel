/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.telegram.usage;

import com.coderjks.camel.MyTelegramApplication;
import org.apache.camel.CamelContext;
import org.apache.camel.component.telegram.TelegramService;
import org.apache.camel.component.telegram.TelegramServiceProvider;
import org.apache.camel.component.telegram.model.UpdateResult;

public class GetUpdatesUsage implements TelegramMethodUsage {

    public void run(CamelContext context) {
        TelegramService service = TelegramServiceProvider.get().getService();
        UpdateResult message = service.getUpdates(MyTelegramApplication.AUTHORIZATION_TOKEN, (long) 10, 10, 10);
        System.out.println(message);
    }
}
