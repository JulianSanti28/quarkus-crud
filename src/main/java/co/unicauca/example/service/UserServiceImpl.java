package co.unicauca.example.service;

import co.unicauca.example.config.MessageLoader;
import co.unicauca.example.domain.ResponseDto;
import co.unicauca.example.exception.BusinessRuleException;
import co.unicauca.example.model.User;
import co.unicauca.example.repository.IUserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static co.unicauca.example.util.MessagesConstants.EM001;
import static co.unicauca.example.util.MessagesConstants.IM001;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__ (@Inject))
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;
    @Override
    public ResponseDto<User> saveUser(User payload) {
        userRepository.persist(payload);
        return new ResponseDto<>(Response.Status.OK.getStatusCode(), MessageLoader.getInstance().getMessage(IM001), payload);
    }
    @Override
    public ResponseDto<User> findById(Long userId) {
       if (!this.userRepository.existsById(userId))
          throw new BusinessRuleException(Response.Status.BAD_REQUEST.getStatusCode(), MessageLoader.getInstance().getMessage(EM001, userId), EM001);
        return new ResponseDto<>(Response.Status.OK.getStatusCode(), MessageLoader.getInstance().getMessage(IM001), this.userRepository.findById(userId));
    }
    @Override
    public ResponseDto<List<User>> findAll() {
        return new ResponseDto<>(Response.Status.OK.getStatusCode(), MessageLoader.getInstance().getMessage(IM001), this.userRepository.listAll());
    }
}
