package com.lm16.uo.dao;

import com.lm16.uo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    /**
     *
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     *
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);

    /**
     *
     * @param ids
     * @return
     */
    List<User> findByIdIn(Collection<String> ids);
}
