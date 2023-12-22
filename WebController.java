package com.uern.rpcdistribuidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private RMIService rmiService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("result", "");
        return "index";
    }

    @PostMapping("/searchNumber")
    public String searchNumber(String nome, Model model) {
        try {
        	rmiService.init();
        	
            String result = rmiService.buscar(nome);
            model.addAttribute("result", "O número de " + nome + result);
        } catch (Exception e) {
            model.addAttribute("result", "Erro na obtenção do número");
            System.out.println(e.getMessage());
        }
        return "index";
    }
}
