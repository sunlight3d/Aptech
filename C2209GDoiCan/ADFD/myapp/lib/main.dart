import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:http/http.dart' as http;
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/config.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'package:myapp/screens/login/login.dart';
import 'package:myapp/screens/product_list/product_list.dart';
import 'package:myapp/screens/splash/splash.dart';
import 'package:myapp/screens/register/register.dart';
import 'package:myapp/bloc/simple_bloc_observer.dart';
import 'package:myapp/services/auth_service.dart';

import 'bloc/auth/bloc.dart';
import 'services/product_service.dart';


void main() {
  Bloc.observer = const SimpleBlocObserver();
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

  @override
  Widget build(BuildContext context) {
    final productService = ProductService(
      baseURL: API_BASE_URL,
      httpClient: http.Client(),
    );

    final authService = AuthService(
      baseURL: API_BASE_URL,
      httpClient: http.Client(),
      localStorageRepository: LocalStorageRepository(),
    );

    return MultiBlocProvider(
      providers: [
        // Khởi tạo AuthenticationBloc với lazy = false
        BlocProvider<AuthenticationBloc>(
          lazy: false,
          create: (context) => AuthenticationBloc(authService: authService)
            ..add(AuthenticationRequested()),
        ),

        // Khởi tạo ProductBloc
        BlocProvider<ProductBloc>(
          create: (context) => ProductBloc(productService: productService)
            ..add(FetchProducts()),
        ),

        // Khởi tạo LoginBloc
        BlocProvider<LoginBloc>(
          create: (context) => LoginBloc(
            authService: context.read<AuthService>(),
          ),
        ),
      ],
      child: MaterialApp.router(
        routerConfig: _router,
      ),
    );

  }
}

