package com.zguiz.ai.service;

import java.util.Map;

public interface TongYiService {

    String completion(String message);
    Map<String, String> streamCompletion(String message);
}
