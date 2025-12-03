📚 Desafio Java: Sistema Inteligente de Biblioteca Universitária
🎯 Cenário
Você foi contratado para desenvolver o sistema de gerenciamento da Biblioteca Central da Universidade TechFlow. O sistema precisa ser robusto, seguir princípios de OOP e lidar com diferentes tipos de materiais e situações excepcionais.

📖 Descrição do Sistema
A biblioteca possui:

Livros físicos tradicionais

Livros digitais (com link de acesso)

Sistema de empréstimos com regras específicas

Relatórios estatísticos

Autores renomados

🏗️ Requisitos Técnicos
1. Estruturas Básicas (OBRIGATÓRIAS)
java
// 1.1 Enum para status
enum StatusMaterial {
    DISPONIVEL("✅ Disponível"),
    EMPRESTADO("📖 Emprestado"),
    EM_MANUTENCAO("🔧 Em manutenção"),
    RESERVADO("⏳ Reservado");
    
    private String descricao;
    
    StatusMaterial(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}

// 1.2 Record para Autor
record Autor(String nome, String nacionalidade, int anoNascimento) {
    @Override
    public String toString() {
        return nome + " (" + nacionalidade + ", " + anoNascimento + ")";
    }
}
2. Classes Principais (IMPLEMENTE)
MaterialBibliografico (classe base abstrata)

LivroFisico (herda de MaterialBibliografico)

LivroDigital (herda de MaterialBibliografico, com características específicas)

Biblioteca (classe principal que gerencia os materiais)

3. Funcionalidades Exigidas
java
// 3.1 Interface com métodos de empréstimo
interface Emprestavel {
    boolean realizarEmprestimo(String matricula) throws MaterialIndisponivelException;
    boolean realizarDevolucao();
    double calcularMulta(int diasAtraso);
}

// 3.2 Exceção personalizada
class MaterialIndisponivelException extends Exception {
    public MaterialIndisponivelException(String titulo, StatusMaterial status) {
        super("❌ O material '" + titulo + "' não pode ser emprestado. Status: " + status.getDescricao());
    }
}
🎮 Funcionalidades do Sistema
Operações que o sistema deve suportar:
Cadastrar novos materiais (físicos e digitais)

Realizar empréstimos com validações

Registrar devoluções com cálculo automático de multa

Buscar materiais por título ou autor

Gerar relatórios estatísticos

Filtrar materiais usando lambda expressions

📊 Exemplo de Output Esperado
text
📚 === BIBLIOTECA UNIVERSITÁRIA TECHLOW === 📚

1. CADASTRO DE LIVROS:
----------------------------------------
✅ Livro cadastrado: "Dom Casmurro" (Físico)
   Autor: Machado de Assis (Brasil, 1839)
   ISBN: 978-85-01-12345-6
   Status: ✅ Disponível

✅ Livro cadastrado: "Clean Code" (Digital)
   Autor: Robert C. Martin (EUA, 1952)
   Link: https://biblioteca.techflow.edu/clean-code
   Status: ✅ Disponível

2. TENTATIVA DE EMPRÉSTIMO:
----------------------------------------
🎓 Aluno: 2023001 tentando empréstimo de "Dom Casmurro"...
📖 Empréstimo realizado com sucesso!
   Data devolução: 15/12/2024
   Status atual: 📖 Emprestado

🎓 Aluno: 2023002 tentando empréstimo de "Dom Casmurro"...
❌ ERRO: O material 'Dom Casmurro' não pode ser emprestado. 
         Status: 📖 Emprestado

3. DEVOLUÇÃO E CÁLCULO DE MULTA:
----------------------------------------
📚 Devolução: "Dom Casmurro"
✅ Devolvido com sucesso!
⚠️  Multa por atraso: R$ 7.50 (5 dias)

4. RELATÓRIO DA BIBLIOTECA:
----------------------------------------
📊 === RELATÓRIO ESTATÍSTICO ===
Total de materiais: 8
Livros físicos: 5
Livros digitais: 3
Materiais disponíveis: 6
Materiais emprestados: 2
----------------------------------------

5. BUSCA COM LAMBDA:
----------------------------------------
🔍 Buscando livros do autor 'Machado de Assis'...
✅ Encontrado: "Dom Casmurro"
✅ Encontrado: "Memórias Póstumas de Brás Cubas"
✅ Encontrado: "Quincas Borba"

6. MÉTODO DEPRECIADO:
----------------------------------------
⚠️  AVISO: Método antigo de busca será removido na versão 2.0
     Motivo: Substituído por busca inteligente com lambda
🛠️ Elementos Técnicos a Demonstrar
[ ] Herança e Polimorfismo
[ ] Encapsulamento (atributos privados com getters/setters)
[ ] Sobrecarga de métodos (múltiplos construtores)
[ ] Sobrescrita de métodos (@Override)
[ ] Classe abstrata com método abstrato
[ ] Uso de final para constantes
[ ] Bloco de inicialização estático
[ ] Classe aninhada estática para Relatório
[ ] Classe interna para Empréstimo
[ ] Expressão lambda para filtragem
[ ] Anotação personalizada @MetodoLegado
[ ] Encadeamento de métodos (method chaining)
[ ] Tratamento de exceções com try-catch
[ ] Uso de enum com métodos
📝 Esqueleto Sugerido para Início
java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Sua anotação personalizada
@interface MetodoLegado {
    String motivo();
    String versaoRemocao() default "2.0";
}

// Sua exceção personalizada (já fornecida acima)

// Enum (já fornecido acima)

// Record (já fornecido acima)

// Interface (já fornecida acima)

// CLASSE ABSTRATA BASE (Você implementa)
abstract class MaterialBibliografico {
    // Atributos encapsulados
    // Construtor com sobrecarga
    // Métodos abstratos e concretos
    // Bloco de inicialização
}

// SUAS IMPLEMENTAÇÕES AQUI
// 1. LivroFisico
// 2. LivroDigital  
// 3. Biblioteca (com classe interna Emprestimo e estática Relatorio)

// CLASSE PRINCIPAL COM MÉTODO MAIN
public class BibliotecaUniversitaria {
    public static void main(String[] args) {
        System.out.println("📚 === BIBLIOTECA UNIVERSITÁRIA TECHLOW === 📚\n");
        
        // Seu código de demonstração aqui
        // Mostrando todos os conceitos implementados
    }
}
🏆 Critérios de Avaliação
Conceito	Pontos	Obrigatório?
Herança e Polimorfismo	20	✅ Sim
Encapsulamento	15	✅ Sim
Tratamento de Exceções	15	✅ Sim
Interface e Enum	10	✅ Sim
Record e Lambda	10	✅ Sim
Classes Aninhadas	10	✅ Sim
Anotação Personalizada	5	✅ Sim
Method Chaining	5	✅ Sim
Output Formatado	10	✅ Sim
Total: 100 pontos

💡 Dicas para Implementação
Comece pela estrutura básica (enum, record, interface)

Implemente a classe abstrata com atributos comuns

Crie as classes concretas com especializações

Desenvolva a classe Biblioteca com suas funcionalidades

Use o método main para demonstrar TODOS os conceitos

Formate o output para ficar visualmente atraente

🎉 Bônus (Opcional)
Implementar persistência em arquivo texto

Criar sistema de reservas em fila

Adicionar data de publicação e edição

⏱️ Tempo estimado: 60-75 minutos
🔧 Dificuldade: Intermediário
🎯 Objetivo: Criar um sistema coeso que demonstre domínio dos conceitos OOP

Boa sorte, desenvolvedor! A Universidade TechFlow conta com você! 🚀

Quando terminar, envie seu arquivo BibliotecaUniversitaria.java para avaliação.