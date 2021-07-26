import model.Clinica;
import model.Consulta;
import model.Paciente;
import model.Pediatra;
import model.Medicacao;
import model.Receita;


import java.time.LocalDateTime;

// Todo projeto possui uma classe Principal, Main, App ou nome do projeto
class App {
  // a classe principal App possui o método principal main()
  // se estiver usando o VSCode com a extensão para Java
  // clique no link _Run_ a seguir:
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

    Pediatra pdtr1 = new Pediatra("James Gosling", 1646953);
    Pediatra pdtr2 = new Pediatra("Margaret Hamilton", 8452534);
    Pediatra pdtr3 = new Pediatra("Bjarne Stroustrup", 93253674);
    Pediatra pdtr4 = new Pediatra("Jean Bartik", 9155445);
    Pediatra pdtr5 = new Pediatra("Betty Jean Jennings", 9155445);


    // leitura dos atributos
    System.out.println(pdtr1.getNome().equals("James Gosling"));
    System.out.println(pdtr1.getCrm() == 1646953);

    // equals consiste no crm
    System.out.println(pdtr1.equals(pdtr2) == false);
    System.out.println(pdtr1.equals(pdtr1) == true);
    System.out.println(pdtr4.equals(pdtr5) == true);

    // toString no formato CRM NOME
    System.out.println(pdtr3.toString().equals("93253674 Bjarne Stroustrup"));

    // PACIENTES -------------------
    Paciente pcnt1 = new Paciente("Barbara Liskov", "5543213344");
    Paciente pcnt2 = new Paciente("Alan Kay", "9351769514");
    Paciente pcnt3 = new Paciente("Dennis Ritchie", "2356121222");
    Paciente pcnt4 = new Paciente("Douglas Engelbart", "7231236333");
    Paciente pcnt5 = new Paciente("Frances Allen", "5374364464");
    Paciente pcnt6 = new Paciente("Barbara Jane Huberman", "5543213344");

    // leitura dos atributos
    System.out.println(pcnt3.getNome().equals("Dennis Ritchie"));
    System.out.println(pcnt3.getRg().equals("2356121222"));

    // equals consiste no rg
    System.out.println(pcnt2.equals(pcnt5) == false);
    System.out.println(pdtr1.equals(pdtr1) == true);
    System.out.println(pcnt1.equals(pcnt6) == true);

    // toString no formato RG NOME
    System.out.println(pcnt4.toString().equals("7231236333 Douglas Engelbart"));

    // CLINICA
    Clinica clnc1 = new Clinica("PARC", "Palo Alto");
    Clinica clnc2 = new Clinica("Microsoft", "Redmond");
    Clinica clnc3 = new Clinica("Oracle", "Redwood");
    Clinica clnc4 = new Clinica("Oracle", "Albuquerque");

    // getters
    System.out.println(clnc1.getNome().equals("PARC"));
    System.out.println(clnc1.getCidade().equals("Palo Alto"));

    // toString com nome e cidade
    System.out.println(clnc2.toString().equals("Microsoft Redmond"));

    // equals se mesmo nome e cidade
    System.out.println(clnc1.equals(clnc2) == false);
    System.out.println(clnc1.equals(clnc1) == true);
    System.out.println(clnc3.equals(clnc4) == false);

    // Pediatras devem ser credenciados e
    // Pacientes devem ser cadastrados na clinica

    clnc1.credenciarPediatra(pdtr1);
    clnc1.credenciarPediatra(pdtr2);


    clnc1.cadastrarPaciente(pcnt1);
    clnc1.cadastrarPaciente(pcnt2);

    // buscar o pediatra
    Pediatra pdtr_teste = clnc1.getPediatra(1646953);
    System.out.println(pdtr_teste.equals(pdtr1));
    System.out.println(clnc1.getPediatra(8452534).equals(pdtr2));

    // se nao existe volta null
    pdtr_teste = clnc1.getPediatra(45453445);
    System.out.println(pdtr_teste == null);
    System.out.println(clnc1.getPediatra(75645745) == null);

    // buscar o paciente
    Paciente pcnt_teste = clnc1.getPaciente("5543213344");
    System.out.println(pcnt_teste.equals(pcnt1));
    System.out.println(clnc1.getPaciente("9351769514").equals(pcnt2));

    // se nao existe volta null
    pcnt_teste = clnc1.getPaciente("7894561230");
    System.out.println(pcnt_teste == null);
    System.out.println(clnc1.getPaciente("5126941112") == null);
    // feito os cadastros eh possivel agendar consultas
    // dado um pediatra, paciente e data/hora
    // desde que pediatra e paciente estejam credenciados/cadastrados!

    // Casos felizes:
    // Barbara Liskov consultará com James Gosling em 10 de novembro de 2021
    // as 15:30

    Consulta con1 = clnc1.agendarConsulta("5543213344", 1646953, LocalDateTime.of(2021, 11, 10, 15, 30));
    // Alan Kay consultará com Margaret Hamilton em 11 de novembro de 2021
    // as 09:00
    Consulta con2 = clnc1.agendarConsulta("9351769514", 8452534, LocalDateTime.of(2021, 11, 11, 9, 0));

    // O construtor de Consulta deve ser invisível fora do modelo e a linha a seguir
    // não deve compilar
    //Consulta cons = new Consulta("9351769514", 8452534, LocalDateTime.of(2021, 11, 11, 9, 0)); // comente esta linha
    System.out.println("/*/*/*/*/*/*/*/*/*/*");

    System.out.println(con1.getPediatra().equals(pdtr1));
    System.out.println(con1.getPaciente().equals(pcnt1));
    System.out.println(con1.getDataHora().equals(LocalDateTime.of(2021, 11, 10, 15, 30)));

    // Status
    System.out.println(con1.isAgendada() == true);
    System.out.println(con1.isCancelada() == false);
    System.out.println(con1.isRealizada() == false);

    // paciente nao existe
    Consulta contriste = clnc1.agendarConsulta("5434441344", 1646953, LocalDateTime.of(2021, 11, 10, 15, 30));
    System.out.println(contriste == null);

    // pediatra nao existe
    contriste = clnc1.agendarConsulta("5543213344", 994422, LocalDateTime.of(2021, 11, 10, 15, 30));
    System.out.println(contriste == null);

    Consulta primeiraConsulta = clnc1.getConsulta(1);

    primeiraConsulta.realizar();



    // CASO A SER REFATORADO

    //Consulta segundaConsulta = clnc1.getConsulta(2);
    //segundaConsulta.ConsultaeReceita("Amoxicilina comprimidos", "1 de 12h em 12h por 7 dias");
    //segundaConsulta.realizar();


    Consulta segundaConsulta = clnc1.getConsulta(2);

    Medicacao m1 = new Medicacao("Amoxicilina comprimidos", "1 de 12h em 12h por 7 dias");
    Medicacao m2 = new Medicacao("Dipirona", "20 gotas 6h em 6h enquanto persistir a febre");
    Receita r1 = new Receita(m1, m2);

    // toString's
    // medicacao com remedio: posologia
    System.out.println(m1.toString().equals("Amoxicilina comprimidos: 1 de 12h em 12h por 7 dias"));
    System.out.println(m2.toString().equals("Dipirona: 20 gotas 6h em 6h enquanto persistir a febre"));

    // receita com medicacoes uma por linha
    System.out.println(r1.toString().equals(
        "Amoxicilina comprimidos: 1 de 12h em 12h por 7 dias\nDipirona: 20 gotas 6h em 6h enquanto persistir a febre"));

    segundaConsulta.realizar(r1);

    // a segunda consulta tem receita
    System.out.println(segundaConsulta.getReceita().equals(r1));

    // a primeira nao
    System.out.println(primeiraConsulta.getReceita() == null);

    // um ultimo caso de teste feliz completo

    clnc1.cadastrarPaciente(pcnt3); // "Dennis Ritchie", "2356121222"
    clnc1.credenciarPediatra(pdtr3); // "Bjarne Stroustrup", 93253674

    clnc1.agendarConsulta("2356121222", 93253674, LocalDateTime.of(2021, 12, 7, 17, 15))
        .realizar(new Receita(new Medicacao("Paracetamol", "1 comprimido / 24h")));
    ;

    System.out.println(clnc1.getConsulta(3).isRealizada() == true);
    System.out.println(clnc1.getConsulta(3).getReceita() != null);
    System.out.println(clnc1.getConsulta(3).getReceita().toString().equals("Paracetamol: 1 comprimido / 24h"));
    System.out.println(clnc1.getConsulta(3).getReceita().toString());
    // desafio (opcional, nao vale nada)
    // System.out.println(clnc1.getConsulta(3).toString().equals("Consulta de Dennis
    // Ritchie com Bjarne Stroustrup dia 07/12/2021 as 17:15"));

  }


}
