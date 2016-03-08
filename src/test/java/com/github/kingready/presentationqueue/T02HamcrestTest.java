package com.github.kingready.presentationqueue;

import com.github.kingready.presentationqueue.entity.Presentation;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import org.junit.Test;

public class T02HamcrestTest {
    @Test
    public void collectionTest() {
        List<Presentation> students = Arrays.asList(
                new Presentation("f.pohninger", "Testing", "PRJ"),
                new Presentation("s.ammerix", "AOP", "PRJ"),
                new Presentation("d.hotelier", "JHotel", "PRJ")
        );
        
        assertThat(students,
            everyItem(Matchers.<Presentation>hasProperty("subject", equalTo("PRJ"))));
    }
}
