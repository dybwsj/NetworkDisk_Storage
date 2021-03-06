package top.quhailong.pan.regist.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.quhailong.pan.utils.JedisClusterUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@CrossOrigin
public class RegistPageController {
    @Autowired
    private JedisClusterUtil jedisClusterUtil;

    /**
     * 注册页面跳转
     *
     * @author: quhailong
     * @date: 2019/9/27
     */
    @RequestMapping("/")
    public String regist(Model model) {
        String pid = UUID.randomUUID().toString();
        model.addAttribute("pid", pid);
        jedisClusterUtil.setValue("regist:" + pid, "registPid", 600);
        return "regist";
    }

    @RequestMapping(value = "/getpass",method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        return "forgetpass";
    }

}
