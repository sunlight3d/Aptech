import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/screens/login/login.dart';
import 'package:myapp/screens/product_list/product_list.dart';
import 'package:myapp/screens/splash/splash.dart';
import 'package:myapp/screens/register/register.dart';

void main() {
  runApp(const MyApp());
}
/// The route configuration.
final GoRouter _router = GoRouter(
  routes: <RouteBase>[
    GoRoute(
      path: '/',
      builder: (BuildContext context, GoRouterState state) {
        return const Splash();
      },
      routes: <RouteBase>[
        GoRoute(
          path: 'login',
          builder: (BuildContext context, GoRouterState state) {
            return const Login();
          },
        ),
        GoRoute(
          path: 'register',
          builder: (BuildContext context, GoRouterState state) {
            return const Register();
          },
        ),
        GoRoute(
          path: 'product_list',
          builder: (BuildContext context, GoRouterState state) {
            return const ProductList();
          },
        ),
      ],
    ),
  ],
);
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ProductList(),
    );
    return MaterialApp.router(
      routerConfig: _router,
    );
  }
}


