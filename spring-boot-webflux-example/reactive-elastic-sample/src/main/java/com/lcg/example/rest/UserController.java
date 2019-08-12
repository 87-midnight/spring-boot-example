package com.lcg.example.rest;

import com.lcg.example.model.User;
import com.lcg.example.repository.ElasticUserRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private ElasticUserRepository elasticUserRepository;

    @GetMapping("")
    public Flux<User> all() {
        return this.elasticUserRepository.findAll();
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody User User) {
        return this.elasticUserRepository.save(User);
    }

    @GetMapping("/{id}")
    public Mono<User> get(@PathVariable("id") String id) {
        return this.elasticUserRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") String id, @RequestBody User User) {
        return this.elasticUserRepository.findById(id)
                .map(p -> {
                    p.setUsername(User.getUsername());
                    return p;
                })
                .flatMap(p -> this.elasticUserRepository.save(p));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return this.elasticUserRepository.deleteById(id);
    }
}
