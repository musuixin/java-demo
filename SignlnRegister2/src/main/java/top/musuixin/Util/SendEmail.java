package top.musuixin.Util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;


class SendmailUtil extends Thread {
    String Toemail;

    public void setToemail(String toemail) {
        Toemail = toemail;
    }

    @Override
    public void run() {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp"); // 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com"); // 主机名
        properties.put("mail.smtp.port", 465);  // 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");  // 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true"); // 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        try {
            message.setFrom(new InternetAddress("1804125652@qq.com"));
            // 设置收件人地址
            message.setRecipients(RecipientType.TO, new InternetAddress[]{new InternetAddress(Toemail)});
            // 设置邮件标题
            message.setSubject("由JavaMail发出的测试邮件");
            // 设置邮件内容
            message.setText("内容为： 这是第一封java发送来的邮件。");
            // 得到邮差对象
            Transport transport = session.getTransport();
            // 连接自己的邮箱账户
            transport.connect("1804125652@qq.com", "lmtpxokrpufdcddj");// 密码为刚才得到的授权码
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class SendEmail {
    public static void main(String[] args) {
        SendmailUtil sendmailUtil = new SendmailUtil();
        sendmailUtil.setToemail("fangdangyu@gmail.com");
        sendmailUtil.start();
        SendmailUtil sendmailUtil1 = new SendmailUtil();
        sendmailUtil1.setToemail("1154430034@qq.com");
        sendmailUtil1.start();
        System.out.println("正在发送邮件");

    }
}
