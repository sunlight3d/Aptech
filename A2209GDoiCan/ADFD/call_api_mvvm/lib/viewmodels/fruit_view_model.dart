import 'package:call_api_mvvm/models/fruit.dart';
import 'package:call_api_mvvm/repositories/fruit_repository.dart';
import 'package:call_api_mvvm/viewmodels/view_model.dart';

class FruitViewModel extends ViewModel {
  final FruitRepository repository;
  List<Fruit> fruits = [];

  FruitViewModel(this.repository);
  Future<void> _performAsyncOperation(
      Future<void> Function() operation,
      ) async {
    try {
      isLoading = true;
      notifyListeners();

      await operation();
      error = null;
    } catch (e) {
      error = e.toString();
      rethrow; // Optionally rethrow if you want calling code to handle errors
    } finally {
      isLoading = false;
      notifyListeners();
    }
  }
  Future<void> getPets() async {
    await _performAsyncOperation(() async {
      fruits = await repository.getFruits();
    });
  }
}