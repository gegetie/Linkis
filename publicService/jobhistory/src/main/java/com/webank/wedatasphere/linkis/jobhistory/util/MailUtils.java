package com.webank.wedatasphere.linkis.jobhistory.util;

import com.webank.wedatasphere.linkis.jobhistory.enums.FileTypeEnum;
import com.webank.wedatasphere.linkis.jobhistory.exception.MailException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;


@Component
public class MailUtils {
	
    private Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String sendEmailfrom;

    @Value("${spring.mail.nickname}")
    private String nickName;

    /**
     * 发送简单邮件
     *
     * @param from    发件人
     * @param subject 主题
     * @param to      收件人
     * @param cc      抄送
     * @param bcc     加密抄送
     * @param content 内容
     * @throws MailException 
     * @throws ServerException
     */
    public void sendSimpleEmail(String from, String subject, String[] to, String[] cc, String[] bcc, String content) throws MailException  {
        long startTimestamp = System.currentTimeMillis();
        log.info("start send email to {}", to.toString());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setSubject(subject);
            message.setTo(to);
            if (null != cc && cc.length > 0) {
                message.setCc(cc);
            }
            if (null != bcc && bcc.length > 0) {
                message.setBcc(bcc);
            }
            message.setText(content);
            javaMailSender.send(message);
            log.info("send mail success, in {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (Exception e) {
            log.error("send mail failed, {} \n", e.getMessage());
            e.printStackTrace();
            throw new MailException(e.getMessage());
        }
    }

    /**
     * 发送简单邮件
     * 使用默认配置发送地址
     *
     * @param to      接受邮箱地址
     * @param subject 主题
     * @param content 内容
     * @throws ServerException
     */
    public void sendSimpleEmail(String to, String subject, String content) throws MailException {
        sendSimpleEmail(sendEmailfrom, subject, new String[]{to}, null, null, content);

    }

    /**
     * 发送 Html 邮件
     *
     * @param subject  主题
     * @param from     发件人
     * @param nickName 昵称
     * @param to       收件人
     * @param cc       抄送
     * @param bcc      加密抄送
     * @param content  内容
     * @throws ServerException
     */
    public void sendHtmlEmail(String from, String nickName, String subject, String[] to, String[] cc, String[] bcc,
                              String content, List<File> files) throws MailException {

        if (StringUtils.isEmpty(from)) {
            log.info("email address(from) cannot be EMPTY");
            throw new MailException("email address(from) cannot be EMPTY");
        }

        Matcher matcher = Constants.PATTERN_EMAIL_FORMAT.matcher(from);

        if (!matcher.find()) {
            log.info("unknow email address(from): {}", from);
            throw new MailException("unknow email address(from)");
        }

        if (StringUtils.isEmpty(subject)) {
            log.info("email subject cannot be EMPTY");
            throw new MailException("email subject cannot be EMPTY");
        }

        if (null == to || to.length < 1) {
            log.info("email address(to) cannot be EMPTY");
            throw new MailException("email address(to) cannot be EMPTY");
        }

        if (StringUtils.isEmpty(content)) {
            log.info("email content cannot be EMPTY");
            throw new MailException("email content cannot be EMPTY");
        }

        long startTimestamp = System.currentTimeMillis();
        log.info("start send email to "+ to);
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(from, nickName);
            messageHelper.setSubject(subject);
            messageHelper.setTo(to);
            if (null != cc && cc.length > 0) {
                messageHelper.setCc(cc);
            }
            if (null != bcc && bcc.length > 0) {
                messageHelper.setBcc(bcc);
            }

            if (StringUtils.isEmpty(content)) {
                content = "<html></html>";
            }
            messageHelper.setText(content, true);

            if (!CollectionUtils.isEmpty(files)) {
                if (files.size() == 1) {
                    File file = files.get(0);
                    String attName = "attachment" + file.getName().substring(file.getName().lastIndexOf("."));
                    messageHelper.addAttachment(attName, file);
                } else {
                    for (int i = 0; i < files.size(); i++) {
                        File file = files.get(i);
                        String attName = "attachment-" + (i + 1) + file.getName().substring(file.getName().lastIndexOf("."));
                        messageHelper.addAttachment(attName, file);
                    }
                }
            }

            javaMailSender.send(message);
            log.info("Send mail success, in {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MessagingException e) {
            log.error("Send mail failed, {}\n", e.getMessage());
            e.printStackTrace();
            throw new MailException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("Send mail failed, {}\n", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送 Html 邮件
     * 使用默认配置发送地址
     *
     * @param subject
     * @param to
     * @param content
     * @throws ServerException
     */
    public void sendHtmlEmail(String subject, String to, String content, List<File> files) throws MailException {
        sendHtmlEmail(sendEmailfrom, nickName, subject, new String[]{to}, null, null, content, files);
    }

    /**
     * 发送 Html 邮件
     * 使用默认配置发送地址
     *
     * @param subject
     * @param to
     * @param content
     * @throws ServerException
     */
    public void sendHtmlEmail(String subject, String to, String[] cc, String[] bcc, String content, List<File> files) throws MailException {
        sendHtmlEmail(sendEmailfrom, nickName, subject, new String[]{to}, cc, bcc, content, files);
    }

    /**
     * 发送模板邮件
     *
     * @param from     发件地址
     * @param nickName 昵称
     * @param subject  主题
     * @param to       收件地址
     * @param cc       抄送
     * @param bcc      加密抄送
     * @param template 模板地址
     * @param content  模板内容
     * @param excels   附件
     * @throws ServerException
     */
    public void sendTemplateEmail(String from, String nickName, String subject, String[] to, String[] cc, String[] bcc,String template, Map<String, Object> content, List<ExcelContent> excels) throws MailException {

        if (StringUtils.isEmpty(from)) {
            log.info("email address(from) cannot be EMPTY");
            throw new MailException("email address(from) cannot be EMPTY");
        }

        Matcher matcher = Constants.PATTERN_EMAIL_FORMAT.matcher(from);

        if (!matcher.find()) {
            log.info("unknow email address(from): {}", from);
            throw new MailException("unknow email address(from)");
        }

        if (StringUtils.isEmpty(subject)) {
            log.info("email subject cannot be EMPTY");
            throw new MailException("email subject cannot be EMPTY");
        }

        if (null == to || to.length < 1) {
            log.info("email address(to) cannot be EMPTY");
            throw new MailException("email address(to) cannot be EMPTY");
        }

        if (StringUtils.isEmpty(template)) {
            log.info("email template path is EMPTY");
            throw new MailException("email template path is EMPTY");
        }

        if (null == content) {
            log.info("template content is EMPTY");
            throw new MailException("template content is EMPTY");
        }

        Context context = new Context();
        for (String key : content.keySet()) {
            context.setVariable(key, content.get(key));
        }

        long startTimestamp = System.currentTimeMillis();
        log.info("start send email to "+ to);
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(from, nickName);
            messageHelper.setSubject(subject);
            messageHelper.setSubject(subject);
            messageHelper.setTo(to);
            if (null != cc && cc.length > 0) {
                messageHelper.setCc(cc);
            }
            if (null != bcc && bcc.length > 0) {
                messageHelper.setBcc(bcc);
            }

            String text = templateEngine.process(template, context);
            messageHelper.setText(text, true);

            if (!CollectionUtils.isEmpty(excels)) {
                excels.forEach(excel -> {
                    try {
                        messageHelper.addAttachment(excel.getName() + FileTypeEnum.XLSX.getFormat(), excel.getFile());
                    } catch (MessagingException e) {
                    }
                });
            }
            javaMailSender.send(message);
            log.info("Send mail success, in {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MessagingException e) {
            log.error("Send mail failed, {}\n", e.getMessage());
            e.printStackTrace();
            throw new MailException(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("Send mail failed, {}\n", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送简单模板邮件
     * 使用默认配置发送地址
     *
     * @param to       接收邮箱地址
     * @param subject  主题
     * @param template 模板地址
     * @param content  内容【哈希，与模板对应】
     * @throws ServerException
     */
    public void sendTemplateEmail(String to, String subject, String template, Map<String, Object> content) throws MailException {
        sendTemplateEmail(sendEmailfrom, nickName, subject, new String[]{to}, null, null, template, content, null);
    }

    /**
     * 发送模板附件邮件
     *
     * @param subject  主题
     * @param to       接收人
     * @param cc       抄送
     * @param bcc      加密抄送
     * @param template 模板地址
     * @param content  模板内容
     * @param excels   附件
     * @param images
     * @throws ServerException
     */
    public void sendTemplateAttachmentsEmail(String subject, String to, String[] cc, String[] bcc, String template, Map<String, Object> content, List<ExcelContent> excels) throws MailException {
        sendTemplateEmail(sendEmailfrom, nickName, subject, new String[]{to}, cc, bcc, template, content, excels);
    }

}
