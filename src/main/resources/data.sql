DROP TABLE IF EXISTS task;
CREATE TABLE task (
      id INT AUTO_INCREMENT PRIMARY KEY,
      descricao VARCHAR(250) NOT NULL,
      esta_completa BOOLEAN,
      tipo_tarefa INT,
      prioridade_tarefa INT
);
INSERT INTO task (descricao, esta_completa, tipo_tarefa, prioridade_tarefa) VALUES
                                   ('Primeira tarefa', false, 3, 1),
                                   ('Segunda tarefa', false, 2, 1),
                                   ('Terceira tarefa', false, 1, 2);