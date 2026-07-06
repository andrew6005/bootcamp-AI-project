package main.java.com.aiproject.ai.service;
import org.springframwork.ai.chat.client.ChatClient;


public class ChatService {
  private final ChatClient ChatClient;
  public ChatService(ChatClient chatClient){
    this.ChatClient = chatClient;
  }
  public String chat(String userMessage){
    return chatClient.prompt()
    .user(userMessage)
    .call()
    .content();
  }

  public Flux<String> streamChat(String userMessage){
    return chatClient.prompt()
    .user(userMessage)
    .stream()
    .content();
  }
  public String chatwithTemperature(String userMessage, double temperature){
    return ChatClient.prompt()
    .user(userMessage)
    .options(ollamachatoptions.builder().temperature(temperature))
    .call()
    .content();
  }
}
