import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:http/http.dart' as http;
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/bloc/user/bloc.dart';
import 'package:myapp/config.dart';
import 'package:myapp/firebase_options.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'package:myapp/screens/login/login.dart';
import 'package:myapp/screens/main/main.dart';
import 'package:myapp/screens/main/profile/profile.dart';
import 'package:myapp/screens/splash/splash.dart';
import 'package:myapp/screens/register/register.dart';
import 'package:myapp/bloc/simple_bloc_observer.dart';
import 'package:myapp/services/auth_service.dart';
import 'package:myapp/services/user_service.dart';

import 'bloc/auth/bloc.dart';
import 'screens/detail_product/detail_product.dart';
import 'services/product_service.dart';
/*
flutter pub add firebase_auth
flutter pub add firebase_core
flutter pub add google_sign_in
flutter pub add meta
flutter pub add formz
flutter pub add google_fonts


flutter pub add firebase_auth_platform_interface --dev
flutter pub add firebase_core_platform_interface --dev
* */

void main() async {
  WidgetsFlutterBinding.ensureInitialized(); // Đảm bản Flutter binding được khởi tạo
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform); // Khởi tạo Firebase
  Bloc.observer = const SimpleBlocObserver();
  runApp(const MyApp());
}

/// Cấu hình routing
final GoRouter _router = GoRouter(
  routes: <RouteBase>[
    GoRoute(
      path: '/',
      builder: (BuildContext context, GoRouterState state) {
        return const SplashScreen();
      },
      routes: <RouteBase>[
        GoRoute(
          path: 'login',
          builder: (BuildContext context, GoRouterState state) {
            return const LoginScreen();
          },
        ),
        GoRoute(
          path: 'register',
          builder: (BuildContext context, GoRouterState state) {
            return const RegisterScreen();
          },
        ),
        GoRoute(
          path: 'main',
          builder: (BuildContext context, GoRouterState state) {
            return MainScreen();
          },
          routes: [
            GoRoute(
              path: 'products/:productId',
              builder: (context, state) {
                final productId = int.parse(state.pathParameters['productId']!);
                return ProductDetailScreen(productId: productId);
              },
            ),
          ]
        ),
        GoRoute(
          path: 'profile/:userId',
          builder: (BuildContext context, GoRouterState state) {
            final userId = int.parse(state.pathParameters['userId']!);
            final token = state.extra as String;
            return ProfileScreen(userId: userId, token: token);
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
    final userService = UserService(
        baseURL: API_BASE_URL,
        httpClient: http.Client()
    );

    return MultiRepositoryProvider(
      providers: [
        RepositoryProvider<AuthService>.value(value: authService),
        RepositoryProvider<UserService>.value(value: userService),
        RepositoryProvider<ProductService>.value(value: productService),
      ],
      child: MultiBlocProvider(
        providers: [
          BlocProvider<AuthenticationBloc>(
            lazy: false,
            create: (context) => AuthenticationBloc(authService: authService)
              ..add(AuthenticationRequested()),
          ),
          BlocProvider<ProductBloc>(
            create: (context) => ProductBloc(productService: productService)
              ..add(FetchProducts()),
          ),
          BlocProvider<LoginBloc>(
            create: (context) => LoginBloc(
              authService: context.read<AuthService>(),
            ),
          ),
          BlocProvider<UserBloc>(
            create: (context) => UserBloc(userService: userService),
          ),
        ],
        child: MaterialApp.router(
          routerConfig: _router,
        ),
      ),
    );
  }
}