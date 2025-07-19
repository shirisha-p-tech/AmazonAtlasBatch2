package ooad.day20;
//OCP Implementation

interface BankNotification{
   void sendOTP();
}
class EmailNotify implements BankNotification{
  public void sendOTP(){
        System.out.println("email sent to your mail id");
    }
}

class MobileNotify implements BankNotification{
    public void sendOTP(){
        System.out.println("sms sent to your mobile");
    }

}

class WhatsappNotify implements BankNotification{
    public void sendOTP(){
        System.out.println("message sent to your whatsapp");
    }

}


public class Task2 {
    public static void main(String[] args) {
        BankNotification email = new EmailNotify();
        BankNotification mobile = new MobileNotify();
        BankNotification whatsapp = new WhatsappNotify();
        System.out.println("OCP Implementation:");
        email.sendOTP();
        mobile.sendOTP();
        whatsapp.sendOTP();
    }
}


/*
OCP Violation Code
public class BankNotifications {
    public void sendOTP(String via) {
        if (via.equals("email")) {
            System.out.println("email sent to your mail id");
        }
    }
}

 */
