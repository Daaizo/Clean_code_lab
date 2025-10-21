package org.example.lab1.builder;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private final String recipient;
    private final String sender;
    private final String subject;
    private final String body;
    private final List<String> attachments;
    private final boolean isHtml;
    private final int priority;

    private Email(EmailBuilder builder) {
        this.recipient = builder.recipient;
        this.sender = builder.sender;
        this.subject = builder.subject;
        this.body = builder.body;
        this.attachments = builder.attachments;
        this.isHtml = builder.isHtml;
        this.priority = builder.priority;
    }

    public static class EmailBuilder {
        private final String recipient;
        private final String sender;
        private String subject = "";
        private String body = "";
        private List<String> attachments = new ArrayList<>();
        private boolean isHtml = false;
        private int priority = 3;

        public EmailBuilder(String recipient, String sender) {
            this.recipient = recipient;
            this.sender = sender;
        }

        public EmailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailBuilder body(String body) {
            this.body = body;
            return this;
        }

        public EmailBuilder addAttachment(String attachment) {
            this.attachments.add(attachment);
            return this;
        }

        public EmailBuilder setHtml(boolean isHtml) {
            this.isHtml = isHtml;
            return this;
        }

        public EmailBuilder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public Email build() {
            return new Email(this);
        }
    }

    @Override
    public String toString() {
        return "Email{recipient='" + recipient + "', sender='" + sender
                + "', subject='" + subject + "', priority=" + priority + "}";
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }
}