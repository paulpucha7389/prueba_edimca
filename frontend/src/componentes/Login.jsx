import React from 'react'
import { Link } from 'react-router-dom';
import './Login.css';

function Login() {

  return (
    <div>
        <div className='container'>
            <Link to="/administrador"> 
                <button type="button" className="btn btn-primary col-12">Gerente</button>
            </Link>
            <Link to="/empleado">
                <button type="button" className="btn btn-success mt-2 col-12">Empleado</button>
            </Link>
        </div>
    </div>
  )
}

export default Login