import 'package:call_api_mvvm/models/fruit.dart';
import 'package:call_api_mvvm/services/fruit_service.dart';

class FruitRepository {
  final FruitService fruitService;
  FruitRepository(this.fruitService);
  Future<List<Fruit>> getFruits() => fruitService.getFruits();
}