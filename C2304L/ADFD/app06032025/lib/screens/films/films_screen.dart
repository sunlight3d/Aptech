import 'package:flutter/material.dart';
import 'package:badges/badges.dart' as badges;

class FilmsScreen extends StatefulWidget {
  const FilmsScreen({super.key});

  @override
  State<FilmsScreen> createState() => _FilmsScreenState();
}

class _FilmsScreenState extends State<FilmsScreen> {
  TextEditingController _searchController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: [
            ClipRRect(
              child: Image.network(
                'https://media.istockphoto.com/id/1437816897/vi/anh/n%E1%BB%AF-doanh-nh%C3%A2n-ng%C6%B0%E1%BB%9Di-qu%E1%BA%A3n-l%C3%BD-ho%E1%BA%B7c-ch%C3%A2n-dung-nh%C3%A2n-s%E1%BB%B1-%C4%91%E1%BB%83-th%C3%A0nh-c%C3%B4ng-trong-s%E1%BB%B1-nghi%E1%BB%87p-c%C3%B4ng-ty-ch%C3%BAng.webp?s=1024x1024&w=is&k=20&c=kvyHTMhRJcFxaB16UlEySEjs8Hdoob-bFto2gUh999c=',
                width: 40,
                height: 40,
                fit: BoxFit.cover,
              ),
              borderRadius: BorderRadius.all(Radius.circular(20)),
            ),
            SizedBox(width: 10,),
            Text("John Doe", style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold),),
            Icon(Icons.arrow_drop_down, color: Colors.lightBlue,),
          ],
        ),
        actions: [
          badges.Badge(
            badgeContent: Text('3', style: TextStyle(color: Colors.white),),
            child: Icon(Icons.notifications),
          ),
          SizedBox(width: 10,),
          Icon(Icons.menu, color: Colors.black,),
          SizedBox(width: 10,)
        ],
      ),
      body: Column(
        children: [
          Container(
            height: 50,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Container(
                  width: 200,
                  child: TextFormField(
                    controller: _searchController,
                    decoration: InputDecoration(
                        hintText: 'Type your text',
                        border: InputBorder.none
                    ),
                  ),
                )
              ],
            ),
          ),
          Expanded(child: ListView(
            children: [
              Row(
                children: [
                  Text('In theaters', style: TextStyle(fontSize: 50),),
                  Expanded(child: Container(),),
                  Container(
                    padding: EdgeInsets.all(10),
                    child: Icon(Icons.menu),
                  ),
                  Container(
                    padding: EdgeInsets.all(10),
                    child: Icon(Icons.grid_4x4_outlined),
                  ),
                ],
              ),
              Container(
                color: Colors.red,
                height: 300,
                child: ListView(
                  scrollDirection: Axis.horizontal,
                  children: [
                    Container(
                      padding: EdgeInsets.symmetric(horizontal: 10),
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                      child: Column(
                        children: [
                          Image.network(
                            'https://media.istockphoto.com/id/1437816897/vi/anh/n%E1%BB%AF-doanh-nh%C3%A2n-ng%C6%B0%E1%BB%9Di-qu%E1%BA%A3n-l%C3%BD-ho%E1%BA%B7c-ch%C3%A2n-dung-nh%C3%A2n-s%E1%BB%B1-%C4%91%E1%BB%83-th%C3%A0nh-c%C3%B4ng-trong-s%E1%BB%B1-nghi%E1%BB%87p-c%C3%B4ng-ty-ch%C3%BAng.webp?s=1024x1024&w=is&k=20&c=kvyHTMhRJcFxaB16UlEySEjs8Hdoob-bFto2gUh999c=',
                            width: 100, height:130,fit: BoxFit.cover,),
                          Text('IMDM: 6.2',style: TextStyle(color: Colors.blue),),
                          Text('djsu dhushdu shuehw ehwuhe wheuw heuhwueh wuheuwheu wheuwheu wheuhwuehwuheuwheuhw uehwuhe wuheuwheuwheuwhuehu hwuehuwe ehuwhew',
                            maxLines: 3,
                            overflow: TextOverflow.ellipsis,),
                          GestureDetector(
                            onTap: (){

                            },
                            child: Container(
                              padding: EdgeInsets.all(10),
                              decoration: BoxDecoration(
                                color: Colors.lightBlue,

                              ),
                              child: Text('Do something'),
                            ),
                          )
                        ],
                      ),
                    ),
                    SizedBox(width: 10,),
                    Container(
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                    ),
                    SizedBox(width: 10,),
                    Container(
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                    ),
                    SizedBox(width: 10,),
                    Container(
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                    ),
                    SizedBox(width: 10,),
                    Container(
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                    ),
                    SizedBox(width: 10,),
                    Container(
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                    ),
                    SizedBox(width: 10,),
                    Container(
                      height: 180,
                      width: 150,
                      decoration: BoxDecoration(
                          color: Colors.green
                      ),
                    )

                  ],
                ),
              )
            ],
          ))
        ],
      ),
    );
  }
}
