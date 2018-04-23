package com.rental.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {

    //�û�����չ�����controller����ǰ
    //����ֵ���ж��Ƿ񽫵�ǰ��������������
    //true���������ִ��
    //flase��������ֹ
    //Object o ����ʾ���Ǳ����صĿ�����Ķ���
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("ִ�е���preHandle����");
        return true;
    }


    //controller��������󣬻�û�����û����ڽ���һ�δ������û�
    //ModelAndView modelAndView�������޸���ʾ����ͼ���޸���ʾ��ͼ�ķ���
    //modelAndView.addObject("msg","�������޸ĵ���Ϣ"); �޸����������������ֵɶ��
    //  modelAndView.setViewName("hello2"); �޸ķ��ص���ͼɶ��
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("ִ�е���postHandle����");
       // modelAndView.addObject("msg","�������޸ĵ���Ϣ");
       // modelAndView.setViewName("hello2");
    }


    //�Ѿ������û��ˣ��������������������Դ������
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("ִ�е���afterHandle����");
    }
}
