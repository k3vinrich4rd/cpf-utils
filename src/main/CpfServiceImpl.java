package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CpfServiceImpl implements CpfService {

    private static final int TAMANHO_CPF = 11;
    private static final int INDICE_PRIMEIRO_VERIFICADOR = 9;
    private static final int INDICE_SEGUNDO_VERIFICADOR = 10;
    private static final int PRIMEIRO_PESO = 10;
    private static final int SEGUNDO_PESO = 11;
    private static final Set<String> CPFS_INVALIDOS = new HashSet<>(Arrays.asList(
            "00000000000", "11111111111", "22222222222", "33333333333",
            "44444444444", "55555555555", "66666666666",
            "77777777777", "88888888888", "99999999999"));


    @Override
    public boolean isCpfValido(String cpf) {

        if (cpf == null || cpf.length() != TAMANHO_CPF || CPFS_INVALIDOS.contains(cpf)) {
            return false;
        }

        int somaPrimeiroDigitoVerificador = 0;
        int somaSegundoDigitoVerificador = 0;
        for (int indice = 0; indice < 9; indice++) {
            int digitoAtual = cpf.charAt(indice) - '0';

            somaPrimeiroDigitoVerificador += digitoAtual * (PRIMEIRO_PESO - indice); // Peso decrescente de 10 a 2
            somaSegundoDigitoVerificador += digitoAtual * (SEGUNDO_PESO - indice);  // Peso decrescente de 11 a 3
        }

        int primeiroDigitoVerificador = (somaPrimeiroDigitoVerificador * 10) % 11;
        if (primeiroDigitoVerificador == 10) {
            primeiroDigitoVerificador = 0;
        }

        somaSegundoDigitoVerificador += primeiroDigitoVerificador * 2;
        int segundoDigitoVerificador = (somaSegundoDigitoVerificador * 10) % 11;
        if (segundoDigitoVerificador == 10) {
            segundoDigitoVerificador = 0;
        }

        return primeiroDigitoVerificador == (cpf.charAt(INDICE_PRIMEIRO_VERIFICADOR) - '0') &&
                segundoDigitoVerificador == (cpf.charAt(INDICE_SEGUNDO_VERIFICADOR) - '0');
    }

    @Override
    public String gerarCpf() {
        int[] cpf = new int[TAMANHO_CPF];

        // Gera os 9 primeiros dígitos aleatórios
        for (int i = 0; i < INDICE_PRIMEIRO_VERIFICADOR; i++) {
            cpf[i] = (int) (Math.random() * 10);
        }

        int somaPrimeiroDigitoVerificador = 0;
        int somaSegundoDigitoVerificador = 0;

        // Um único for para calcular as duas somas
        for (int i = 0; i < INDICE_PRIMEIRO_VERIFICADOR; i++) {
            somaPrimeiroDigitoVerificador += cpf[i] * (PRIMEIRO_PESO - i);
            somaSegundoDigitoVerificador += cpf[i] * (SEGUNDO_PESO - i);
        }

        int primeiroDigitoVerificador = (somaPrimeiroDigitoVerificador * 10) % 11;
        if (primeiroDigitoVerificador == 10) {
            primeiroDigitoVerificador = 0;
        }
        cpf[INDICE_PRIMEIRO_VERIFICADOR] = primeiroDigitoVerificador;

        somaSegundoDigitoVerificador += primeiroDigitoVerificador * 2;
        int segundoDigitoVerificador = (somaSegundoDigitoVerificador * 10) % 11;
        if (segundoDigitoVerificador == 10) {
            segundoDigitoVerificador = 0;
        }
        cpf[INDICE_SEGUNDO_VERIFICADOR] = segundoDigitoVerificador;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < TAMANHO_CPF; i++) {
            stringBuilder.append(cpf[i]);
        }

        String cpfStr = stringBuilder.toString();
        if (CPFS_INVALIDOS.contains(cpfStr)) {
            return gerarCpf(); // Tenta novamente
        }

        return cpfStr;
    }

}
