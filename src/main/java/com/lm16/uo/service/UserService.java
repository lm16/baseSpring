package com.lm16.uo.service;

import com.lm16.uo.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public interface UserService {

    User findById(String id);

    List<User> findAll();

    User save(User user);

    void delete(String id);

    /**
     * 分页
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);

    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    List<User> findByIdIn(Collection<String> ids);

    Future<List<User>> asynFindAll();

    User findByNameAndPasswordRetry(String name, String password);
}
