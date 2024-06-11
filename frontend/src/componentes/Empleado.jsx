import React, { useState } from 'react';
import axios from 'axios';

function EmployeePage() {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [priority, setPriority] = useState('Alta');
  const [status, setStatus] = useState('Aprobada');

  const handleSubmit = async (event) => {
    event.preventDefault();
    const request = { name, description, priority, status };
    try {
      await axios.post('http://localhost:8080/requirements/createRequeriment', request);
      alert('Request submitted successfully!');
    } catch (error) {
      console.error('There was an error submitting the request!', error);
    }
  };

  return (
    <div className="container-fluid col-8">
      <h2>Solicitar Requerimkiento</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Nombre</label>
          <input type="text" className="form-control" value={name} onChange={(e) => setName(e.target.value)} required />
        </div>
        <div className="form-group">
          <label>Descripcion</label>
          <textarea className="form-control" value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>
        </div>
        <div className="form-group">
          <label>Prioridad</label>
          <select className="form-control bg-dark" value={priority} onChange={(e) => setPriority(e.target.value)} required>
            <option value="Alta">Alta</option>
            <option value="Media">Media</option>
            <option value="Baja">Baja</option>
          </select>
        </div>
        <div className="form-group">
          <label>Estado</label>
          <select className="form-control bg-dark" value={status} onChange={(e) => setStatus(e.target.value)} required>
            <option value="Pendiente">Pendiente</option>
            <option value="Aprobada">Aprobada</option>
            <option value="Asignada">Asiganada</option>
          </select>
        </div>
        <button type="submit" className="btn btn-primary mt-2">Submit</button>
      </form>
    </div>
  );
}

export default EmployeePage;
