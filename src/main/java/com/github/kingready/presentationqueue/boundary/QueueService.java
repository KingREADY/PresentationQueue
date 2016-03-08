package com.github.kingready.presentationqueue.boundary;

import com.github.kingready.presentationqueue.control.EnqueueRequestValidator;
import com.github.kingready.presentationqueue.control.QueueRequestProcessor;

public class QueueService {
    EnqueueRequestValidator validator;
    QueueRequestProcessor processor;

    public QueueService() {
        this.validator = new EnqueueRequestValidator();
        this.processor = new QueueRequestProcessor();
    }
    
    public void enqueue(String studentId) {
        if (!validator.validate(studentId)) {
            throw new IllegalArgumentException();
        }
        processor.addStudentToQueue(studentId);
    }
}
