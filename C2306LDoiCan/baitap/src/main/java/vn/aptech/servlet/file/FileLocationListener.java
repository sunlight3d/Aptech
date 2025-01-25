package vn.aptech.servlet.file;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.io.File;

@WebListener
public class FileLocationListener implements ServletContextListener {
    private final static String FILE_LOCATION = "C:/Users/teacher/Upload";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        File file = new File(FILE_LOCATION);
        if (!file.exists()) {
            file.mkdirs();
        }
        sce.getServletContext().setAttribute("fileLocation", FILE_LOCATION);
        System.out.println("Set file location: " + FILE_LOCATION);
    }
}
