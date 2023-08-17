package com.a3.trabalho.rest.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.mindrot.jbcrypt.BCrypt;


import com.a3.trabalho.rest.Modelos.Users;
import com.a3.trabalho.rest.Modelos.Voo;
import com.a3.trabalho.rest.Repo.UserRepo;
import com.a3.trabalho.rest.Repo.VooRepo;

@CrossOrigin
@RestController
public class ApiControllers {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VooRepo vooRepo;

    @GetMapping(value = "/")
    public String getpage() {
        return "Welcome";
    }

    @GetMapping(value = "/voos")
    public List<Voo> getVoos() {
        return vooRepo.findAll();
    }

    @GetMapping(value = "/users")
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveuser(@RequestBody Users user){
        String hashedPassword = BCrypt.hashpw(user.getSenha(), BCrypt.gensalt());
        user.setSenha(hashedPassword);
        userRepo.save(user);    
        return "Usuário salvo com sucesso";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Users user) {
        Users updatedUser = userRepo.findById(id).get();
        updatedUser.setEmail(user.getEmail());
        String hashedPassword = BCrypt.hashpw(user.getSenha(), BCrypt.gensalt());
        updatedUser.setSenha(hashedPassword);
        userRepo.save(updatedUser);
        return "Usuário atualizado com sucesso";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser (@PathVariable int id) {
        Users deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return String.format("O Usuário com o id \"%d\" foi deletado com sucesso", id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(@RequestBody Users user) {
        Users existingUser = userRepo.findByEmail(user.getEmail());

        if (existingUser != null && BCrypt.checkpw(user.getSenha(), existingUser.getSenha())) {
            return new ResponseEntity<>("Login bem-sucedido!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Falha no Login", HttpStatus.UNAUTHORIZED);
        }
    }

}
