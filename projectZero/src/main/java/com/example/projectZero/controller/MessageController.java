package com.example.projectZero.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("message")
public class MessageController {
    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>(){{put("id", "1"); put("text", "first message");}});
        add(new HashMap<String, String>(){{put("id", "2"); put("text", "second message");}});
    }};

    @GetMapping
    public List<Map<String, String>> getMessages() {
        return messages;
    }

}
