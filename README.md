# Calculadora de IMC - Projeto FECAP 3CCOMP

## Dados aluno e professor
- Nome: Pedro Henrique Nascimento Lemos
- Professor: Vinicius Heltai

## Descrição do Projeto

Este é um projeto Android desenvolvido em Java utilizando Gradle que calcula o Índice de Massa Corporal (IMC) do usuário e exibe na tela um feedback positivo personalizado para cada categoria de IMC.

Desenvolvi esse projeto para entrega do projeto que compõe a nota da N1 da matéria do professor Vinicius Heltai
## Classificação do IMC
O IMC é classificado nas seguintes categorias:

- Abaixo do peso: IMC < 18.5
- Peso normal: 18.5 <= IMC < 25
- Sobrepeso: 25 <= IMC < 30
- Obesidade grau 1: 30 <= IMC < 35
- Obesidade grau 2: 35 <= IMC < 40
- Obesidade grau 3: IMC >= 40

## Tecnologias Utilizadas
- Java
- Gradle
- Android SDK 35


## Estrutura do Projeto

```
app/
├── build.gradle
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/
│   │   │       └── com/
│   │   │           └── fecapccp/
│   │   │               └── calculadoraimc/
│   │   │                   ├── MainActivity.java
│   │   │                   ├── calcularimc/
│   │   │                   │   └── CalculoImcActivity.java
│   │   │                   └── categoriasimc/
│   │   │                       ├── AbaixoDoPesoActivity.java
│   │   │                       ├── PesoNormalActivity.java
│   │   │                       ├── SobrepesoActivity.java
│   │   │                       ├── Obesidade1Activity.java
│   │   │                       ├── Obesidade2Activity.java
│   │   │                       └── Obesidade3Activity.java
│   │   └── res/
│   │       ├── anim/
│   │       │   ├── scale_animation.xml
│   │       ├── layout/
│   │       │   ├── activity_abaixo_do_peso.xml
│   │       │   ├── activity_peso_normal.xml
│   │       │   ├── activity_sobrepeso.xml
│   │       │   ├── activity_obesidade_1.xml
│   │       │   ├── activity_obesidade_2.xml
│   │       │   ├── activity_obesidade_3.xml
│   │       │   └── activity_calculo_imc.xml
│   │       └── values/
│   │           └── colors.xml
│   │           └── strings.xml
└── README.md
```

# Desafios e Decisões
Durante o desenvolvimento deste projeto, enfrentei diversos desafios, especialmente na parte dos layouts. Posicionar os elementos na tela de forma precisa foi uma tarefa difícil, exigindo muita paciência e criatividade.  Além disso, tomei algumas decisões importantes, como a de não incluir um gráfico no projeto. A biblioteca que utilizei para gráficos estava causando problemas e quebrando o projeto, então optei por removê-la para garantir a estabilidade do aplicativo.

## Como Executar o Projeto
1. Clone o repositório:  
`git clone https://github.com/Pedro-Lemos/calculadora-imc.git`

2. Abra o projeto no Android Studio.
3. Sincronize o projeto com o Gradle (Groovy).  
4. Conecte um dispositivo Android ou inicie um emulador.  
5. Execute o aplicativo. 
