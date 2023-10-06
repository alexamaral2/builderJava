package builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBuilderTest {

    @Test
    void deveRetornarExcecaoParaProdutoSemCodigo() {
        try {
            ProdutoBuilder produtoBuilder = new ProdutoBuilder();
            Produto produto = produtoBuilder
                    .setNome("Produto 1")
                    .setPreco(10.0)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Código inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaProdutoSemNome() {
        try {
            ProdutoBuilder produtoBuilder = new ProdutoBuilder();
            Produto produto = produtoBuilder
                    .setCodigo(1)
                    .setPreco(10.0)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarProdutoValido() {
        ProdutoBuilder produtoBuilder = new ProdutoBuilder();
        Produto produto = produtoBuilder
                .setCodigo(1)
                .setNome("Produto 1")
                .setPreco(10.0)
                .build();

        assertNotNull(produto);
    }
}