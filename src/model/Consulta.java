package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Consulta {

  private Paciente consultaPaciente;
  private Pediatra consultaPediatra;
  private LocalDateTime dataHora;
  private boolean agendada;
  private boolean cancelada;
  private boolean realizada;
  private int id;
  private Receita rec;
  private Receita receitas;
  private ArrayList<Receita> receita = new ArrayList<>();



  Consulta(Paciente consultaPaciente, Pediatra consultaPediatra,LocalDateTime dataHora,int id){
    this.consultaPaciente=consultaPaciente;
    this.consultaPediatra=consultaPediatra;

    this.dataHora=dataHora;
    agendada=true;
    cancelada=false;
    //realizada=false;
    this.id=id;


  }

  public LocalDateTime getDataHora() {
      return dataHora;
  }
  public Paciente getPaciente() {
      return consultaPaciente;
  }
  public Pediatra getPediatra() {
      return consultaPediatra;
  }

  public boolean isAgendada() {

    return agendada;
  }

  public boolean isCancelada() {


  return cancelada;
  }

  public boolean isRealizada() {

  return realizada;
  }

  public int getId() {
    return id;
  }

  public void realizar() {
  this.realizada=true;
  }

  public void realizar(Receita rec) {
  this.rec=rec;
  this.realizada=true;
  }

  public Object getReceita() {
  return this.rec;
  }

  @Override
  public String toString() {
    return "Consulta de " + consultaPaciente.getNome() + " com " + consultaPediatra.getNome() + " dia "
        + dataHora.getDayOfMonth() + "/" + dataHora.getMonthValue() + "/" + dataHora.getYear() + " as "
        + dataHora.getHour() + ":" + dataHora.getMinute();

  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Consulta) {
      Consulta outraConsulta = (Consulta) obj;
      return this.id == outraConsulta.id;
    }
    return false;
  }

public Receita ConsultaeReceita(String medicacao, String horamedicamento) {
  this.receitas=new Receita(new Medicacao(medicacao, horamedicamento));
  this.realizada=true;
  return this.receitas;

}

}
