package Api;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.UnsupportedEncodingException;
import java.util.Date;


import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;





public class Email {


//    https://www.pepipost.com/tutorials/examples-for-sending-emails-from-javamail-api/
        private final Logger logger = LogManager.getLogger(this.getClass());
        /**
         * Utility method to send simple HTML email
         * @param session
         * @param toEmail
         * @param subject
         * @param body
         */
        public static void sendEmail(Session session, String toEmail, String subject, String body){

            try
            {
                MimeMessage msg = new MimeMessage(session);
                //set message headers
                msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
                msg.addHeader("format", "flowed");
                msg.addHeader("Content-Transfer-Encoding", "8bit");

                msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

                msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

                msg.setSubject(subject, "UTF-8");

                msg.setText(body, "UTF-8");

                msg.setSentDate(new Date());

                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
                //Logger.debug("Message is ready");
                Transport.send(msg);

                //Logger.debug("Email Sent Successfully!!");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }



}
