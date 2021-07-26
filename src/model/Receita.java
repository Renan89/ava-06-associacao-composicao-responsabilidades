package model;

import java.util.ArrayList;

public class Receita {

  private ArrayList<Medicacao> medicacoes = new ArrayList<>();

  public Receita(Medicacao... medicacoes) {
    for (Medicacao m : medicacoes) {
      this.medicacoes.add(m);
    }
  }

  public Receita prescricao (String medicacao, String horamedicamento){
    medicacoes.add(new Medicacao(medicacao, horamedicamento));
    return this;
  }

  @Override
  public String toString() {
    String retorno = "";
    for (Medicacao m : medicacoes) {
      if (medicacoes.indexOf(m) != medicacoes.size() - 1)
        retorno += m.toString() + "\n";
      else
        retorno += m.toString();
    }
    return retorno;
  }
}
