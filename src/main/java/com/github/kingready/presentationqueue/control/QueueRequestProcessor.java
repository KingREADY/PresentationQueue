package com.github.kingready.presentationqueue.control;

public class QueueRequestProcessor {

    public void addStudentToQueue(String studentId) {
        System.out.println(String.format("Student %s added to queue!", studentId));
    }
}
