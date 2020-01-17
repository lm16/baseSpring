package com.lm16.uo;


import com.lm16.uo.bean.User;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Future;

public class AsyncTest extends BaseTest{

    @Test
    public void a() throws InterruptedException {

        long start = System.currentTimeMillis();



         Future<List<User>> list1 = userService.asynFindAll();
         Future<List<User>> list2 = userService.asynFindAll();
         Future<List<User>> list3 = userService.asynFindAll();

         while(true){
             if(list1.isDone() && list2.isDone() && list3.isDone()){
                 break;
             }else{
                 Thread.sleep(10);
             }
         }

        long end = System.currentTimeMillis();

        logger.info("三次查询耗时："+ (end-start));
    }
}
