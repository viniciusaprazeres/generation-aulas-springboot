package org.generation.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indica que esta é uma classe Controladora
@RequestMapping("/helloworld") // Indica um End Point para a aplicação
public class HelloWorldController {

    @GetMapping
    public String helloWorld(){
        return "Hello, World!";
    }

    @GetMapping("/bsm")
    public String bsm(){
        return "- Persistência \n" +
                "- Mentalidade de Crescimento\n" +
                "- Orientação ao Futuro\n" +
                "- Responsabilidade Pessoal\n" +
                "- Trabalho em Equipe\n" +
                "- Comunicação\n" +
                "- Comunicação Não Violenta\n" +
                "- Atenção para Detalhes\n" +
                "- Proatividade";
    }

    @GetMapping("/objetivos")
    public String objetivos(){
        return "- Aprender a usar o Postman \n" +
                "- Estudar mais sobre Classes Abstratas\n" +
                "- Entender melhor o Spring Initializr\n" +
                "- Aprender mais funções do Insomnia";
    }

}
