package com.mengyou.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.List;

/**
 * Created by zhangfan on 2015/8/31.
 */
public class MailEngine {

    private List<MailSender> mailSenders;


    public List<MailSender> getMailSenders() {
        return mailSenders;
    }

    public void setMailSenders(List<MailSender> mailSenders) {
        this.mailSenders = mailSenders;
    }


    public void send() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("");
        simpleMailMessage.setTo();
        simpleMailMessage.setReplyTo();
        simpleMailMessage.setSubject();
        simpleMailMessage.setText();
        for (MailSender mailSender : mailSenders) {

            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
            helper.setFrom(email.getFromAddress());// 发件人
            helper.setTo(email.getToAddress());// 收件人
            helper.setReplyTo(email.getFromAddress());// 回复到
            helper.setSubject(email.getSubject());// 邮件主题
            helper.setText(email.getContent(), true);// true表示设定html格式
            mailSender.send(mime);

        }
    }
}
