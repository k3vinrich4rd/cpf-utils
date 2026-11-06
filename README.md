# 🇧🇷 cpf-utils

Validação e geração de CPF em **Java puro**, com testes em **JUnit 5**.

## O que faz
- **Validação** — `isCpfValido(String cpf)`: confere o tamanho, a lista de CPFs inválidos (todos os dígitos iguais, como `11111111111`) e os dois dígitos verificadores.
- **Geração** — `gerarCpf()`: gera um CPF válido, que nunca cai na lista de inválidos.

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
