import 'package:flutter/material.dart';

class SelectAddressScreen extends StatefulWidget {
  const SelectAddressScreen({super.key});

  @override
  State<SelectAddressScreen> createState() => _SelectAddressScreenState();
}

class _SelectAddressScreenState extends State<SelectAddressScreen> {
  int selectedAddressIndex = 0; // Chỉ mục địa chỉ được chọn

  final List<Map<String, String>> addresses = [
    {
      "name": "Nguyễn Đức Hoàng",
      "phone": "(+84) 399 946 776",
      "address":
      "Phòng 3302, Helios Tower, Số 75, Nguyen Thi Tam Trinh Street, Phường Mai Động, Quận Hoàng Mai, Hà Nội",
      "default": "true"
    },
    {
      "name": "Cafe H3",
      "phone": "(+84) 399 946 776",
      "address": "H3 Cafe, Phố Trung Kính, Phường Trung Hòa, Quận Cầu Giấy, Hà Nội",
    },
    {
      "name": "Nguyễn Đức Hoàng",
      "phone": "(+84) 964 896 239",
      "address": "Số 41, Ngõ Mai Hương, Bạch Mai, Hà Nội, Phường Bạch Mai, Quận Hai Bà Trưng, Hà Nội",
    },
    {
      "name": "Nguyễn Đức Hoàng",
      "phone": "(+84) 964 896 239",
      "address": "Số 285, Đội Cấn, Phường Liễu Giai, Quận Ba Đình, Hà Nội",
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true, // Đưa tiêu đề ra giữa
        title: const Text(
          "Chọn địa chỉ nhận hàng",
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
        ),
        backgroundColor: Colors.white,
        elevation: 0,
      ),
      body: Column(
        children: [
          const Padding(
            padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
            child: Align(
              alignment: Alignment.centerLeft,
              child: Text("Địa chỉ", style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold)),
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: addresses.length,
              itemBuilder: (context, index) {
                final address = addresses[index];
                return GestureDetector(
                  onTap: () {
                    setState(() {
                      selectedAddressIndex = index;
                    });
                    Navigator.pop(context, address);
                  },
                  child: Container(
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(
                      border: Border(bottom: BorderSide(color: Colors.grey[300]!)),
                    ),
                    child: Row(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Radio<int>(
                          value: index,
                          groupValue: selectedAddressIndex,
                          onChanged: (value) {
                            setState(() {
                              selectedAddressIndex = value!;
                            });
                            Navigator.pop(context, address);
                          },
                          activeColor: Colors.purple,
                        ),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              RichText(
                                text: TextSpan(
                                  children: [
                                    TextSpan(
                                      text: "${address['name']} ",
                                      style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16, color: Colors.black),
                                    ),
                                    TextSpan(
                                      text: address['phone'],
                                      style: const TextStyle(fontSize: 16, color: Colors.grey),
                                    ),
                                  ],
                                ),
                              ),
                              const SizedBox(height: 5),
                              Text(
                                address['address']!,
                                style: const TextStyle(fontSize: 14, color: Colors.black54),
                              ),
                              const SizedBox(height: 5),
                              if (address.containsKey('default'))
                                Container(
                                  padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 2),
                                  decoration: BoxDecoration(
                                    border: Border.all(color: Colors.purple),
                                    borderRadius: BorderRadius.circular(4),
                                  ),
                                  child: const Text(
                                    "Mặc định",
                                    style: TextStyle(color: Colors.purple, fontSize: 12),
                                  ),
                                ),
                            ],
                          ),
                        ),
                        GestureDetector(
                          onTap: () {
                            // Xử lý sửa địa chỉ
                          },
                          child: const Text(
                            "Sửa",
                            style: TextStyle(color: Colors.purple, fontSize: 14),
                          ),
                        ),
                      ],
                    ),
                  ),
                );
              },
            ),
          ),
          // Nút thêm địa chỉ mới
          GestureDetector(
            onTap: () {
              // Xử lý thêm địa chỉ mới
            },
            child: Container(
              padding: const EdgeInsets.symmetric(vertical: 14),
              decoration: BoxDecoration(
                border: Border(top: BorderSide(color: Colors.grey[300]!)),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  const Icon(Icons.add_circle_outline, color: Colors.purple),
                  const SizedBox(width: 5),
                  const Text(
                    "Thêm Địa Chỉ Mới",
                    style: TextStyle(fontSize: 16, color: Colors.purple, fontWeight: FontWeight.bold),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
