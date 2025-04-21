import 'package:flutter/material.dart';

class Sample extends StatefulWidget {
  const Sample({super.key});

  @override
  State<Sample> createState() => _SampleState();
}

class _SampleState extends State<Sample> {
  int _counter = 0;
  int _currentIndex = 0;
  DateTime? _selectedDate;

  @override
  void initState() {
    super.initState();
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          children: [
            TextButton(
                onPressed: () {
                  setState(() {
                    _counter = _counter <= 0 ? 0 : _counter - 1;
                  });
                },
                child: Text('Decrease')
            ),
            Text(
              'Counter is: $_counter',
              style: TextStyle(fontSize: 40, fontWeight: FontWeight.bold),
            ),
            TextButton(
                onPressed: () {
                  setState(() {
                    _counter = _counter + 1;
                  });
                },
                child: Text('Increase')
            ),
            TextButton(onPressed: () async {
              final DateTime? pickedDate = await showDatePicker(
                context: context,
                initialDate: DateTime(2021, 7, 25),
                firstDate: DateTime(2021),
                lastDate: DateTime(2022),
              );

              setState(() {
                this._selectedDate = pickedDate;
              });
            }, child: Text('Pick a date')),
            Text('Selected date : ${_selectedDate?.toString()}'),
            TextButton(onPressed: () {
              showDialog(
                  context: context,
                  builder: (_) {
                    return AlertDialog(
                        title: Text('Alert Dialog'),
                        content: Text('This is an Alert Dialog!'),
                            actions: [
                              TextButton(
                              onPressed: () =>
                              Navigator.pop(context),
                            child: Text('Cancel')),
                            TextButton(
                            onPressed: () => Navigator.pop(context),
                            child: Text('Ok')),
                              TextButton(
                                  onPressed: () => Navigator.pop(context),
                                  child: Text('haha'))

                    ], );
                  });
            }, child: Container(
              child: Text('Show dialog'),
              padding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
              decoration: BoxDecoration(
                color: Colors.green
              )
            )),
            Image.network(
                'https://cdnphoto.dantri.com.vn/oOYTvVASgW-sNXsZTexizA14pxU=/thumb_w/1360/2025/02/06/mua-vang-via-than-tai14-1-1738842815086.jpg?watermark=true',
                fit: BoxFit.contain,
                width: 200,
              height: 200,
            ),
            Icon(Icons.add, size: 100, color: Colors.amber,)
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex, // Thiết lập index hiện tại
        onTap: (index) {
          setState(() {
            _currentIndex = index; // Cập nhật state khi tap
          });
        },
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
            activeIcon: Icon(
              Icons.home,
              color: Colors.red,
            ),
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.search),
              activeIcon: Icon(
                Icons.search,
                color: Colors.red,
              ),
              label: 'Search'
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.camera),
              activeIcon: Icon(
                Icons.camera,
                color: Colors.red,
              ),
              label: 'Camera'
          )
        ],
        selectedItemColor: Colors.red, // Màu cho item được chọn
        unselectedItemColor: Colors.grey, // Màu cho item không được chọn
      ),
    );
  }
}