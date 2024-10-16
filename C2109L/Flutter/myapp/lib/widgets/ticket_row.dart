import 'package:flutter/material.dart';
import 'package:myapp/models/ticket.dart';

class TicketRow extends StatelessWidget {
  final Ticket ticket;
  final int index;
  TicketRow({super.key,
    required this.ticket,
    required this.index
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      //color: index % 2 == 0 ? Colors.green : Colors.deepOrange,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              Icon(
                Icons.access_alarms,
                color: Colors.black45,
                size: 20.0,
              ),
              SizedBox(width: 5,),
              Text('#${ticket.id}'),
              Expanded(child: Container(),),
              Text('12:58 PM')
            ],
          ),
          Text(ticket.title, textAlign: TextAlign.start,),
          SizedBox(height: 5,),
          Text(ticket.name, textAlign: TextAlign.start,),
          Row(
            children: [
              Icon(
                Icons.access_alarms,
                color: Colors.blue,
                size: 20.0,
              ),
              SizedBox(width: 5,),
              Text(ticket.status),
              SizedBox(width: 5,),
              Icon(
                Icons.mic_none,
                color: Colors.black45,
                size: 20.0,
              ),
              Expanded(child: Container(),),
              CircleAvatar(
                backgroundImage: NetworkImage('https://upload.wikimedia.org/wikipedia/commons/9/9d/Head_face_detail_lateral.jpg'),
                radius: 15,
              ),

            ],
          ),
          SizedBox(height: 5,),
          Container(
              height: 1,
              width: double.infinity,
              color: Colors.black
          ),
          SizedBox(height: 10,),
        ],
      ),
    );
  }
}
