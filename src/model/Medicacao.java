package model;

import java.time.LocalDateTime;

public class Medicacao {

  private String medicacao;
  private String horamedicamento;


  public Medicacao(String medicacao, String horamedicamento){
    this.medicacao=medicacao;
    this.horamedicamento=horamedicamento;
  }

  @Override
  public String toString() {

      return medicacao+": "+horamedicamento;
  }

}
