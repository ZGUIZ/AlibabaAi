package com.zguiz.ai.service.impl;

import com.zguiz.ai.service.TongYiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.StreamingChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Slf4j
@Service
public class TongyiServiceImpl implements TongYiService {
    private ChatClient chatClient;
    private StreamingChatClient streamingChatClient;

    public TongyiServiceImpl(ChatClient chatClient,StreamingChatClient streamingChatClient){
        this.chatClient = chatClient;
        this.streamingChatClient = streamingChatClient;
    }

    @Override
    public String completion(String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }

    @Override
    public Map<String, String> streamCompletion(String message) {
        StringBuilder fullContent = new StringBuilder();
        streamingChatClient.stream(new Prompt(message)).flatMap(chatResponse -> Flux.fromIterable(chatResponse.getResults()))
                .map(content -> content.getOutput().getContent())
                .doOnNext(fullContent::append)
                .last()
                .map(lastContent -> Map.of(message,fullContent.toString()))
                .block();
        return Map.of(message, fullContent.toString());
    }
}
