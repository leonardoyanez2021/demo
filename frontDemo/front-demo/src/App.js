import React, { Component } from 'react';
import './App.css';
import { PersonaService } from './service/PersonaService';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import {Panel} from 'primereact/panel';

export default class App extends Component{
  constructor(){
    super();
    this.state = {
      visible : false,
      persona: {
        nombre: null,
        apellido: null
      },
      selectedPersona : {

      }
    };
    this.personaService = new PersonaService();

  }

  componentDidMount(){
    this.personaService.getAll().then(data => this.setState({personas: data}))
  }


  render(){
    return (
      <Panel header="Personas">
        <DataTable value={this.state.personas} paginator rows={5} rowsPerPageOptions={[5, 10, 25, 50]} tableStyle={{ minWidth: '50rem' }}>
            <Column field="nombre" header="Nombre" style={{ width: '25%' }}></Column>
            <Column field="apellido" header="Apellido" style={{ width: '25%' }}></Column>
        </DataTable>
      </Panel>
    )
  }
}