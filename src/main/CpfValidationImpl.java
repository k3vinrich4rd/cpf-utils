package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CpfValidationImpl implements CpfValidation {

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
        if (cpf == null || !cpf.matches("\\d{" + TAMANHO_CPF + "}") || CPFS_INVALIDOS.contains(cpf)) {
            return false;
        }

        int somaParaPrimeiroVerificador = 0;
        int segundoDigitoCalculado = 0;

        for (int posicao = 0; posicao < 9; posicao++) {
            int digito = cpf.charAt(posicao) - '0';
            somaParaPrimeiroVerificador += digito * (PRIMEIRO_PESO - posicao);
            segundoDigitoCalculado += digito * (SEGUNDO_PESO - posicao);
        }

        int primeiroDigitoCalculado = (somaParaPrimeiroVerificador * 10) % 11;

        if (primeiroDigitoCalculado == 10) {
            primeiroDigitoCalculado = 0;
        }

        int segundoDigitoVerificador = (segundoDigitoCalculado * 10) % 11;
        if (segundoDigitoVerificador == 10) {
            segundoDigitoVerificador = 0;
        }

        return primeiroDigitoCalculado == (cpf.charAt(INDICE_PRIMEIRO_VERIFICADOR) - '0') &&
                segundoDigitoVerificador == (cpf.charAt(INDICE_SEGUNDO_VERIFICADOR) - '0');
    }
}
