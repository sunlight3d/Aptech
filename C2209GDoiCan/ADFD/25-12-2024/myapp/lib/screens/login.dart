import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  final int x = 0;
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  bool _passwordVisile = false;
  @override
  Widget build(BuildContext context) {
    return  Scaffold(
      body: Container(
        width: double.infinity,
        child: Stack(
          children: [
            Positioned.fill(
              child: Image.asset(
                'images/background.png',
                fit: BoxFit.cover, // Đảm bảo ảnh phủ toàn bộ Container
              ),
            ),
            Container(
              padding: EdgeInsets.only(left: 10, top: 10, right: 10, bottom: 10),
              height: double.infinity,
              child: Column(
                //mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Text('Login', style: TextStyle(fontSize:  30,), textAlign: TextAlign.center,),
                    ],
                  ),
                  Expanded(child: Container(),),
                  Text('Email address'),
                  TextField(
                    decoration: InputDecoration(
                      //hintText: 'Enter your email',
                      enabledBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.purple),
                      ),
                      focusedBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.purple),
                      ),
                    ),
                  ),
                  SizedBox(height: 20,),
                  Text('Password',),
                  Stack(
                    children: [
                      Container(
                        child: TextField(
                          obscureText: !_passwordVisile, // Ẩn văn bản
                          decoration: InputDecoration(
                            //hintText: 'Enter your password',
                            enabledBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.purple),
                            ),
                            focusedBorder: UnderlineInputBorder(
                              borderSide: BorderSide(color: Colors.purple),
                            ),
                          ),
                        ),
                      ),
                      SizedBox(width: 10), // Khoảng cách giữa TextField và Icon
                      Positioned(child: InkWell(
                        child: Container(
                          child: Icon(
                            this._passwordVisile == false ? Icons.visibility_off : Icons.visibility,
                            color: Colors.black.withAlpha(120),
                            size: 25.0,
                          ),
                          padding: EdgeInsets.all(10),
                        ),
                        onTap: () {
                          setState(() {
                            _passwordVisile = !_passwordVisile;
                          });
                        },
                      ),
                        right: 0,
                      )

                    ],
                  ),
                  SizedBox(height: 10,),
                  Container(
                    height: 45,
                    width: double.infinity,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Text('Login', style: TextStyle(fontSize: 18, color: Colors.white),),
                      ],
                    ),
                    decoration: BoxDecoration(
                      color: Colors.purple,
                      borderRadius: BorderRadius.all(Radius.circular(10))
                    ),
                  ),
                  Padding(
                      padding: EdgeInsets.all(10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          Text('Forgot password ?', style: TextStyle(fontSize:  14,), textAlign: TextAlign.center,),
                        ],
                      ),
                  ),
                  Expanded(child: Container(),),
                  Padding(
                    padding: EdgeInsets.all(10),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Text('Did not have account ?', style: TextStyle(fontSize:  14,), textAlign: TextAlign.center,),
                      ],
                    ),
                  ),
                  Padding(
                    padding: EdgeInsets.all(10),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Text('Create account',
                          style: TextStyle(
                              fontSize:  14,
                              fontWeight: FontWeight.bold,
                              color: Colors.purple), textAlign: TextAlign.center),
                      ],
                    ),
                  )
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
