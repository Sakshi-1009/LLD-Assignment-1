public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public void send(String address, String content) {
        System.out.println("EMAIL -> to=" + address + " " + content);
        audit.add("email sent");
    }
}
