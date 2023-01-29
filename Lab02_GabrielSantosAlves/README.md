### Controle Institucional da Situação Acadêmica (CoISA)
Neste projeto, você deve desenvolver um sistema capaz de gerenciar o uso dos laboratórios de Ciência da Computação (LCC’s) e sua vida acadêmica. O COISA se trata de um sistema complexo, logo a separação de responsabilidades através da criação de classes é de extrema importância, pois tem como objetivo estruturar, coerentemente, o seu programa.
A vida do aluno pode ser organizada em quatro atividades básicas: 
(1) organizar seu tempo de uso de internet para as disciplinas, o que é bem importante considerando o modelo remoto atual, (2) estudar para as disciplinas, (3) organizar resumos de estudo e (4) acompanhar sua rotina de descanso. 
Para permitir o controle dessas 4 atividades, você irá desenvolver um sistema que permite avaliar a quantidade de tempo de internet (online) que você tem usado nas disciplinas, a quantidade de horas que você tem estudado, o cadastro de resumos de estudos e, por fim, como está sua rotina de descanso.
Assim, para cada uma das atividades, é descrito um conjunto de valores referentes a cada atividade e de ações que podem ser feitas para aquela atividade.

---
Já existe uma classe pronta que irá ser executada para testar o funcionamento do seu programa. Por este programa é possível ver as classes que devem ser implementadas (dica: pelo menos uma classe para cada atividade) bem como os métodos públicos. Você deve copiar essa classe no seu programa e fazê-la funcionar sem alterações de acordo com as especificações que virão a seguir. Execute sempre esta classe para garantir que você está desenvolvendo corretamente cada atividade.

```
package lab2;
public class Coisa {
  public static void main(String[] args) {
      registrarDescanso();
      System.out.println("-----");
      registrarTempoOnline();
      System.out.println("-----");
      controlarDisciplina();
      System.out.println("-----");
      registrarResumos();
  }
  public static void registrarDescanso() {
      Descanso descanso = new Descanso();
      System.out.println(descanso.getStatusGeral());
      descanso.defineHorasDescanso(30);
      descanso.defineNumeroSemanas(1);
      System.out.println(descanso.getStatusGeral());
      descanso.defineHorasDescanso(26);
      descanso.defineNumeroSemanas(2);
      System.out.println(descanso.getStatusGeral());
      descanso.defineHorasDescanso(26);
      descanso.defineNumeroSemanas(1);
      System.out.println(descanso.getStatusGeral());
  }
  private static void registrarTempoOnline() {
      RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
      tempoLP2.adicionaTempoOnline(10);
      System.out.println(tempoLP2.atingiuMetaTempoOnline());
      tempoLP2.adicionaTempoOnline(10);
      tempoLP2.adicionaTempoOnline(10);
      System.out.println(tempoLP2.atingiuMetaTempoOnline());
      tempoLP2.adicionaTempoOnline(2);
      System.out.println(tempoLP2.atingiuMetaTempoOnline());
      System.out.println(tempoLP2.toString());
      RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2");
      System.out.println(tempoP2.toString());
  }
  private static void controlarDisciplina() {
      Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
      prog2.cadastraHoras(4);
      prog2.cadastraNota(1, 5.0);
      prog2.cadastraNota(2, 6.0);
      prog2.cadastraNota(3, 7.0);
      System.out.println(prog2.aprovado());
      prog2.cadastraNota(4, 10.0);
      System.out.println(prog2.aprovado());
      System.out.println(prog2.toString());
  }
  private static void registrarResumos() {
      RegistroResumos meusResumos = new RegistroResumos(100);  // 100 resumos
     
      meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
      meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");


      String[] resumos = meusResumos.pegaResumos();


      for (int i = 0; i < meusResumos.conta(); i++) {
          System.out.println(resumos[i]);
      }


      System.out.println();
      System.out.println("Resumos: ");
      System.out.println(meusResumos.imprimeResumos());
      System.out.println(meusResumos.temResumo("Classes"));
      System.out.println(meusResumos.temResumo("Objetos"));
  }
}
```

# Essa classe ao ser executada deve produzir a seguinte saída:
```
cansado
descansado
cansado
descansado
---
false
true
true
LP2 32/30
P2 0/120
---
false
true
PROGRAMACAO 2 4 7.0 [5.0, 6.0, 7.0, 10.0]
---
Classes: Classes definem um tipo e a base de código para criação de objetos.
Tipo: Identifica a semântica (operações e significados) de um conjunto de dados.

Resumos:
- 2 resumo(s) cadastrado(s)
- Classes | Tipo
true
false
```

