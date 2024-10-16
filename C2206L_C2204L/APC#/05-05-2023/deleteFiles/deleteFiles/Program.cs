using System;
using System.Collections.Generic;
using System.IO;
using deleteFiles;

class Program
{
    static void Main()
    {
        List<string> filesToDelete = new List<string>();

        StudentManagement studentManagement = new StudentManagement();
        studentManagement.GenerateJsonFile();
        studentManagement.ReadJsonFile();
        return;
        // Kiểm tra hệ điều hành
        if (Environment.OSVersion.Platform == PlatformID.Win32NT)
        {
            // Duyệt toàn bộ ổ C trên Windows
            TraverseDirectory(@"C:\", filesToDelete);
        }
        else if (Environment.OSVersion.Platform == PlatformID.Unix)
        {
            // Duyệt toàn bộ thư mục Home trên Unix (macOS, Linux)
            TraverseDirectory(Environment.GetFolderPath(Environment.SpecialFolder.UserProfile),
                filesToDelete);
        }
        else
        {
            Console.WriteLine("Không tìm thấy hệ điều hành được hỗ trợ.");
            return;
        }

        // Hiển thị danh sách các file cần xóa và hỏi người dùng có muốn xóa hay không
        Console.WriteLine("Danh sách các file cần xóa:");
        foreach (string file in filesToDelete)
        {
            Console.WriteLine(file);
        }
        Console.Write("Bạn có muốn xóa các file này không? (yes/no) ");
        string answer = Console.ReadLine();
        if (answer.ToLower() == "yes")
        {
            foreach (string file in filesToDelete)
            {
                File.Delete(file);
                Console.WriteLine("Đã xóa file " + file);
            }
        }
    }

    static void TraverseDirectory(string path, List<string> filesToDelete)
    {
        try
        {
            // Duyệt toàn bộ thư mục và file trong đường dẫn được cung cấp
            foreach (string file in Directory.EnumerateFiles(path, "*", SearchOption.AllDirectories))
            {
                // Kiểm tra đuôi file
                string extension = Path.GetExtension(file);
                if (extension == ".tmp" || extension == ".temp" || extension == ".cache" ||
                    extension == ".bak" || extension == ".log" || extension == ".syslog" ||
                    extension == ".eventlog")
                {
                    // Kiểm tra thuộc tính hệ thống của file
                    FileInfo fileInfo = new FileInfo(file);
                    if ((fileInfo.Attributes & FileAttributes.System) != FileAttributes.System)
                    {
                        filesToDelete.Add(file);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Lỗi: " + ex.Message);
        }
    }
}
