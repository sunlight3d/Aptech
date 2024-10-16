#Dockerfile => build your custom image
FROM php:7.0-cli
# Set working dir in container environment
WORKDIR /app
# Add all current files and folder on host env to container env
ADD . /app
# Alternative: COPY . /app
# Run command `php index.php` in container env
CMD ["php", "index.php"]