package com.ex4.ex4.config;

import java.util.List;
import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.ai.document.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.ex4.ex4.service.DocumentsService;

@Component
public class DocumentRunner implements CommandLineRunner{
  private final DocumentsService documentsService;
  public DocumentRunner (DocumentsService documentsService){
    this.documentsService = documentsService;
  }
  private void printDocuments (List<Document> documents){
    for(int i = 0; i < documents.size();i++){
      System.out.println("--- Document" + i +" ----");
      String perview = documents .get(i).getText().substring(0, Math.min(500, documents.get(i).getText().length()));
      System.out.println(perview+"...");

    }
  }

  @Override
  public void run(String... args){
    System.out.println("--- load text file ---");
    Resource handbookResource = new ClassPathResource("doc/acme-employee-handbook.txt");
    List<Document> txtDocs = documentsService.load(handbookResource);
    printDocuments(txtDocs);
  }
  
}
