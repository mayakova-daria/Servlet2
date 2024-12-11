package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.*;
import java.io.*;

import static org.mockito.Mockito.*;

public class OrderServletTest {

    @Test
    public void testCreateOrder() throws Exception {
        OrderServlet servlet = new OrderServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getReader()).thenReturn(new BufferedReader(new StringReader("{\"id\":1,\"date\":\"2023-01-01\",\"cost\":100.0,\"products\":[]}")));
        doNothing().when(response).setStatus(HttpServletResponse.SC_CREATED);

        servlet.doPost(request, response);

        verify(response).setStatus(HttpServletResponse.SC_CREATED);
    }
}
