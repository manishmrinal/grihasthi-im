package com.grihasthi.inventorymanagement.service;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {
	
	@Autowired
	private ConvertToPdfService pdfService;
	private JavaMailSender jmsender;
	
	@Autowired
	public MailSenderService(JavaMailSender jmsender) {
		
		this.jmsender = jmsender;
	}
	
	
	
	public void sendMail() throws MailException{
		
		//separate mail bean can also be created
		
//		SimpleMailMessage mail=new SimpleMailMessage();
//		
//		mail.setTo("manishmrinalface@gmail.com");
//		mail.setFrom("manishmrinalm@gmail.com");
//		mail.setSubject("Testing for mail integration");
//		mail.setText("Body for the mail!!! DONE!!!!");
		
		
		String smtpHost = "smtp.gmail.com"; //replace this with a valid host
	    int smtpPort = 587; //replace this with a valid port

//	    String sender = "sender@yourhost.com"; //replace this with a valid sender email address
//	    String recipient = "recipient@anotherhost.com"; //replace this with a valid recipient email address
//	    String content = "dummy content"; //this will be the text of the email
//	    String subject = "dummy subject"; //this will be the subject of the email

	    Properties properties = new Properties();
	    properties.put("mail.smtp.host", smtpHost);
	    properties.put("mail.smtp.port", smtpPort); 
	    properties.put("mail.smtp.starttls.enable","true");
	    Session session = Session.getDefaultInstance(properties, null);
		
		
		
		  ByteArrayOutputStream outputStream = null;

		    try {           
		        //construct the text body part
		        MimeBodyPart textBodyPart = new MimeBodyPart();
		        textBodyPart.setText("MIME message");

		        //now write the PDF content to the output stream
		        outputStream = new ByteArrayOutputStream();
		       // pdfService.export(outputStream);
		        byte[] bytes = outputStream.toByteArray();

		        //construct the pdf body part
		        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
		        MimeBodyPart pdfBodyPart = new MimeBodyPart();
		        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
		        pdfBodyPart.setFileName("test.pdf");

		        //construct the mime multi part
		        MimeMultipart mimeMultipart = new MimeMultipart();
		        mimeMultipart.addBodyPart(textBodyPart);
		        mimeMultipart.addBodyPart(pdfBodyPart);
		
		
		        //create the sender/recipient addresses
		        InternetAddress iaSender = new InternetAddress("manishmrinalm@gmail.com");
		        InternetAddress iaRecipient = new InternetAddress("manishmrinalface@gmail.com");

		        //construct the mime message
		        MimeMessage mimeMessage = new MimeMessage(session);
		        mimeMessage.setSender(iaSender);
		        mimeMessage.setSubject("Hello this is  a test mail");
		        mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
		        mimeMessage.setContent(mimeMultipart);

		        //send off the email
		        Transport.send(mimeMessage, "manishmrinalm@gmail.com", "bxqchkhqhnfmcpjk");

//		        System.out.println("sent from " + sender + 
//		                ", to " + recipient + 
//		                "; server = " + smtpHost + ", port = " + smtpPort);         
		    } catch(Exception ex) {
		        ex.printStackTrace();
		    } finally {
		        //clean off
		        if(null != outputStream) {
		            try { outputStream.close(); outputStream = null; }
		            catch(Exception ex) { }
		        }
		    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		
//		MimeMessage message = jmsender.createMimeMessage();
//		
//		
//		  try{
//		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		            
//		        helper.setFrom("manishmrinalm@gmail.com");
//		        helper.setTo("manishmrinalface@gmail.com");
//		        helper.setSubject("Testing for mail integration");
//		        helper.setText(String.format(
//		        		"Body for the mail!!! DONE!!!!", "manish", "hey!!its a beuatiful day!!"));
//		            
//		        FileSystemResource file = new FileSystemResource("C:\\log.txt");
//		        helper.addAttachment(file.getFilename(), file);
//
//		         }catch (MessagingException e) {
//		        throw new MailParseException(e);
//		         }
//		         mailSender.send(message);
//		         }
//		
//		
//		
//		
//		jmsender.send(mail);
//		
//		
//	}
	

}
}
