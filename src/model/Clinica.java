package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Clinica {

  private String Nome;
  private String Cidade;
  private ArrayList<Consulta> consultas = new ArrayList<>();
  private ArrayList<Pediatra> pediatras = new ArrayList<>();
  private ArrayList<Paciente> pacientes = new ArrayList<>();



  public Clinica(String Nome, String Cidade){
    this.Nome=Nome;
    this.Cidade=Cidade;
  }

  public String getCidade() {
      return Cidade;
  }
  public String getNome() {
      return Nome;
  }
  public Pediatra getPediatra(int index) {
    for (Pediatra pa: pediatras) {
      if(pa.getCrm() == index)
      return pediatras.get(pediatras.indexOf(pa));

    }
      return null;
  }


  @Override
  public boolean equals(Object obj) {
    if(this.Nome==obj)return true;
    if(null==obj)return false;

      if(obj instanceof Clinica){
        return  ((Clinica)obj).Cidade.equals(this.Cidade);
      }
      return false;
  }

  @Override
  public String toString() {
      return this.Nome+" "+this.Cidade;
  }

  public void credenciarPediatra(Pediatra novop) {
    //Pediatra novoPediatra = new Pediatra(novop);

  this.pediatras.add((Pediatra) novop);

  }

  public void cadastrarPaciente(Paciente novoPaciente) {
    //Paciente novoPaciente = new Paciente (novoPa);
  this.pacientes.add((Paciente) novoPaciente);
  }


  public Paciente getPaciente(String paci) {
    for (Paciente pe : pacientes) {
      if(pe.getRg()==paci){
        return pacientes.get(pacientes.indexOf(pe));
      }

    }
    return null;
  }

  public Consulta agendarConsulta(String rg, int crm, LocalDateTime dataHora) {

    if(getPaciente(rg)==null || getPediatra(crm)==null) return null;

    if (consultas.size() > 0){
      consultas.add(
          new Consulta(getPaciente(rg), getPediatra(crm), dataHora, consultas.get(consultas.size() - 1).getId() + 1));
    } else {
      consultas.add(new Consulta(getPaciente(rg), getPediatra(crm), dataHora, consultas.size() + 1));
    }
    return consultas.get(consultas.size() - 1);

  }

  public Consulta getConsulta(int id) {

    for (Consulta consulta : consultas) {
      if(consulta.getId()==id){
        return consulta;
      }
    }
    return null;
  }



}

