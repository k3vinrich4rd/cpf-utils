# 🇧🇷 cpf-utils

Validação e geração de CPF em **Java puro**, com testes em **JUnit 5**.

## O que faz
- **Validação** — `isCpfValido(String cpf)`: confere o tamanho, a lista de CPFs inválidos (todos os dígitos iguais, como `11111111111`) e os dois dígitos verificadores (módulo 11).
- **Geração** — `gerarCpf()`: sorteia 9 dígitos, calcula os 2 verificadores e tenta de novo se cair na lista de inválidos.
- Aceita só a string com **11 dígitos**, sem máscara (`246.813.579-28` retorna `false`).
- Projeto **Java puro**, sem Maven/Gradle (projeto do IntelliJ), com **7 testes** em `CpfServiceImplTest`.

## Por que existe
Exercício para praticar regras de negócio em Java puro (dígitos verificadores, lista de inválidos e geração controlada), com testes JUnit 5, sem framework. Serve como referência pequena e legível de validação/geração de CPF — não substitui bibliotecas consolidadas em produção.

## O que aprendi
- Calcular os dois dígitos verificadores com módulo 11 e pesos decrescentes.
- Rejeitar cedo (`null`, tamanho ≠ 11, CPFs com todos os dígitos iguais) antes do cálculo.
- Cobrir validação e geração com testes nomeados (`@DisplayName`) em JUnit 5.
- Limite consciente: entrada só com 11 dígitos numéricos; `Math.random()` serve para dados de teste, não para uso criptográfico.

## Estrutura
| Arquivo | Papel |
|---|---|
| `src/main/CpfService.java` | interface (o contrato) |
| `src/main/CpfServiceImpl.java` | implementação das regras |
| `src/main/test/CpfServiceImplTest.java` | 7 testes JUnit 5 |

## Testes
- Deve retornar verdadeiro para CPF válido
- Deve retornar falso para CPF inválido
- Deve retornar falso quando CPF for nulo, tamanho inválido ou na lista de inválidos
- Deve gerar CPF com 11 dígitos
- Deve gerar CPF contendo apenas números
- Deve gerar CPF que não está na lista de inválidos
- Deve gerar CPF válido

## Como rodar
Projeto do IntelliJ IDEA (sem Maven/Gradle): abra a pasta, adicione o JUnit 5 ao classpath quando a IDE pedir e rode `CpfServiceImplTest`.

## Licença
Apache-2.0
