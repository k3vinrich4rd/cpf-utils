package main.test;

import main.CpfValidationImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CpfValidationImplTest {

    private static final String CPF_VALIDO = "44019379025";
    private static final String CPF_INVALIDO = "44019379023";
    private final CpfValidationImpl cpfValidationImpl = new CpfValidationImpl();

    @Test
    @DisplayName("Deve retornar falso quando CPF for nulo ou não tiver 11 caracteres")
    public void deveRetornarFalsoQuandoCpfForNuloOuTamanhoOuCpfInvalido() {
        assertFalse(cpfValidationImpl.isCpfValido(null));
        assertFalse(cpfValidationImpl.isCpfValido(""));
        assertFalse(cpfValidationImpl.isCpfValido("123"));
        assertFalse(cpfValidationImpl.isCpfValido("00000000000"));
        assertFalse(cpfValidationImpl.isCpfValido("4401937902"));   // 10 dígitos
        assertFalse(cpfValidationImpl.isCpfValido("440193790255")); // 12 dígitos
    }

    @Test
    @DisplayName("Deve retornar verdadeiro para CPF válido")
    public void deveRetornarVerdadeiroParaCpfValido() {
        assertTrue(cpfValidationImpl.isCpfValido(CPF_VALIDO));
    }

    @Test
    @DisplayName("Deve retornar falso para CPF inválido")
    public void deveRetornarFalsoParaCpfInvalido() {
        assertFalse(cpfValidationImpl.isCpfValido(CPF_INVALIDO));
    }
}
