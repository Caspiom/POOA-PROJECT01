package cms;

import org.hsqldb.rights.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UsersList implements Persistencia<Users>{

    Scanner scan = new Scanner(System.in);
    private List<Users> users = new ArrayList<Users>();
    public int count = 0;

    @Override
    public void save(Users entidade) {
        if(entidade.getId() == null) {
            entidade.setId(count++);
        }
        users.add(entidade);
    }

    @Override
    public void atualizar(Users entidade) {
        for (Users user : users) {
            if (user.getId() == entidade.getId()) {
                user.setName(entidade.getName());
                break;
            }
        }
    }

    @Override
    public List<Users> listar() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public boolean remover(int id) {
        return users.removeIf(users -> users.getId() == id);
    }

    public boolean getName(int id){
        for(Users user : users){
            if(user.getId() == id){
                return true;
            }
        }
        return false;
    }

    public Users getUserById(int id) {
        for (Users user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Users createUser(int id) {
        System.out.println("Digite o nome do novo usuário:");
        String Novousuario = scan.nextLine();

        System.out.println("Digite a senha do novo usuário");
        String Novasenha = scan.nextLine();

        Users newUser = new Users(id,Novousuario, Novasenha);
        save(newUser);
        return newUser;
    }

    public void editUser(){
        System.out.println("Digite o id do usuário que deseja modificar:");
        int id = scan.nextInt();
        scan.nextLine(); // Consumir a nova linha

        Users user = getUserById(id);
        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do usuário:");
        String novoNome = scan.nextLine();

        user.setName(novoNome);

        atualizar(user);

        System.out.println("Usuário " + novoNome + " alterado com sucesso");
    }

    public void deleteUser() {
        System.out.println("Digite o id do usuário que deseja deletar:");
        int idDel = scan.nextInt();
        remover(idDel);
        System.out.println("Usuário removido com sucesso");
    }

    public void print() {
        System.out.println("Lista de usuários:");
        List<Users> listaUsuarios = listar();
        for (Users user : listaUsuarios) {
            System.out.println("ID: " + user.getId() + ", Nome: " + user.getName() + ", Senha: " + user.getPassword());
        }
    }

    public void editPass(){
        System.out.println("Digite o id do usuário que terá a senha redefinida:");
        int modUsuario = scan.nextInt();
        scan.nextLine(); // Consumir a nova linha

        // Verifica se o usuário existe
        if (!getName(modUsuario)) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        int tentativas = 0;
        boolean senhaCorreta = false;

        while (tentativas < 3 && !senhaCorreta) {
            System.out.println("Digite a senha anterior:");
            String velhaSenha = scan.nextLine();

            // Verifica se a senha antiga está correta
            Users user = getUserById(modUsuario);
            if (user != null && user.getPassword().equals(velhaSenha)) {
                senhaCorreta = true; // A senha está correta
            } else {
                tentativas++;
                System.out.println("Senha incorreta. Você ainda tem " + (3 - tentativas) + " tentativas.");
            }
        }

        if (!senhaCorreta) {
            System.out.println("Você excedeu o número de tentativas.");
            System.out.println("Esqueceu a senha? (sim/não)");
            String resposta = scan.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Por favor, entre em contato com o suporte para redefinir sua senha.");
            }
        } else {
            System.out.println("Digite a nova senha:");
            String novaSenha = scan.nextLine();
            Users user = getUserById(modUsuario);
            if (user != null) {
                user.setPassword(novaSenha);
                System.out.println("Senha redefinida com sucesso!");
            }
        }
    }

    public boolean verificarCredenciais(String nome, String senha) {
        for (Users user : listar()) {
            if (user.getName().equals(nome) && user.getPassword().equals(senha)) {
                return true;
            }
        }
        return false;
    }


}
