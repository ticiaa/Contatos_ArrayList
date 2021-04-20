package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Classes.CodeComparator;
import Classes.Contact;

public class Prog {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        int opt;
        Scanner ler = new Scanner(System.in);

        do {
            System.out.println("\n1 - Criar novo contato");
            System.out.println("2 - Exibir lista de contatos");
            System.out.println("3 - Excluir contato");
            System.out.println("4 - Pesquisar por nome");
            System.out.println("5 - Pesquisar por código");
            System.out.println("0 - Encerrar");
            System.out.println("\nDigite a opção: ");
            opt = ler.nextInt();
            ler.nextLine();

            switch (opt) {
            case 0:
                return;

            case 1:
                int code;

                do {
                    System.out.println("\nDigite 1 para cadastrar ou 2 para voltar ao menu: ");
                    code = ler.nextInt();
                    ler.nextLine();

                    if (code == 1) {
                        System.out.println("\nNome: ");
                        String contname = ler.nextLine();
                        System.out.println("Número: ");
                        String numbercont = ler.nextLine();

                        if (contacts.contains(numbercont)) {
                            System.out.println("Este contato já existe");
                        } else {
                            Random generator = new Random();
                            int codecont = generator.nextInt((9999 - 1000 + 1) + 1000);

                            contacts.add(new Contact(contname, numbercont, codecont));
                            System.out.println("Contato salvo!");
                        }
                    }

                } while (code != 2);
                break;

            case 2:
                System.out.println("\nDigite 1 para exibir em ordem alfabética ou 2 para exibir por idCode: ");
                int opc = ler.nextInt();

                if (opc == 1) {
                    contacts.sort(null);

                    if (contacts.isEmpty()) {
                        System.out.println("Não há contatos cadastrados");
                    } else {
                        System.out.println("\n------------ LISTA DE CONTATOS -----------");
                        for (Contact contact : contacts) {
                            System.out.println(contact);
                        }
                    }
                } else {
                    if (opc == 2) {
                        contacts.sort(new CodeComparator());

                        if (contacts.isEmpty()) {
                            System.out.println("Não há contatos cadastrados");
                        } else {
                            System.out.println("\n------------ CONTATOS LISTADOS POR IDCODE -----------");
                            for (Contact contact : contacts) {
                                System.out.println(contact);
                            }

                        }
                    }
                }
                break;

            case 3:
                System.out.println("Digite o nome do contato a ser exclúido: ");
                String contremove = ler.nextLine();

                contacts.removeIf(p -> p.getName().equalsIgnoreCase(contremove));
                break;

            case 4:
                System.out.println("\nDigite o nome a ser localizado: ");
                String psqname = ler.nextLine();

                for (Contact contact : contacts) {
                    if (contact.getName().equalsIgnoreCase(psqname)) {
                        System.out.println("\nContato localizado: ");
                        System.out.println(contact);
                        break;
                    } else
                        System.out.println("\nNenhum contato compatível");
                }
                break;

            case 5:
                System.out.println("\nDigite o idCode a ser localizado:");
                int idcode = ler.nextInt();

                for (Contact contact : contacts) {
                    if (contact.getCode() == (idcode)) {
                        System.out.println("\nContato localizado: ");
                        System.out.println(contact);
                        break;
                    } else
                        System.out.println("\nNenhum contato compatível");
                }
                break;

            default:
                System.out.println("Opção inválida");
                break;

            }

        } while (opt != 0);

        ler.close();
    }
}
