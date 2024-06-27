import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash, faEdit, faSquareCheck, faSquare } from '@fortawesome/free-solid-svg-icons';
import '../App.css';

export const TodoList = ({ task, toggleComplete }) => {
  return (
    <div className='Todo'>
      <p className={`${task.completed ? "completed" : "incompleted"}`}>
        {task.description}
      </p>
    <div className='icons'>
      <FontAwesomeIcon
        className='check-icon'
        color='white'
        onClick={() => { toggleComplete(task.id); }}
        icon={task.completed ? faSquareCheck : faSquare} />
      <FontAwesomeIcon
        className='edit-icon'
        color='white'
        icon={faEdit} />
      <FontAwesomeIcon
        className='delete-icon'
        color='white'
        icon={faTrash} />
    </div>
    </div>
  );
};
