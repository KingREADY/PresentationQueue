package com.github.kingready.presentationqueue.boundary;

import com.github.kingready.presentationqueue.control.EnqueueRequestValidator;
import com.github.kingready.presentationqueue.control.QueueRequestProcessor;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class T03MockingTest {

    private QueueService cut;
    private final String studentId = "f.pohninger";

    @Before
    public void setup() {
        this.cut = new QueueService();
        this.cut.validator = mock(EnqueueRequestValidator.class);
        this.cut.processor = mock(QueueRequestProcessor.class);
    }

    @Test
    public void successfulEnqueue() {
        when(this.cut.validator.validate(studentId))
                .thenReturn(true);
        
        this.cut.enqueue(studentId);
        verify(this.cut.processor, times(1)).addStudentToQueue(studentId);
        verify(this.cut.validator, times(1)).validate(studentId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unauthorizedEnqueue() {
        
        when(this.cut.validator.validate(studentId))
                .thenReturn(false);
        
        this.cut.enqueue(studentId);

        verify(this.cut.processor, never())
                .addStudentToQueue(studentId);
    }
}
