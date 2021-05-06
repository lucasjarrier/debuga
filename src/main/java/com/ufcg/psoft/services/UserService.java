package com.ufcg.psoft.services;

import com.ufcg.psoft.models.User;
import com.ufcg.psoft.repositories.UserRepository;
import com.ufcg.psoft.util.Estagio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);


    @Autowired
    private UserRepository userRepository;

    // OK
    public User save(User user) throws Exception {
        if(validateEmail(user.getEmail())) {
            if(!isPresent(user)) return userRepository.save((user));
            else throw new Exception("Já existe um usuário com esse CPF");
        }
        throw new Exception("E-mail Inválido!");
    }

    private boolean isPresent(User user) {
        return (userRepository.findByCpf(user.getCpf()) == null) ? false : true;
    }

    // OK
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User userUpdates) throws Exception {
        User user = userRepository.findById(id).get();

        if(user == null) {
            throw new Exception("Usuário não encontrado!");
        }

        user.setEmail(userUpdates.getEmail());
        user.setName(userUpdates.getName());
        /*
        user.setCartaoSUS(userUpdates.getCartaoSUS());
        user.setEndereco(userUpdates.getEndereco());
        user.setTelefone(userUpdates.getTelefone());
        user.setProfissao(userUpdates.getProfissao());
        user.setDataNascimento(userUpdates.getDataNascimento());*/

        final User userUpdated = userRepository.save(user);
        return user;
    }

    //OK
    public User findByCPF(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    //OK
    public User deleteById(Long id) throws Exception {
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }

    //OK
    public boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User realizarVacinacao(String cpf) throws Exception {

        User user = userRepository.findByCpf(cpf);

        if(user == null) {
            throw new Exception("Usuário não cadastrado!");
        }

        else if(user.getEstagio().equals(Estagio.NaoHabilitado)) {
            user.setEstagio(Estagio.HabilitadoPrimeiraDose);
        }
        else if(user.getEstagio().equals(Estagio.HabilitadoPrimeiraDose)) {
            user.setEstagio(Estagio.TomouPrimeiraDose);
        }
        else if(user.getEstagio().equals(Estagio.TomouPrimeiraDose)) {
            user.setEstagio(Estagio.HabilitadoSegundaDose);
        }
        else if (user.getEstagio().equals(Estagio.HabilitadoSegundaDose)) {
            user.setEstagio(Estagio.Finalizado);
        } else {
            throw new Exception("Usuário Terminou a Vacinação!");
        }

        return userRepository.save(user);
    }

    public Estagio consultarEstado(String cpf) throws Exception {
        User user = findByCPF(cpf);
        if(user == null) {
            throw new Exception("Usuário não encontrado!");
        }
        return user.getEstagio();
    }
}
