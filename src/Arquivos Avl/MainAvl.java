public class MainAvl {
    public static void main(String[] args) {
        ArvoreAvl avl = new ArvoreAvl();

        int[] numeros = {30, 20, 40, 10, 25, 35, 50, 5};

        for (int num : numeros) {
            avl.adicionar(num);
        }

        System.out.println("Pré-ordem após inserção:");
        avl.mostrarPreOrdem();

        avl.excluir(20);
        System.out.println("\nPré-ordem após exclusão de 20:");
        avl.mostrarPreOrdem();
    }
}
