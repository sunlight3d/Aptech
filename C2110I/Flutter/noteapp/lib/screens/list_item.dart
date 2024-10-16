import 'package:flutter/material.dart';
import 'package:noteapp/models/note.dart';

class ListItem extends StatelessWidget {
  int index;
  Note note;
  ListItem({
    super.key,
    required this.index,
    required this.note
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 80,
      child: Row(
        children: [
          Container(width: 15, color: index % 2 == 0 ?
              Colors.blue : Colors.yellow,),
          Padding(
              padding: EdgeInsets.symmetric(horizontal: 10),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(this.note.content, style: TextStyle(fontSize: 17, fontWeight: FontWeight.bold),),
                Text(this.note.isImportant ? 'yes':'no', style: TextStyle(fontSize: 17),),
              ],
            ),
          )
        ],
      ),
    );
  }
}
