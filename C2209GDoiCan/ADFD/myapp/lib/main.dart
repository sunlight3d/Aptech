import 'package:back_button_interceptor/back_button_interceptor.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:http/http.dart' as http;
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/bloc/payment/bloc.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/bloc/user/bloc.dart';
import 'package:myapp/config.dart';
import 'package:myapp/firebase_options.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'package:myapp/screens/checkout/checkout.dart';
import 'package:myapp/screens/login/login.dart';
import 'package:myapp/screens/main/main.dart';
import 'package:myapp/screens/main/profile/profile.dart';
import 'package:myapp/screens/splash/splash.dart';
import 'package:myapp/screens/register/register.dart';
import 'package:myapp/bloc/simple_bloc_observer.dart';
import 'package:myapp/services/auth_service.dart';
import 'package:myapp/services/cart_item_service.dart';
import 'package:myapp/services/cart_service.dart';
import 'package:myapp/services/payment_service.dart';
import 'package:myapp/services/user_service.dart';

import 'bloc/auth/bloc.dart';
import 'screens/detail_product/detail_product.dart';
import 'screens/select_address/select_address.dart';
import 'services/product_service.dart';

// Thêm import cho CartBloc
import 'package:myapp/bloc/cart/bloc.dart'; // Giả sử bạn đã đặt CartBloc vào thư mục này

/*
flutter pub add firebase_auth
flutter pub add firebase_core
flutter pub add google_sign_in
flutter pub add meta
flutter pub add formz
flutter pub add google_fonts

flutter pub add firebase_auth_platform_interface --dev
flutter pub add firebase_core_platform_interface --dev
*/

import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:http/http.dart' as http;
import 'package:myapp/bloc/cart/bloc.dart';
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/bloc/user/bloc.dart';
import 'package:myapp/config.dart';
import 'package:myapp/firebase_options.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'package:myapp/screens/checkout/checkout.dart';
import 'package:myapp/screens/login/login.dart';
import 'package:myapp/screens/main/main.dart';
import 'package:myapp/screens/main/profile/profile.dart';
import 'package:myapp/screens/splash/splash.dart';
import 'package:myapp/screens/register/register.dart';
import 'package:myapp/bloc/simple_bloc_observer.dart';
import 'package:myapp/services/auth_service.dart';
import 'package:myapp/services/cart_item_service.dart';
import 'package:myapp/services/cart_service.dart';
import 'package:myapp/services/user_service.dart';
import 'package:myapp/screens/detail_product/detail_product.dart';
import 'package:myapp/screens/select_address/select_address.dart';
import 'package:myapp/services/product_service.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);
  Bloc.observer = const SimpleBlocObserver();
  SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,  // Chỉ cho phép dọc
  ]).then((_) {
    runApp(const MyApp());
  });
}

/// Cấu hình routing
final GoRouter _router = GoRouter(
  routes: <RouteBase>[
    GoRoute(
      path: '/',
      builder: (context, state) => const SplashScreen(),
      routes: <RouteBase>[
        GoRoute(path: 'login', builder: (context, state) => const LoginScreen()),
        GoRoute(path: 'register', builder: (context, state) => const RegisterScreen()),
        GoRoute(
          path: 'main',
          builder: (context, state) {
            final tabIndex = int.tryParse(state.uri.queryParameters['index'] ?? '0') ?? 0;
            return MainScreen(
              key: ValueKey(tabIndex),
              initialTabIndex: tabIndex,
            );
          },
          routes: [
            GoRoute(
              path: 'products/:productId',
              builder: (context, state) {
                final productId = int.parse(state.pathParameters['productId']!);
                return ProductDetailScreen(productId: productId);
              },
            ),
          ],
        ),
        // Đưa checkout ra ngoài main
        GoRoute(
          path: 'checkout',
          builder: (context, state) => const CheckoutScreen(),
          routes: [
            GoRoute(
              path: 'select-address', // Không có dấu `/` ở đầu, nó sẽ nối vào `/checkout`
              builder: (context, state) => const SelectAddressScreen(),
            ),
          ],
        ),
        GoRoute(
          path: 'profile/:userId',
          builder: (context, state) {
            final userId = int.parse(state.pathParameters['userId']!);
            final token = state.extra as String;
            return ProfileScreen(userId: userId, token: token);
          },
        ),
      ],
    ),
  ],
);

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
    BackButtonInterceptor.add(myInterceptor, zIndex: 1);
  }

  @override
  void dispose() {
    BackButtonInterceptor.remove(myInterceptor);
    super.dispose();
  }

  /// Chặn nút back vật lý trên toàn bộ ứng dụng
  bool myInterceptor(bool stopDefaultButtonEvent, RouteInfo info) {
    return true; // Trả về true để chặn Back
  }

  @override
  Widget build(BuildContext context) {
    final localStorageRepository = LocalStorageRepository();

    final authService = AuthService();
    final productService = ProductService();
    final userService = UserService();
    final cartService = CartService();
    final cartItemService = CartItemService();
    final paymentService = PaymentService();

    return MultiRepositoryProvider(
      providers: [
        RepositoryProvider<LocalStorageRepository>.value(value: localStorageRepository),
        RepositoryProvider<AuthService>.value(value: authService),
        RepositoryProvider<ProductService>.value(value: productService),
        RepositoryProvider<UserService>.value(value: userService),
        RepositoryProvider<CartService>.value(value: cartService),
        RepositoryProvider<CartItemService>.value(value: cartItemService),
        RepositoryProvider<PaymentService>.value(value: paymentService),
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
            create: (context) => LoginBloc(authService: authService),
          ),
          BlocProvider<UserBloc>(
            create: (context) => UserBloc(userService: userService),
          ),
          BlocProvider<CartBloc>(
            create: (context) => CartBloc(
              cartService: cartService,
              cartItemService: cartItemService,
              localStorageRepository: localStorageRepository,
            )..add(FetchCartItems()),
          ),
          BlocProvider<PaymentBloc>( // ✅ Thêm PaymentBloc
            create: (context) => PaymentBloc(paymentService: paymentService),
          ),
        ],
        child: MaterialApp.router(
          debugShowCheckedModeBanner: false,
          title: 'Thanh Toán Shopee',
          theme: ThemeData(
            primarySwatch: Colors.purple,
          ),
          routerConfig: _router,
        ),
      ),
    );
  }
}
