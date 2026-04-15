public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit); }

    @Override
    public void send(String address, String content) {
        System.out.println("WA -> to=" + address + " body=" + content);
        audit.add("wa sent");
    }
}
