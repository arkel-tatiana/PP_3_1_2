package web.pp_3_1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.pp_3_1_2.dao.UserRepository;
import web.pp_3_1_2.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
         return userRepository.findAll();
    }

    @Override
    public void saveUser(User userSave) {
        userRepository.save(userSave);
    }

    @Override
    public void deleteUser(Long id) { userRepository.deleteById(id);}

    @Override
    public User findUser(Long id) {
        User userFind = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userFind = optionalUser.get();
        }
        return userFind;
    }

    @Override
    public void updateUser(User userUpdate) {
        userRepository.save(userUpdate);
    }


}
