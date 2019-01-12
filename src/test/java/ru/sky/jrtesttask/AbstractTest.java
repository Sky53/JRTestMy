package ru.sky.jrtesttask;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.properties")
public abstract class AbstractTest {
}
