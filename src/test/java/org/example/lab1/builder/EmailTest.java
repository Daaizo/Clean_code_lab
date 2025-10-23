package org.example.lab1.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void build_shouldCreateEmailWithMandatoryFieldsTest() {
        // given
        final String recipient = "alice@example.com";
        final String sender = "bob@example.com";
        final String expectedSubject = "";

        // when
        Email email = new Email.EmailBuilder(recipient, sender)
                .build();

        // then
        assertEquals(recipient, email.getRecipient());
        assertEquals(sender, email.getSender());
        assertEquals(expectedSubject, email.getSubject(), "Default subject should be empty string");
    }

    @Test
    void subjectAndBody_shouldBeSetCorrectlyTest() {
        // given
        final String recipient = "user1@mail.com";
        final String sender = "user2@mail.com";
        final String subject = "Hello";
        final String body = "How are you?";
        final String expectedPriority = "priority=3";

        // when
        Email email = new Email.EmailBuilder(recipient, sender)
                .subject(subject)
                .body(body)
                .build();

        // then
        assertEquals(subject, email.getSubject());
        String emailAsString = email.toString();
        assertTrue(emailAsString.contains(subject));
        assertTrue(emailAsString.contains(expectedPriority), "Default priority should be 3");
    }

    @Test
    void addAttachment_shouldAddFilesToListTest() {
        // given
        final String recipient = "a@b.com";
        final String sender = "c@d.com";
        final String attachment1 = "file1.txt";
        final String attachment2 = "file2.pdf";

        // when
        Email email = new Email.EmailBuilder(recipient, sender)
                .addAttachment(attachment1)
                .addAttachment(attachment2)
                .build();

        // then
        String emailAsString = email.toString();
        assertTrue(emailAsString.contains(recipient));
        assertEquals(recipient, email.getRecipient());
    }

    @Test
    void setHtmlAndPriority_Test() {
        // given
        final String recipient = "r@x.com";
        final String sender = "s@y.com";
        final int priority = 1;
        final String expectedPriorityString = "priority=" + priority;

        // when
        Email email = new Email.EmailBuilder(recipient, sender)
                .setHtml(true)
                .priority(priority)
                .build();

        // then
        String result = email.toString();
        assertTrue(result.contains(expectedPriorityString));
    }

    @Test
    void build_multipleEmails_shouldBeIndependentTest() {
        // given
        final String recipient = "x@x.com";
        final String sender = "y@y.com";
        final String subject1 = "One";
        final String subject2 = "Two";

        // when
        Email.EmailBuilder builder = new Email.EmailBuilder(recipient, sender);
        Email email1 = builder.subject(subject1).build();
        Email email2 = builder.subject(subject2).build();

        // then
        assertNotEquals(email1.getSubject(), email2.getSubject());
        assertEquals(subject1, email1.getSubject());
        assertEquals(subject2, email2.getSubject());
    }
}
