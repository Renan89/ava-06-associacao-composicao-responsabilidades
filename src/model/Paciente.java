package model;


public class Paciente {

  private String Nome;
  private String rg;

    public Paciente(String Nome, String rg) {
      this.Nome=Nome;
      this.rg=rg;
    }



    public String getNome() {
        return Nome;
    }
    public String getRg() {
        return rg;
    }


    @Override
    public boolean equals(Object obj) {
      if(obj instanceof Paciente){
        return ((Paciente)obj).rg==(this.rg);
      }
      return false;
    }

    @Override
    public String toString() {
        return this.rg+" "+this.Nome;
    }





}
