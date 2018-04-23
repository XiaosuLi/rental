package com.rental.controller;


import com.rental.pojo.User;
import com.rental.service.UserService;
import com.rental.utility.TestCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    /*+++
    1������С�᣺get��post������£���ֵ�ԣ�form����name��������ֱ�Ӵ�������
       �ڲ���������һ�����ܽ�������
    2���Ѵ����Ĳ�����װ��һ��bean�ࣨ����ֻ��䲿�����ԣ�������ֻҪbean����������form����nameһ�����Զ�ע��bean����
       ע�����bean���������Ĺ��췽����дһ���޲����Ĺ��췽��
    3������ͬʱע��һ��baen��+���ղ������������������Ĳ�������ȫ���ŵ�bean��

     */




    /*
       ת��ע��ҳ��
     */
    @RequestMapping("/register")
    public String toRegisterPage(){
        return "register";
    }

    /*
       ת����¼����
     */
    @RequestMapping("/login")
    public String toLoginPage(){
        return "login";
    }

    /*
    ��ת����������ҳ��
     */

    @RequestMapping("/forgetpawd")
    public String toForgetpawdPage(){
        return "forgetpawd";
    }

    /*
    ��ת���޸�����ҳ��
     */

    @RequestMapping("/changepawd")
    public String toChangepawd(){
        return "changepawd";
    }







    /*
    ִ��ע�����
    */
    @RequestMapping("/doregister")
    @ResponseBody
    public Map<String,Object> listAllUser(User u, String testCode, HttpSession session) {

        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (userService.userIsExist(u.getUserPhone())) {
            resultMap.put("result", "�û��Ѿ�ע��");
            return resultMap;
        }

        //�жϲ�������Ϲ淶
        String myTestCodePhone = (String) session.getAttribute("testCodePhone");
        String myTestCode = (String) session.getAttribute("testCode");
        if (testCode.equals(myTestCode) && testCode.length() != 0
                && u.getUserPhone().equals(myTestCodePhone)) {
            System.out.println("ע��ɹ�");
            //���سɹ��Ľ��
            resultMap.put("result", "SUCCESS");
            userService.userRegister(u);
            return resultMap;
        } else {
            //������֤�����
            resultMap.put("result", "��֤�����");
            return resultMap;
        }

    }

    /*
    ִ�е�¼����
     */
    @RequestMapping("/dologin")
    @ResponseBody
    public Map<String,Object> userLogin(String userPhone, String userPassword,
                                        HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        User user = userService.userLogin(userPhone, userPassword);
        if (user == null) {
            resultMap.put("result", "�û������ڻ��������");
            return  resultMap;
        } else {
            //��userPhone д��Session;
            session.setAttribute("userPhone", userPhone);
            System.out.println(session.getAttribute("userPhone").toString());
            resultMap.put("result", "SUCCESS");
            return  resultMap;
        }
    }

    /*
    ��ȡ��֤��,
    ע��ʱ��
    �ȿ��ֻ���ע��û��
    ע�᷵���Ѿ�ע�ᣬ�������ţ�δע�ᣬ���Ͷ���


    */
    @RequestMapping("/getcode")
    @ResponseBody
    public Map<String,Object> getTestCode(String userPhone, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (userService.userIsExist(userPhone)) {
            resultMap.put("result", "�û��Ѿ�ע��");
            System.out.println("�û��Ѿ�ע��");
            return resultMap;
        } else {
            //������֤�룬������֤��д��Session
            TestCode testCode = new TestCode();
            String code = testCode.createTestCode();
            System.out.println("�ֻ�����:" + userPhone);
            System.out.println("��֤����:" + code);
            session.setAttribute("testCodePhone",userPhone);
            session.setAttribute("testCode", code);
            //TODO ���Ͷ�����֤��Ŀ���
            //  testCode.sendTestCode(userPhone,code);
            resultMap.put("result", "SUCCESS");
            return resultMap;
        }
    }



    /*
    �޸�����ʱ��
    �ȿ��ֻ��Ŵ���û��
    ��������ʾ���û������ڣ����ڣ�������֤��
     */

    @RequestMapping("/getpawdcode")
    @ResponseBody
    public Map<String,Object> getPawdTestCode(String userPhone, HttpSession session) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if (userService.userIsExist(userPhone)) {
            TestCode testCode = new TestCode();
            String code = testCode.createTestCode();
            System.out.println("�ֻ�����:" + userPhone);
            System.out.println("��������ʱ��֤����:" + code);
            session.setAttribute("testCodePhone",userPhone);
            session.setAttribute("testCode", code);
            //TODO ���Ͷ�����֤��Ŀ���
            //  testCode.sendTestCode(userPhone,code);
            resultMap.put("result", "SUCCESS");
            return resultMap;
        } else {

            resultMap.put("result", "�û�������");
            System.out.println("�û�������");
            return resultMap;
        }
    }


    /*
    ��������-����֤���Ƿ�ͨ��
    ͨ������ת�����������jsp

     */

    @RequestMapping("/changepawdcode")
    @ResponseBody
    public Map<String,Object> changePassword(HttpSession session,String testCode,String userPhone,HttpServletResponse resp) throws IOException {

        Map<String,Object> resultMap = new HashMap<String,Object>();

        String myTestCodePhone = (String) session.getAttribute("testCodePhone");
        String myTestCode = (String) session.getAttribute("testCode");
        if (testCode.equals(myTestCode) && testCode.length() != 0
                && userPhone.equals(myTestCodePhone)) {
            System.out.println("�޸�����ɹ�");
            //���سɹ��Ľ��
            resultMap.put("result", "SUCCESS");
            //���޸�����ҳ��ͨ�� ���ֵ����ȡuser
            session.setAttribute("passUserPhone",userPhone);
            return resultMap;
        } else {
            //������֤�����
            resultMap.put("result", "��֤�����");
            return resultMap;
        }

    }



    /*

    �޸�����ɹ�����ת����¼ҳ��

     */

    @RequestMapping("tochangepawd")
    public String toChangePawd (String userPassword,HttpSession session){

        System.out.println(userPassword);
        String userPhone = session.getAttribute("passUserPhone").toString();
        userService.userChangePswd(userPhone,userPassword);
        return "login";
    }


}
