package main.test;

import main.CpfServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CpfValidationImplTest {

    private static final String CPF_VALIDO = "60268510032";
    private static final String CPF_INVALIDO = "44019379023";
    private final CpfServiceImpl cpfValidationImpl = new CpfServiceImpl();
    private static final Set<String> CPFS_INVALIDOS = new HashSet<>(Arrays.asList(
            "00000000000", "11111111111", "22222222222", "33333333333",
            "44444444444", "55555555555", "66666666666",
            "77777777777", "88888888888", "99999999999"));

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

    @Test
    @DisplayName("Deve retornar falso quando CPF for nulo, tamanho inválido ou na lista de inválidos")
    public void deveRetornarFalsoQuandoCpfForNuloOuTamanhoOuCpfInvalido() {
        assertFalse(cpfValidationImpl.isCpfValido(null));
        assertFalse(cpfValidationImpl.isCpfValido(""));
        assertFalse(cpfValidationImpl.isCpfValido("123"));
        assertFalse(cpfValidationImpl.isCpfValido("00000000000"));
        assertFalse(cpfValidationImpl.isCpfValido("4401937902"));   // 10 dígitos
        assertFalse(cpfValidationImpl.isCpfValido("440193790255")); // 12 dígitos
    }

    @Test
    @DisplayName("Deve gerar CPF com 11 dígitos")
    void deveGerarCpfCom11Digitos() {
        String cpf = cpfValidationImpl.gerarCpf();
        assertEquals(11, cpf.length(), "CPF deve ter 11 dígitos");
    }

    @Test
    @DisplayName("Deve gerar CPF contendo apenas números")
    void deveGerarCpfApenasNumeros() {
        String cpf = cpfValidationImpl.gerarCpf();
        assertTrue(cpf.matches("\\d{11}"), "CPF deve conter apenas números");
    }

    @Test
    @DisplayName("Deve gerar CPF que não está na lista de inválidos")
    void deveGerarCpfNaoEstaNaListaDeInvalidos() {
        String cpf = cpfValidationImpl.gerarCpf();
        assertFalse(CPFS_INVALIDOS.contains(cpf), "CPF não pode estar na lista de inválidos");
    }

    @Test
    @DisplayName("Deve gerar CPF válido")
    void deveGerarCpfValido() {
        String cpf = cpfValidationImpl.gerarCpf();
        assertTrue(cpfValidationImpl.isCpfValido(cpf), "CPF gerado deve ser válido");
    }

}