package com.ex2.demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class PromptService {
  private final ChatClient chatClient;
  public PromptService(ChatClient.Builder builder) {
    this.chatClient = builder.build();
  }

  public String reviewCode(String language, String code) {
    String prompt = """
        you are a senior{language} developer.
        Review the following code and provide specific , actionable feedback:
        ```{language}
        {code}
        ```
        Focus on : correctness, readability, and potential bugs.
        """;
    return chatClient.prompt(prompt)
        .user(e -> e.text(prompt).param("language", language).param("code", code))
        .call()
        .content();
  }
  public String classifySentiment(String text){
    String fewShotSystem="""
        classify the sentiment of the given text.
        Reply with exactly one word :positive, negative , neutral

        examples:
        Text: "I love this product!"-> positive
        Text: "This is absolutely terrible service" -> negative
        Text: "The package arrived today." -> neutral
        Text: "It's okay , nothing special."-> neutral
        Text: "I can't believe how bad this is!" -> negative
        """;
        return chatClient.prompt().system(fewShotSystem)
        .user("tText"+ text)
        .call()
        .content()
        .trim();
  }


  }
  

