package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.core.domain.AjaxResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 登录控制器测试类
 * 
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class SysLoginControllerTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;
    private String baseUrl;

    @BeforeEach
    public void setUp() {
        restTemplate = new TestRestTemplate();
        baseUrl = "http://localhost:" + port;
    }

    /**
     * 测试用户登录接口
     */
    @Test
    public void testLogin() {
        // 准备登录参数
        Map<String, String> loginParams = new HashMap<>();
        loginParams.put("username", "admin");
        loginParams.put("password", "admin123");
        loginParams.put("code", "6666");
        loginParams.put("uuid", "test-uuid");

        // 发送登录请求
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(loginParams, headers);

        ResponseEntity<AjaxResult> response = restTemplate.postForEntity(
                baseUrl + "/login", request, AjaxResult.class);

        // 验证响应
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(200, response.getBody().get("code"));
        assertNotNull(response.getBody().get("token"));
    }

    /**
     * 测试获取用户信息接口
     */
    @Test
    public void testGetInfo() {
        // 先登录获取token
        Map<String, String> loginParams = new HashMap<>();
        loginParams.put("username", "admin");
        loginParams.put("password", "admin123");
        loginParams.put("code", "6666");
        loginParams.put("uuid", "test-uuid");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> loginRequest = new HttpEntity<>(loginParams, headers);

        ResponseEntity<AjaxResult> loginResponse = restTemplate.postForEntity(
                baseUrl + "/login", loginRequest, AjaxResult.class);

        String token = (String) loginResponse.getBody().get("token");

        // 使用token获取用户信息
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> getInfoRequest = new HttpEntity<>(headers);

        ResponseEntity<AjaxResult> infoResponse = restTemplate.exchange(
                baseUrl + "/getInfo", HttpMethod.GET, getInfoRequest, AjaxResult.class);

        // 验证响应
        assertEquals(HttpStatus.OK, infoResponse.getStatusCode());
        assertNotNull(infoResponse.getBody());
        assertEquals(200, infoResponse.getBody().get("code"));
        assertNotNull(infoResponse.getBody().get("user"));
        assertNotNull(infoResponse.getBody().get("roles"));
        assertNotNull(infoResponse.getBody().get("permissions"));
    }

    /**
     * 测试获取用户岗位信息接口
     */
    @Test
    public void testGetPostInfo() {
        // 先登录获取token
        Map<String, String> loginParams = new HashMap<>();
        loginParams.put("username", "admin");
        loginParams.put("password", "admin123");
        loginParams.put("code", "6666");
        loginParams.put("uuid", "test-uuid");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> loginRequest = new HttpEntity<>(loginParams, headers);

        ResponseEntity<AjaxResult> loginResponse = restTemplate.postForEntity(
                baseUrl + "/login", loginRequest, AjaxResult.class);

        String token = (String) loginResponse.getBody().get("token");

        // 使用token获取岗位信息
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> getPostInfoRequest = new HttpEntity<>(headers);

        ResponseEntity<AjaxResult> postInfoResponse = restTemplate.exchange(
                baseUrl + "/getPostInfo", HttpMethod.GET, getPostInfoRequest, AjaxResult.class);

        // 验证响应
        assertEquals(HttpStatus.OK, postInfoResponse.getStatusCode());
        assertNotNull(postInfoResponse.getBody());
        assertEquals(200, postInfoResponse.getBody().get("code"));
        // 岗位信息可能为空，但应该存在该字段
        assertNotNull(postInfoResponse.getBody().get("postNames"));
        assertNotNull(postInfoResponse.getBody().get("posts"));
    }

    /**
     * 测试获取路由信息接口
     */
    @Test
    public void testGetRouters() {
        // 先登录获取token
        Map<String, String> loginParams = new HashMap<>();
        loginParams.put("username", "admin");
        loginParams.put("password", "admin123");
        loginParams.put("code", "6666");
        loginParams.put("uuid", "test-uuid");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> loginRequest = new HttpEntity<>(loginParams, headers);

        ResponseEntity<AjaxResult> loginResponse = restTemplate.postForEntity(
                baseUrl + "/login", loginRequest, AjaxResult.class);

        String token = (String) loginResponse.getBody().get("token");

        // 使用token获取路由信息
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> getRoutersRequest = new HttpEntity<>(headers);

        ResponseEntity<AjaxResult> routersResponse = restTemplate.exchange(
                baseUrl + "/getRouters", HttpMethod.GET, getRoutersRequest, AjaxResult.class);

        // 验证响应
        assertEquals(HttpStatus.OK, routersResponse.getStatusCode());
        assertNotNull(routersResponse.getBody());
        assertEquals(200, routersResponse.getBody().get("code"));
    }
}