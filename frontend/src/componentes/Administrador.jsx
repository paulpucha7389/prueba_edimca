import React from 'react'
import { useState, useEffect } from 'react';

import axios from 'axios';

function Administrador() {
    const [requests, setRequests] = useState([]);
  const [technicians, setTechnicians] = useState([]);
  const [selectedTechnician, setSelectedTechnician] = useState('');

  useEffect(() => {
    fetchRequests();
    fetchTechnicians();
  }, []);

  const fetchRequests = async () => {
    try {
      const response = await axios.get('http://localhost:8080/requirements/getAll');
      //const res = await response.json
      console.log(response.data);
      setRequests(response.data);
    } catch (error) {
      console.error('There was an error fetching the requests!', error);
    }
  };

  const fetchTechnicians = async () => {
    try {
      const response = await axios.get('http://localhost:8080/technician/getAll');
      console.log(response.data)
      setTechnicians(response.data);
    } catch (error) {
      console.error('There was an error fetching the technicians!', error);
    }
  };

  const handleApprove = async (id) => {
    try {
      await axios.put(`http://localhost:8080/requirements/${id}/approve`);
      fetchRequests();
    } catch (error) {
      console.error('There was an error approving the request!', error);
    }
  };

  const handleAssign = async (id) => {
    try {
      await axios.put(`http://localhost:8080/requirements/${id}/assign`, { technician: selectedTechnician });
      fetchRequests();
    } catch (error) {
      console.error('There was an error assigning the request!', error);
    }
  };

  return (
    <div className="container-fluid">
      <h2>Soporte Administrador</h2>
      <table className="table col-lg-12 col-md-12 col-sm-12">
        <thead>
          <tr>
            <th className='col-1'>Name</th>
            <th className='col-3'>Description</th>
            <th className='col-1'>Priority</th>
            <th className='col-1'> Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {requests.map((request) => (
            <tr key={request.id}>
              <td>{request.name}</td>
              <td>{request.description}</td>
              <td>{request.priority}</td>
              <td>{request.status}</td>
              <td>
                {request.status === 'Pendiente' && (
                  <button className="btn btn-success col-auto" onClick={() => handleApprove(request.id)}>Approve</button>
                )}
                {request.status === 'Aprobada' && (
                  <div>
                    <button className="btn btn-primary col-auto" onClick={() => handleAssign(request.id)}>Assign</button>
                    <select className="form-control" onChange={(e) => setSelectedTechnician(e.target.value)}>
                      {technicians.map((tech) => (
                        <option className='col-2' key={tech.id} value={tech.name}>{tech.name}</option>
                      ))}
                    </select>
                  </div>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Administrador