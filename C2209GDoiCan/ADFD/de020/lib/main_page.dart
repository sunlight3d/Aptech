import 'package:flutter/material.dart';

import 'detail_page.dart';
import 'models/job.dart';

class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<MainPage> createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  List<Job> jobs = [
    Job(
      company: "Google",
      role: "Software Engineer",
      jobDescription: "Phát triển hệ thống backend mở rộng.",
      year: "2022 - Hiện tại",
      imagePath: 'assets/images/google.jpg',
    ),
    Job(
      company: "Amazon",
      role: "Data Scientist",
      jobDescription: "Phân tích dữ liệu và xây dựng mô hình AI.",
      year: "2020 - 2022",
      imagePath: 'assets/images/amazon.png',
    ),
    Job(
      company: "Microsoft",
      role: "UI/UX Designer",
      jobDescription: "Thiết kế trải nghiệm người dùng tối ưu.",
      year: "2018 - 2020",
      imagePath: 'assets/images/microsoft.png',
    ),
    Job(
      company: "Facebook",
      role: "Mobile Developer",
      jobDescription: "Xây dựng ứng dụng di động trên iOS & Android.",
      year: "2016 - 2018",
      imagePath: 'assets/images/facebook.png',
    ),
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: Column(
          children: [
            Container(
              child: ClipRRect(
                borderRadius: BorderRadius.circular(100), // Không bo góc để giữ hình vuông
                child: ClipRect(
                  child: Align(
                    alignment: Alignment.center,
                    widthFactor: 1.0,
                    heightFactor: 1.0,
                    child: Image.network(
                      "https://images.unsplash.com/photo-1489278353717-f64c6ee8a4d2?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                      height: 200.0,
                      width: 200.0,
                      fit: BoxFit.cover, // Đảm bảo hình ảnh phủ kín vùng hiển thị
                    ),
                  ),
                ),
              ),
              padding: EdgeInsets.all(10),
            ),
            Flexible(child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: GridView.builder(
                gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 2, // Hiển thị 2 cột
                  crossAxisSpacing: 10,
                  mainAxisSpacing: 10,
                  childAspectRatio: 1, // Điều chỉnh tỷ lệ ảnh và text
                ),
                itemCount: jobs.length,
                itemBuilder: (context, index) {
                  final job = jobs[index];

                  return ClipRRect(
                    borderRadius: BorderRadius.circular(10), // Bo góc ảnh
                    child: Stack(
                      fit: StackFit.expand,
                      children: [
                        Image.asset(
                          job.imagePath,
                          fit: BoxFit.cover, // Căn chỉnh ảnh
                        ),
                        InkWell(
                          child: Container(
                            color: Colors.black54, // Làm mờ nền để dễ đọc text
                            padding: const EdgeInsets.all(8),
                            // child: Column(
                            //   mainAxisAlignment: MainAxisAlignment.center,
                            //   children: [
                            //     Text(
                            //       job.company,
                            //       style: const TextStyle(
                            //         fontSize: 16,
                            //         fontWeight: FontWeight.bold,
                            //         color: Colors.white,
                            //       ),
                            //       textAlign: TextAlign.center,
                            //     ),
                            //     Text(
                            //       job.role,
                            //       style: const TextStyle(
                            //         fontSize: 14,
                            //         fontStyle: FontStyle.italic,
                            //         color: Colors.white70,
                            //       ),
                            //       textAlign: TextAlign.center,
                            //     ),
                            //     Text(
                            //       job.year,
                            //       style: const TextStyle(
                            //         fontSize: 12,
                            //         color: Colors.white60,
                            //       ),
                            //       textAlign: TextAlign.center,
                            //     ),
                            //   ],
                            // ),
                          ),
                          onTap: () {
                            final job = jobs[index];
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) => DetailPage(job: job),
                              ),
                            );
                          },
                        ),
                      ],
                    ),
                  );
                },
              ),
            ))
          ],
        ),
      ),
    );
  }
}
