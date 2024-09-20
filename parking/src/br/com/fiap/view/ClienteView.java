package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;

public class ClienteView {
        public static void main(String[] args) {
            int id;
            String nome, placa;
            String[] escolha = {"Inserir","Alterar","Excluir","Listar"};
            int opcao;
            ClienteController clienteController = new ClienteController();
            do {
                try {
                    opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id"));
                    switch (opcao) {
                        case 0:
                            nome = JOptionPane.showInputDialog("Digite o nome do cliente");
                            placa = JOptionPane.showInputDialog("Digite uma placa para o cliente");
                            System.out.println(clienteController.inserirCliente(nome, placa));
                            break;
                        case 1:
                            nome = JOptionPane.showInputDialog("Digite um NOVO nome para o cliente");
                            placa = JOptionPane.showInputDialog("Digite uma NOVA placa para o cliente");
                            System.out.println(clienteController.alterarCliente(id, nome, placa));
                            break;
                        case 2:
                            System.out.println(clienteController.excluirCliente(id));
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, clienteController.listarUmCliente(id));
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
            JOptionPane.showMessageDialog(null, "Fim de Programa");
        }
}
