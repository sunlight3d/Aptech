<?php

use Illuminate\Foundation\Application;
use Illuminate\Foundation\Configuration\Exceptions;
use Illuminate\Foundation\Configuration\Middleware;
use \App\Http\Middleware\CheckSession;
return Application::configure(basePath: dirname(__DIR__))
    ->withRouting(
        web: __DIR__.'/../routes/web.php',
        commands: __DIR__.'/../routes/console.php',
        health: '/up',
    )
    ->withMiddleware(function (Middleware $middleware) {
        //$middleware->append(CheckSession::class);
        $middleware->use([            
           // CheckSession::class,            
        ]);
    })
    ->withExceptions(function (Exceptions $exceptions) {
        //
    })->create();

    /**
    composer create-project laravel/laravel my-project
    
    php artisan make:model User -m
    php artisan migrate

    php artisan make:controller UserController --resource

    php artisan make:model Post -m
    php artisan migrate

    php artisan make:controller PostController --resource

    php artisan session:table

    php artisan make:migration rename_hashed_password_to_password_in_users_table

    then config up() of the migration file

    php artisan migrate

    php artisan make:middleware CheckSession

    php artisan make:controller HomeController

    php artisan vendor:publish --tag=laravel-pagination

    Install Laravel Vite: https://tailwindcss.com/docs/guides/laravel#vite
    
    php artisan make:controller AdminController


   INSERT INTO posts (title, content, user_id, url, created_at, updated_at) VALUES 
('Learning Laravel Basics', 'This post covers the basics of Laravel, including installation and setup...', 8, 'https://example.com/learning-laravel-basics', NOW(), NOW()),
('PHP 8 New Features', 'PHP 8 introduces many new features and optimizations. This post explores these new additions...', 8, 'https://example.com/php-8-features', NOW(), NOW()),
('Building RESTful APIs with Laravel', 'Laravel makes it easy to build RESTful APIs. This post covers the steps to create an API...', 8, 'https://example.com/building-restful-apis', NOW(), NOW()),
('Laravel Blade Templates', 'Blade is the simple, yet powerful templating engine provided with Laravel. This post explains how to use it...', 8, 'https://example.com/laravel-blade-templates', NOW(), NOW()),
('Understanding Laravel Middleware', 'Middleware provides a convenient mechanism for filtering HTTP requests entering your application...', 8, 'https://example.com/laravel-middleware', NOW(), NOW()),
('Database Migrations in Laravel', 'Database migrations are like version control for your database, allowing your team to easily modify and share...',8, 'https://example.com/laravel-migrations', NOW(), NOW()),
('Eloquent Relationships in Laravel', 'Eloquent makes it easy to define relationships between models. This post covers the basics of Eloquent relationships...', 8, 'https://example.com/eloquent-relationships', NOW(), NOW()),
('Laravel Queues and Jobs', 'Queues allow you to defer the processing of a time-consuming task, such as sending an email...', 8, 'https://example.com/laravel-queues', NOW(), NOW()),
('Laravel Task Scheduling', 'In addition to managing queues, Laravel provides a robust task scheduling system that allows you to schedule...', 8, 'https://example.com/laravel-task-scheduling', NOW(), NOW()),
('Laravel Authentication', 'Laravel offers a complete authentication system out of the box. This post covers setting up and customizing authentication...', 8, 'https://example.com/laravel-authentication', NOW(), NOW()),
('Introduction to Laravel Nova', 'Laravel Nova is a beautifully designed administration panel for Laravel. This post introduces its main features...', 8, 'https://example.com/laravel-nova', NOW(), NOW()),
('Building a Blog with Laravel', 'This tutorial walks through building a simple blog application with Laravel from scratch...', 8, 'https://example.com/building-a-blog', NOW(), NOW()),
('Laravel Collections', 'Collections are a wrapper around arrays with a variety of methods for interacting with the data. This post explores...', 8, 'https://example.com/laravel-collections', NOW(), NOW()),
('Deploying Laravel Applications', 'This post covers best practices for deploying Laravel applications to production...', 8, 'https://example.com/deploying-laravel', NOW(), NOW()),
('Understanding Laravel Service Container', 'The service container is a powerful tool for managing class dependencies and performing dependency injection...', 8, 'https://example.com/laravel-service-container', NOW(), NOW()),
('Laravel Broadcasting', 'Broadcasting your server-side events to the client is a breeze with Laravel. This post explains how to set it up...', 8, 'https://example.com/laravel-broadcasting', NOW(), NOW()),
('Laravel Event Broadcasting', 'Broadcasting allows you to broadcast your server-side events to the client side, making real-time applications easy...', 8, 'https://example.com/laravel-event-broadcasting', NOW(), NOW()),
('Laravel Localization', 'Localization is the process of translating your application into different languages. This post explains how to...', 8, 'https://example.com/laravel-localization', NOW(), NOW()),
('Laravel Horizon', 'Laravel Horizon provides a beautiful dashboard and code-driven configuration for your Redis queues...', 8, 'https://example.com/laravel-horizon', NOW(), NOW()),
('Building a RESTful API with Laravel Passport', 'Laravel Passport is an OAuth2 server implementation for API authentication using Laravel...', 8, 'https://example.com/laravel-passport', NOW(), NOW());

*/