package neu.showchart.controller;

import neu.showchart.entity.User;
import neu.showchart.repository.UserRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

   // @RequestMapping(value="/user/login",method= RequestMethod.POST)
   @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){


       User user = userRepository.findByUsernameAndPassword(username, password);
       if(user!=null){
            //登陆成功,防止表单重复提交，可以重定向到主页
           session.setAttribute("loginUser",username);
           return "redirect:/main.html";
       }else{
           //登陆失败
           map.put("msg","用户名密码错误");
           return "login";
       }


    }
}
