public class ArvoreAvl {
    private NoAvl raiz;

    public void adicionar(int chave) {
        raiz = inserir(raiz, chave);
    }

    public void excluir(int chave) {
        raiz = remover(raiz, chave);
    }

    private NoAvl inserir(NoAvl no, int chave) {
        if (no == null) return new NoAvl(chave);

        if (chave < no.chave) {
            no.esquerda = inserir(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = inserir(no.direita, chave);
        } else {
            return no; // Duplicatas não são permitidas
        }

        atualizarAltura(no);
        return reequilibrar(no);
    }

    private NoAvl remover(NoAvl no, int chave) {
        if (no == null) return null;

        if (chave < no.chave) {
            no.esquerda = remover(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = remover(no.direita, chave);
        } else {
            if (no.esquerda == null || no.direita == null) {
                no = (no.esquerda != null) ? no.esquerda : no.direita;
            } else {
                NoAvl sucessor = menorNo(no.direita);
                no.chave = sucessor.chave;
                no.direita = remover(no.direita, sucessor.chave);
            }
        }

        if (no == null) return null;

        atualizarAltura(no);
        return reequilibrar(no);
    }

    private NoAvl menorNo(NoAvl no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    private void atualizarAltura(NoAvl no) {
        int altEsq = (no.esquerda != null) ? no.esquerda.altura : 0;
        int altDir = (no.direita != null) ? no.direita.altura : 0;
        no.altura = 1 + Math.max(altEsq, altDir);
    }

    private int fatorBalanceamento(NoAvl no) {
        int altEsq = (no.esquerda != null) ? no.esquerda.altura : 0;
        int altDir = (no.direita != null) ? no.direita.altura : 0;
        return altEsq - altDir;
    }

    private NoAvl reequilibrar(NoAvl no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.esquerda) < 0) {
                no.esquerda = rotacionarEsquerda(no.esquerda);
            }
            return rotacionarDireita(no);
        }

        if (fb < -1) {
            if (fatorBalanceamento(no.direita) > 0) {
                no.direita = rotacionarDireita(no.direita);
            }
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private NoAvl rotacionarDireita(NoAvl y) {
        NoAvl x = y.esquerda;
        NoAvl T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private NoAvl rotacionarEsquerda(NoAvl x) {
        NoAvl y = x.direita;
        NoAvl T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    public void mostrarPreOrdem() {
        mostrarPreOrdem(raiz);
        System.out.println();
    }

    private void mostrarPreOrdem(NoAvl no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            mostrarPreOrdem(no.esquerda);
            mostrarPreOrdem(no.direita);
        }
    }
}
