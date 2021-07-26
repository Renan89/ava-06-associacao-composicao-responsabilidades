package model;

public class Pediatra {

  private String nome;
  private int crm;



  public Pediatra(String nome, int crm) {
    this.nome=nome;
    this.crm=crm;
  }

  public Pediatra(Pediatra novop) {
  }


  public String getNome() {
      return nome;
  }
  public int getCrm() {
      return crm;
  }

  @Override
  public int hashCode() {

      return this.crm;
  }
  @Override
  public boolean equals(Object obj) {
      if(obj instanceof Pediatra){
        return ((Pediatra)obj).crm==(this.crm);
      }
      return false;
  }

  @Override
  public String toString() {

      return this.crm+ " "+this.nome;
  }

}
