package com.thoughtworks.checkout;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Test;

public class AppTest {
  @Test
  public void testSingle() throws Exception {
    String input =
      "Pizza - Pepperoni,12.99\n";
    String expectedOutput =
      "*************** RECEIPT ****************\n" +
      "\n" +
      "Pizza - Pepperoni                  12.99\n" +
      "                                --------\n" +
      "Total for 1 items                  12.99\n" +
      "                                ========\n";
    try (
      StringReader reader = new StringReader(input);
      StringWriter writer = new StringWriter();
    ) {
      App.run(reader, writer);
      assertThat(writer.toString(), is(equalTo(expectedOutput)));
    }
  }
}
