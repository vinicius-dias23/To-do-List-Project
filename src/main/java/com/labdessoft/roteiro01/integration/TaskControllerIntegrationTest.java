package com.labdessoft.roteiro01.integration;
import com.labdessoft.roteiro01.Roteiro01Application;
import com.labdessoft.roteiro01.controller.TaskController;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.nio.file.Path;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.RestAssured.delete;
import static org.hamcrest.Matchers.equalTo;
@SpringBootTest(classes = {Roteiro01Application.class}, webEnvironment
        = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class TaskControllerIntegrationTest {
    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.port = 8080;
    }
    @Test
    public void
    carregarListaDeTarefas() {
        get("/api/tarefa").then().statusCode(200);
    }
    @Test
    public void
    carregarInformacoesDeUmaTarefa() {
        get("/api/tarefa/1").then().statusCode(200)
                .assertThat().body("descricao",
                        equalTo("Primeira tarefa"));
    }

    @Test
    public void inserirNovaTarefa() {
        String novaTarefaJson = "{\n" +
                "    \"descricao\": \"Quarta tarefa\",\n" +
                "    \"estaCompleta\": false,\n" +
                "    \"tipoTarefa\": 2,\n" +
                "    \"prioridadeTarefa\": 1\n" +
                "}";

        given()
                .contentType(JSON)
                .body(novaTarefaJson)
                .when()
                .post("/api/tarefa")
                .then()
                .statusCode(201)
                .body("descricao", equalTo("Quarta tarefa"))
                .body("estaCompleta", equalTo(false))
                .body("tipoTarefa", equalTo(2))
                .body("prioridadeTarefa", equalTo(1));
    }

    @Test
    public void editarTarefa() {
        String tarefaJson = "{\n" +
                "    \"descricao\": \"Segunda tarefa Editada\",\n" +
                "    \"estaCompleta\": false,\n" +
                "    \"tipoTarefa\": 3,\n" +
                "    \"prioridadeTarefa\": 1\n" +
                "}";

        given()
                .contentType(JSON)
                .body(tarefaJson)
                .when()
                .put("/api/tarefa/2")
                .then()
                .statusCode(201)
                .body("descricao", equalTo("Segunda tarefa Editada"))
                .body("estaCompleta", equalTo(false))
                .body("tipoTarefa", equalTo(3))
                .body("prioridadeTarefa", equalTo(1));
    }

    @Test
    public void removerTarefa() {
        String novaTarefaJson = "{\n" +
                "    \"descricao\": \"Tarefa para deletar\",\n" +
                "    \"estaCompleta\": false,\n" +
                "    \"tipoTarefa\": 2,\n" +
                "    \"prioridadeTarefa\": 1\n" +
                "}";

        int taskId = given()
                .contentType(JSON)
                .body(novaTarefaJson)
                .when()
                .post("/api/tarefa")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        delete("/api/tarefa/" + taskId).then().statusCode(202);

        get("/api/tarefa/" + taskId).then().statusCode(404);
    }
}