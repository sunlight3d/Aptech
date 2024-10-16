import 'package:flutter/material.dart';
import 'package:myapp/widgets/my_button.dart';
class Splash extends StatelessWidget {
  const Splash({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Container(
              decoration: BoxDecoration(
                  gradient: LinearGradient(
                    begin: Alignment.topCenter,
                    end: Alignment.bottomCenter,
                    colors: [
                      Colors.orange.withOpacity(0.5), // Top color
                      Colors.orange, // Bottom color
                    ],
                  )
              )),
          Container(
            width: double.infinity,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Container(
                  child: Column(
                    children: [
                      Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          Text('d', style: TextStyle(fontSize: 50, fontWeight: FontWeight.bold, color: Colors.white),),
                          Text('ev', style: TextStyle(fontSize: 50, fontWeight: FontWeight.bold, color: Colors.black),),
                          Text('rnz', style: TextStyle(fontSize: 50, fontWeight: FontWeight.bold, color: Colors.white),),
                        ],
                      ),

                    ],
                  ),
                ),
                Text('devrnz design ',
                  textAlign: TextAlign.end,
                  style: TextStyle(fontSize: 15, fontWeight: FontWeight.bold),),
                SizedBox(height: 20,),
                MyButton(onTap: () {
                  print('press login');
                },
                  textColor: Colors.orange,
                  backgroundColor: Colors.white,
                  title: 'login',
                ),
                SizedBox(height: 20,),
                MyButton(onTap: () {
                  print('press login');
                },
                  textColor: Colors.white,
                  backgroundColor: Colors.orange,
                  title: 'Register Now'
                ),
                InkWell(
                  child: Padding(
                    child: Text('Quick login with touch id',
                        style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold)),
                    padding: EdgeInsets.symmetric(vertical: 20),
                  ),
                  onTap: () {
                    print('Quick login with touch id');
                  },
                ),
                Icon(Icons.fingerprint, color: Colors.white, size:  100,),
                Text('Use touch Id', style: TextStyle(color: Colors.white)),
              ],
            ),
          )
        ],
      )
    );
  }
}
