package vn.aptech.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.aptech.servlet.database.entity.Account;
import vn.aptech.servlet.service.AccountService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AccountServlet", urlPatterns = "/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //AccountService.getInstance().createAccount();
        List< Account> accounts = AccountService.getInstance().getAccounts();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("mobile");
        Account account = new Account();
        account.setName(name);
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);
        account.setMobile(phone);
        AccountService.getInstance().createAccount(account);
        resp.sendRedirect("/account");
    }
}
