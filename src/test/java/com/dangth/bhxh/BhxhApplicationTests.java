package com.dangth.bhxh;

import com.dangth.bhxh.model.Worker;
import com.dangth.bhxh.model.admin.Role;
import com.dangth.bhxh.model.admin.User;
import com.dangth.bhxh.repository.UserRepository;
import com.dangth.bhxh.repository.WorkerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BhxhApplicationTests {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindMsbh() {
        Worker w = workerRepository.findByMsbh("1553934403501");
        Assert.assertEquals("Tran Hai Dang", w.getFullName());
    }

    @Test
    @Transactional
    public void testSignIn() {
        User actual = userRepository.findByEmail("dangth@gmail.com");
        User expectedResult = new User();
        expectedResult.setId(1);
        expectedResult.setEmail("dangth@gmail.com");
        expectedResult.setPassword("$2a$10$tfrsFQv//azBkhsCq22VD.pj/AcJJZZubmpI530.vF/vJJUji8JiW");
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, "ROLE_ADMIN"));
        expectedResult.setRoles(new HashSet<>(roles));
        Assert.assertEquals(expectedResult, actual);
    }
}
