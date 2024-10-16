import 'package:flutter/material.dart';
import 'package:noteapp/database/sqlite_helper.dart';
import 'package:noteapp/models/note.dart';
import 'package:noteapp/repositories/note_repository.dart';
import 'package:noteapp/screens/list_item.dart';
import 'package:provider/provider.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  @override
  Widget build(BuildContext context) {
    SQLiteHelper sqLiteHelper = Provider.of<SQLiteHelper>(context);
    final noteRepository = Provider.of<NoteRepository>(context);
    return Scaffold(
      body: SafeArea(
        child: Container(
          child: Column(
            children: [
              Container(
                height: 80,
                color: Colors.red,
              ),
              FutureBuilder<List<Note>>(
                  future: sqLiteHelper.getAllNotes(),//async function
                  builder: (context, snapshot) {
                    if (snapshot.connectionState == ConnectionState.waiting) {
                      return CircularProgressIndicator(); // Show loading indicator while fetching data
                    } else if (snapshot.hasError) {
                      return Text('Error: ${snapshot.error}');
                    } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
                      return Text('No data available');
                    } else {
                      // Render the list of notes here
                      final notes = snapshot.data;
                      return ListView.builder(
                        itemCount: notes!.length,
                        itemBuilder: (context, index) {
                          return ListTile(
                            title: Text(notes[index].content),
                            // Add more ListTile content as needed
                          );
                        },
                      );
                    }
                  }
              )
            ],
          ),
        ),
      ),
    );
  }
}
