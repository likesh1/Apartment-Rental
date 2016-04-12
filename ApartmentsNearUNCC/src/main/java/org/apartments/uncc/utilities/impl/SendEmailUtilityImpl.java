/**
 * 
 */
package org.apartments.uncc.utilities.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apartments.uncc.utilities.ISendEmail;
import org.apartments.uncc.viewBeans.MailBean;
import org.apartments.uncc.viewBeans.UserDetailsBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author Pritam
 *
 */
public class SendEmailUtilityImpl implements ISendEmail {

	private MailSender mailSender;
    private SimpleMailMessage templateMessage;
	
    public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	
	/* (non-Javadoc)
	 * @see org.apartments.uncc.utilities.ISendEmail#sendEmail()
	 */
	@Override
	public void sendEmail(UserDetailsBean userDetails) {
		// TODO Auto-generated method stub
		System.out.println("Inside Mail API");
		//JavaMailSenderImpl sender = new JavaMailSenderImpl();
		//sender.setHost("127.0.0.1");

		/*MimeMessage message = ((JavaMailSenderImpl) mailSender).createMimeMessage();

		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper;
		try {
			String[] ccIds={"ksavakia@uncc.edu","sprakas2@uncc.edu","lpammina@uncc.edu"};
			helper = new MimeMessageHelper(message, true);
			helper.setSubject("Thanks for Registration!!");
			helper.setTo("pborate@uncc.edu");
			//helper.setCc(ccIds);
			//helper.setC
			helper.setFrom("customer_service@liveoffcampus.com");
			//helper.setText("<html><body><img src='cid:identifier1234'/></body></html>", true);
			helper.setText("<html><head></head><body style='color:lightblue'><div><table><tr><td>"
						+ "Dear Pritam, Thanks for registration<br><p>We Appreciate your interest in our website. Looking Forward to serve you better</p><br><p>Regards,<br>SSDI_08 Team</p></td></tr></table></div></body></html>", true);
			//FileSystemResource res = new FileSystemResource(new File("/Users/Pritam/git/SSDI_08/ApartmentsNearUNCC/src/main/java/org/apartments/uncc/resources/BackgroundImage.jpg"));
			//helper.addInline("identifier1234", res);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// use the true flag to indicate the text included is HTML
		//helper.setText("<html><body><img src=''cid:identifier1234''></body></html>", true);
		
		// let's include the infamous windows Sample file (this time copied to c:/)
		//FileSystemResource res = new FileSystemResource(new File("c:/Sample.jpg"));
		//helper.addInline("identifier1234", res);

		mailSender.send(message);*/
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(userDetails.getUsername());
        msg.setReplyTo("donot_reply@liveoffcampus.com");
        msg.setText(
            "Dear "+userDetails.getfName()
                + ",\n\nThank you for registering with uncc.liveoffcampus.com \n"
                + "Your OTP for verification is: "+userDetails.getVerificationCode()+"\n"
                + "Please use this code to verify your email id. "
                + "We are glad to have you!!!\n\n"
                + "Regards,\n"
                + "Team SSDI_08");
        try{
            this.mailSender.send(msg);
            System.out.println("Mail Sent!!!");
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
	}

	

	

	/* (non-Javadoc)
	 * @see org.apartments.uncc.utilities.ISendEmail#sendVerificationCode()
	
	@Override
	public int sendVerificationCode() {
		// TODO Auto-generated method stub
		return 0;
	} */

	@Override
	public void sendEmail(MailBean mailBean) {
		// TODO Auto-generated method stub
		System.out.println("Inside Mail API");
		
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		//sg.setFrom("sprakas2@uncc.edu");
		System.out.println("To --"+mailBean.getTo());
        msg.setTo(mailBean.getTo());
        //msg.setSubject("Student is interested in renting your apartment.");
        msg.setText(
            "Dear "
                
                + "\n\n"+mailBean.getMailbody()
                + "\n\nRegards,\n"
                + "Team SSDI_08");
        try{
            this.mailSender.send(msg);
            System.out.println("Mail Sent!!!");
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
	}


	

	

	/* (non-Javadoc)
	 * @see org.apartments.uncc.utilities.ISendEmail#sendVerificationCode()
	
	@Override
	public int sendVerificationCode() {
		// TODO Auto-generated method stub
		return 0;
	} */

}
