package io.revlearners.model.services.interfaces;

public interface IEmailService {
    boolean sendVerificationEmail(String recipientEmail, Long recipientId);
}
