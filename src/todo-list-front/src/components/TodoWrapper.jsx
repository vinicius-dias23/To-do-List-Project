import React, { useEffect, useState } from 'react';
import { TodoForm } from './TodoForm';
import { TodoList } from './TodoList';
import '../App.css';
import { v4 as uuidv4 } from "uuid";
import axios from 'axios';

const API_URL = 'https://to-do-list-project-yi4s.onrender.com/api/tarefa';

export const TodoWrapper = () => {
  const [tarefas, setTarefas] = useState([
    {id: 1, descricao: 'Tarefa exemplo', estaCompleta: false, tipoTarefa: 1, prioridadeTarefa: 1}
  ]);
  
  const [tarefaAtualizada, setTarefaAtualizada] = useState({ id: '', descricao: '',  estaCompleta: false });

  // const addTodo = (description) => {
  //   setTodos([
  //     ...todos,
  //   { id: uuidv4(), description: description, completed: false },
  //   ]);
  // }

  // const deleteTodo = (id) => setTodos(todos.filter((todo) => todo.id !== id));

  const toggleComplete = id => {
    const newTodos = tarefas.map(tarefa => tarefa.id === id ? {...tarefa, estaCompleta:
    !tarefa.estaCompleta} : tarefa);
    setTarefas(newTodos);
  }

  // const editTodo = (id) => {
  //   setTodos(
  //     todos.map((todo) =>
  //       todo.id === id ? { ...todo, isEditing: !todo.isEditing } : todo
  //     )
  //   );
  // }

  useEffect(() => {
    fetchTarefas();
  }, [tarefas.length]);
  console.log('tarefas ->', tarefas);

  // Função para buscar todas as tarefas
  const fetchTarefas = () => {
    axios.get('/api/tarefa')
    .then(response => {
      setTarefas(response.data);
    })
    .catch(error => {
      console.error('Erro ao buscar tarefas:', error);
    });
  };

  // Função para atualizar uma tarefa
  const updateTarefa = async (id) => {
    axios.put(`/api/tarefa/${id}`, tarefaAtualizada)
    .then(response => {
      setTarefas(tarefas.map(tarefa => (tarefa._id === id ? response.data : tarefa)));
      setTarefaAtualizada({ id: '', nome: '', descricao: '' });
    })
    .catch(error => {
      console.error('Erro ao atualizar tarefa:', error);
    });
  };

  return (
    <div className="App">
      <h1>Lista de Tarefas</h1>
      <TodoForm
        tarefas={tarefas}
        setTarefas={setTarefas}
        fetchTarefas={fetchTarefas} />
      {tarefas && tarefas.length > 0 && tarefas.map((item) => 
      item &&
        <TodoList
          key={item.id}
          task={item}
          toggleComplete={toggleComplete}
          fetchTarefas={fetchTarefas}
          tarefas={tarefas}
          setTarefas={setTarefas} />)}
    </div>
  )
}