package cn.hoarfrost.security.demo.controller;

import cn.hoarfrost.security.demo.security.ImoocAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @time: 2019/7/23 15:32
 * @author: huangyicai
 * @descripe:
 * @version: 1.0
 */
@RestController
@RequestMapping("test")
public class TestController {
    /*@Autowired
    private ImoocAuthenticationSuccessHandler hoarfrostAuthenticationSuccessHandler;

    @GetMapping("q")
    public String test1(){
        return "1111";
    }
    @GetMapping("code")
    public void codeLogin(@RequestParam Map<String, String> parameters, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Authentication userAuth = new UsernamePasswordAuthenticationToken(parameters.get("username"), parameters.get("password"));
        ((AbstractAuthenticationToken)userAuth).setDetails(parameters);
        hoarfrostAuthenticationSuccessHandler.onAuthenticationSuccess(request,response,userAuth);
    }*/
}
