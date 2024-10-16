using System;
using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json;
using System.Xml;
using deleteFiles.Models;

namespace deleteFiles
{
	public class StudentManagement
    {
        private String fileName = "data.json";
        public void ReadJsonFile() {
            // Đọc nội dung tệp JSON vào một chuỗi
            string json = File.ReadAllText(this.fileName);

            // Chuyển đổi chuỗi JSON sang danh sách đối tượng Person
            List<Person> people = JsonConvert.DeserializeObject<List<Person>>(json);

            // In ra thông tin của từng đối tượng Person
            foreach (Person person in people)
            {
                Console.WriteLine($"Họ và tên: {person.FullName}");
                Console.WriteLine($"Ngày sinh: {person.Birthday}");
                Console.WriteLine($"Email: {person.Email}");
                Console.WriteLine($"Địa chỉ: {person.Address}");
                Console.WriteLine($"Giới tính: {person.Gender}");
                Console.WriteLine();
            }
        }
        public void GenerateJsonFile() {
            // Tạo danh sách đối tượng với các trường fullname, birthday, email, address và gender
            var people = new List<Person>
        {
            new Person
            {
                FullName = "John Smith",
                Birthday = new DateTime(1980, 1, 1),
                Email = "john.smith@example.com",
                Address = "123 Main St, Anytown USA",
                Gender = Gender.Male
            },
            new Person
            {
                FullName = "Jane Doe",
                Birthday = new DateTime(1985, 2, 1),
                Email = "jane.doe@example.com",
                Address = "456 Oak St, Othertown USA",
                Gender = Gender.Female
            },
            new Person
            {
                FullName = "Bob Johnson",
                Birthday = new DateTime(1990, 3, 1),
                Email = "bob.johnson@example.com",
                Address = "789 Elm St, Another Town USA",
                Gender = Gender.Male
            }
        };

            // Chuyển đổi danh sách đối tượng sang chuỗi JSON
            string json = JsonConvert.SerializeObject(people, Newtonsoft.Json.Formatting.Indented);

            // Ghi chuỗi JSON vào tệp
            File.WriteAllText(this.fileName, json);

            Console.WriteLine("Đã tạo tệp data.json.");

        }
	}
}

