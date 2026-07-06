package com.ex2.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ex2.demo.service.PromptService;

@Component
public class AppRunner implements CommandLineRunner{
  private final PromptService promptService;
  public AppRunner(PromptService promptService){
    this.promptService = promptService;

  }
  @Override
  public void run(String... args){
    System.out.println("---code review---");
    String code = """
        public class cat{
        public String abc;
        System.out.println(abc);
         
        }
        """;
        System.out.println(promptService.reviewCode("java", code));
        System.out.println("\n-- few-shot Sentiment---");
        String[] texts={
       "I love this product!",
       "This is absolutely terrible service",
       "The package arrived today.", 
       "It's okay , nothing special.",
       "I can't believe how bad this is!"

        };
        for (String text : texts){
          System.out.printf(" \"%s\" -> %s%n",text,promptService.classifySentiment(text));
        }
  }
 
  
}
