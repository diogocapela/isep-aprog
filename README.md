# isep-aprog
* [PL02](https://github.com/diogocapela/isep-aprog#pl02)
* [PL03](https://github.com/diogocapela/isep-aprog#pl03)

# PL02
## PL02 - Exercício 04
```
ED: input1, input2, input3, numero, raiz

INÍCIO

  LER(input1)
  LER(input2)
  
  SE(input2 <= input1)
    ESCREVER('Os número devem ser introduzidos por ordem crescente.')
  FIMSE
  
  SE(input2 > input1)
  
    LER(input3)

    SE(input3 <= input2)
      ESCREVER('Os número devem ser introduzidos por ordem crescente.')
    FIMSE
    
    SE(input3 > input2)

      numero = input1 * 10^2 + input2 * 10^1 + input1 * 10^0

      raiz = numero^(0.5)

      ESCREVER('O número introduzido foi: ' + numero)
      ESCREVER('A raiz quadrada do número introduzido é: ' + raiz)
    
    FIMSE
    
  FIMSE
  
FIM
```

## PL02 - Exercício 06
```
ED: precoNormal, precoSaldo

INÍCIO

  LER(precoNormal)
  
  ENQUANTO(precoNormal <= 0)
    ESCREVER('Preco introduzido incorrecto. Por favor introduza o preço novamente.')
    LER(precoNormal)
  FIMENQUANTO
  
  SE(precoNormal > 200)
    precoSaldo = precoNormal * 0.4
  FIMSE
  
  SE(precoNormal <= 200 && precoNormal > 100)
    precoSaldo = precoNormal * 0.6
  FIMSE
  
  SE(precoNormal <= 100 && precoNormal > 50)
    precoSaldo = precoNormal * 0.7
  FIMSE
  
  SE(precoNormal <= 50)
    precoSaldo = precoNormal * 80
  FIMSE
  
  ESCREVER('O preço do artigo em saldo é de ' + precoSaldo + '.')
  
FIM
```

## PL02 - Exercício 08
```
ED: a, b, c

INÍCIO
  LER(a, b, c)
  
  ENQUANTO(a <= 0 || b <= 0 || c <= 00 || a + b + c != 180)
    ESCREVER('Ângulos introduzidos incorrecto. Por favor insira os dados novamente.')
    LER(a, b, c)
  FIMENQUANTO

  SE(a == 90 || b == 90 || c == 90)
    ESCREVER('Triângulo rectangulo.')
  FIMSE
  
  SE(a > 90 || b > 90 || c > 90)
    ESCREVER('Triângulo obtusângulo.')
  FIMSE
  
  SE(a < 90 && b < 90 && c < 90)
    ESCREVER('Triângulo acutângulo.')
  FIMSE
  
FIM
```

## PL02 - Exercício 09
```
ED Input: partidaH, partidaM, duracaoH, partidaM
ED Processo: chegadaH, chegadaM, chegaNoDiaSeguinte

INÍCIO

  // Calcular as horas e minutos de chegada (sem ajustes)
  
  chegadaM = partidaM + duracaoM
  chegadaH = partidaH + duracaoH
  
  // Ajustar os minutos de chegada
  
  ENQUANTO(chegadaM >= 60)
    chegadaM = chegadaM - 60
    chegadaH = chegadaH + 1
  FIMENQUANTO
  
  // Ajustar as horas de chegada
  
  SE(chegadaH >= 24)
    chegadaH = chegadaH - 24
    chegaNoDiaSeguinte = true
  FIMSE

FIM
```

## PL02 - Exercício 10 (JavaScript)
```javascript
// Variáveis de input
// ----------------------------

let inicioHr = 18;
let inicioMin = 22;
let inicioSeg = 54;

let duracaoTotalEmSeg = 6620;

// Variáveis de processamento
// ----------------------------

let duracaoHr;
let duracaoMin;
let duracaoSeg;

let finalHr;
let finalMin;
let finalSeg;

// Algoritmo
// ----------------------------

// Verificação dos inputs
if (inicioHr < 0 || inicioHr > 23 || inicioMin < 0 || inicioMin > 59 || inicioSeg < 0 || inicioSeg > 59 || duracaoTotalEmSeg < 0) {

	console.log('Dados introduzidos incorrectos.');

// Caso todos os inputs estejam correctos continuar
} else {

	// Ver quantas horas temos no total de segundos
	duracaoHr = Math.floor(duracaoTotalEmSeg / 3600);

	// Remover as horas do total de segundos
	duracaoTotalEmSeg = duracaoTotalEmSeg % 3600;

	// Ver quantos minutos temos no total de segundos restante
	duracaoMin = Math.floor(duracaoTotalEmSeg / 60);

	// Remover as horas do total de segundos restante
	duracaoTotalEmSeg = duracaoTotalEmSeg % 60;

	// Passar para a variavél duracaoSeg o total de segundos que restou
	duracaoSeg = duracaoTotalEmSeg;

	// Calcular as horas do fim (sem ajutes)
	finalHr = inicioHr + duracaoHr;

	// Calcular os minutos do fim (sem ajutes)
	finalMin = inicioMin + duracaoMin;

	// Calcular os segundos do fim (sem ajutes)
	finalSeg = inicioSeg + duracaoSeg;

	// Ajustar os segudos (enquanto os segundos finais forem superior a 59, subtrair 60 aos segundos finais e adicionar 1 aos minutos finais)
	while (finalSeg > 59) {
		finalSeg = finalSeg - 60;
		finalMin++;
	}

	// Ajustar os minutos (enquanto os minutos finais forem superior a 59, subtrair 60 aos minutos finais e adicionar 1 às horas finais)
	while (finalMin > 59) {
		finalMin = finalMin - 60;
		finalHr++;
	}

	// Ajutar as horas (enquanto as horas finais forem superior a 23, subtrair 24 às horas finais)
	while (finalHr > 23) {
		finalHr = finalHr - 24;
	}

	// Mensagem com a hora de início da tarefa
	console.log('Hora de início:');
	console.log(`${inicioHr}:${inicioMin}:${inicioSeg}`);

	// Mensagem com o tempo de duração da tarefa
	console.log('Tempo de duração:');
	console.log(`${duracaoHr}:${duracaoMin}:${duracaoSeg}`);

	// Mensagem com a hora de finalização da tarefa
	console.log('Hora de finalização:');
	console.log(`${finalHr}:${finalMin}:${finalSeg}`);

}
```

## PL02 - Exercício 12
```
ED: p1x, p1y, p2x, p2y, distancia

INÍCIO

  LER(p1x, p1y, p2x, p2y)
  
  distancia = (((p2x - p1x)^2) + ((p2y - p1y)^2))^0.5
  
  ESCREVER('A distância entre os dois pontos é de ' + distancia + '.')
  
FIM
```

## PL02 - Exercício 13
```
ED: totalSegundos, horas, minutos, segundos, contentorSegundos

INÍCIO
  
  // Remover os dias inteiros do total em segundos
  
  ENQUANTO(totalSegundos >= 86400)
    totalSegundos = totalSegundos - 86400
  FIMENQUANTO
 
  // Calcular quantas horas estão no total de segundos restantes
  
  horas = totalSegundos DIV 3600
  
  contentorSegundos = totalSegundos - (totalSegundos MOD 3600)
  
  // Calcular quantos minutos estão no total de segundos restantes
  
  minutos = contentorSegundos DIV 60
  contentorSegundos = contentorSegundos - (contentorSegundos MOD 60)
  
  // Calcular quantos segundos estão no total de segundos restantes
  
  segundos = contentorSegundos
  
  // Escrever a mensagem
  
  SE(totalSegundos >= 21600 && totalSegundos < 43201)
    ESCREVER('Bom dia.')
  ENTÂO SE(totalSegundos >= 43201 && totalSegundos < 72001)
    ESCREVER('Boa tarde.')
  SENÃO
    ESCREVER('Boa noite.')
  FIMSE
  
  // Escrever a hora
 
  ESCREVER(horas + ':' + minutos + ':' + segundos)
 
FIM
```

## PL02 - Exercício 14
```
ED Input: area, precoLitroTinta, rendimentoLitroTinta, salarioDiaPintor

ED Processo: litrosDeTintaNecessarios, precoDeTintaNecessaria, numeroPintores, numeroDiasNecessarios, custoMaoObra, custoTinta, custoTotal

INÍCIO

	LER(area, precoLitroTinta, rendimentoLitroTinta, salarioDiaPintor)

	SE(area <= 0)
		ESCREVER ('Área introduzida incorrecta.')
	ENTÃO SE(0 <= area < 100)
		numeroPintores = 1
	ENTÃO SE(100 <= area < 300)
		numeroPintores = 2
	ENTÃO SE(300 <= area < 1000)
		numeroPintores = 3
	SENÃO
		numeroPintores = 4
	FIMSE

	numeroDiasNecessarios = area / (numeroPintores * 16)
 
	SE(numeroDiasNecessarios MOD 2 != 0)
		numeroDiasNecessarios = (area DIV (numeroPintores * 16)) + 1
	FIMSE
  
	custoMaoObra = numeroPintores * salarioDiaPintor * numeroDiasNecessarios
	litrosDeTintaNecessarios = area / rendimentoLitroTinta
	precoDeTintaNecessaria = litrosDeTintaNecessarios * precoLitroTinta

	ESCREVER('O custo da mão de obra é de ' + custoMaoObra + '€.')
	ESCREVER('O custo total da tinta é de ' +  precoDeTintaNecessaria + '€.')
	ESCREVER ('O custo total da obra vai ser de ' custoMaoObra + precoDeTintaNecessaria + '€.')

FIM
```

# PL03
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
