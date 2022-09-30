package com.utility;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class SendMail
{

	public static void execute(String reportFileName) throws Exception

	{
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/utility/SendEmailData.Properties");
		Properties SendEmailData = new Properties();
		SendEmailData.load(fis);   
		 
		String attachmentFilePath = System.getProperty("user.dir") + "/target/cucumber-reports/Extentreport.html";
		
		String vConfigEmail=SendEmailData.getProperty("ConfigEmail");
		String vConfigEmailPassword=SendEmailData.getProperty("ConfigEmailPassword");
		String vConfigEmailHost= SendEmailData.getProperty("ConfigEmailHost");
		String vConfigEmailPort=SendEmailData.getProperty("ConfigEmailPort");
		String vStarttls=SendEmailData.getProperty("starttls");
		String vAuth=SendEmailData.getProperty("auth");
		String vSocketFactoryClass = SendEmailData.getProperty("SocketFactoryClass");
		String vfallback = SendEmailData.getProperty("fallback");
		String vSubject= SendEmailData.getProperty("Subject");
		String vBody = SendEmailData.getProperty("body");
		String vSenderName = SendEmailData.getProperty("SenderName");
		String vSenderMob = SendEmailData.getProperty("SenderMob");
		String vSenderExt = SendEmailData.getProperty("SenderExt");
		String[] to = SendEmailData.getProperty("ToEmailList").split(",");
		String[] cc = SendEmailData.getProperty("CcEmailList").split(",");
		String[] bcc =SendEmailData.getProperty("BccEmailList").split(",");
  
		SendMail.sendMail(vConfigEmail, vConfigEmailPassword, vConfigEmailHost, vConfigEmailPort, vStarttls,
				vAuth, true, vSocketFactoryClass, vfallback, to, cc, bcc, vSubject,
				vBody, attachmentFilePath, reportFileName,vSenderName,vSenderMob,vSenderExt);
	}

	public static boolean sendMail(String userName, String passWord, String host, String port, String starttls,
			String auth, boolean debug, String socketFactoryClass, String fallback, String[] to, String[] cc,
			String[] bcc, String vSubject, String vBody, String attachmentFilePath, String attachmentName,String SenderName,String SenderMob,String SenderExt) {
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.socketFactory.port", port);
			//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.starttls.enable", starttls);

		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
	        
			String ReportTime= dateFormat.format(new Date());
			Session session = Session.getDefaultInstance(props, null);
			//session.setDebug(debug);

			
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(vSubject+" : "+ReportTime);
			
			String mailBody1 ="<body><p style=font-size:10.0pt;color:black;>Hi All,</br></br></P>";
			String mailBody2 ="<body><p style=font-size:10.0pt;color:black;>"+vBody+"</br></br></P></br>";
			String mailBody3 ="<body><p style=font-size:10.0pt;color:black;>Note:This is an automated email to share latest test execution report from BNT QA team.</br></P>";
			String mailBody4 ="<body><p style=font-size:10.0pt;color:black;>Regards,</br>"+SenderName+"</br></P></br>";
			String mailBody5 ="<img src="+"http://www.bnt-soft.com/assets/images/Desktop/Header/LogoSmall.png/"+"></br></br>";
			String mailBody6 ="<span><b>BNT SOFT PRIVATE LIMITED</b>, India | Transforming Thoughts into Bits</span><br/></br>";
			String mailBody7 ="<span><a href=http://www.bnt-soft.com/>www.bnt-soft.com</a> | <a href=mailto:"+userName+">"+userName+"</a></span>";
			String mailBody8 ="<span> | m: 91."+SenderMob+" | t: 91.20. 66499300 Ext : "+SenderExt+"</span></br></br>";
			String mailBody9 ="<span style=font-size:10.0pt;color:black;>The contents of this e-mail and any attachment(s) are confidential and intended for the named recipient(s)only. It shall not attach any liability on the originator or B&amp;T or its affiliates. Any views or opinions presented in this email are solely those of the author and may not necessarily reflect the opinions of B&amp;T or its affiliates. Any form of reproduction, dissemination, copying, disclosure,modification, distribution and / or publication of this message without the prior written consent of the author of this e-mail is strictly prohibited. If you have received this email in error please delete it and notify the sender immediately. Before opening any mail and attachments please check them for viruses and defect</span></body></html>";
			

			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			DataSource source = new FileDataSource(attachmentFilePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(attachmentName);
			messageBodyPart1.setContent(mailBody1+mailBody2+mailBody3+mailBody4+mailBody5+mailBody6+mailBody7+mailBody8+mailBody9, "text/html; charset=utf-8");
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(messageBodyPart1);

			msg.setContent(multipart);
			
			msg.setFrom(new InternetAddress(userName));

			for (int i = 0; i < to.length; i++) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
			}

			for (int i = 0; i < cc.length; i++) {
				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
			}

			for (int i = 0; i < bcc.length; i++) {
				msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc[i]));
			}

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

		} catch (Exception mex) {
			mex.printStackTrace();
			return false;
		}
	}
}
