package com.labdessoft.roteiro01.service; 

import com.fasterxml.jackson.databind.ObjectMapper; 
import com.labdessoft.roteiro01.entity.Task; 
import com.labdessoft.roteiro01.repository.TaskRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import java.util.ArrayList; 
import java.util.List; 

@Service 
public class ServiceTask { 
    @Autowired 
    TaskRepository taskRepository; 
    package com.labdessoft.roteiro01.service; 

    import com.fasterxml.jackson.databind.ObjectMapper; 
    import com.labdessoft.roteiro01.entity.Task; 
    import com.labdessoft.roteiro01.repository.TaskRepository; 
    import org.springframework.beans.factory.annotation.Autowired; 
    import org.springframework.stereotype.Service; 

    import java.util.ArrayList; 
    import java.util.List; 

    @Service 
    public class ServiceTask { 
        @Autowired 
        TaskRepository taskRepository; 

        public String ServiceListTask() { 
            try{ 
                List<Task> taskList = new ArrayList<Task>(taskRepository.findAll()); 
                if(taskList.isEmpty()){ 
                    return "empty!"; 
                } 
                ObjectMapper objectMapper = new ObjectMapper(); 
                String json = objectMapper.writeValueAsString(taskList); 
                return json; 
            } catch (Exception e) { 
                return "Error"; 
            } 
        } 

        public String ServiceIncludeTask(String description, Boolean completed) { 
            try { 
                Task newTask = new Task(description, completed); 
                taskRepository.save(newTask); 
                return "Tarefa inserida com sucesso."; 
            } catch (Exception e) { 
                System.out.println(e); 
                return "Erro ao inserir tarefa."; 
            } 

        } 

        public String ServiceDeleteTask(Long id) { 
            try { 
                Task newTask = new Task(); 
                newTask = taskRepository.getReferenceById(id); 
                taskRepository.delete(newTask); 
                return "Tarefa deletada com sucesso."; 
            } catch (Exception e) { 
                System.out.println(e); 
                return "Erro ao deletar tarefa."; 
            } 

        } 
    }
    public String ServiceListTask() { 
        try{ 
            List<Task> taskList = new ArrayList<Task>(taskRepository.findAll()); 
            if(taskList.isEmpty()){ 
                return "empty!"; 
            } 
            ObjectMapper objectMapper = new ObjectMapper(); 
            String json = objectMapper.writeValueAsString(taskList); 
            return json; 
        } catch (Exception e) { 
            return "Error"; 
        } 
    } 

    public String ServiceIncludeTask(String description, Boolean completed) { 
        try { 
            Task newTask = new Task(description, completed); 
            taskRepository.save(newTask); 
            return "Tarefa inserida com sucesso."; 
        } catch (Exception e) { 
            System.out.println(e); 
            return "Erro ao inserir tarefa."; 
        } 

    } 

    public String ServiceDeleteTask(Long id) { 
        try { 
            Task newTask = new Task(); 
            newTask = taskRepository.getReferenceById(id); 
            taskRepository.delete(newTask); 
            return "Tarefa deletada com sucesso."; 
        } catch (Exception e) { 
            System.out.println(e); 
            return "Erro ao deletar tarefa."; 
        } 

    } 
}