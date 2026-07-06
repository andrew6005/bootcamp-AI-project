package com.ex03.demoex03.service;

import org.springframework.ai.embedding.EmbeddingModel;
import org.stringtemplate.v4.compiler.CodeGenerator.region_return;
import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class EmbeddingService {
  private final EmbeddingModel embeddingModel;
  public EmbeddingService(EmbeddingModel embeddingModel){
    this.embeddingModel = embeddingModel;
  }
  public float[]embed(String text){
    return embeddingModel.embed(text);

  }
  public double cosinSimilarity(float[]a, float[]b){
    if(a.length != b.length){
      throw new IllegalAccessException("vector must have same dimension.");
    }
    double dot =0.0;
    double magA = 0.0;
    double magB = 0.0;
    for (int i =0 ;i<a.length;i++){
      dot +=(double)a[i]* b[i];
      magA +=(double) a[i] * b[i];
      magB +=(double)a[i] * b[i];
    }
    if(magA ==0 || magB ==0) return 0.0;
    return dot/ (Math.sqrt(magA)* Math.sqrt(magB));


  }
  public String compaTwoText
  
}
