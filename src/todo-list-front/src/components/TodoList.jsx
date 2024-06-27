import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import '../App.css';

export const TodoList = ({ task }) => {
  return (
    <div className='Todo'>
      <p className={`${task.completed ? "completed" : "incompleted"}`}>
        {task.description}
      </p>
    <div>
      <FontAwesomeIcon
      className='delete-icon'
      icon={faTrash} />
    </div>
    </div>
  );
};
