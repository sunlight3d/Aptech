import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/repositories/local_storage_repository.dart';

class SelectAddressScreen extends StatefulWidget {
  const SelectAddressScreen({super.key});

  @override
  State<SelectAddressScreen> createState() => _SelectAddressScreenState();
}

class _SelectAddressScreenState extends State<SelectAddressScreen> {
  int selectedAddressIndex = 0;
  List<Map<String, String>> addresses = [];
  final LocalStorageRepository _localStorage = LocalStorageRepository();

  @override
  void initState() {
    super.initState();
    _loadAddresses();
  }

  void _loadAddresses() async {
    final storedAddresses = await _localStorage.getAddresses();
    setState(() {
      addresses = storedAddresses;
    });
  }

  void _addNewAddress() {
    final _formKey = GlobalKey<FormState>();
    TextEditingController nameController = TextEditingController();
    TextEditingController phoneController = TextEditingController();
    TextEditingController addressController = TextEditingController();

    showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: const Text("Thêm Địa Chỉ Mới"),
          content: Form(
            key: _formKey,
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                TextFormField(
                  controller: nameController,
                  decoration: const InputDecoration(labelText: "Họ và tên"),
                  validator: (value) {
                    if (value == null || value.trim().isEmpty) {
                      return "Vui lòng nhập họ và tên";
                    }
                    return null;
                  },
                ),
                TextFormField(
                  controller: phoneController,
                  decoration: const InputDecoration(labelText: "Số điện thoại"),
                  keyboardType: TextInputType.phone,
                  validator: (value) {
                    if (value == null || value.trim().isEmpty) {
                      return "Vui lòng nhập số điện thoại";
                    }
                    if (!RegExp(r'^\d{7,12}$').hasMatch(value)) {
                      return "Số điện thoại phải có từ 7 đến 12 số";
                    }
                    return null;
                  },
                ),
                TextFormField(
                  controller: addressController,
                  decoration: const InputDecoration(labelText: "Địa chỉ"),
                  validator: (value) {
                    if (value == null || value.trim().isEmpty) {
                      return "Vui lòng nhập địa chỉ";
                    }
                    return null;
                  },
                ),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: const Text("Hủy"),
            ),
            TextButton(
              onPressed: () async {
                if (_formKey.currentState!.validate()) {
                  final newAddress = {
                    "name": nameController.text.trim(),
                    "phone": phoneController.text.trim(),
                    "address": addressController.text.trim(),
                  };
                  await _localStorage.saveAddress(newAddress);
                  _loadAddresses();
                  Navigator.pop(context);
                }
              },
              child: const Text("Lưu"),
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        title: const Text("Chọn địa chỉ nhận hàng"),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () {
            SchedulerBinding.instance.addPostFrameCallback((_) {
              Navigator.pop(context, addresses[selectedAddressIndex]);
            });
          },
        ),
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
                  onTap: () async {
                    setState(() {
                      selectedAddressIndex = index;
                    });
                    await _localStorage.saveSelectedAddress(address);

                    if (mounted) { // Kiểm tra mounted trước khi pop
                      Navigator.pop(context, address);
                    }
                  },
                  child: Container(
                    padding: const EdgeInsets.all(12),
                    decoration: BoxDecoration(border: Border(bottom: BorderSide(color: Colors.grey[300]!))),
                    child: Row(
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
                              Text("${address['name']} - ${address['phone']}", style: const TextStyle(fontWeight: FontWeight.bold)),
                              Text(address['address']!, style: const TextStyle(fontSize: 14, color: Colors.black54)),
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                );
              },
            ),
          ),
          GestureDetector(
            onTap: _addNewAddress,
            child: Container(
              padding: const EdgeInsets.symmetric(vertical: 14),
              decoration: BoxDecoration(border: Border(top: BorderSide(color: Colors.grey[300]!))),
              child: const Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.add_circle_outline, color: Colors.purple),
                  SizedBox(width: 5),
                  Text("Thêm Địa Chỉ Mới", style: TextStyle(fontSize: 16, color: Colors.purple, fontWeight: FontWeight.bold)),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}