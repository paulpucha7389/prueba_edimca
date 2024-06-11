import React from 'react'
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import Empleado from './componentes/Empleado';
import Administrador from './componentes/Administrador';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootswatch/dist/quartz/bootstrap.min.css';
import Login from './componentes/Login';

function App() {

  return (
    <BrowserRouter>
     <Routes>
      <Route path='/' Component={Login}></Route>
      <Route path="/empleado" Component={Empleado}/>
      <Route path="/administrador" Component={Administrador}/>
     </Routes>
    </BrowserRouter>
  )
}

export default App
