import 'package:flutter/material.dart';

class Friends extends StatefulWidget {
  const Friends({super.key});

  @override
  State<Friends> createState() => _FriendsState();
}

class _FriendsState extends State<Friends> {
  final fakedTasks = <String>[
    "He'd have you all unravel at the",
    'Who scream',
    'Revolution is coming...',
    'Heed not the rabble','Sound of screams but the',
    'Revolution, they...'
  ];
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

  }
  @override
  Widget build(BuildContext context) {
    final double screenWidth = MediaQuery.of(context).size.width;
    final double screenHeight = MediaQuery.of(context).size.height;

    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: EdgeInsets.all(10),
          color: Colors.white,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Container(
                height: 0.25 * screenHeight,
                child: Stack(
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.circular(12.0),
                      child: Image(
                        image: AssetImage('images/top_background.jpg'),
                        fit: BoxFit.cover,
                        width: double.infinity,
                      ),
                    ),

                    Padding(
                      padding: EdgeInsets.all(10),
                      child: Column(
                        children: [
                          Row(
                            mainAxisAlignment: MainAxisAlignment.spaceBetween,
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: [
                              Icon(Icons.arrow_back_ios_new),
                              Container(
                                padding: EdgeInsets.all(10),
                                child: Text('Settings',
                                  textAlign: TextAlign.center,
                                  style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
                                ),
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(20),
                                  color: Colors.deepOrangeAccent,
                                  boxShadow: [
                                    BoxShadow(
                                      color: Colors.black.withOpacity(0.5),
                                      blurRadius: 2,
                                      offset: Offset(2, 2), // Shadow position
                                    ),
                                  ],
                                ),
                              )
                            ],
                          ),
                          Row(
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: [
                              CircleAvatar(
                                backgroundColor: Colors.white,
                                radius: 23.0,
                                child: CircleAvatar(
                                  backgroundImage: NetworkImage('https://t4.ftcdn.net/jpg/03/64/21/11/240_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg'),
                                  radius: 20,
                                ),
                              ),
                              SizedBox(width: 10,),
                              Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    'Jenny Wilson',
                                    style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
                                  ),
                                  Text(
                                    'London',
                                    style: TextStyle(color: Colors.white),
                                  ),
                                  SizedBox(height: 10,),
                                  Row(
                                    children: [
                                      Container(
                                        child: Icon(Icons.access_alarm, color: Colors.white,),
                                        margin: EdgeInsets.only(right: 5),
                                        decoration: BoxDecoration(
                                          borderRadius: BorderRadius.circular(8),
                                          color: Colors.green,
                                        ),
                                      ),
                                      Text('70'),
                                      SizedBox(width: 15,),
                                      Container(
                                        child: Icon(Icons.access_alarm, color: Colors.white,),
                                          margin: EdgeInsets.only(right: 5),
                                          decoration: BoxDecoration(
                                              borderRadius: BorderRadius.circular(8),
                                              color: Colors.deepOrangeAccent,
                                          ),
                                      ),
                                      Text('12,560')
                                    ],
                                  )
                                ],
                              )
                            ],
                          ),
                        ],
                      ),
                    ),

                  ],
                ),
              ),
              Text('Badges', style: TextStyle(fontWeight: FontWeight.bold),),
              Container(
                height: screenHeight * 0.25,
                child: GridView.count(
                  primary: false,
                  padding: const EdgeInsets.all(20),
                  crossAxisSpacing: 10,
                  mainAxisSpacing: 10,
                  crossAxisCount: 4,
                  children: fakedTasks.map((e) => Container(
                      padding: const EdgeInsets.all(8),
                      child: Center(
                        child: Text("He'd have you all unravel at the", textAlign: TextAlign.center,),
                      ),
                      decoration: BoxDecoration(
                          color: Colors.teal[100],
                          borderRadius: BorderRadius.circular(100)
                      )
                  )).toList(growable: true),
                ),
              ),
              Expanded(
                  child: ListView.builder(
                      itemCount: 5,
                      itemBuilder: (BuildContext context, int index) {
                        return Container(
                          padding: EdgeInsets.all(10),
                          child: Column(
                            children: [
                              Row(
                                children: [
                                  Text('crispi calamaddee', style: TextStyle(fontWeight: FontWeight.bold),),
                                  Expanded(child: Container()),
                                  Icon(Icons.access_alarm_outlined, size: 25,)
                                ],
                              ),
                              Row(
                                children: [
                                  Icon(Icons.calendar_month, size: 20,),
                                  Text('24 July'),
                                  SizedBox(width: 10,),
                                  Icon(Icons.lock_clock, size: 20,),
                                  Text('10:00 AM'),
                                  SizedBox(width: 10,),
                                  Icon(Icons.monetization_on, size: 20,),
                                  Text('10560'),
                                ],
                              )
                            ],
                          ),
                        );
                  })
              )

            ],
          ),
        ),
      ),
    );
  }
}
