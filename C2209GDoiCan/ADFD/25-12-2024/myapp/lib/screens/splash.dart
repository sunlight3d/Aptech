import 'package:flutter/material.dart';

class Splash extends StatelessWidget {
  const Splash({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(child: Stack(
        children: [
          // Container(
          //   decoration: BoxDecoration(
          //     color: Colors.white
          //   ),
          //   child: Center(
          //     child: Text('Aptech', textAlign: TextAlign.center, style: TextStyle(fontSize: 50),),
          //   ),
          // ),
          Container(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                    padding: EdgeInsets.all(10),
                    child: Row(
                      children: [
                        Image(
                          image: AssetImage('images/holly-berry.png'),
                          width: 100,
                          height: 100,
                        ),
                      ],
                    )
                ),
                Container(
                    padding: EdgeInsets.all(10),
                    child: Column(
                      children: [
                        Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                            Image(
                              image: AssetImage('images/christmas-decoration.png'),
                              width: 100,
                              height: 100,
                            ),
                          ],
                        ),
                        Text('Aptech', textAlign: TextAlign.center, style: TextStyle(fontSize: 30),)
                      ],
                    )
                ),
                Container(padding: EdgeInsets.all(10),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        Image(
                          image: AssetImage('images/holly-berry.png'),
                          width: 100,
                          height: 100,
                        ),
                      ],
                    )
                )
              ],
            ),
          )
        ],
      ))
    );
  }
}
