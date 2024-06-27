import React, { useState } from 'react';
import axios from 'axios';
import '../App.css';

export const TodoForm = ({ tarefas, setTarefas }) => {
  const [value, setValue] = useState('');

  const createTarefa = (descricao) => {
    let obj = {
      descricao,
      tipoTarefa: 1,
      prioridadeTarefa: 1
    }
    axios.post('/api/tarefa', obj)
    .then(response => {
      setTarefas([...tarefas, response.data]);
    })
    .catch(error => {
      console.error('Erro ao criar tarefa:', error);
    });
  };

  return (
    <div className='TodoForm'>
      <input type='text'
        className='todo-input'
        placeholder='Descrição da tarefa'
        value={value}
        onChange={(e) => { setValue(e.target.value);}} />
        <button
          type='button'
          className='todo-btn'
          onClick={() => { createTarefa(value); }}>
          Adicionar Tarefa
        </button>
    </div>
  )
}