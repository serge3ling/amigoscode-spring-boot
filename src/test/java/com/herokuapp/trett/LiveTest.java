package com.herokuapp.trett;

import com.herokuapp.trett.entity.Student;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Main.class }, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LiveTest {
    private static final String API_ROOT = "http://localhost:8080/students";

    @Test
    public void testGetAllStudents() {
        Response response = RestAssured.get(API_ROOT);
        org.junit.Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        System.out.println("testGetAllStudents() passed.");
    }

    @Test
    public void testGetStudent1() {
        Response response = RestAssured.get(API_ROOT + "/1");
        // id, name, course
        int id = response.jsonPath().getInt("id");
        String name = response.jsonPath().getString("name");
        String course = response.jsonPath().getString("course");
        assertEquals(1, id);
        Student student = new Student(id, name, course);
        System.out.println("testGetStudent1() passed. " + student);
    }
}
