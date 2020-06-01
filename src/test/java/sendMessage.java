//
//import java.util.Properties;
//
//import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//class sendMessage {
//
//     @Test
//     public static void springMail() throws MessagingException {
//         ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext-DataSource.xml");
//
//         JavaMailSender javaMailSender = ioc.getBean(JavaMailSender.class);
//         System.out.println("？？？Sadada:"+javaMailSender);
//         MimeMessage message = javaMailSender.createMimeMessage();
//
//         MimeMessageHelper helper=new MimeMessageHelper(message);
//         //发送方  这个要和properties中的一致
//         helper.setFrom("1398231193@qq.com");
//         //接受方
//         helper.setTo("1151466132@qq.com");
//
//         //主题
//         helper.setSubject("您的账号出现异常！");
//         //邮件内容
//         helper.setText("截止2020年5月28日10:17分，出现黑客入侵危害，请及时注意，切勿乱发验证码！");
//
//         javaMailSender.send(message);
//     }
//
//    public static void main(String[] args) throws MessagingException {
//        springMail();
//    }
//}
