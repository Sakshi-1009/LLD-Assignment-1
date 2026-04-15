public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    public void send(String address, String content) {
        System.out.println("SMS -> to=" + address + " body=" + content);
        audit.add("sms sent");
    }
}
