import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash, faEdit, faSquareCheck, faSquare } from '@fortawesome/free-solid-svg-icons';
import '../App.css';
import axios from 'axios';

export const TodoList = ({ task, toggleComplete, tarefas, setTarefas, fetchTarefas }) => {
  const deleteTarefa = (id) => {
    axios.delete(`/api/tarefa/${id}`)
      .then(response => {
        setTarefas(tarefas.filter(tarefa => tarefa._id !== id));
        fetchTarefas();
      })
      .catch(error => {
        console.error('Erro ao deletar tarefa:', error);
      });
  };

  return (
    <div className='Todo'>
      <p className={`${task.completed ? "completed" : "incompleted"}`}>
        {task.descricao}
      </p>
    <div className='icons'>
      <FontAwesomeIcon
        className='check-icon'
        color='white'
        onClick={() => { toggleComplete(task.id); }}
        icon={task.estaCompleta ? faSquareCheck : faSquare} />
      <FontAwesomeIcon
        className='edit-icon'
        color='white'
        icon={faEdit} />
      <FontAwesomeIcon
        className='delete-icon'
        color='white'
        icon={faTrash}
        onClick={() => { deleteTarefa(task.id); }} />
    </div>
    </div>
  );
};
