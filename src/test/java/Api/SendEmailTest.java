package Api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendEmailTest {

    /**
     * Gets response success.
     */
    @Test
    void getResponseSuccess() {
        SendEmail send = new SendEmail();
        send.getInfo("hi", "testing\nthis is line break<br>this si secound one\r this is third ");
    }

}