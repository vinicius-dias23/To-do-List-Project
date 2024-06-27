import React, { useState } from 'react';
import '../App.css';

export const TodoForm = ({ addTodo }) => {
  const [value, setValue] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (value) {
      // adicionar tarefa
      addTodo(value);
      // limpar formulário após envio
      setValue('')
    }
  }
  return (
    <form className='TodoForm' onSubmit={handleSubmit}>
      <input type='text'
        className='todo-input'
        placeholder='Descrição da tarefa'
        value={value}
        onChange={(e) => setValue(e.target.value)} />
        <button type='submit' className='todo-btn'>
          Adicionar Tarefa
        </button>
    </form>
  )
}