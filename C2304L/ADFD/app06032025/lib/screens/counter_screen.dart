import 'package:app03062025/utils/helpers.dart';
import 'package:flutter/material.dart';

class CounterScreen extends StatefulWidget {
  final String title;
  const CounterScreen({super.key, required this.title});

  @override
  State<CounterScreen> createState() => _CounterScreenState();
}

class _CounterScreenState extends State<CounterScreen> {
  int _counter = 0;
  int _selectedTabIndex = 0;
  List<Map<String, dynamic>> tabData = [
    {
      'name': 'Home',
      'icon': Icons.home,
    },
    {
      'name': 'Favorites',
      'icon': Icons.favorite,
    },
    {
      'name': 'Settings',
      'icon': Icons.settings,
    }
  ];
  Widget _generateTabs () {
    return Expanded(child: ListView.builder(itemBuilder: (BuildContext context, int index) {
      final Map<String, dynamic> item = tabData[index];
      return ListTile(
        tileColor: _selectedTabIndex == index ? Colors.red : Colors.white,
        leading: Icon(item['icon']),
        title: Row(
          children: [
            Text(item['name']),
            Expanded(child: Container(),),
            Container(
              height: 30,
              width: 30,
              decoration: BoxDecoration(
                  color: Colors.red,
                  borderRadius: BorderRadius.circular(15)
              ),
              child: Center(child: Text('5', style: TextStyle(color: Colors.white, fontSize: 13),),),
            ),

          ],
        ),
        onTap: () {
          print('Press home');
          setState(() {
            _selectedTabIndex = index;
          });
          alert(context: context, content: 'Toi vua an Home', onPressed: (){
            Navigator.pop(context);
          });
          //Navigator.pop(context);
        },
      );
    },
      itemCount: tabData.length,
    ));

  }
  void test() {
    List<int> someIntegers = <int>[1, 2,3,];
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('AppBar without hamburger button')),
      drawer: Drawer(
        elevation: 20,
        child: Column(
          children: [
            UserAccountsDrawerHeader(
                decoration: BoxDecoration(
                  image: const DecorationImage(
                    image: NetworkImage('https://flutter.github.io/assets-for-api-docs/assets/widgets/owl-2.jpg'),
                    fit: BoxFit.cover,
                  ),
                ),
                currentAccountPicture: ClipRRect(
                  borderRadius: BorderRadius.circular(50),
                  child: Image(
                    width: 100,
                    height: 100,
                    fit: BoxFit.cover,
                    image: NetworkImage('https://plus.unsplash.com/premium_photo-1689568126014-06fea9d5d341?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D'),
                  ),
                ),
                accountName: Text('Nguyen Duc Hoang', style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),
                accountEmail: Text('nguyenduchoang@gmail.com')
            ),
            _generateTabs()
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(onPressed: () {
        print('You pressed Float button');
      },
       child: Icon(Icons.add_a_photo),
      ),
      body: Center(
        child: Column(
          children: [
            Text(widget.title),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  _counter = _counter - 1;
                });
              },
              child: Text('Decrease'),
            ),
            Text('counter is : ${_counter}'),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  _counter = _counter + 1;
                });
              },
              child: Text('Increase'),
            ),
          ],
        ),
      ),
    );
  }
}
