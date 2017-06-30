package com.free.exam.controller;

import com.free.exam.dao.PackageDao;
import com.free.exam.dao.UserDao;
import com.free.exam.model.Package;
import com.free.exam.model.User;
import com.free.exam.mutithread.ThreadStateStudy;
import com.free.exam.orm.EzOrm;
import com.free.exam.proxy.DynamicHanlder;
import com.free.exam.service.SocketService;
import com.free.exam.service.UserService;
import com.free.exam.util.MethodReflectUtil;
import com.free.exam.util.Points24Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Li Yu on 2017/6/6.
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private SocketService userSocketService;
    @Autowired
    private MethodReflectUtil mru;
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    @Autowired
    @Qualifier("packageDao")
    private PackageDao packageDao;
    @Autowired
    private Points24Util p2u;
    @Autowired
    private ThreadStateStudy tss;

    @RequestMapping(value = "/exam/mysqltest", method = RequestMethod.GET)
    public List<User> testUser(HttpServletRequest request, Model model){
        List<User> users = userService.getAllUsers();
        System.out.println(users.toString());
        Collections.sort(users, new Comparator<User>(){
            public int compare(User o1, User o2){
                if(o1.getId() >= o2.getId()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        User user = userService.getUserByName("Max");
        System.out.println(user.toString());
        return users;
    }

    @RequestMapping(value = "/exam/socketservertest", method = RequestMethod.GET)
    public String testSocket(HttpServletRequest request, Model model){
        userSocketService.getServerAndListen();
        return "OK";
    }

    @RequestMapping(value = "/exam/ormtest", method = RequestMethod.GET)
    public String testOrm(HttpServletRequest request, Model model){
        //User user = new User();
        //user.setId(0L);
        //user.setName("Test");
        //user.setNationality("Earth");
        //user.setGender("Male");
        //user = userDao.getById(1L);
        //System.out.println(user.toString());
        //userDao.save(user);

        Package pkg = new Package();
        pkg.setPkgId(2L);
        pkg.setPkgName("测试叠加包");
        pkg.setDataLimit(25000L);
        pkg.setMsgLimit(600L);
        pkg.setVoiceLimit(54000L);
        packageDao.save(pkg);
        //pkg = packageDao.getById(1L);
        //System.out.println(pkg.toString());

        return "OK";
    }

    @RequestMapping(value = "/exam/delete", method = RequestMethod.GET)
    public String testOrmDetele(HttpServletRequest request, Model model){
        User user = new User();
        user.setId(0L);
        user.setName("Test");
        user.setNationality("Earth");
        user.setGender("Male");
        System.out.println(user.toString());
        userDao.remove(user);

        //Package pkg = new Package();
        //pkg.setPkgId(2L);
        //pkg.setPkgName("测试叠加包");
        //pkg.setDataLimit(25000L);
        //pkg.setMsgLimit(600L);
        //pkg.setVoiceLimit(54000L);
        //packageDao.save(pkg);
        //pkg = packageDao.getById(1L);
        //System.out.println(pkg.toString());

        return "OK";
    }

    @RequestMapping(value = "/exam/update", method = RequestMethod.GET)
    public String testOrmUpdate(HttpServletRequest request, Model model){
        User user = new User();
        user.setId(2L);
        user.setName("Test");
        user.setNationality("Earth");
        user.setGender("Male");
        System.out.println(user.toString());
        userDao.update(user);

        //Package pkg = new Package();
        //pkg.setPkgId(2L);
        //pkg.setPkgName("测试叠加包");
        //pkg.setDataLimit(25000L);
        //pkg.setMsgLimit(600L);
        //pkg.setVoiceLimit(54000L);
        //packageDao.save(pkg);
        //pkg = packageDao.getById(1L);
        //System.out.println(pkg.toString());

        return "OK";
    }

    @RequestMapping(value = "/exam/getAll", method = RequestMethod.GET)
    public String testOrmSelectAll(HttpServletRequest request, Model model){
        List<User> users = userDao.getAll();
        System.out.println(users.toString());
        List<Package> pkgs = packageDao.getAll();
        System.out.println(pkgs.toString());
        return "OK";
    }

    @RequestMapping(value = "/exam/reflectest", method = RequestMethod.GET)
    public String testReflect(HttpServletRequest request, Model model){
        User user = new User();
        mru.init(user);
        mru.setMethodCall("setName", "101");
        return "OK";
    }

    @RequestMapping(value = "/exam/proxy", method = RequestMethod.GET)
    public String testProxy(HttpServletRequest request, Model model){
        DynamicHanlder dynamicHanlder = new DynamicHanlder();
        EzOrm ezOrm = (EzOrm) dynamicHanlder.bind(new UserDao());
        List<User> users = ezOrm.getAll();
        System.out.println(users);
        User user = (User) ezOrm.getById(2L);
        System.out.println(user);
        return "OK";
    }

    @RequestMapping(value = "/exam/24", method = RequestMethod.GET)
    public List<String> test24(HttpServletRequest request, Model model){
        int[] inputs = {10,2,3,4};
        List<String> res = p2u.do24(inputs);
        return res;
    }

    @RequestMapping(value = "/do24", method = RequestMethod.POST)
    public List<String> play24(@RequestBody Map<String, Integer> paramap){
        int[] inputs = {paramap.get("num1"),paramap.get("num2"),paramap.get("num3"),paramap.get("num4")};

        List<String> res = p2u.do24(inputs);
        return res;
    }

    @RequestMapping(value = "threadTest", method = RequestMethod.GET)
    public String threadTest(){
        tss.test();
        return "O.O";
    }
}
