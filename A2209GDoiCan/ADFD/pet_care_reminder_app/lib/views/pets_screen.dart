import 'package:flutter/material.dart';
import 'package:pet_care_reminder_app/models/pet.dart';
import 'package:pet_care_reminder_app/viewmodels/pet_view_model.dart';
import 'package:pet_care_reminder_app/views/add_pet_screen.dart';
import 'package:provider/provider.dart';

class PetsScreen extends StatefulWidget {
  const PetsScreen({super.key});

  @override
  State<PetsScreen> createState() => _PetsScreenState();
}

class _PetsScreenState extends State<PetsScreen> {
  @override
  void initState() {
    super.initState();
    // Load pets when the screen initializes
    Provider.of<PetViewModel>(context, listen: false).getPets();
  }

  @override
  Widget build(BuildContext context) {
    final petViewModel = Provider.of<PetViewModel>(context);
    final theme = Theme.of(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text('My Pets'),
        centerTitle: true,
        elevation: 0,
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: () => petViewModel.getPets(),
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            if (petViewModel.isLoading)
              const LinearProgressIndicator(minHeight: 2)
            else
              const SizedBox(height: 2),
            const SizedBox(height: 8),
            Expanded(
              child: petViewModel.isLoading
                  ? const Center(child: CircularProgressIndicator())
                  : petViewModel.pets.isEmpty
                  ? Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(
                      Icons.pets,
                      size: 64,
                      color: theme.disabledColor,
                    ),
                    const SizedBox(height: 16),
                    Text(
                      'No pets added yet',
                      style: theme.textTheme.titleMedium?.copyWith(
                        color: theme.disabledColor,
                      ),
                    ),
                    const SizedBox(height: 8),
                    Text(
                      'Tap the + button to add your first pet',
                      style: theme.textTheme.bodyMedium?.copyWith(
                        color: theme.disabledColor,
                      ),
                    ),
                  ],
                ),
              )
                  : ListView.separated(
                itemCount: petViewModel.pets.length,
                separatorBuilder: (context, index) =>
                const Divider(height: 1),
                itemBuilder: (context, index) {
                  final pet = petViewModel.pets[index];
                  final numberOfReminders =
                      pet.reminders?.length ?? 0;
                  return ListTile(
                    leading: const Icon(Icons.pets,
                        color: Colors.amber),
                    title: Text(
                      pet.name,
                      style: theme.textTheme.titleMedium,
                    ),
                    subtitle: Text(
                      '$numberOfReminders ${numberOfReminders == 1 ? 'reminder' : 'reminders'}',
                      style: theme.textTheme.bodySmall,
                    ),
                    trailing: const Icon(Icons.chevron_right),
                    contentPadding: const EdgeInsets.symmetric(
                        horizontal: 16),
                    onTap: () {
                      // Add navigation to pet details if needed
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => const AddPetScreen()),
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}