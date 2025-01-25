package vn.aptech.servlet.file;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UploadFileServlet",
        urlPatterns = {"/upload"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletContext context = getServletContext();
        String path = context.getAttribute("fileLocation").toString();
        File file = new File(path);

        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            out.println("No files found");
        } else {
            out.println("<h3> " + files.length + " files found</h3>");
            out.println("<ul>");
            for (File f : files) {
                if (f.isFile()) {
                    out.println("<li><a href='/download?filename=" + f.getName() + "'>" + f.getName() + "</a></li>");
                }
            }
            out.println("</ul>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            Part part = req.getPart("file");
            String filename = getFileName(part);
            ServletContext context = getServletContext();
            String path = context.getAttribute("fileLocation").toString();
            if (filename != null && !filename.isEmpty()) {
                String filePath = path + File.separator + filename;
                part.write(filePath);
                out.println("Uploaded Successfully!");
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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
