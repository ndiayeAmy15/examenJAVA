package com.springexamen.examen.Controller;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);

        // Vérifiez si l'utilisateur est connecté pour les routes protégées
        if (session == null || session.getAttribute("utilisateur") == null) {
            // Redirigez vers la page de connexion si l'utilisateur n'est pas connecté
            response.sendRedirect("/login");
            return;
        }

        // Passez à la suite si l'utilisateur est connecté
        chain.doFilter(request, response);
    }
}