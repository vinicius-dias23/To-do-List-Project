package com.labdessoft.roteiro01.entity; 

import io.swagger.v3.oas.annotations.media.Schema; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import lombok.AllArgsConstructor; 
import lombok.Getter; 
import lombok.Setter; 

@Entity 
@Getter 
@Setter 
// @NoArgsConstructor 
@AllArgsConstructor 
@Schema(description = "Todos os detalhes sobre uma tarefa. ") 
public class Task { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Schema(name = "Descrição da tarefa deve possuir pelo menos 10 caracteres") 
    private Long id; 
    @Getter 
    private String description; 
    private Boolean completed; 

    public Task() { 

    } 

    public Task(String description, Boolean completed) { 
        this.description = description; 
        this.completed = completed; 
    } 

    public String getName() { 
        return description; 
    } 

    public void setName(String description) { 
        this.description = description; 
    } 

    public boolean isCompleted() { 
        return completed; 
    } 

    public void setCompleted(boolean completed) { 
        this.completed = completed; 
    } 

    @Override 
    public String toString() { 
        return "Task [id=" + id + ", description=" + description + ", completed=" + completed + "]"; 
    } 
}