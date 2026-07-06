package com.ex03.demoex03.config;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ex03.demoex03.service.EmbeddingService;
@Component
public class EmbeddingRunner implements CommandLineRunner{
  private final EmbeddingService embeddingService;
  public EmbeddingRunner(EmbeddingService embeddingService){
    this.embeddingService = embeddingService;

  }
  @Override
  public void run(String... agrs){
    float[]vector = embeddingService.embed("hello world");
    System.out.println(vector.length);
    System.out.println(Arrays.toString(vector));

    System.out.println(embeddingService.compaTwo);

  }
  
}
