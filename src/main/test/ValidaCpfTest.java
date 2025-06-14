package main.test;

import main.ValidaCpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidaCpfTest {

    private static final String CPF_VALIDO = "44019379025";
    private static final String CPF_INVALIDO = "44019379023";
    private final ValidaCpf validaCpf = new ValidaCpf();

    @Test
    public void deveRetornarFalsoQuandoCpfForNuloOuTamanhoInvalido() {
        assertFalse(validaCpf.isCpfValido(null));
        assertFalse(validaCpf.isCpfValido(""));
        assertFalse(validaCpf.isCpfValido("123"));
        assertFalse(validaCpf.isCpfValido("4401937902"));   // 10 dígitos
        assertFalse(validaCpf.isCpfValido("440193790255")); // 12 dígitos
    }

    @Test
    public void deveRetornarVerdadeiroParaCpfValido() {
        assertTrue(validaCpf.isCpfValido(CPF_VALIDO));
    }

    @Test
    public void deveRetornarFalsoParaCpfInvalido() {
        assertFalse(validaCpf.isCpfValido(CPF_INVALIDO));
    }

    @Test
    public void deveRetornarVerdadeiroQuandoSegundoDigitoVerificadorFor10() {
        // CPF onde o segundo dígito verificador é 0 porque o cálculo resulta em 10
        String cpfComSegundoDV10 = "74682489070";
        assertTrue(validaCpf.isCpfValido(cpfComSegundoDV10));
    }
}
