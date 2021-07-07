# Avaliação 06 Associação, Composição e Responsabilidades.

Link do Classroom: <https://classroom.github.com/a/3k1A-kwS>

> "Já que teu braço me pertence agora, eu quero ele forte."
>
> [A tutela cruel de Pai Mei](https://youtu.be/JOCe0isg_1E)

## Implementar e testar segundo as especificações

- O esforço estimado desta atividade está entre 6 e 12h.
- Os Casos de Teste podem ser corrigidos se estiverem mal escritos, mas **a especificação dos objetos não pode ser alterada**.
- As classes do modelo devem ficar no pacote `model`.
- E, por fim, assegure-se de **assistir as videoaulas antes de começar**, pois lá estão explicados todos os conceitos e práticas presentes nesta atividade.



### Implementar um Sistema de Consultas para um Consultório Pedriátrico

Considere um sistema, de consultas para uma clínica pediátrica. Nele é possível manter um cadastro de pacientes e credenciamento de pediatras. O sistema gerencia o agendamento de consultas e sua posterior realização ou cancelamento. Na finalização da consulta pode-se especificar quais medicamentos e posologia foram indicados, por exemplo, Amoxicilina comprimidos / 1 comprimido de 12h em 12h por 7 dias. Na análise do sistema foram projetadas as classes `Clinica(nome,cidade)`, `Paciente(nome, rg)`, `Pediatra(nome,crm)`, `Consulta(paciente,pediatra)`, `Receita` e `Medicacao`.

Casos de teste:

```java
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

// os pediatras são acessados pelo crm e pacientes pelo rg

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

// O construtor de Consulta deve ser invisível fora do modelo e a linha a seguir não deve compilar
Consulta cons = new Consulta("9351769514", 8452534, LocalDateTime.of(2021, 11, 11, 9, 0)); // comente esta linha

// desafio: rejeitar uma consulta quando a data/hora for anterior ao agora (now) - não vale nada
System.out.println(con1.getPediatra().equals(pdtr1));
System.out.println(con1.getPaciente().equals(pcnt1));
System.out.println(con1.getDataHora().equals(LocalDateTime.of(2021, 05, 10, 15, 30)));

// Status
System.out.println(con1.isAgendada() == true);
System.out.println(con1.isCancelada() == false);
System.out.println(con1.isRealizada() == false);

// cada consulta ganha um id sequencial
System.out.println(con1.getId() == 1);
System.out.println(con2.getId() == 2);

// elas podem ser buscadas pelo id
Consulta cnslt = clnc1.getConsulta(1);

// só é igual se for o mesmo id
System.out.println(cnslt.equals(con1) == true);
System.out.println(clnc1.getConsulta(1).equals(clnc1.getConsulta(2)) == false);

// se nao existe retorna null
cnslt = clnc1.getConsulta(9);
System.out.println(cnslt == null);
System.out.println(clnc1.getConsulta(11) == clnc1.getConsulta(21)); // null == null

// Casos tristes: retornam consulta null

// paciente nao existe
Consulta contriste = clnc1.agendarConsulta("5434441344", 1646953, LocalDateTime.of(2021, 11, 10, 15, 30));
System.out.println(contriste == null);

// pediatra nao existe
contriste = clnc1.agendarConsulta("5543213344", 994422, LocalDateTime.of(2021, 11, 10, 15, 30));
System.out.println(contriste == null);


// data/hora colide numa janela de 30 min (desafio, opcional, nao vale nada)
// colide com a con1
// Consulta colideHorario = clnc1.agendarConsulta("7231236333", 9155445, LocalDateTime.of(2021, 11, 10, 15, 35));
// System.out.println(colideHorario == null);
// colide com a con1
// colideHorario = clnc1.agendarConsulta("7231236333", 9155445, LocalDateTime.of(2021, 11, 10, 15, 5));
// System.out.println(colideHorario == null);

// realizando uma consulta
// a realizacao pode receber (opcionalmente) uma receita com um ou mais medicamentos

Consulta primeiraConsulta = clnc1.getConsulta(1);

primeiraConsulta.realizar();

// CASO A SER REFATORADO

Consulta segundaConsulta = clnc1.getConsulta(2);

Medicacao m1 = new Medicacao("Amoxicilina comprimidos", "1 de 12h em 12h por 7 dias");
Medicacao m2 = new Medicacao("Dipirona", "20 gotas 6h em 6h enquanto persistir a febre");
Receita r1 = new Receita(m1, m2);

// toString's
// medicacao com remedio: posologia
System.out.println(m1.toString().equals("Amoxicilina comprimidos: 1 de 12h em 12h por 7 dias"));
System.out.println(m2.toString().equals("Dipirona: 20 gotas 6h em 6h enquanto persistir a febre"));

// receita com medicacoes uma por linha
System.out.println(r1.toString().equals("Amoxicilina comprimidos: 1 de 12h em 12h por 7 dias\nDipirona: 20 gotas 6h em 6h enquanto persistir a febre"));

segundaConsulta.realizar(r1);

// a segunda consulta tem receita
System.out.println(segundaConsulta.getReceita().equals(r1));

// a primeira nao
System.out.println(primeiraConsulta.getReceita() == null);

// um ultimo caso de teste feliz completo

clnc1.cadastrarPaciente(pcnt3); // "Dennis Ritchie", "2356121222"
clnc1.credenciarPediatra(pdtr3); // "Bjarne Stroustrup", 93253674

clnc1.agendarConsulta("2356121222", 93253674, LocalDateTime.of(2021, 12, 7, 17, 15))
  .realizar(new Receita(new Medicacao("Paracetamol", "1 comprimido / 24h")));;

System.out.println(clnc1.getConsulta(3).isRealizada() == true);
System.out.println(clnc1.getConsulta(3).getReceita() != null);
System.out.println(clnc1.getConsulta(3).getReceita().toString().equals("Paracetamol: 1 comprimido / 24h"));

// desafio (opcional, nao vale nada)
// System.out.println(clnc1.getConsulta(3).toString().equals("Consulta de Dennis Ritchie com Bjarne Stroustrup dia 07/12/2021 as 17:15"));
```



### Refatorar o Sistema Clínica Pediátrica

Fazer com que as medicações e receitas sejam composição da consulta em vez da agregação que é no momento. Isto é, os `new`'s serão realizados dentro consulta. Podes (deves) reescrever os testes a partir de `// CASO A SER REFATORADO` para concluir esta parte.



### Sistema Livraria

Imagine um sistema para livraria. Modele o domínio, descobrindo as classes conceituais. Numa cópia adicione as associações e atributos. Na última cópia adicione os comportamentos/métodos. _Não é obrigatório implementar, mas se quiseres podes considerar como exercício._

- - -

> A good programmer looks both ways before crossing a one-way street.
>
> -- Unknown
