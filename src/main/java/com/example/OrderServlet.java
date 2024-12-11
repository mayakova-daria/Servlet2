package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Створення замовлення
        Order order = objectMapper.readValue(req.getReader(), Order.class);

        // Логіка для збереження в базу (спрощено)
        System.out.println("Створено замовлення: " + order);
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Отримання замовлення (спрощено)
        String id = req.getParameter("id");
        System.out.println("Отримання замовлення з ID: " + id);

        // Відправка даних назад
        resp.setContentType("application/json");
        resp.getWriter().write("{ \"id\": " + id + ", \"status\": \"Отримано\" }");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Оновлення замовлення
        System.out.println("Оновлення замовлення...");
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Видалення замовлення
        String id = req.getParameter("id");
        System.out.println("Видалено замовлення з ID: " + id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
