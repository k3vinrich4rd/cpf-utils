# JavaCPFValidator

Implementação robusta para validação e geração de CPFs em Java.

## Descrição

Este projeto contém a interface `CpfValidation` e sua implementação `CpfValidationImpl`, responsáveis por validar e gerar números de CPF (Cadastro de Pessoas Físicas) conforme as regras oficiais brasileiras.

- **
  Validação:
  ** O método `isCpfValido(String cpf)` verifica se um CPF é válido, checando o tamanho, a lista de CPFs inválidos e o cálculo dos dígitos verificadores.
- **
  Geração:
  ** O método `gerarCpf()` gera um CPF válido, garantindo que não pertença à lista de CPFs inválidos conhecidos.

## Funcionalidades

- Validação de CPF (tamanho, blacklist, dígitos verificadores)
- Geração de CPF válido aleatório