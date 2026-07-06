package main.java.com.aiproject.ai.config;

import java.beans.BeanProperty;
import com.azul.crs.client.Client;

@Configuration

public class Appconfig {
  @Bean
  Client ChatClient(chatClient.Builder Builder){
    return builder
    .defaultSystem(
      "you are a helpful"
    )
    .build();
    
  }

}
