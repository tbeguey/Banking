package Banking.Banking.controllers;

import Banking.Banking.entities.Client;
import Banking.Banking.entities.CompteEpargne;
import Banking.Banking.repositories.ClientRepository;
import Banking.Banking.repositories.CompteEpargneRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@Controller
@RequestMapping(path="/comptes_epargnes")
public class CompteEpargneController {
    @Autowired
    private CompteEpargneRepository compteEpargneRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path="")
    public @ResponseBody
    Iterable<CompteEpargne> getAllCompteEpargne() {
        // This returns a JSON or XML with the users
        return compteEpargneRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody String getCompteEpargne(@PathVariable int id) {
        Optional<CompteEpargne> optionalCompteEpargne = compteEpargneRepository.findById(id);
        if(optionalCompteEpargne.isPresent()) {
            CompteEpargne CompteEpargne = optionalCompteEpargne.get();
            return CompteEpargne.toString();
        }
        return "Error on our side";
    }

    @PostMapping(path="")
    public @ResponseBody String addNewCompteEpargne(@RequestBody LinkedHashMap requestBody) {
        Optional<Client> optionalClient = clientRepository.findById((int) requestBody.get("id_client"));
        requestBody.remove("id_client");

        if(optionalClient.isPresent()){
            CompteEpargne CompteEpargne = new ObjectMapper().convertValue(requestBody, CompteEpargne.class);
            CompteEpargne.setClient(optionalClient.get());
            compteEpargneRepository.save(CompteEpargne);
            return "Compte courant created : " + CompteEpargne.toString();
        }
        return "Client not found";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteCompteEpargne(@PathVariable int id) {
        compteEpargneRepository.deleteById(id);
        return "Compte courant deleted : " + id;
    }
}