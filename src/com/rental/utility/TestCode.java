package com.rental.utility;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class TestCode {

    //���û�������֤��
    public void sendTestCode(String userphone,String testCode){
        //���ó�ʱʱ��-�����е���
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //��ʼ��ascClient��Ҫ�ļ�������
        final String product = "Dysmsapi";//����API��Ʒ���ƣ����Ų�Ʒ���̶��������޸ģ�
        final String domain = "dysmsapi.aliyuncs.com";//����API��Ʒ�������ӿڵ�ַ�̶��������޸ģ�
        //�滻�����AK
        final String accessKeyId = "LTAIGY0mHpclCGUS";//���accessKeyId,�ο����ĵ�����2
        final String accessKeySecret = "BilNUsLpCSRwHXGvAgLABqCclw1hMe";//���accessKeySecret���ο����ĵ�����2
        //��ʼ��ascClient,��ʱ��֧�ֶ�region�������޸ģ�
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //��װ�������
        SendSmsRequest request = new SendSmsRequest();
        //ʹ��post�ύ
        request.setMethod(MethodType.POST);
        //����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ1000���ֻ�����,������������ڵ������ü�ʱ�������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ
        request.setPhoneNumbers(userphone);
        //����:����ǩ��-���ڶ��ſ���̨���ҵ�
        request.setSignName("��ʱ����ƽ̨");
        //����:����ģ��-���ڶ��ſ���̨���ҵ�
        request.setTemplateCode("SMS_130950016");
        //��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
        //������ʾ:���JSON����Ҫ�����з�,����ձ�׼��JSONЭ��Ի��з���Ҫ��,������������а���\r\n�������JSON����Ҫ��ʾ��\\r\\n,����ᵼ��JSON�ڷ���˽���ʧ��
        request.setTemplateParam("{ \"code\":\""+ testCode +"\"}");
        //��ѡ-���ж�����չ��(��չ���ֶο�����7λ�����£������������û�����Դ��ֶ�)
        //request.setSmsUpExtendCode("90997");
        //��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
        // request.setOutId("yourOutId");
        //����ʧ���������ClientException�쳣
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("����ɹ�");//����ɹ�
        }
    }


    //������֤��
    public String createTestCode(){
        StringBuffer testCode = new StringBuffer();
        for (int i = 0; i <6 ; i++) {
            int tmp;
            tmp = (int)(Math.random()*10);
            testCode.append(tmp);
        }
        return testCode.toString();
    }
}
