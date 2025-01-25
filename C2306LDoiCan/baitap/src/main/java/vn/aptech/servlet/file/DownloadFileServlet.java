package vn.aptech.servlet.file;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "DownloadFileServlet",
        urlPatterns = {"/download"})
public class DownloadFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getParameter("filename");
        if (filename == null || filename.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        ServletContext context = getServletContext();
        String path = context.getAttribute("fileLocation") + File.separator + filename;

        File file = new File(path);
        if (!file.exists()) {
           resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            OutputStream outputStream = resp.getOutputStream();
            byte[] buffer = new byte[4096];
            int isRead = 0;
            while ( (isRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, isRead);
            }
        }
    }
}
