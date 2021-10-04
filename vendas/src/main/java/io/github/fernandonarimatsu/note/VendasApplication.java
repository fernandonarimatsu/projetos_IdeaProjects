package io.github.fernandonarimatsu.note;

import io.github.fernandonarimatsu.note.domain.entity.Cliente;
import io.github.fernandonarimatsu.note.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando Clientes.");
            clientes.salvar(new Cliente("Fernando Akio Narimatsu"));
            clientes.salvar(new Cliente("Rafael Yuji Narimatsu"));
            clientes.salvar(new Cliente("Julia Akemi Narimatsu"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando Clientes.");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            System.out.println("Buscando Clientes.");
            clientes.buscarPorNome("Ak").forEach(System.out::println);

//            todosClientes = clientes.obterTodos();
//            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }



}
