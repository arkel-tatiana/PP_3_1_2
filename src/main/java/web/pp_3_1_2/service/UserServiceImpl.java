package web.pp_3_1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.pp_3_1_2.dao.UserRepository;
import web.pp_3_1_2.model.User;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
         return userRepository.findAll();
    }

    @Override
    @Transactional()
    public void saveUser(User userSave) {
        userRepository.save(userSave);
    }

    @Override
    @Transactional()
    public void deleteUser(Long id) { userRepository.deleteById(id);}

    @Override
    @Transactional(readOnly = true)
    public User findUser(Long id) {
        User userFind = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userFind = optionalUser.get();
        }
        return userFind;
    }

    @Override
    @Transactional()
    public void updateUser(User userUpdate) {
        userRepository.save(userUpdate);
    }


}
