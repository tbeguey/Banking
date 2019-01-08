package Banking.Banking.controllers;

import Banking.Banking.entities.Client;
import Banking.Banking.entities.CompteCourant;
import Banking.Banking.repositories.ClientRepository;
import Banking.Banking.repositories.CompteCourantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@Controller
@RequestMapping(path="/comptes_courants")
public class CompteCourantController {
    @Autowired
    private CompteCourantRepository compteCourantRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path="")
    public @ResponseBody Iterable<CompteCourant> getAllCompteCourant() {
        // This returns a JSON or XML with the users
        return compteCourantRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody String getCompteCourant(@PathVariable int id) {
        Optional<CompteCourant> optionalCompteCourant = compteCourantRepository.findById(id);
        if(optionalCompteCourant.isPresent()) {
            CompteCourant compteCourant = optionalCompteCourant.get();
            return compteCourant.toString();
        }
        return "Error on our side";
    }

    @PostMapping(path="")
    public @ResponseBody String addNewCompteCourant(@RequestBody LinkedHashMap requestBody) {
        Optional<Client> optionalClient = clientRepository.findById((int) requestBody.get("id_client"));
        requestBody.remove("id_client");

        if(optionalClient.isPresent()){
            CompteCourant compteCourant = new ObjectMapper().convertValue(requestBody, CompteCourant.class);
            compteCourant.setClient(optionalClient.get());
            compteCourantRepository.save(compteCourant);
            return "Compte courant created : " + compteCourant.toString();
        }
        return "Client not found";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteCompteCourant(@PathVariable int id) {
        compteCourantRepository.deleteById(id);
        return "Compte courant deleted : " + id;
    }
}