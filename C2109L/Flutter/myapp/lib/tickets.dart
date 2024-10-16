import 'package:flutter/material.dart';
import 'package:myapp/models/ticket.dart';
import 'package:myapp/widgets/ticket_row.dart';

class Tickets extends StatefulWidget {
  Tickets({super.key});
  List<Ticket> fakedTickets = [
    Ticket(id: 123, title: "Do somethionfgh", name: 'Nguyen Van A', status: 'Open'),
    Ticket(id: 124, title: "Do somethionfgh", name: 'N dushdguyen Van A', status: 'Open'),
    Ticket(id: 127, title: "Do somethionfgh", name: 'Nguyenede Van A', status: 'Open'),
    Ticket(id: 129, title: "Do somethionfgh", name: 'Nguyen Vaeen A', status: 'Open'),
    Ticket(id: 133, title: "Do somethionfgh", name: 'Nguyen Vaeq23n A', status: 'Open'),
    Ticket(id: 134, title: "Do somethionfgh", name: 'Nguyeddn Van A', status: 'Open'),
    Ticket(id: 149, title: "Do somethionfgh", name: 'Nguye90n Van D', status: 'Open'),
  ];
  @override
  State<Tickets> createState() => _TicketsState();
}

class _TicketsState extends State<Tickets> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          child: Column(
            children: [
              Container(
                height: 60,
                color:Colors.indigo
              ),
              Expanded(child: ListView.builder(
                  padding: EdgeInsets.only(top: 10, left: 10, right: 10),
                  itemCount: widget.fakedTickets.length,
                  itemBuilder: (BuildContext buildContext,int index) {
                    Ticket ticket = widget.fakedTickets[index];
                    return TicketRow(ticket: ticket, index: index,);
                  }
              ),)
            ],
          )
        ),
      ),
    );
  }
}
