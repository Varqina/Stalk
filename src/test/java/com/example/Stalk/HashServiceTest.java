package com.example.Stalk;

import com.example.Stalk.models.service.HashService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
public class HashServiceTest {
    @Mock
    HashService hashService;

    @Test
    public void hashTest(){
        System.out.println(hashService.hashRandom());

    }

}
