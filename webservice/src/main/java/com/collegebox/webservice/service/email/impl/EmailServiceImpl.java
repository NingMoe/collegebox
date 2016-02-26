package com.collegebox.webservice.service.email.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.collegebox.webservice.model.email.Email;
import com.collegebox.webservice.pojo.User;
import com.collegebox.webservice.service.email.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	private static final Log logger = LogFactory.getLog(EmailServiceImpl.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;

	@Override
	public void sendEmail(Email email, Map<String, String> fileMap, Map<String, Object> model) {
		// TODO Auto-generated method stub
		try {
			 MimeMessage mimeMessage = mailSender.createMimeMessage();
	         MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
	         messageHelper.setFrom(email.getFrom()); //设置发件人Email
	         logger.info("send email from:" + email.getFrom());
	         messageHelper.setSubject(email.getSubject()); //设置邮件主题
	         logger.info("send email subject:" + email.getSubject());
	         
	         /* 设置邮件内容
	          * 这里需要将内容首先嵌入模板
	          * */
	         if(email.getTemplate() == null || "".equals(email.getTemplate())) {
	        	 messageHelper.setText(email.getText());
	         } else {
	        	 if(model == null) {
	        		 model = new HashMap<String, Object>();
			         model.put("content", email.getText());
	        	 }
		         String text = VelocityEngineUtils.mergeTemplateIntoString(
		        		 velocityEngine, email.getTemplate(),"utf-8",model);
		         messageHelper.setText(text, true);
		         logger.info("send email template:" + email.getTemplate());
	         }
	         logger.info("send email text:" + email.getText());
	         
	         messageHelper.setTo(email.getTo());  //设定收件人Email
	         for(String to : email.getTo()) {
	        	 logger.info("send email to:" + to);
	         }
	         
	         if(email.getCc() != null && email.getCc().length > 0) {
	        	 messageHelper.setCc(email.getCc());//设置抄送
	        	 for(String cc : email.getCc()) {
	        		 logger.info("send email cc:" + cc);
	        	 }
	         }
	         
	         if(email.getBcc() != null && email.getBcc().length > 0) {
	        	 messageHelper.setBcc(email.getBcc());//设置密送
	        	 for(String bcc : email.getBcc()) {
	        		 logger.info("send email bcc:" + bcc);
	        	 }
	         }
	         
	         if(email.getReplyTo() != null && !"".equals(email.getReplyTo())) {
	        	 messageHelper.setReplyTo(email.getReplyTo());//设置回复
	        	 logger.info("send email replyTo:" + email.getReplyTo());
	         }
	         
	         FileSystemResource file;
	         if(email.getFiles() != null && email.getFiles().length > 0) {
	        	 for(String s : email.getFiles()) {
		        	 file = new FileSystemResource(new File(s));//读取附件
		        	 String fileName = fileMap.get(file.getFilename());
		        	 messageHelper.addAttachment(fileName, file);//向email中添加附件
		        	 logger.info("send email attach:" + s);
		         }
	         }
	         
	         mailSender.send(mimeMessage);
	         logger.info("send email .... success");
	            
	     } catch (Exception e) {
	    	 logger.error("send email .... failed:" + e);
	     }
	}

	@Override
	@Async
	public void sendStudentRegisterEmail(String email, String url) {
		// TODO Auto-generated method stub
		logger.info("异步发送学生注册邮件，测试日志......成功！请完善发送代码");
	}

	@Override
	@Async
	public void sendForgotPasswordEmail(User user, String url) {
		// TODO Auto-generated method stub
		logger.info("异步发送忘记密码邮件，测试日志......成功！请完善发送代码");
	}

	@Override
	@Async
	public void sendSuccessRegisterEmail(User user) {
		// TODO Auto-generated method stub
		logger.info("异步发送注册成功邮件，测试日志......成功！请完善发送代码");
	}

}
