public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.raiz = new No("A");
        arvore.raiz.esquerda = new No("B");
        arvore.raiz.direita  = new No("C");
        arvore.raiz.esquerda.esquerda  = new No("D");
        arvore.raiz.esquerda.direita   = new No("E");
        arvore.raiz.direita.direita    = new No("F");

        // Contagem de nós usando método recursivo
        int totalNos = arvore.contarNos(arvore.raiz);
        System.out.println("Total de nós na árvore (usando recursão): " + totalNos);

        // Impressão dos percursos recursivos
        System.out.print("Percurso Pré-Ordem (recursivo): ");
        arvore.buscaPreOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Percurso Em-Ordem (recursivo): ");
        arvore.buscaEmOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Percurso Pós-Ordem (recursivo): ");
        arvore.buscaPosOrdem(arvore.raiz);
        System.out.println();

        // Impressão do percurso por nível (em largura)
        System.out.println("Percurso em Nível (largura):");
        arvore.buscaEmNivel();

        // Impressão dos percursos iterativos (sem recursão)
        System.out.print("Percurso Em-Ordem (iterativo): ");
        arvore.emOrdemIterativo(arvore.raiz);
        System.out.println();

        System.out.print("Percurso Pós-Ordem (iterativo): ");
        arvore.posOrdemIterativo(arvore.raiz);
        System.out.println();

        // Contagem de nós usando estrutura iterativa (sem recursão)
        int totalNosIterativo = arvore.contarNosIterativo();
        System.out.println("Total de nós na árvore (usando estrutura iterativa): " + totalNosIterativo);

        // Contagem de nós folha (aqueles que não possuem filhos)
        int totalFolhas = arvore.contarFolhasIterativo();
        System.out.println("Total de nós folha na árvore: " + totalFolhas);
    }
}