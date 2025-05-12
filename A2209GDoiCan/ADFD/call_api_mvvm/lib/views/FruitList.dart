import 'package:call_api_mvvm/viewmodels/fruit_view_model.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class FruitList extends StatefulWidget {
  const FruitList({super.key});

  @override
  State<FruitList> createState() => _FruitListState();
}

class _FruitListState extends State<FruitList> {
  @override
  void initState() {
    super.initState();
    Provider.of<FruitViewModel>(context, listen: false).getFruits();
  }

  @override
  Widget build(BuildContext context) {
    final viewModel = Provider.of<FruitViewModel>(context);
    final theme = Theme.of(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Fruits'),
        centerTitle: true,
        elevation: 0,
        actions: [
          IconButton(
            icon: const Icon(Icons.refresh),
            onPressed: () => viewModel.getFruits(),
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            viewModel.isLoading
                ? const LinearProgressIndicator(minHeight: 2)
                : const SizedBox(height: 2),
            const SizedBox(height: 8),
            Expanded(
              child: viewModel.isLoading
                  ? const Center(child: CircularProgressIndicator())
                  : viewModel.fruits.isEmpty
                  ? Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(
                      Icons.eco,
                      size: 64,
                      color: theme.disabledColor,
                    ),
                    const SizedBox(height: 16),
                    Text(
                      'No fruits found',
                      style: theme.textTheme.titleMedium?.copyWith(
                        color: theme.disabledColor,
                      ),
                    ),
                    const SizedBox(height: 8),
                    Text(
                      'Pull to refresh or check your connection',
                      style: theme.textTheme.bodyMedium?.copyWith(
                        color: theme.disabledColor,
                      ),
                    ),
                  ],
                ),
              )
                  : ListView.separated(
                itemCount: viewModel.fruits.length,
                separatorBuilder: (context, index) =>
                const Divider(height: 1),
                itemBuilder: (context, index) {
                  final fruit = viewModel.fruits[index];
                  return ListTile(
                    leading: const Icon(Icons.eco, color: Colors.green),
                    title: Text(
                      fruit.name,
                      style: theme.textTheme.titleMedium,
                    ),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Family: ${fruit.family}',
                          style: theme.textTheme.bodySmall,
                        ),
                        const SizedBox(height: 4),
                        Text(
                          'Calories: ${fruit.nutritions.calories}kcal | '
                              'Carbs: ${fruit.nutritions.carbohydrates}g',
                          style: theme.textTheme.bodySmall,
                        ),
                        Text(
                          'Fat: ${fruit.nutritions.fat}g | '
                              'Protein: ${fruit.nutritions.protein}g',
                          style: theme.textTheme.bodySmall,
                        ),
                        Text(
                          'Sugar: ${fruit.nutritions.sugar}g',
                          style: theme.textTheme.bodySmall,
                        ),
                      ],
                    ),
                    trailing: const Icon(Icons.chevron_right),
                    contentPadding: const EdgeInsets.symmetric(
                        horizontal: 16),
                    onTap: () {
                      // Add navigation to fruit details if needed
                    },
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}