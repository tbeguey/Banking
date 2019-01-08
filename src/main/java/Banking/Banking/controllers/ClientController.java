package Banking.Banking.controllers;

import Banking.Banking.entities.Client;
import Banking.Banking.entities.CompteCourant;
import Banking.Banking.repositories.ClientRepository;
import Banking.Banking.repositories.CompteCourantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompteCourantRepository compteCourantRepository;


    @GetMapping(path="")
    public @ResponseBody Iterable<Client> getAllClients() {
        // This returns a JSON or XML with the users
        return clientRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody String getClient(@PathVariable int id) {
        // This returns a JSON or XML with the users
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            return client.toString();
        }
        return "Error on our side";
    }

    @GetMapping(path="/{id}/comptes")
    public @ResponseBody String getComptesClient(@PathVariable int id){
        return "";
    }

    @PostMapping(path="")
    public @ResponseBody String addNewClient(@RequestBody Client client) {
        clientRepository.save(client);
        return "Client created : " + client.toString();
    }

    @PutMapping(path="/{id}")
    public @ResponseBody String updateClient(@RequestBody Client c, @PathVariable int id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            client.setPrenom(c.getPrenom());
            client.setNom(c.getNom());

            clientRepository.save(client);
            return "Client update : " + client.toString();
        }

        //return "Error on our side";
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteClient(@PathVariable int id) {
        clientRepository.deleteById(id);
        return "Client deleted : " + id;
    }

    @GetMapping(path="/rich")
    public @ResponseBody Iterable<Client> getRichClients() {
        return clientRepository.findRichClients();
    }
}
