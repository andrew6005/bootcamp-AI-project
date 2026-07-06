
@Component
public class ChatRunner implements CommandLineRunner {
  public ChatRunner(ChatService chatService){
    this.chatService= chatService;

  }
  @Override
  public void run(String... args){
    String question = "what is the sky color?";
    String answer = chatservice.chat(question);
    System.out.println("Q:"+ question);
    System.out.println("A:"+ answer);
    

  }

  
}
