# isep-aprog

## PL03 - Exercício 02 (Java)
```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int alunos;
        float nota;
        int notasPositivas = 0;
        int notasNegativas = 0;
        double somaPositivas = 0;
        double somaNegativas = 0;
        double mediaPositivas;
        double mediaNegativas;
        double percentagemPositivas;
        double percentagemNegativas;

        System.out.println("Quantos alunos são no total?");
        alunos = scanner.nextInt();

        while(alunos <= 0) {
            System.out.println("Número introduzido incorrecto. Introduza outra vez.");
            alunos = scanner.nextInt();
        }

        for(int i = 1; i <= alunos; i++) {

            System.out.println("Nota do aluno " + i + ", num total de " + alunos + " alunos.");
            nota = scanner.nextInt();

            if(nota >= 10) {
                notasPositivas++;
                somaPositivas = somaPositivas + nota;
            } else {
                notasNegativas++;
                somaNegativas = somaNegativas + nota;
            }

        }

        mediaPositivas = (double) somaPositivas / (double) alunos;
        mediaNegativas = (double) somaNegativas / (double) alunos;

        percentagemPositivas = (double) notasPositivas / (double) alunos;
        percentagemNegativas = (double) notasNegativas / (double) alunos;

        System.out.println("Positivas: " + notasPositivas);
        System.out.println("Negativas: " + notasNegativas);

        System.out.println("A percentagem de positivas é: " + percentagemPositivas);
        System.out.println("A percentagem de negativas é: " + percentagemNegativas);
        
        System.out.println("Média das Positivas: " + mediaPositivas);
        System.out.println("Média das Negativas: " + mediaNegativas);

    }

}
```

## PL03 - Exercício 05
```
ED: minimo, maximo, lista

INÍCIO

  LER(minimo, maximo)
  
  ENQUANTO(minimo >= maximo)
    ESCREVER('Intervalo definido incorrecto. Por favor volte a introduzir os dados.')
    LER(minimo, maximo)
  FIMENQUANTO
  
  lista = ''
  
  PARA(i = minimo + 1; i <= maximo; i++)
    SE(i MOD 5 == 0 && i MOD 2 == 0)
      lista = lista + i
    FIMSE
  FIMPARA

FIM
```

## PL03 - Exercício 05 (Java)
```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minimo = 0;
        int maximo = 0;

        String lista = "";

        System.out.println("Hello World!");

        System.out.println("Input the maximum range:");
        maximo = scanner.nextInt();

        System.out.println("Input the minimum range:");
        minimo = scanner.nextInt();

        while(minimo >= maximo || maximo <= 0 || minimo <= 0) {
            System.out.println("Wrong range, please repeat the input.");

            System.out.println("Input the maximum range:");
            maximo = scanner.nextInt();

            System.out.println("Input the minimum range:");
            minimo = scanner.nextInt();
        }

        for(int i = minimo + 1; i <= maximo; i++) {

            if(i % 5 == 0 && i % 2 != 0) {
                lista = lista + i + ",";
            }

        }

        System.out.println("Minimum:");
        System.out.println(minimo);

        System.out.println("Maximum:");
        System.out.println(maximo);

        System.out.println("The list is:");
        System.out.println(lista);

    }

}
```

## PL03 - Exercício 07
```
ED: produtoMaximo, produtoAcumulado, numeroMaior

INÍCIO

  numeroMaior = 0;
  produtoAcumulado = 1;

  LER(produtoMaximo);
  
  ENQUANTO(produtoAcumulado <= produtoMaximo)
  
    LER(novoNumero);
    
    ENQUANTO(novoNumero <= 0)
      ESCREVER('Os número introduzidos devem ser positivos. Introduza o número outra vez.');
      LER(novoNumero);
    FIMENQUANTO
    
    SE(novoNumero > numeroMaior)
      numeroMaior = novoNumero;
    FIMSE
    
    produtoAcumulado = produtoAcumulado * novoNumero;

  FIMENQUANTO
  
  ESCREVER('O maior de todos os números introduzidos foi: ' + numeroMaior);

FIM
```

## PL03 - Exercício 09 (Java)
```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a;
        int b;
        int c;
        double delta;
        double root1;
        double root2;

        System.out.println("ax2 + bx + c = 0");

        System.out.println("Input A:");
        a = scanner.nextInt();

        System.out.println("Input B:");
        b = scanner.nextInt();

        System.out.println("Input C:");
        c = scanner.nextInt();

        delta = Math.pow(b, 2) - (4 * a * c);

        root1 = (-b + Math.sqrt(delta)) / (2 * a);
        root2 = (-b - Math.sqrt(delta)) / (2 * a);

        if(delta < 0) {

            System.out.println("Nenhuma raiz real (delta menor que zero).");

        } else if(delta == 0) {

            System.out.println("Uma única raiz real: (delta igual a zero).");
          
            System.out.println("Raiz: " + root1);

        } else {

            System.out.println("Duas raízes reais: (delta maior que zero).");

            System.out.println("Raiz 1: " + root1);
            System.out.println("Raiz 2: " + root2);

            if(root1 == root2) {
                System.out.println("A equação tem uma raiz dupla.");
            }

        }

        if(a == 0) {
            System.out.println("Não é equação do segundo grau.");
        }

    }

}
```
