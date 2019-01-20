package org.debugroom.mynavi.sample.aws.lambda.functions;

import java.util.Arrays;
import java.util.function.Function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import lombok.extern.slf4j.Slf4j;
import org.debugroom.mynavi.sample.aws.lambda.model.Input;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import reactor.core.publisher.Flux;

@Slf4j
public class ApiGatewayEventFunction implements Function<Message<Input>, Message<String>> {

    @Override
    public Message<String> apply(Message<Input> inputMessage) {
        log.info("Message : " + inputMessage.getPayload().getTest());
        return new Message<String>() {
            @Override
            public String getPayload() {
                return "Complete!";
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        };

    }

}
