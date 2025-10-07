package application;

import entities.Product;
import services.ManagerProduct;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("iniciando programa");

        escolherOperacao(sc);
    }

    public static void escolherOperacao(Scanner sc) {

        boolean loop = true;

        while (loop) {
            System.out.println();
            try {

                System.out.println("--------------------------------------------");
                System.out.println("| (1) mostrar lista de produtos em estoque |");
                System.out.println("| (2) atualizar dados do produto           |");
                System.out.println("| (3) adicionar um novo produto ao estoque |");
                System.out.println("| (4) remover produto do estoque           |");
                System.out.println("| (5) sair                                 |");
                System.out.println("--------------------------------------------");

                System.out.print("digite o valor: ");
                int operacao = sc.nextInt();
                System.out.println();
                loop = realizarOperacao(operacao, sc);
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("digite apenas numeros inteiros ! ! !");
            }

        }

    }

    public static boolean realizarOperacao(int operacao, Scanner sc) {

        List<Product> listProduct = ManagerProduct.listProduct();
        switch (operacao) {
            case 1:

                System.out.println("lista de produtos: ");
                listProduct.forEach(System.out::println);
                break;

            case 2:

                try {

                    System.out.print("quantos produtos voce deseja atualizar: ");
                    int totalUpdate = sc.nextInt();

                    for (int i = 1; i <= totalUpdate; i++) {

                        System.out.print("digite o id do produto que vocer atualizar: ");
                        int id_product = sc.nextInt();
                        System.out.println();

                        for (Product p : listProduct) {

                            if (p.getId_product() == id_product) {
                                System.out.println("------------------------------");
                                System.out.println("| (1)atualizar nome          |");
                                System.out.println("| (2)atualizar preco         |");
                                System.out.println("| (3)atualizar nome e preco  |");
                                System.out.println("-----------------------------");
                                System.out.print("digite: ");
                                int updateOp = sc.nextInt();
                                sc.nextLine();

                                switch (updateOp) {
                                    case 1:
                                        p = updateName(p, sc);
                                        break;

                                    case 2:
                                        p = updatePrice(p, sc);
                                        break;
                                    case 3:
                                        p = updateNamePrice(p, sc);
                                        break;
                                    default:
                                        System.out.println("operacao inexistente ");
                                        break;
                                }
                            }
                        }

                    }
                    ManagerProduct.updateProduct(listProduct);
                } catch (InputMismatchException e) {
                    System.out.println("tipo de digito invalido ! ! !");
                }

                break;

            case 3:

                System.out.print("quantos produtos vocer quer adicionar? ");
                int totalPadd = sc.nextInt();
                System.out.println();
                sc.nextLine();

                for (int i = 1; i <= totalPadd; i++) {

                    System.out.print("name: ");
                    String name = sc.nextLine();
                    System.out.print("price: ");
                    Double price = sc.nextDouble();
                    sc.nextLine();

                    ManagerProduct.addPorduct(name, price);
                }
                System.out.println("produto(s) adicionado(s) !");
                break;
            case 4:

                System.out.print("quantos produtos vocer quer remover? ");
                int totalPremove = sc.nextInt();

                for (int i = 1; i <= totalPremove; i++) {
                    System.out.print("digite o id do produto que voce quer remover: ");
                    int id = sc.nextInt();
                    ManagerProduct.removeProduto(id);
                }

                System.out.println("produto(s) removido(s) !");

                break;

            case 5:
                System.out.println("saindo!!!");
                return false;
            default:
                System.out.println("operacao inexistente ");
                break;

        }

        return true;
    }


    public static Product updateName(Product p, Scanner sc) {
        boolean loop = true;
        while (loop) {

            System.out.println();
            System.out.print("name:");
            String name = sc.nextLine();

            if (name.trim().isEmpty()) {
                System.out.println("o nome nao pode ficar vazio");
            } else {
                p.setName(name);
                System.out.println("(atualizao realizada)");
                loop = false;
            }
        }
        return p;
    }

    public static Product updatePrice(Product p, Scanner sc) {
        boolean loop = true;
        while (loop) {
            try {

                System.out.println();
                System.out.print("price: ");
                Double price = sc.nextDouble();

                if (price > 0) {
                    p.setPrice(price);
                    System.out.println("(atualizacao realizada)");
                    loop = false;
                } else {
                    System.out.println("valor nao pode ser menor ou igual a zero");
                }
            } catch (InputMismatchException e) {
                System.out.println("digite valores compativeis com a operacao");
                sc.nextLine();
            }
        }
        return p;
    }

    public static Product updateNamePrice(Product p, Scanner sc) {
        boolean loop = true;
        while (loop) {

            System.out.println();
            System.out.print("name:");
            String name = sc.nextLine();
            System.out.print("price: ");
            Double price = sc.nextDouble();

            if (price > 0) {

                p.setPrice(price);

                if (name.trim().isEmpty()) {
                    System.out.println("o nome nao pode ficar vazio");
                } else {
                    p.setPrice(price);
                    p.setName(name);
                    System.out.println("(atualizao realizada)");
                    loop = false;
                }

            } else {
                System.out.println("valor nao pode ser menor ou igual a zero");
            }
        }

        return p;
    }
}