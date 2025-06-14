package main.test;

import main.ValidaCpf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidaCpfTest {

    private static final String CPF_VALIDO = "44019379025";
    private static final String CPF_INVALIDO = "44019379023";
    private final ValidaCpf validaCpf = new ValidaCpf();

    @Test
    @DisplayName("Deve retornar falso quando CPF for nulo ou não tiver 11 caracteres")
    public void deveRetornarFalsoQuandoCpfForNuloOuTamanhoInvalido() {
        assertFalse(validaCpf.isCpfValido(null));
        assertFalse(validaCpf.isCpfValido(""));
        assertFalse(validaCpf.isCpfValido("123"));
        assertFalse(validaCpf.isCpfValido("4401937902"));   // 10 dígitos
        assertFalse(validaCpf.isCpfValido("440193790255")); // 12 dígitos
    }

    @Test
    @DisplayName("Deve retornar verdadeiro para CPF válido")
    public void deveRetornarVerdadeiroParaCpfValido() {
        assertTrue(validaCpf.isCpfValido(CPF_VALIDO));
    }

    @Test
    @DisplayName("Deve retornar falso para CPF inválido")
    public void deveRetornarFalsoParaCpfInvalido() {
        assertFalse(validaCpf.isCpfValido(CPF_INVALIDO));
    }
}
