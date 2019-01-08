package Banking.Banking.controllers;

import Banking.Banking.entities.Operation;
import Banking.Banking.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/operations")
public class OperationController {

    @Autowired
    private OperationRepository operationRepository;


    @GetMapping(path="")
    public @ResponseBody
    Iterable<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    String getOperationById(@PathVariable int id) {
        Optional<Operation> optionalOperation = operationRepository.findById(id);
        if(optionalOperation.isPresent())
            return optionalOperation.get().toString();
        return "Error on our side";
    }


    @PostMapping(path="")
    public @ResponseBody String addNewOperation(@RequestBody Operation operation) {
        operationRepository.save(operation);
        return "Operation created : " + operation.toString();
    }

    @GetMapping(path="/clients/{id}")
    public @ResponseBody
    Iterable<Operation> getOperationsByClient(@PathVariable int id) {
        return operationRepository.findByClient(id);
    }
}
