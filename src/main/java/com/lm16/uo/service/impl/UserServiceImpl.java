package com.lm16.uo.service.impl;


import com.lm16.uo.bean.User;
import com.lm16.uo.config.exception.BaseException;
import com.lm16.uo.dao.UserDao;
import com.lm16.uo.service.UserService;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.redis.core.RedisTemplate;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    private static final String ALL_USER = "ALL_USER_LIST";

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public User findById(String id){

        /* 从缓存中取数据 */
        List<User> list = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        if(list!=null && list.size()>0){
            for(User item: list){
                if(item.getId().equals(id)){
                    logger.info("findById be provided from redis");
                    return item;
                }
            }
        }

        User user = userDao.findById(id).orElseThrow(()-> new EntityNotFoundException(id));

        try {
            logger.info("我想执行一下？");
            logger.info(System.currentTimeMillis());
        }catch (Exception e){
            return user;
        }

/*         加入缓存列表*/
        redisTemplate.opsForList().leftPush(ALL_USER, user);

        return user;
        /*return userDao.findById(id).orElseThrow(()->new EntityNotFoundException(id));*/
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {



        String error = null;
        error.split("/");

        return userDao.save(user);
    }

    @Override
    public void delete(String id) {
        userDao.deleteById(id);

        logger.info("userService/delete()  id="+id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userDao.findByNameLike(name);
    }

    @Override
    public List<User> findByIdIn(Collection<String> ids) {
        return userDao.findByIdIn(ids);
    }

    @Async
    @Override
    public Future<List<User>> asynFindAll() {
        try{
            logger.info("计时开始");
            long start = System.currentTimeMillis();

            List<User> list = userDao.findAll();

            long end = System.currentTimeMillis();
            logger.info("计时结束。耗时为"+(end-start));

            return new AsyncResult<>(list);
        }catch (Exception e){

            logger.error("error", e);

            return new AsyncResult<>(null);
        }
    }

    @Override
    @Retryable(value={BaseException.class}, maxAttempts = 5, backoff=@Backoff(delay=5000, multiplier=2))
    public User findByNameAndPasswordRetry(String name, String password) {

        logger.info("[findByNameAndPasswordRetry] 方法重试失败！");

        throw new BaseException();

    }
}
