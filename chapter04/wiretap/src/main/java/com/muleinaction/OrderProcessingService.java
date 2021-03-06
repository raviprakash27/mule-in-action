package com.muleinaction;

import java.util.List;
import javax.jms.ObjectMessage;

import com.muleinaction.common.*;
import org.mule.api.lifecycle.Callable;
import org.mule.api.MuleEventContext;
import org.mule.module.client.MuleClient;

public class OrderProcessingService implements Callable {

  public Object onCall(MuleEventContext muleEventContext) throws Exception {
        System.out.println("Order Processing Service");

        MuleClient muleClient = new MuleClient(muleEventContext.getMuleContext());
        muleClient.dispatch("vm://order.service.received", "message received", null);
        return muleEventContext.getMessage();
    }
}
