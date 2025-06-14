package main;

public class ValidaCpf implements CpfValidation {

    @Override
    public boolean isCpfValido(String cpf) {

        //Verifica se o cpf não é nulo e se tem 11 caracteres
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Cálculo das somas para os dígitos verificadores
        int somaPrimeiroDigitoVerificador = 0;
        int somaSegundoDigitoVerificador = 0;
        for (int indice = 0; indice < 9; indice++) {
            int digitoAtual = cpf.charAt(indice) - '0'; // Faz o parse do caractere para inteiro
            //soma dos produtos
            somaPrimeiroDigitoVerificador += digitoAtual * (10 - indice); // Peso decrescente de 10 a 2
            somaSegundoDigitoVerificador += digitoAtual * (11 - indice);  // Peso decrescente de 11 a 3
        }

        // Cálculo do primeiro dígito verificador
        //fórmula oficial para calcular o primeiro dígito verificador do CPF, usando a soma dos produtos, multiplicando por 10 e pegando o resto da divisão por 11.
        int primeiroDigitoVerificador = (somaPrimeiroDigitoVerificador * 10) % 11; //Regra para validar e evitar cpf's falsos
        if (primeiroDigitoVerificador == 10) {
            primeiroDigitoVerificador = 0; // Regra do CPF: se for 10, vira 0
        }

        // 4. Cálculo do segundo dígito verificador
        somaSegundoDigitoVerificador += primeiroDigitoVerificador * 2; // Inclui o primeiro dígito verificador, peso 2
        int segundoDigitoVerificador = (somaSegundoDigitoVerificador * 10) % 11;
        if (segundoDigitoVerificador == 10) {
            segundoDigitoVerificador = 0; // Regra do CPF: se for 10, vira 0
        }

        // 5. Verificação final: compara os dígitos calculados com os do CPF informado
        return primeiroDigitoVerificador == (cpf.charAt(9) - '0') &&
                segundoDigitoVerificador == (cpf.charAt(10) - '0');
    }
}
