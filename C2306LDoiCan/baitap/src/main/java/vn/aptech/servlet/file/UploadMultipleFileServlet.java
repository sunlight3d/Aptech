package vn.aptech.servlet.file;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "UploadMultipleFileServlet",
        urlPatterns = {"/multiple-uploads"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class UploadMultipleFileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            int success = 0, error = 0;
            Collection<Part> parts = req.getParts();
            if (parts == null || parts.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            ServletContext context = getServletContext();
            String path = context.getAttribute("fileLocation").toString();
            for (Part part : parts) {
                String filename = getFileName(part);
                if (filename != null && !filename.isEmpty()) {
                    String filePath = path + File.separator + filename;
                    part.write(filePath);
                    success++;
                } else {
                    error++;
                }
            }
            out.println("Upload success: " + success + ", error: " + error + " files");
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    public String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.trim().indexOf("=") + 3, item.length() - 1).trim();
            }
        }
        return null;
    }
}
