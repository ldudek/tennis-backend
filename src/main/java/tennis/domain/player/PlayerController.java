package tennis.domain.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/players")
    List<Player> all() {
        return playerService.listAll();
    }

    @PostMapping("/players")
    Player addPlayer(@RequestBody Player player) {
        return playerService.add(player);
    }

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {

        //TODO
        return null;
    }

    @PutMapping("/players/{id}")
    Player updatePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {

        //TODO
        /*
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
        */
        return null;
    }


    @DeleteMapping("/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        //TODO
    }

}
